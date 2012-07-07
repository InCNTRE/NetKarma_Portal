/*
#
# Copyright 2007 The Trustees of Indiana University
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or areed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# -----------------------------------------------------------------
#
# Project: Karma-Service-core
# File:  BaseDBIngesterImplementer.java
# Description:  An implementation of IngesterImplementer interface that
#   works with database
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest.db;

import static edu.indiana.dsi.karma.ingest.IngesterConstants.INVALID_RECORD_ID;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType;
import org.dataandsearch.www.karma._2010._08.AnnotableRelationshipEnumType;

import edu.indiana.dsi.karma.common.ObjectPool;
import edu.indiana.dsi.karma.ingest.AnnotableObject;
import edu.indiana.dsi.karma.ingest.AnnotableObject.AnnotableObjectCategoryEnum;
import edu.indiana.dsi.karma.ingest.Annotation;
import edu.indiana.dsi.karma.ingest.Annotation.AnnotationDefinitionScopeEnum;
import edu.indiana.dsi.karma.ingest.Certainty;
import edu.indiana.dsi.karma.ingest.Certainty.CertaintySourceEnum;
import edu.indiana.dsi.karma.ingest.DBLockConfiguration;
import edu.indiana.dsi.karma.ingest.DataObject;
import edu.indiana.dsi.karma.ingest.DataObject.DataObjectEnum;
import edu.indiana.dsi.karma.ingest.EntityObject;
import edu.indiana.dsi.karma.ingest.EntityObject.AuthorshipTypeEnum;
import edu.indiana.dsi.karma.ingest.EntityObject.EntityCategoryEnum;
import edu.indiana.dsi.karma.ingest.EntityObject.EntitySubtypeEnum;
import edu.indiana.dsi.karma.ingest.EntityObject.InstanceOf;
import edu.indiana.dsi.karma.ingest.EntityObject.UserBehalf;
import edu.indiana.dsi.karma.ingest.IngestException;
import edu.indiana.dsi.karma.ingest.IngesterConstants;
import edu.indiana.dsi.karma.ingest.IngesterConstants.DataLifeCycleEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.EntityLifeCycleEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.InvocationTypeEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingFilterType;
import edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingStatus;
import edu.indiana.dsi.karma.ingest.IngesterConstants.StatusSourceEnum;
import edu.indiana.dsi.karma.ingest.IngesterImplementer;
import edu.indiana.dsi.karma.ingest.NotificationSummary;
import edu.indiana.dsi.karma.ingest.NotificationSummary.InvocationDataEnum;
import edu.indiana.dsi.karma.ingest.NotificationSummary.NotificationTypeEnum;
import edu.indiana.dsi.karma.ingest.NotificationSummary.StatusEnum;
import edu.indiana.dsi.karma.ingest.Quality;
import edu.indiana.dsi.karma.ingest.Quality.QualitySourceEnum;
import edu.indiana.dsi.karma.ingest.db.AnnotableObjectFactory.AnnotableEntity;
import edu.indiana.dsi.karma.ingest.db.AnnotableObjectFactory.AnnotableFile;
import edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord.MethodRecord;
import edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord.ServiceRecord;
import edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord.UserRecord;
import edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord.WorkflowRecord;
import edu.indiana.dsi.karma.ingest.db.DataObjectFactory.BlockObject;
import edu.indiana.dsi.karma.ingest.db.DataObjectFactory.CollectionObject;
import edu.indiana.dsi.karma.ingest.db.DataObjectFactory.FileObject;
import edu.indiana.dsi.karma.ingest.db.EntityFactory.MethodEntity;
import edu.indiana.dsi.karma.ingest.db.EntityFactory.ServiceEntity;
import edu.indiana.dsi.karma.ingest.db.EntityFactory.UserEntity;
import edu.indiana.dsi.karma.ingest.db.EntityFactory.WorkflowEntity;


/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 * @author You-Wei Cheah
 *
 */
public class BaseDBIngesterImplementer implements IngesterImplementer<Long, String>{
    
    protected static enum MultiEntryMethodModeEnum {
        RETURN_IDS,
        QUICK;
    }
    
    protected static class StatusWithSource {
        private final StatusEnum status;
        private final StatusSourceEnum source;
        
        StatusWithSource(StatusEnum status, StatusSourceEnum source) {
            this.status = status;
            this.source = source;
        }
        
        StatusEnum getStatus() {
            return this.status;
        }
        
        StatusSourceEnum getSource() {
            return this.source;
        }
        
        boolean isMoreCertainThan(StatusWithSource another) {
            if (another == null) {
                return true;
            }
            
            if (this.source.equals(another.source)) {
                return false;
            }
            
            switch(this.source) {
            case PRESUMED:
                return false;
            case INFERRED:
                switch (another.source) {
                case PRESUMED:
                    return true;
                case INFERRED:
                case NOTIFIED:
                    return false;
                }
            case NOTIFIED:
                switch (another.source) {
                case PRESUMED:
                case INFERRED:
                    return true;
                case NOTIFIED:
                    return false;
                }
            }
            
            assert false : "Should not reach here. this.source " + this.source.name() + " another.source " + another.source.name();
            return false;
        }
    }
    
    protected static class InvocationRecord {
        private long invocationInternalID;
        private long invokerInternalID;
        private long invokeeInternalID;
        private InvocationTypeEnum invocationType;
        private long invocationStartTime;
        private long executionEndTime;
        private StatusWithSource invocationStatus;
        private StatusWithSource executionStatus;
        private Certainty certainty;
        
        private boolean updatedInvocationInternalID;
        private boolean updatedInvokerInternalID;
        private boolean updatedInvokeeInternalID;
        private boolean updatedInvocationType;
        private boolean updatedInvocationStartTime;
        private boolean updatedExecutionEndTime;
        private boolean updatedInvocationStatus;
        private boolean updatedExecutionStatus;
        private boolean updatedCertainty;
        
        InvocationRecord(long invocationInternalID, long invocationStartTime, long executionEndTime, StatusWithSource invocationStatus, StatusWithSource executionStatus, Certainty certainty) {
            this(invocationInternalID, INVALID_RECORD_ID, INVALID_RECORD_ID, null, invocationStartTime, executionEndTime, invocationStatus, executionStatus, certainty);
        }
        
        InvocationRecord(long invokerInternalID, long invokeeInternalID, InvocationTypeEnum invocationType, long invocationStartTime, long executionEndTime, StatusWithSource invocationStatus, StatusWithSource executionStatus, Certainty certainty) {
            this(INVALID_RECORD_ID, invokerInternalID, invokeeInternalID, invocationType, invocationStartTime, executionEndTime, invocationStatus, executionStatus, certainty);
        }
        
        InvocationRecord(long invocationInternalID, long invokerInternalID, long invokeeInternalID, InvocationTypeEnum invocationType, long invocationStartTime, long executionEndTime, StatusWithSource invocationStatus, StatusWithSource executionStatus, Certainty certainty) {
            this.invocationInternalID = invocationInternalID;
            this.invokerInternalID = invokerInternalID;
            this.invokeeInternalID = invokeeInternalID;
            this.invocationType = invocationType;
            this.invocationStartTime = invocationStartTime;
            this.executionEndTime = executionEndTime;
            this.invocationStatus = invocationStatus;
            this.executionStatus = executionStatus;
            this.certainty = certainty;
            resetUpdateFlags();
            
        }
        long getInvocationInternalID() {
            return invocationInternalID;
        }
        
        void setInvocationInternalID(long invocationInternalID) {
            this.invocationInternalID = invocationInternalID;
            this.updatedInvocationInternalID = true;
        }
        
        long getInvokerInternalID() {
            return invokerInternalID;
        }
        
        void setInvokerInternalID(long invokerInternalID) {
            this.invokerInternalID = invokerInternalID;
            this.updatedInvokerInternalID = true;
        }
        
        long getInvokeeInternalID() {
            return invokeeInternalID;
        }
        
        void setInvokeeInternalID(long invokeeInternalID) {
            this.invokeeInternalID = invokeeInternalID;
            this.updatedInvokeeInternalID = true;
        }
        
        InvocationTypeEnum getInvocationType() {
            return invocationType;
        }
        
        void setInvocationType(InvocationTypeEnum invocationType) {
            this.invocationType = invocationType;
            updatedInvocationType = true;
        }
        
        long getInvocationStartTime() {
            return invocationStartTime;
        }
        
        void setInvocationStartTime(long invocationStartTime) {
            this.invocationStartTime = invocationStartTime;
            updatedInvocationStartTime = true;
        }
        
        long getExecutionEndTime() {
            return executionEndTime;
        }
        
        void setExeuctionEndTime(long executionEndTime) {
            this.executionEndTime = executionEndTime;
            updatedExecutionEndTime = true;
        }
        
        StatusWithSource getInvocationStatus() {
            return invocationStatus;
        }
        
        void setInvocationStatus(StatusWithSource invocationStatus) {
            this.invocationStatus = invocationStatus;
            updatedInvocationStatus = true;
        }
        
        StatusWithSource getExecutionStatus() {
            return executionStatus;
        }
        
        void setExecutionStatus(StatusWithSource executionStatus) {
            this.executionStatus = executionStatus;
            updatedExecutionStatus = true;
        }
        
        Certainty getCertainty() {
            return certainty;
        }
        
        void setCertainty(Certainty certainty) {
            this.certainty = certainty;
            updatedCertainty = true;
        }
        
        void resetUpdateFlags() {
            updatedCertainty = false;
            updatedExecutionEndTime = false;
            updatedExecutionStatus = false;
            updatedInvocationInternalID = false;
            updatedInvocationStartTime = false;
            updatedInvocationStatus = false;
            updatedInvocationType = false;
            updatedInvokeeInternalID = false;
            updatedInvokerInternalID = false;
        }
        
        boolean isCertaintyUpdated() {
            return updatedCertainty;
        }
        
        boolean isExecutionEndTimeUpdated() {
            return updatedExecutionEndTime;
        }
        
        boolean isExecutionStatusUpdated() {
            return updatedExecutionStatus;
        }
        
        boolean isInvocationInternalIDUpdated() {
            return updatedInvocationInternalID;
        }
        
        boolean isInvocationStartTimeUpdated() {
            return updatedInvocationStartTime;
        }
        
        boolean isInvocationStatusUpdated() {
            return updatedInvocationStatus;
        }
        
        boolean isInvocationTypeUpdated() {
            return updatedInvocationType;
            
        }
        boolean isInvokerInternalIDUpdated() {
            return updatedInvokerInternalID;
        }
        
        boolean isInvokeeInternalIDUpdated() {
            return updatedInvokeeInternalID;
        }
        boolean isUpdated() {
            return (updatedCertainty || 
                    updatedExecutionEndTime || 
                    updatedExecutionStatus ||
                    updatedInvocationInternalID ||
                    updatedInvocationStartTime ||
                    updatedInvocationStatus ||
                    updatedInvocationType ||
                    updatedInvokerInternalID ||
                    updatedInvokeeInternalID);
            
        }
    }
    
    protected static class DataTransferRecord {
        private long transferInternalID;
        private long senderInternalID;
        private long receiverInternalID;
        private long dataInternalID;
        private long transferStartTime;
        private long transferEndTime;
        private StatusWithSource transferStatus;
        private Certainty certainty;
        
        private boolean updatedTransferInternalID;
        private boolean updatedSenderInternalID;
        private boolean updatedReceiverInternalID;
        private boolean updatedDataInternalID;
        private boolean updatedTransferStartTime;
        private boolean updatedTransferEndTime;
        private boolean updatedTransferStatus;
        private boolean updatedCertainty;
        
        DataTransferRecord(long senderInternalID, long receiverInternalID, long dataInternalID, long transferStartTime, long transferEndTime, StatusWithSource transferStatus, Certainty certainty) {
            this(INVALID_RECORD_ID, senderInternalID, receiverInternalID, dataInternalID, transferStartTime, transferEndTime, transferStatus, certainty);
        }
        
        DataTransferRecord(long transferInternalID, long senderInternalID, long receiverInternalID, long dataInternalID, long transferStartTime, long transferEndTime, StatusWithSource transferStatus, Certainty certainty) {
            this.transferInternalID = transferInternalID;
            this.senderInternalID = senderInternalID;
            this.receiverInternalID = receiverInternalID;
            this.dataInternalID = dataInternalID;
            this.transferStartTime = transferStartTime;
            this.transferEndTime = transferEndTime;
            this.transferStatus = transferStatus;
            this.certainty = certainty;
            
            resetUpdateFlags();
        }
        
        long getTransferInternalID() {
            return transferInternalID;
        }
        void setTransferInternalID(long transferInternalID) {
            this.transferInternalID = transferInternalID;
            updatedTransferInternalID = true;
        }
        long getSenderInternalID() {
            return senderInternalID;
        }
        void setSenderInternalID(long senderInternalID) {
            this.senderInternalID = senderInternalID;
            updatedSenderInternalID = true;
        }
        long getReceiverInternalID() {
            return receiverInternalID;
        }
        void setReceiverInternalID(long receiverInternalID) {
            this.receiverInternalID = receiverInternalID;
            updatedReceiverInternalID = true;
        }
        long getDataInternalID() {
            return dataInternalID;
        }
        void setDataInternalID(long dataInternalID) {
            this.dataInternalID = dataInternalID;
            updatedDataInternalID = true;
        }
        long getTransferStartTime() {
            return transferStartTime;
        }
        void setTransferStartTime(long transferStartTime) {
            this.transferStartTime = transferStartTime;
            updatedTransferStartTime = true;
        }
        long getTransferEndTime() {
            return transferEndTime;
        }
        void setTransferEndTime(long transferEndTime) {
            this.transferEndTime = transferEndTime;
            updatedTransferEndTime = true;
        }
        StatusWithSource getTransferStatus() {
            return transferStatus;
        }
        void setTransferStatus(StatusWithSource transferStatus) {
            this.transferStatus = transferStatus;
            updatedTransferStatus = true;
        }
        Certainty getCertainty() {
            return certainty;
        }
        void setCertainty(Certainty certainty) {
            this.certainty = certainty;
            updatedCertainty = true;
        }
        void resetUpdateFlags() {
            updatedTransferInternalID = false;
            updatedSenderInternalID = false;
            updatedReceiverInternalID = false;
            updatedDataInternalID = false;
            updatedTransferStartTime = false;
            updatedTransferEndTime = false;
            updatedTransferStatus = false;
            updatedCertainty = false;
        }
        boolean isTransferInternalIDUpdated() {
            return updatedTransferInternalID;
        }
        boolean isSenderInternalIDUpdated() {
            return updatedSenderInternalID;
        }
        boolean isReceiverInternalIDUpdated() {
            return updatedReceiverInternalID;
        }
        boolean isDataInternalIDUpdated() {
            return updatedDataInternalID;
        }
        boolean isTransferStartTimeUpdated() {
            return updatedTransferStartTime;
        }
        boolean isTransferEndTimeUpdated() {
            return updatedTransferEndTime;
        }
        boolean isTransferStatusUpdated() {
            return updatedTransferStatus;
        }
        boolean isCertaintyUpdated() {
            return updatedCertainty;
        }
        boolean isUpdated() {
            return (updatedTransferInternalID ||
                    updatedSenderInternalID ||
                    updatedReceiverInternalID ||
                    updatedDataInternalID ||
                    updatedTransferStartTime ||
                    updatedTransferEndTime ||
                    updatedTransferStatus ||
                    updatedCertainty);
        }
    }
    
    protected static class InvocationResponseRecord {
        private InvocationRecord invocationRecord;
        private DataTransferRecord dataTransferRecord;
        
        InvocationResponseRecord(InvocationRecord invocationRecord, DataTransferRecord dataTransferRecord) {
            this.invocationRecord = invocationRecord;
            this.dataTransferRecord = dataTransferRecord;
        }
        
        public InvocationRecord getInvocationRecord() {
            return invocationRecord;
        }
        
        public DataTransferRecord getDataTransferRecord() {
            return dataTransferRecord;
        }
    }

    protected static abstract class EntityRecord {
        protected long internalID;
        protected boolean updatedInternalID;
        
        
        long getInternalID() {
            return internalID;
        }
        
        void setInternalID(long internalID) {
            this.internalID = internalID;
            updatedInternalID = true;
        }
        
        boolean isInternalIDUpdated() {
            return updatedInternalID;
        }
        
        abstract EntityCategoryEnum getEntityCategory();
        abstract EntitySubtypeEnum getEntitySubtype();
        abstract boolean isUpdated();
        abstract void resetUpdateFlags();
        
        static class UserRecord extends EntityRecord {
            protected String userDN;
            protected String fullName;
            protected String affiliation;
            protected String email;
            
            protected boolean updatedUserDN;
            protected boolean updatedFullName;
            protected boolean updatedAffiliation;
            protected boolean updatedEmail;
            
            UserRecord(String userDN) {
                this(userDN, INVALID_RECORD_ID, null, null, null);
            }
            UserRecord(String userDN, long internalID) {
                this(userDN, internalID, null, null, null);
            }
            UserRecord(String userDN, long internalID, String fullName, String affiliation, String email) {
                super();
                this.userDN = userDN;
                this.internalID = internalID;
                this.fullName = fullName;
                this.affiliation = affiliation;
                this.email = email;
                
                resetUpdateFlags();
            }
            
            String getUserDN () {
                return userDN;
            }
            
            void setUserDN(String userDN) {
                this.userDN = userDN;
                updatedUserDN = true;
            }
            String getFullName() {
                return fullName;
            }
            void setFullName(String fullName) {
                this.fullName = fullName;
                updatedFullName = true;
            }
            String getAffiliation() {
                return affiliation;
            }
            void setAffiliation(String affiliation) {
                this.affiliation = affiliation;
                updatedAffiliation = true;
            }
            String getEmail() {
                return email;
            }
            void setEmail(String email) {
                this.email = email;
                updatedEmail = true;
            }
            
            boolean isUserDNUpdated() {
                return updatedUserDN;
            }
            boolean isFullNameUpdated() {
                return updatedFullName;
            }
            boolean isAffiliationUpdated() {
                return updatedAffiliation;
            }
            boolean isEmailUpdated() {
                return updatedEmail;
            }
            
            /**
             * 
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#resetUpdateFlags()
             */
            @Override
            void resetUpdateFlags() {
                updatedInternalID = false;
                updatedUserDN = false;
                updatedFullName = false;
                updatedAffiliation = false;
                updatedEmail = false;
            }
            
            /**
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#getEntityCategory()
             */
            @Override
            EntityCategoryEnum getEntityCategory() {
                return EntityCategoryEnum.USER;
            }

            /**
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#getEntitySubtype()
             */
            @Override
            EntitySubtypeEnum getEntitySubtype() {
                return null;
            }

            /**
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#isUpdated()
             */
            @Override
            boolean isUpdated() {
                return (updatedInternalID || updatedUserDN || updatedFullName || updatedAffiliation || updatedEmail);
            }
            
        }

        static class WorkflowRecord extends EntityRecord {
            public static final int INVALID_TIMESTEP = -1;
            
            protected String workflowID;
            protected String workflowNodeID;
            protected int timestep;
            protected EntitySubtypeEnum subtype;
            
            boolean updatedWorkflowID;
            boolean updatedWorkflowNodeID;
            boolean updatedTimestep;
            boolean updatedSubtype;
            
            WorkflowRecord(String workflowID) {
                this(workflowID, INVALID_RECORD_ID, null, null, INVALID_TIMESTEP);
            }
            WorkflowRecord(String workflowID, EntitySubtypeEnum subtype) {
                this(workflowID, INVALID_RECORD_ID, subtype, null, INVALID_TIMESTEP);
            }
            WorkflowRecord(String workflowID, long internalID, EntitySubtypeEnum subtype, String workflowNodeID, int timestep) {
                super();
                this.workflowID = workflowID;
                this.internalID = internalID;
                this.subtype = subtype;
                this.workflowNodeID = workflowNodeID;
                this.timestep = timestep;
                
                resetUpdateFlags();
            }
            
            String getWorkflowID() {
                return workflowID;
            }
            void setWorkflowID(String workflowID) {
                this.workflowID = workflowID;
                updatedWorkflowID = true;
            }
            String getWorkflowNodeID() {
                return workflowNodeID;
            }
            void setWorkflowNodeID(String workflowNodeID) {
                this.workflowNodeID = workflowNodeID;
                updatedWorkflowNodeID = true;
            }
            int getTimestep() {
                return timestep;
            }
            void setTimestep(int timestep) {
                this.timestep = timestep;
                updatedTimestep = true;
            }
            void setEntitySubtype(EntitySubtypeEnum subtype) {
                this.subtype = subtype;
                updatedSubtype = true;
            }
            boolean isWorkflowIDUpdated() {
                return updatedWorkflowID;
            }
            boolean isWorkflowNodeIDUpdated() {
                return updatedWorkflowNodeID;
            }
            boolean isTimestepUpdated() {
                return updatedTimestep;
            }
            boolean isSubtypeUpdated() {
                return updatedSubtype;
            }
            
            /**
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#getEntityCategory()
             */
            @Override
            EntityCategoryEnum getEntityCategory() {
                return EntityCategoryEnum.WORKFLOW;
            }

            /**
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#getEntitySubtype()
             */
            @Override
            EntitySubtypeEnum getEntitySubtype() {
                return subtype;
            }

            /**
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#isUpdated()
             */
            @Override
            boolean isUpdated() {
                return (updatedInternalID || updatedSubtype || updatedTimestep || updatedWorkflowID || updatedWorkflowNodeID);
            }

            /**
             * @see edu.indiana.dsi.karma.ingest.db.BaseDBIngesterImplementer.EntityRecord#resetUpdateFlags()
             */
            @Override
            void resetUpdateFlags() {
                updatedInternalID = false;
                updatedSubtype = false;
                updatedTimestep = false;
                updatedWorkflowID = false;
                updatedWorkflowNodeID = false;
            }
            
        }

        static class ServiceRecord extends WorkflowRecord {
            protected String serviceID;
            protected boolean updatedServiceID;
            
            ServiceRecord(String serviceID, EntitySubtypeEnum subtype, String workflowID, String workflowNodeID, int timestep) {
                this(serviceID, INVALID_RECORD_ID, subtype, workflowID, workflowNodeID, timestep);
            }
            
            ServiceRecord(String serviceID, long internalID, EntitySubtypeEnum subtype, String workflowID, String workflowNodeID, int timestep) {
                super(workflowID, internalID, subtype, workflowNodeID, timestep);
                this.serviceID = serviceID;
                resetUpdateFlags();
            }
            
            String getServiceID() {
                return serviceID;
            }
            void setServiceID(String serviceID) {
                this.serviceID = serviceID;
                updatedServiceID = true;
            }
            
            boolean isServiceIDUpdated() {
                return updatedServiceID;
            }
            
            @Override
            boolean isUpdated() {
                return (updatedServiceID || super.isUpdated());
            }
            
            @Override
            void resetUpdateFlags() {
                updatedServiceID = false;
                super.resetUpdateFlags();
            }
            
        }
        
        static class MethodRecord extends ServiceRecord {
            protected String methodID;
            protected boolean updatedMethodID;
            
            MethodRecord(String methodID, EntitySubtypeEnum subtype, String serviceID, String workflowID, String workflowNodeID, int timestep) {
                this(methodID, INVALID_RECORD_ID, subtype, serviceID, workflowID, workflowNodeID, timestep);
            }
            MethodRecord(String methodID, long internalID, EntitySubtypeEnum subtype, String serviceID, String workflowID, String workflowNodeID, int timestep) {
                super(serviceID, internalID, subtype, workflowID, workflowNodeID, timestep);
                this.methodID = methodID;
                resetUpdateFlags();
            }
            String getMethodID() {
                return methodID;
            }
            void setMethodID(String methodID) {
                this.methodID = methodID;
                updatedMethodID = true;
            }
            boolean isMethodIDUpdated() {
                return updatedMethodID;
            }
            @Override
            boolean isUpdated() {
                return (updatedMethodID || super.isUpdated());
            }
            @Override
            void resetUpdateFlags() {
                updatedMethodID = false;
                super.resetUpdateFlags();
            }
        }
        
    }
    
    static class BaseDBStoredRawNotification implements StoredRawNotification<Long, String> {
        protected Long internalID;
        protected String notification;
        protected NotificationTypeEnum notificationType;

        public BaseDBStoredRawNotification(Long internalID, NotificationTypeEnum notificationType, String notification) {
            this.internalID = internalID;
            this.notificationType = notificationType;
            this.notification = notification;
        }
        /**
         * @see edu.indiana.dsi.karma.ingest.IngesterImplementer.StoredRawNotification#getInternalID()
         */
        @Override
        public Long getInternalID() {
            return internalID;
        }

        /**
         * @see edu.indiana.dsi.karma.ingest.IngesterImplementer.StoredRawNotification#getNotification()
         */
        @Override
        public String getNotification() {

            return notification;
        }

        /**
         * @see edu.indiana.dsi.karma.ingest.IngesterImplementer.StoredRawNotification#getNotificationType()
         */
        @Override
        public NotificationTypeEnum getNotificationType() {

            return notificationType;
        }
        
    }

    private static Logger log = Logger.getLogger(BaseDBIngesterImplementer.class);
    private static Logger plog = Logger.getLogger("perflog");

    protected ObjectPool<Connection> connectionPool = null;

    public static final int DEFAULT_RAW_NOTIFICATION_CACHE_SIZE = 100;
    protected int rawNotificationCacheSize = DEFAULT_RAW_NOTIFICATION_CACHE_SIZE;
    
    protected List<StoredRawNotification<Long, String>> rawUnknownNotificationCache;
    protected List<StoredRawNotification<Long, String>> rawKnownNotificationCache;

    
    
//    public BaseDBIngesterImplementer(String dbLocation, String dbUsername, String dbPassword, int cacheSize, int initialPoolSize, int maxPoolSize, long timeToLive) throws ClassNotFoundException {
    public BaseDBIngesterImplementer(int cacheSize) {

        this.rawNotificationCacheSize = cacheSize > 0 ? cacheSize : DEFAULT_RAW_NOTIFICATION_CACHE_SIZE;

        rawKnownNotificationCache = new ArrayList<StoredRawNotification<Long, String>>();
        
        rawUnknownNotificationCache = new ArrayList<StoredRawNotification<Long, String>>();
        
//        DBConnectionPool.init(dbLocation, dbUsername, dbPassword, initialPoolSize, maxPoolSize, timeToLive);
//        
        connectionPool = DBConnectionPool.getInstance();
//        
//        DBConnectionPool.launch();
        
    }


    
    protected Connection getConnection() throws SQLException {
        
        Connection connection = connectionPool.getEntry();
        return connection;
    }


    
    
    /**
     * Get invocation record from DB based on given invoker, invokee and invocationType
     * @param invokerID DB internal ID of the invoker
     * @param invokeeID DB internal ID of the invokee
     * @param invocationType type of the invocation
     * @param connection established connection to DB
     * @return the first record from DB matching the criteria
     * @throws SQLException
     * @throws IngestException
     * 
     * 
     */
    protected InvocationRecord getInvocationRecord(long invokerID, long invokeeID, InvocationTypeEnum invocationType, Connection connection) throws SQLException, IngestException {
        InvocationRecord invocationRecord = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = connection.prepareStatement("SELECT invocation_id, invocation_start_time, execution_end_time, invocation_status, execution_status, certainty, certainty_source, invocation_status_source, execution_status_source FROM exe_invocation WHERE invoker_id=? AND invokee_id=? AND invocation_type=?");
            statement.setLong(1, invokerID);
            statement.setLong(2, invokeeID);
            statement.setString(3, invocationType.name());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis(); 
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("query invocation record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                long invocationID = resultSet.getLong("invocation_id");
                long invocationStartTime = resultSet.getTimestamp("invocation_start_time").getTime();
                long executionEndTime = resultSet.getTimestamp("execution_end_time").getTime();
                StatusEnum invocationStatusEnum = StatusEnum.valueOf(StatusEnum.class, resultSet.getString("invocation_status"));
                StatusEnum executionStatusEnum = StatusEnum.valueOf(StatusEnum.class, resultSet.getString("execution_status"));
                byte certaintyScore = resultSet.getByte("certainty");
                CertaintySourceEnum certaintySource = CertaintySourceEnum.valueOf(CertaintySourceEnum.class, resultSet.getString("certainty_source"));
                StatusSourceEnum invocationStatusSource = StatusSourceEnum.valueOf(StatusSourceEnum.class, resultSet.getString("invocation_status_source"));
                StatusSourceEnum executionStatusSource = StatusSourceEnum.valueOf(StatusSourceEnum.class, resultSet.getString("execution_status_source"));
                
                invocationRecord = new InvocationRecord(invocationID, invokerID, invokeeID, invocationType, invocationStartTime, executionEndTime, new StatusWithSource(invocationStatusEnum, invocationStatusSource), new StatusWithSource(executionStatusEnum, executionStatusSource), new Certainty(certaintyScore, certaintySource));
                
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return invocationRecord;
    }

    /**
     * Get data transfer record from DB based on the given sender, receiver, and data object
     * @param senderID DB internal ID of the sender
     * @param receiverID DB internal ID of the receiver
     * @param dataObjectID DB internal ID of the data object
     * @param connection established connection to DB
     * @return the first record from DB matching the criteria
     * @throws SQLException
     * @throws IngestException
     * 
     * 
     */
    protected DataTransferRecord getDataTransferRecord(long senderID, long receiverID, long dataObjectID, Connection connection) throws SQLException, IngestException {
        DataTransferRecord dataTransferRecord = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            statement = connection.prepareStatement("SELECT transfer_id, transfer_start_time, transfer_end_time, transfer_status, transfer_status_source, certainty, certainty_source FROM exe_data_transfer WHERE sender_id=? AND receiver_id=? AND data_id=?");
            statement.setLong(1, senderID);
            statement.setLong(2, receiverID);
            statement.setLong(3, dataObjectID);

            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("query data transfer record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                long transferInternalID = resultSet.getLong("transfer_id");
                long transferStartTime = resultSet.getLong("transfer_start_time");
                long transferEndTime = resultSet.getLong("transfer_end_time");
                StatusEnum transferStatus = StatusEnum.valueOf(StatusEnum.class, resultSet.getString("transfer_status"));
                StatusSourceEnum transferStatusSource = StatusSourceEnum.valueOf(StatusSourceEnum.class, resultSet.getString("transfer_status_source"));
                byte certaintyScore = resultSet.getByte("certainty");
                CertaintySourceEnum certaintySource = CertaintySourceEnum.valueOf(CertaintySourceEnum.class, resultSet.getString("certainty_source"));
                
                dataTransferRecord = new DataTransferRecord(transferInternalID, senderID, receiverID, dataObjectID, transferStartTime, transferEndTime, new StatusWithSource(transferStatus, transferStatusSource), new Certainty(certaintyScore, certaintySource));
                
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return dataTransferRecord;
    }

    protected Long getLastAutoID(Connection connection) throws SQLException {

        Long lastAutoID = null;

        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;
        
        try {
            prepStatement = connection.prepareStatement("SELECT LAST_INSERT_ID()");
            resultSet = prepStatement.executeQuery();
    
            if (resultSet.next()) {
                long lastID = resultSet.getLong(1);
                if (!resultSet.wasNull()) {
                    lastAutoID = new Long(lastID);
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (prepStatement != null) {
                prepStatement.close();
                prepStatement = null;
            }
        }
        return lastAutoID;
    }

    /**
     * Insert a new data object record into DB
     * 
     * @param dataObjectEnum type of the data object
     * @param quality quality of the data object
     * @param annotationList List of annotations
     * @param connection an established connection to DB
     * @return DB internal ID of the newly added record, or null if the insert failed
     * @throws SQLException
     * @throws IngestException if the insert failed
     * 
     * 
     */
    protected Long addNewDataObjectRecord(DataObjectEnum dataObjectEnum, Quality quality, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        Long objectID = null;
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement("INSERT INTO exe_data_object(object_type, quality, quality_source) VALUES (?, ?, ?)");
            statement.setString(1, dataObjectEnum.name());
            statement.setByte(2, quality.getQualityScore());
            statement.setString(3, quality.getQualitySource().name());
            
//            if (log.isTraceEnabled()) log.trace("INSERT INTO exe_data_object(object_type, quality, quality_source) VALUES (?, ?, ?)" + "\n" + dataObjectEnum.name() + "\n" + quality.getQualityScore() + "\n" + quality.getQualitySource().name());
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewDataObjectRecord DB INSERT time: " + (System.currentTimeMillis() - startTime));
            if (result > 0) {
                objectID = getLastAutoID(connection);
                
                addNewDataObjectAnnotations(objectID.longValue(), annotationList, connection);
                
            } else {
                throw new IngestException("Failed to add new data object");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return objectID;
    }

    /**
     * Determines invocation status and source of the determination based on the notification
     * @param notificationSummary summary of the source notification
     * @return invocation status determined by the notification summary
     * 
     * 
     */
    private static StatusWithSource determineInvocationStatusFromNotification(NotificationSummary notificationSummary) {
        StatusWithSource statusWithSource = null;
        
        switch (notificationSummary.getNotificationType()) {
        case INVOKING_SERVICE:
        case INVOKING_WORKFLOW:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.PRESUMED);
            break;
        case SERVICE_INVOKED:
        case WORKFLOW_INVOKED:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.NOTIFIED);
            break;
        case INVOKING_SERVICE_STATUS:
        case INVOKING_WORKFLOW_STATUS:
            statusWithSource = new StatusWithSource(notificationSummary.getStatus(), StatusSourceEnum.NOTIFIED);
            break;
        case RECEIVED_FAULT:
        case DATA_RECEIVED_FINISHED:
        case DATA_RECEIVED_STARTED:
        case DATA_SEND_FINISHED:
        case DATA_SEND_STARTED:
        case RECEIVED_RESPONSE:
        case SENDING_FAULT:
        case SENDING_RESPONSE:
        case SENDING_RESPONSE_STATUS:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.INFERRED);
            break;
        case DATA_CONSUMED:
        case DATA_PRODUCED:
        case SERVICE_INITIALIZED:
        case SERVICE_TERMINATED:
        case UNKNOWN_TYPES:
        case WORKFLOW_FAILED:
        case WORKFLOW_INITIALIZED:
        case WORKFLOW_TERMINATED:
        default:
            assert false : "Notification should not trigger invocation " + notificationSummary.getNotificationType().name();
                
        }
        return statusWithSource;
    }

    /**
     * Determines execution status and source of the determination based on the notification  
     * @param notificationSummary summary of the source notification
     * @return execution status determined by the notification summary
     * 
     * 
     */
    private static StatusWithSource determineExecutionStatusFromNotification(NotificationSummary notificationSummary) {
        StatusWithSource statusWithSource = null;
        switch (notificationSummary.getNotificationType()) {
        case DATA_RECEIVED_FINISHED:
        case DATA_RECEIVED_STARTED:
        case DATA_SEND_FINISHED:
        case DATA_SEND_STARTED:
            switch (notificationSummary.getDataType()) {
            case FAULT:
                statusWithSource = new StatusWithSource(StatusEnum.FAILED, StatusSourceEnum.INFERRED);
                break;
            case RESULT:
                statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.INFERRED);
                break;
            case PARAMS:
                assert false : "Notification should not have PARAMS dataType " + notificationSummary.getNotificationType().name();
            }
            break;
        case INVOKING_SERVICE:
        case INVOKING_WORKFLOW:
        case SERVICE_INVOKED:
        case WORKFLOW_INVOKED:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.PRESUMED);
            break;
        case INVOKING_SERVICE_STATUS:
        case INVOKING_WORKFLOW_STATUS:
            switch (notificationSummary.getStatus()) {
            case FAILED:
                statusWithSource = new StatusWithSource(StatusEnum.FAILED, StatusSourceEnum.NOTIFIED);
                break;
            case SUCCESS:
                statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.PRESUMED);
                break;
            }
            break;
        case RECEIVED_FAULT:
        case SENDING_FAULT:
            statusWithSource = new StatusWithSource(StatusEnum.FAILED, StatusSourceEnum.NOTIFIED);
            break;
        case RECEIVED_RESPONSE:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.NOTIFIED);
            break;
        case SENDING_RESPONSE:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.INFERRED);
            break;
        case SENDING_RESPONSE_STATUS:
            switch(notificationSummary.getDataType()) {
            case FAULT:
                statusWithSource = new StatusWithSource(StatusEnum.FAILED, StatusSourceEnum.NOTIFIED);
                break;
            case RESULT:
                switch(notificationSummary.getStatus()) {
                case FAILED:
                    statusWithSource = new StatusWithSource(StatusEnum.FAILED, StatusSourceEnum.NOTIFIED);
                    break;
                case SUCCESS:
                    statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.NOTIFIED);
                    break;
                }
                break;
            case PARAMS:
                assert false : "Should not reach here.  PARAMS cannot be invocation response";
            }
        case DATA_CONSUMED:
        case DATA_PRODUCED:
        case SERVICE_INITIALIZED:
        case SERVICE_TERMINATED:
        case UNKNOWN_TYPES:
        case WORKFLOW_FAILED:
        case WORKFLOW_INITIALIZED:
        case WORKFLOW_TERMINATED:
        default:
            assert false : "Notification should not trigger determination of execution status " + notificationSummary.getNotificationType().name();
        }
        
        return statusWithSource;
    }
    
    /**
     * Determine data transfer status and source of determination based on the notification 
     * @param notificationSummary summary of source notification
     * @return data transfer status determined by the notification summary
     * 
     * 
     */
    private static StatusWithSource determineDataTransferStatusFromNotification(NotificationSummary notificationSummary) {
        StatusWithSource statusWithSource = null;
        switch(notificationSummary.getNotificationType()) {
        case DATA_RECEIVED_FINISHED:
        case RECEIVED_FAULT:
        case RECEIVED_RESPONSE:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.NOTIFIED);
            break;
        case DATA_RECEIVED_STARTED:
        case DATA_SEND_FINISHED:
        case DATA_SEND_STARTED:
        case SENDING_FAULT:
        case SENDING_RESPONSE:
            statusWithSource = new StatusWithSource(StatusEnum.SUCCESS, StatusSourceEnum.PRESUMED);
            break;
        case SENDING_RESPONSE_STATUS:
            statusWithSource = new StatusWithSource(notificationSummary.getStatus(), StatusSourceEnum.NOTIFIED);
            break;
        case DATA_CONSUMED:
        case DATA_PRODUCED:
        case INVOKING_SERVICE:
        case INVOKING_SERVICE_STATUS:
        case INVOKING_WORKFLOW:
        case INVOKING_WORKFLOW_STATUS:
        case SERVICE_INITIALIZED:
        case SERVICE_INVOKED:
        case SERVICE_TERMINATED:
        case UNKNOWN_TYPES:
        case WORKFLOW_FAILED:
        case WORKFLOW_INITIALIZED:
        case WORKFLOW_INVOKED:
        case WORKFLOW_TERMINATED:
        default:
            assert false : "Notification should not trigger determination of data transfer status " + notificationSummary.getNotificationType().name();
            
        }
        return statusWithSource;
    }
    
    /**
     * Add a new invocation record to DB.
     * @param invocationRecord an InvocationRecord object containing information regarding the invocation.  The field invocationInternalID of this object will be updated to the DB internal ID of the new record after a successful DB insert.
     * @param connection an established connection to DB
     * @throws SQLException
     * @throws IngestException thrown if failed to add the new invocation record.
     * 
     * 
     */
    protected void addNewInvocationRecord(InvocationRecord invocationRecord, Connection connection) throws SQLException, IngestException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement("INSERT INTO exe_invocation(invoker_id, invokee_id, invocation_start_time, execution_end_time, invocation_status, execution_status, invocation_type, certainty, certainty_source, invocation_status_source, execution_status_source) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            statement.setLong(1, invocationRecord.getInvokerInternalID());
            statement.setLong(2, invocationRecord.getInvokeeInternalID());
            statement.setTimestamp(3, new java.sql.Timestamp(invocationRecord.getInvocationStartTime()));
            statement.setTimestamp(4, new java.sql.Timestamp(invocationRecord.getExecutionEndTime()));
            statement.setString(5, invocationRecord.getInvocationStatus().getStatus().name());
            statement.setString(6, invocationRecord.getExecutionStatus().getStatus().name());
            statement.setString(7, invocationRecord.getInvocationType().name());
            statement.setByte(8, invocationRecord.getCertainty().getCertaintyScore());
            statement.setString(9, invocationRecord.getCertainty().getCertaintySource().name());
            statement.setString(10, invocationRecord.getInvocationStatus().getSource().name());
            statement.setString(11, invocationRecord.getExecutionStatus().getSource().name());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewInvocationRecord DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                invocationRecord.setInvocationInternalID(getLastAutoID(connection));
            } else {
                throw new IngestException("Failed to add new invocation record");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }

        }
    }
    
    /**
     * Update udpated fields of the data transfer record in DB
     * @param dataTransferRecord a DataTransferRecord object with fields updated
     * @param connection an established connection to DB
     * @throws SQLException
     * @throws IngestException thrown when failed to update the fields
     * 
     * 
     */
    protected void updateDataTransferRecord(DataTransferRecord dataTransferRecord, Connection connection) throws SQLException, IngestException {
        PreparedStatement statement = null;
        
        try {
            StringBuilder statementBuilder = new StringBuilder("UPDATE exe_data_transfer SET ");
            List<String> updateFieldList = new ArrayList<String>();
            
            if (dataTransferRecord.isSenderInternalIDUpdated()) {
                updateFieldList.add("sender_id");
            }
            if (dataTransferRecord.isReceiverInternalIDUpdated()) {
                updateFieldList.add("receiver_id");
            }
            if (dataTransferRecord.isDataInternalIDUpdated()) {
                updateFieldList.add("data_id");
            }
            if (dataTransferRecord.isTransferStartTimeUpdated()) {
                updateFieldList.add("transfer_start_time");
            }
            if (dataTransferRecord.isTransferEndTimeUpdated()) {
                updateFieldList.add("transfer_end_time");
            }
            if (dataTransferRecord.isTransferStatusUpdated()) {
                updateFieldList.add("transfer_status");
                updateFieldList.add("transfer_status_source");
            }
            if (dataTransferRecord.isCertaintyUpdated()) {
                updateFieldList.add("certainty");
                updateFieldList.add("certainty_source");
            }
            
            if (log.isTraceEnabled()) {
                if (dataTransferRecord.getTransferStartTime() > dataTransferRecord.getTransferEndTime()) {
                    log.trace("WARNING! transfer start time > transfer end time:  start time: " + (new java.sql.Timestamp(dataTransferRecord.getTransferStartTime())).toString() + "  end time: " + (new java.sql.Timestamp(dataTransferRecord.getTransferEndTime())).toString());
                }
            }
            
            int size = updateFieldList.size();
            if (size > 0) {
                statementBuilder.append(updateFieldList.get(0)).append("=?");
                for (int i = 1; i < size; i++) {
                    statementBuilder.append(", ").append(updateFieldList.get(i)).append("=?");
                }
                statementBuilder.append(" WHERE transfer_id=?");

                if (log.isDebugEnabled()) log.debug("SQL: " + statementBuilder.toString());
                
                statement = connection.prepareStatement(statementBuilder.toString());
            
                int index = 1;
                if (dataTransferRecord.isSenderInternalIDUpdated()) {
                    statement.setLong(index, dataTransferRecord.getSenderInternalID());
                    index++;
                }
                if (dataTransferRecord.isReceiverInternalIDUpdated()) {
                    statement.setLong(index, dataTransferRecord.getReceiverInternalID());
                    index++;
                }
                if (dataTransferRecord.isDataInternalIDUpdated()) {
                    statement.setLong(index, dataTransferRecord.getDataInternalID());
                    index++;
                }
                if (dataTransferRecord.isTransferStartTimeUpdated()) {
                    statement.setTimestamp(index, new java.sql.Timestamp(dataTransferRecord.getTransferStartTime()));
                    index++;
                }
                if (dataTransferRecord.isTransferEndTimeUpdated()) {
                    statement.setTimestamp(index, new java.sql.Timestamp(dataTransferRecord.getTransferEndTime()));
                    index++;
                }
                if (dataTransferRecord.isTransferStatusUpdated()) {
                    statement.setString(index, dataTransferRecord.getTransferStatus().getStatus().name());
                    index++;
                    statement.setString(index, dataTransferRecord.getTransferStatus().getSource().name());
                    index++;
                }
                if (dataTransferRecord.isCertaintyUpdated()) {
                    statement.setByte(index, dataTransferRecord.getCertainty().getCertaintyScore());
                    index++;
                    statement.setString(index, dataTransferRecord.getCertainty().getCertaintySource().name());
                    index++;
                }
                statement.setLong(index, dataTransferRecord.getTransferInternalID());
                long startTime = 0;
                if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                int result = statement.executeUpdate();
                if (plog.isTraceEnabled()) plog.trace("updateDataTransferRecord DB UPDATE time: " + (System.currentTimeMillis() - startTime));
                
                if (result <= 0) {
                    throw new IngestException("Failed to update data transfer record");
                }
            } else {
                if (log.isDebugEnabled()) log.debug("Nothing to update");
            }
        } finally {
            dataTransferRecord.resetUpdateFlags();
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    }
    
    /**
     * Update updated fields of the invocation record in DB
     * @param invocationRecord an InvocationRecord object with fields updated
     * @param connection an established connection to DB
     * @throws SQLException
     * @throws IngestException thrown when failed to update the fields
     * 
     * 
     */
    protected void updateInvocationRecord(InvocationRecord invocationRecord, Connection connection) throws SQLException, IngestException {
        PreparedStatement statement = null;
        
        try {
            StringBuilder statementBuilder = new StringBuilder("UPDATE exe_invocation SET ");
            List<String> updateFieldList = new ArrayList<String>();
            
            if (invocationRecord.isInvokerInternalIDUpdated()) {
                updateFieldList.add("invoker_id");
            }
            if (invocationRecord.isInvokeeInternalIDUpdated()) {
                updateFieldList.add("invokee_id");
            }
            if (invocationRecord.isInvocationStartTimeUpdated()) {
                updateFieldList.add("invocation_start_time");
            }
            if (invocationRecord.isExecutionEndTimeUpdated()) {
                updateFieldList.add("execution_end_time");
            }
            if (invocationRecord.isInvocationStatusUpdated()) {
                updateFieldList.add("invocation_status");
                updateFieldList.add("invocation_status_source");
            }
            if (invocationRecord.isExecutionStatusUpdated()) {
                updateFieldList.add("execution_status");
                updateFieldList.add("execution_status_source");
            }
            if (invocationRecord.isInvocationTypeUpdated()) {
                updateFieldList.add("invocation_type");
            }
            if (invocationRecord.isCertaintyUpdated()) {
                updateFieldList.add("certainty");
                updateFieldList.add("certainty_source");
            }
            
            int size = updateFieldList.size();
            
            if (size > 0) {
                statementBuilder.append(updateFieldList.get(0)).append("=?");
                for (int i = 1; i < size; i++) {
                    statementBuilder.append(", ").append(updateFieldList.get(i)).append("=?");
                }
                statementBuilder.append(" WHERE invocation_id=?");
            
                if (log.isDebugEnabled()) log.debug("SQL: " + statementBuilder.toString());
                
                statement = connection.prepareStatement(statementBuilder.toString());
                
                int index = 1;
                if (invocationRecord.isInvokerInternalIDUpdated()) {
                    statement.setLong(index, invocationRecord.getInvokerInternalID());
                    index++;
                }
                if (invocationRecord.isInvokeeInternalIDUpdated()) {
                    statement.setLong(index, invocationRecord.getInvokeeInternalID());
                    index++;
                }
                if (invocationRecord.isInvocationStartTimeUpdated()) {
                    statement.setTimestamp(index, new java.sql.Timestamp(invocationRecord.getInvocationStartTime()));
                    index++;
                }
                if (invocationRecord.isExecutionEndTimeUpdated()) {
                    statement.setTimestamp(index, new java.sql.Timestamp(invocationRecord.getExecutionEndTime()));
                    index++;
                }
                if (invocationRecord.isInvocationStatusUpdated()) {
                    statement.setString(index, invocationRecord.getInvocationStatus().getStatus().name());
                    index++;
                    statement.setString(index, invocationRecord.getInvocationStatus().getSource().name());
                    index++;
                }
                if (invocationRecord.isExecutionStatusUpdated()) {
                    statement.setString(index, invocationRecord.getExecutionStatus().getStatus().name());
                    index++;
                    statement.setString(index, invocationRecord.getExecutionStatus().getSource().name());
                    index++;
                }
                if (invocationRecord.isInvocationTypeUpdated()) {
                    statement.setString(index, invocationRecord.getInvocationType().name());
                    index++;
                }
                if (invocationRecord.isCertaintyUpdated()) {
                    statement.setByte(index, invocationRecord.getCertainty().getCertaintyScore());
                    index++;
                    statement.setString(index, invocationRecord.getCertainty().getCertaintySource().name());
                    index++;
                }
                statement.setLong(index, invocationRecord.getInvocationInternalID());
                
                long startTime = 0;
                if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                int result = statement.executeUpdate();
                if (plog.isTraceEnabled()) plog.trace("updateInvocationRecord DB UPDATE time: " + (System.currentTimeMillis() - startTime));
                
                if (result <= 0) {
                    throw new IngestException("Failed to update invocation record");
                }
            } else {
                if (log.isDebugEnabled()) log.debug("Nothing to update");
            }
        } finally {
            invocationRecord.resetUpdateFlags();
            if (statement != null) {
                statement.close();
                statement = null;
            }

        }
    }

    /**
     * Add a new FileObject into DB
     * @param fileObject FileObject to be added
     * @param quality quality of the FileObject
     * @param connection established connection to DB
     * @return internal ID of the newly added FileObject
     * @throws SQLException 
     * @throws IngestException thrown if failed to add the FileObject
     * 
     * 
     */
    protected Long addNewFileObject(FileObject fileObject, Quality quality, Connection connection) throws SQLException, IngestException {
        Long internalID = null;
        PreparedStatement statement = null;
        
        try {
            
            long ownerInternalID = INVALID_RECORD_ID;

            long startTime = 0;
            
            try {
            
                String ownerDN = fileObject.getOwnerDN();
                
                if (ownerDN != null) {
                    UserEntity userEntity = EntityFactory.createUserEntity(ownerDN);
                    if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                    UserRecord userRecord = getUserRecord(userEntity, connection);
                    if (plog.isTraceEnabled()) plog.trace("getUserRecord: " + (System.currentTimeMillis() - startTime));
                    
                    if (userRecord == null) {
                        if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                        ownerInternalID = addNewUserEntity(userEntity, connection);
                        if (plog.isTraceEnabled()) plog.trace("addNewUserEntity: " + (System.currentTimeMillis() - startTime));
                    } else {
                        ownerInternalID = userRecord.getInternalID();
                    }
                }
            } catch (SQLException e) {
                log.error("Failed to handle fileObject.ownerDN, but continue to add fileObject anyway.", e);
            } catch (IngestException ie) {
                log.error("Failed to handle fileObject.ownerDN, but continue to add fileObject anyway.", ie);
            }
            
            List<Annotation> annotationList = fileObject.getAnnotations();

            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            internalID = addNewDataObjectRecord(DataObjectEnum.FILE, quality, annotationList, connection);
            if (plog.isTraceEnabled()) plog.trace("addNewDataObjectRecord: " + (System.currentTimeMillis() - startTime));

            StringBuilder statementBuilder = new StringBuilder("INSERT INTO exe_file (file_id, file_uri");
            StringBuilder statementSuffixBuilder = new StringBuilder(" VALUES(?, ?");
            
            String fileURI = fileObject.getFileURI();
            
            long createTime = fileObject.getCreateTime();
            if (createTime > 0) {
                statementBuilder.append(",creation_date");
                statementSuffixBuilder.append(",?");
            }
            
            String md5Sum = fileObject.getMD5Sum();
            if (md5Sum != null) {
                statementBuilder.append(",md5_checksum");
                statementSuffixBuilder.append(",?");
            }
            
            String name = fileObject.getName();
            if (name != null) {
                statementBuilder.append(",file_name");
                statementSuffixBuilder.append(",?");
            }
            
            if (ownerInternalID != INVALID_RECORD_ID) {
                statementBuilder.append(",owner_id");
                statementSuffixBuilder.append(",?");
            }
            
            long size = fileObject.getSize();
            if (size >= 0) {
                statementBuilder.append(",size");
                statementSuffixBuilder.append(",?");
            }
            
            statementBuilder.append(")");
            statementSuffixBuilder.append(")");
            
//            String logMsg = null;
//            if (log.isTraceEnabled()) logMsg = statementBuilder.toString() + statementSuffixBuilder.toString();
            
            statement = connection.prepareStatement(statementBuilder.toString() + statementSuffixBuilder.toString());
            
            int index = 1;
            statement.setLong(index, internalID.longValue());
            index++;
            
            statement.setString(index, fileURI);
            index++;
            
//            if (log.isTraceEnabled()) logMsg += "\n" + internalID.longValue() + "\n" + fileURI;
            
            if(createTime > 0) {
                Timestamp timestamp = new Timestamp(createTime);
                statement.setTimestamp(index, timestamp);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + timestamp;
            }
            
            if (md5Sum != null) {
                statement.setString(index, md5Sum);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + md5Sum;
            }
            
            if (name != null) {
                statement.setString(index, name);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + name;
            }
            
            if (ownerInternalID != INVALID_RECORD_ID) {
                statement.setLong(index, ownerInternalID);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + ownerInternalID;
            }
            
            if (size >= 0) {
                statement.setLong(index, size);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + size;
            }
            
//            if (log.isTraceEnabled()) log.trace(logMsg);
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewFileObject DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (!(result > 0)) {
                throw new IngestException("Failed to add new file object");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            
        }
        return internalID;
    }
    
    
    /**
     * Add a new BlockObject into DB
     * @param blockObject BlockObject to be added
     * @param quality quality of the BlockObject
     * @param connection established connection to DB
     * @return DB internal ID of the newly added BlockObject
     * @throws SQLException
     * @throws IngestException thrown if failed to add the BlockObject
     * 
     * 
     */
    protected Long addNewBlockObject(BlockObject blockObject, Quality quality, Connection connection) throws SQLException, IngestException {
        Long internalID = null;
        PreparedStatement statement = null;
        
        try {
            List<Annotation> annotationList = blockObject.getAnnotations();
            
            internalID = addNewDataObjectRecord(DataObjectEnum.BLOCK, quality, annotationList, connection);
            
            String blockContent = blockObject.getBlockContent();
            long size = blockContent.length();
            
            String md5Sum = blockObject.getMD5();
            
            statement = connection.prepareStatement("INSERT INTO exe_block(block_id, md5_checksum, size, block_content) VALUES (?, ?, ?, ?)");
            statement.setLong(1, internalID.longValue());
            statement.setString(2, md5Sum);
            statement.setLong(3, size);
            statement.setString(4, blockContent);
            
//            if (log.isTraceEnabled()) log.trace("INSERT INTO exe_block(block_id, md5_checksum, size, block_content) VALUES (?, ?, ?, ?)" + "\n" + internalID.longValue() + "\n" + md5Sum + "\n" + size + "\n" + blockContent);
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewBlockObject DB INSERT time: " + (System.currentTimeMillis() - startTime));
             
            if (!(result > 0)) {
                throw new IngestException("Failed to add new block object");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            
        }
        return internalID;
    }
    
    /**
     * Add a new CollectionObject to DB
     * @param collectionObject CollectionObject to be added
     * @param quality quality of the CollectionObject
     * @param connection established connection to DB
     * @return DB internal ID of the newly added CollectionObject
     * @throws SQLException
     * @throws IngestException thrown when failed to add the CollectionObject
     * 
     * 
     */
    protected Long addNewCollectionObject(CollectionObject collectionObject, Quality quality, Connection connection) throws SQLException, IngestException {
        Long internalID = null;
        PreparedStatement statement = null;
        
        try {
            
            List<Annotation> annotationList = collectionObject.getAnnotations();
            
            internalID = addNewDataObjectRecord(DataObjectEnum.COLLECTION, quality, annotationList, connection);
            statement = connection.prepareStatement("INSERT INTO exe_data_collection(collection_id, collection_uri) VALUES (?, ?)");
            statement.setLong(1, internalID.longValue());
            String collectionURI = collectionObject.getCollectionURI();
            statement.setString(2, collectionURI);
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewCollectionObject DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (!(result > 0)) {
                throw new IngestException("Failed to add new collection");
            }
            
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            
        }
        
        return internalID;
    }
    
    /**
     * Add a list of members to a collection
     * @param collectionID DB internal ID of the collection
     * @param memberIDList List of DB internal IDs of members
     * @param mode if set to RETURN_IDS, method returns the DB internal IDs of all entries added; if set to QUICK, method executes faster by not returning the IDs.
     * @param connection established connection to DB
     * @return List of DB internal IDs of membership
     * @throws SQLException
     * @throws IngestException thrown if not all members are added to collection
     * 
     * 
     */
    protected List<Long> addNewMembersToCollection(Long collectionID, List<Long> memberIDList, MultiEntryMethodModeEnum mode, Connection connection) throws SQLException, IngestException {
        List<Long> membershipInternalIDList = null;
        PreparedStatement statement = null;
        
        try {
            StringBuilder builder = new StringBuilder("INSERT INTO exe_data_collection_membership(collection_id, member_id) VALUES (?,?)");
            int size = memberIDList.size();
            for (int i = 1; i < size; i++) {
                builder.append(",(?,?)");
            }
            
            statement = connection.prepareStatement(builder.toString());
            long collIDValue = collectionID.longValue();
            for (int i = 0; i < size; i++) {
                statement.setLong(i * 2 + 1, collIDValue);
                statement.setLong(i * 2 + 2, memberIDList.get(i).longValue());
            }
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewMembersToCollection DB INSERT time: " + (System.currentTimeMillis() - startTime));
            if (result < size) {
                throw new IngestException("Failed to add all members to collection");
            } else {
                if (MultiEntryMethodModeEnum.RETURN_IDS.equals(mode)) {
                    statement.close();
                    membershipInternalIDList = new ArrayList<Long>();
                    builder = new StringBuilder("SELECT membership_id FROM exe_data_collection_membership WHERE collection_id=? AND member_id IN (?");
                    for (int i = 1; i < size; i++) {
                        builder.append(",?");
                    }
                    
                    statement = connection.prepareStatement(builder.toString());
                    
                    int index = 1;
                    
                    statement.setLong(index, collectionID.longValue());
                    index++;
                    
                    for (int i = 0; i < size; i++) {
                        statement.setLong(index, memberIDList.get(i).longValue());
                        index++;
                    }

                    if (plog.isTraceEnabled()) startTime = System.currentTimeMillis(); 
                    ResultSet resultSet = statement.executeQuery();
                    if (plog.isTraceEnabled()) plog.trace("query member from membership time: " + (System.currentTimeMillis() - startTime));
                    while (resultSet.next()) {
                        membershipInternalIDList.add(Long.valueOf(resultSet.getLong("membership_id")));
                    }
                    resultSet.close();
                }
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return membershipInternalIDList;
    }
    
    /**
     * Add a DataObject or a nested DataObject collection tree into DB
     * 
     * @param dataObject the DataObject or a nested collection of DataObject to be added
     * @param quality quality of the DataObject to be added
     * @param connection established connection to DB
     * @return DB internal ID of the newly added DataObject or that of the newly added top-level collection 
     * @throws SQLException
     * @throws IngestException
     * 
     * 
     */
    protected Long addNewDataObjectTree(DataObject dataObject, Quality quality, Connection connection) throws SQLException, IngestException {
        Long internalID = null;
        
        if (dataObject != null) {
            DataObjectEnum dataObjectType = dataObject.getDataObjectType();

            switch (dataObjectType) {

            case FILE:
                internalID = addNewFileObject((FileObject)dataObject, quality, connection);
                break;
            case BLOCK:
                internalID = addNewBlockObject((BlockObject)dataObject, quality, connection);
                break;
            case COLLECTION:
                CollectionObject collectionObject = (CollectionObject)dataObject;
                internalID = addNewCollectionObject(collectionObject, quality, connection);
                int childrenCount = collectionObject.getChildrenCount();
                List<Long> memberInternalIDList = null;
                if (childrenCount > 0) {
                    memberInternalIDList = new ArrayList<Long>();
                    List<DataObject> children = collectionObject.getChildren();
                    for (DataObject child : children) {
                        Long childID = addNewDataObjectTree(child, quality, connection);
                        memberInternalIDList.add(childID);
                    }
                }
                addNewMembersToCollection(internalID, memberInternalIDList, MultiEntryMethodModeEnum.QUICK, connection);
                break;
            default:
                assert false : "Bad data object type: " + dataObjectType.name();

            }
        }
        
        return internalID;
    }

    /**
     * Add a new data transfer record to DB
     * @param dataTransferRecord a DataTransferRecord containing information regarding the data transfer.  The field dataTransferInternalID of this object will be updated to the DB internal ID of the new record after a successful DB insert
     * @param connection an established connection to DB
     * @throws SQLException
     * @throws IngestException thrown if failed to add the new data transfer record
     * 
     * 
     */
    protected void addNewDataTransferRecord(DataTransferRecord dataTransferRecord, Connection connection) throws SQLException, IngestException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO exe_data_transfer (sender_id, receiver_id, data_id, transfer_start_time, transfer_end_time, transfer_status, transfer_status_source, certainty, certainty_source) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setLong(1, dataTransferRecord.getSenderInternalID());
            statement.setLong(2, dataTransferRecord.getReceiverInternalID());
            statement.setLong(3, dataTransferRecord.getDataInternalID());
            statement.setTimestamp(4, new java.sql.Timestamp(dataTransferRecord.getTransferStartTime()));
            statement.setTimestamp(5, new java.sql.Timestamp(dataTransferRecord.getTransferEndTime()));
            statement.setString(6, dataTransferRecord.getTransferStatus().getStatus().name());
            statement.setString(7, dataTransferRecord.getTransferStatus().getSource().name());
            statement.setByte(8, dataTransferRecord.getCertainty().getCertaintyScore());
            statement.setString(9, dataTransferRecord.getCertainty().getCertaintySource().name());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewDataTransferRecord DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                dataTransferRecord.setTransferInternalID(getLastAutoID(connection));
            } else {
                throw new IngestException("Failed to add new data transfer record");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    }


    /**
     * Add annotations of entity to DB
     * @param entityInternalID DB internal ID of the entity
     * @param annotationList List of annotations;
     * @param connection established connection to DB
     * @throws SQLException
     * @throws IngestException
     */
    protected void addNewEntityAnnotations(long entityInternalID, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        addAnnotations("exe_entity_annotation", "entity_id", entityInternalID, annotationList, connection);
    }
    
    
    /**
     * Add annotations of execution-level data lifecycle to DB
     * @param eventInternalID DB internal ID of the data lifecycle event
     * @param annotationList List of annotations;
     * @param connection established connection to DB
     * @throws SQLException
     * @throws IngestException
     */
    protected void addNewDataLifeCycleAnnotations(long eventInternalID, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        addAnnotations("exe_data_lifecycle_annotation", "event_id", eventInternalID, annotationList, connection);
    }
    /**
     * Add new annotations for invocation to DB
     * @param invocationInternalID DB internal ID of the invocation
     * @param annotationList List of annotations to be added
     * @param connection established connection to DB
     * @throws SQLException
     * @throws IngestException thrown if not all annotations are added to DB
     * 
     * 
     */
    protected void addNewInvocationAnnotations(long invocationInternalID, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        addAnnotations("exe_invocation_annotation", "invocation_id", invocationInternalID, annotationList, connection);

    }

    /**
     * Add new annotations for data object to DB
     * @param dataObjectInternalID DB internal ID of the data object
     * @param annotationList List of annotations to be added
     * @param connection an established connection to DB
     * @throws SQLException
     * @throws IngestException thrown if not all annotations are added to DB
     * 
     * 
     */
    protected void addNewDataObjectAnnotations(long dataObjectInternalID, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        addAnnotations("exe_data_object_annotation", "object_id", dataObjectInternalID, annotationList, connection);


    }
    
    
    /**
     * Add new annotations for data transfer to DB
     * @param dataObjectInternalID DB internal ID of the data transfer
     * @param annotationList List of annotations to be added
     * @param connection an established connection to DB
     * @throws SQLException
     * @throws IngestException thrown if not all annotations are added to DB
     * 
     * 
     */
    protected void addNewDataTransferAnnotations(long dataTransferInternalID, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        addAnnotations("exe_data_transfer_annotation", "transfer_id", dataTransferInternalID, annotationList, connection);


    }

    /**
     * Save information regarding an invocation into DB.  The DB internal IDs of the invoker and the invokee must be known
     * @param notificationSummary summary of the notification the invocation information was from
     * @param invokerID DB internal ID of the invoker entity
     * @param invokeeID DB internal ID of the invokee entity
     * @param invocationType type of invocation
     * @param time time of invocation
     * @param annotationList List of annotations
     * @param certainty certainty of the invocation
     * @param connection established connection to DB
     * @return record of invocation
     * @throws SQLException
     * @throws IngestException
     * 
     * 
     */
    protected InvocationRecord saveInvocation(NotificationSummary notificationSummary, long invokerID, long invokeeID, InvocationTypeEnum invocationType, Calendar time, List<Annotation> annotationList, Certainty certainty, Connection connection) throws SQLException, IngestException {

        InvocationRecord invocationRecord = null;


        invocationRecord = getInvocationRecord(invokerID, invokeeID, invocationType, connection);
        
        StatusWithSource invocationStatus = determineInvocationStatusFromNotification(notificationSummary);
        StatusWithSource executionStatus = determineExecutionStatusFromNotification(notificationSummary);

        if (invocationRecord == null) {
            invocationRecord = new InvocationRecord(INVALID_RECORD_ID, invokerID, invokeeID, invocationType, time.getTimeInMillis(), time.getTimeInMillis(), invocationStatus, executionStatus, certainty);
            addNewInvocationRecord(invocationRecord, connection);

        } else {
            if (time.getTimeInMillis() > invocationRecord.getExecutionEndTime()) {
                invocationRecord.setExeuctionEndTime(time.getTimeInMillis());
            }
            
            if (invocationStatus.isMoreCertainThan(invocationRecord.getInvocationStatus())) {
                invocationRecord.setInvocationStatus(invocationStatus);
            }
            
            if (executionStatus.isMoreCertainThan(invocationRecord.getExecutionStatus())) {
                invocationRecord.setExecutionStatus(executionStatus);
            }
            
            if (certainty.isMoreCertainThan(invocationRecord.getCertainty())) {
                invocationRecord.setCertainty(certainty);
            }
            
            if (invocationRecord.isUpdated()) {
                updateInvocationRecord(invocationRecord, connection);
            }
        }
        
        if (invocationRecord != null && invocationRecord.getInvocationInternalID() != INVALID_RECORD_ID) {
        	
        	/* Edit by You-Wei Cheah (blotted on 10/10/2011)
        	 *  
        	 * Removed params from invocationType */
//            if (params != null) {
//
//                Long blockInternalID = getDataObjectInternalID(params, connection);
//                if (blockInternalID == null) {
//                    Quality quality = new Quality(Quality.DEFAULT_QUALITY_SCORE, QualitySourceEnum.UNKNOWN);
//                    blockInternalID = addNewDataObjectTree(params, quality, connection);
//                    addNewInvocationData(invocationRecord.getInvocationInternalID(), blockInternalID.longValue(), InvocationDataEnum.PARAMS, connection);
//                } else {
//                    Long comboID = getInvocationDataInternalID(invocationRecord.getInvocationInternalID(), blockInternalID.longValue(), InvocationDataEnum.PARAMS, connection);
//                    if (comboID == null) {
//                        addNewInvocationData(invocationRecord.getInvocationInternalID(), blockInternalID.longValue(), InvocationDataEnum.PARAMS, connection);
//                    }
//                	/* Edit by You-Wei Cheah (added on 09/20/2011)
//                	 * This is to enable the processing of the 
//                	 * annotation block even though the block record is present. */
//                    addNewDataObjectAnnotations(blockInternalID, params.getAnnotations(), connection);                       
//                }
//            	
//            	/*Quality quality = new Quality(Quality.DEFAULT_QUALITY_SCORE, QualitySourceEnum.UNKNOWN);
//                Long blockInternalID = addNewDataObjectTree(params, quality, connection);
//                addNewInvocationData(invocationRecord.getInvocationInternalID(), blockInternalID.longValue(), InvocationDataEnum.PARAMS, connection);           
//            	*/
//            }        
            if (annotationList != null && annotationList.size() > 0) {
                addNewInvocationAnnotations(invocationRecord.getInvocationInternalID(), annotationList, connection);
            }
        } else {
            throw new IngestException("Failed to save invocation");
        }
        
        return invocationRecord;
    }
    
    /**
     * Take apart different information contained in an invocation response and save them into DB
     * @param notificationType type of the notification the invocation response was from 
     * @param invoker Entity of the invoker, i.e. initiator of the invocation
     * @param invokee Entity of the invokee, i.e. what is being invoked
     * @param invocationType type of the invocation
     * @param time time of the response
     * @param dataType type of the response, whether it is RESULT or FAULT
     * @param response the response data object
     * @param annotationList List of annotations regarding the data transfer
     * @param quality quality of the response
     * @param connection established connection to DB
     * @return record of invocation response
     * @throws SQLException
     * @throws IngestException thrown if some information failed to be saved to DB
     * 
     * 
     * 
     */
    
    protected InvocationResponseRecord saveInvocationResponse(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar time, InvocationDataEnum dataType, DataObject response, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        
        if (log.isTraceEnabled()) {
            switch (invoker.getEntityCategory()) {
            case METHOD:
                log.trace("invoker method uri: " + ((MethodEntity)invoker).getMethodID());
                break;
            case SERVICE:
                log.trace("invoker service uri: " + ((ServiceEntity)invoker).getServiceID());
                break;
            case USER:
                log.trace("invoker user dn: " + ((UserEntity)invoker).getUserDN());
                break;
            case WORKFLOW:
                log.trace("invoker workflow uri: " + ((WorkflowEntity)invoker).getWorkflowID());
                break;
            }
            
            switch (invokee.getEntityCategory()) {
            case METHOD:
                log.trace("invokee method uri: " + ((MethodEntity)invokee).getMethodID());
                break;
            case SERVICE:
                log.trace("invokee service uri: " + ((ServiceEntity)invokee).getServiceID());
                break;
            case USER:
                log.trace("invokee user dn: " + ((UserEntity)invokee).getUserDN());
                break;
            case WORKFLOW:
                log.trace("invokee workflow uri: " + ((WorkflowEntity)invokee).getWorkflowID());
                break;
            }
            
        }

        InvocationResponseRecord invocationResponseRecord = null;
        
        Long invokerID = null;
        Long invokeeID = null;
        
        // insert the invoker-entity record, as appropriate
        invokerID = insertEntityRecord(notificationSummary, invoker, connection);
        
        // insert the invokee-entity record, as appropriate
        invokeeID = insertEntityRecord(notificationSummary, invokee, connection);

        Certainty certainty = new Certainty(Certainty.DEFAULT_CERTAINTY_SCORE, CertaintySourceEnum.INFERENCE);
        
        if (log.isTraceEnabled()) {
            if (invokerID.longValue() == invokeeID.longValue()) {
                log.trace("WARNING! identical invoker ID and invokee ID: invokerID: " + invokerID.longValue() + " invokeeID: " + invokeeID);
            }
        }
        InvocationRecord invocationRecord = saveInvocation(notificationSummary, invokerID.longValue(), invokeeID.longValue(), invocationType, time, null, certainty, connection);
        if (log.isDebugEnabled()) log.debug("invocation record ID: " + invocationRecord.getInvocationInternalID()); 
        
        Long dataObjectID = getDataObjectInternalID(response, connection);

        if (dataObjectID == null) {
            Quality quality = new Quality(Quality.DEFAULT_QUALITY_SCORE, QualitySourceEnum.UNKNOWN);
            dataObjectID = addNewDataObjectTree(response, quality, connection);
            addNewInvocationData(invocationRecord.getInvocationInternalID(), dataObjectID.longValue(), dataType, connection);
        } else {
            Long comboInternalID = getInvocationDataInternalID(invocationRecord.getInvocationInternalID(), dataObjectID.longValue(), dataType, connection);
            if (comboInternalID == null) {
                addNewInvocationData(invocationRecord.getInvocationInternalID(), dataObjectID.longValue(), dataType, connection);
            }
           	/* Edit by You-Wei Cheah (added on 09/20/2011)
        	 * This is to enable the processing of the 
        	 * annotation block even though the file record is present. */
            addNewDataObjectAnnotations(dataObjectID, response.getAnnotations(), connection);            
        }               

        /*Quality quality = new Quality(Quality.DEFAULT_QUALITY_SCORE, QualitySourceEnum.UNKNOWN);
        Long dataObjectID = addNewDataObjectTree(response, quality, connection);
        addNewInvocationData(invocationRecord.getInvocationInternalID(), dataObjectID.longValue(), dataType, connection);
        */
        
        DataTransferRecord dataTransferRecord = saveDataTransfer(notificationSummary, invokeeID.longValue(), invokerID.longValue(), dataObjectID.longValue(), time, annotationList, connection);

        invocationResponseRecord = new InvocationResponseRecord(invocationRecord, dataTransferRecord);

        return invocationResponseRecord;
    }

    /**
     * Get DB internal ID of invocation data
     * @param invocationID DB internal ID of invocation
     * @param dataID DB internal ID of data
     * @param dataType the role of the data
     * @param connection established connection to DB
     * @return DB internal ID of the combination, or null if no such combination is in DB
     * @throws SQLException
     */
    protected Long getInvocationDataInternalID (long invocationID, long dataID, InvocationDataEnum dataType, Connection connection) throws SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT combination_id FROM exe_invocation_data WHERE invocation_id=? AND block_id=? AND role=?");
            statement.setLong(1, invocationID);
            statement.setLong(2, dataID);
            statement.setString(3, dataType.name());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("query invocation data time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                internalID = Long.valueOf(resultSet.getLong("combination_id"));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }
    
    /**
     * Save information regarding data transfer into DB
     * @param notificationSummary summary of source notification
     * @param senderID DB internal ID of sender
     * @param receiverID DB internal ID of receiver
     * @param dataObjectID DB internal ID of data object being transferred
     * @param time transfer time
     * @param annotationList list of annotations
     * @param connection established connection to DB
     * @return data transfer record
     * @throws SQLException
     * @throws IngestException thrown when failed to save data transfer
     * 
     * 
     */
    protected DataTransferRecord saveDataTransfer(NotificationSummary notificationSummary, long senderID, long receiverID, long dataObjectID, Calendar time, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
//        Long dataTransferID = null;

        if (log.isDebugEnabled()) {
            log.debug("senderID: " + senderID + "  receiverID: " + receiverID);
            if (log.isTraceEnabled() && (senderID == receiverID)) log.trace("WARNING! identical senderID and receiverID");
        }
        
        DataTransferRecord dataTransferRecord = null;
        dataTransferRecord = getDataTransferRecord(senderID, receiverID, dataObjectID, connection);


        Certainty dataTransferCertainty = new Certainty(Certainty.DEFAULT_CERTAINTY_SCORE, CertaintySourceEnum.NOTIFICATION);
        StatusWithSource dataTransferStatus = determineDataTransferStatusFromNotification(notificationSummary);

        if (dataTransferRecord == null) {

            dataTransferRecord = new DataTransferRecord(senderID, receiverID, dataObjectID, time.getTimeInMillis(), time.getTimeInMillis(), dataTransferStatus, dataTransferCertainty);

            addNewDataTransferRecord(dataTransferRecord, connection);

        } else {
            if (time.getTimeInMillis() > dataTransferRecord.getTransferEndTime()) {
                dataTransferRecord.setTransferEndTime(time.getTimeInMillis());
            }

            if (dataTransferStatus.isMoreCertainThan(dataTransferRecord.getTransferStatus())) {
                dataTransferRecord.setTransferStatus(dataTransferStatus);
            }

            if (dataTransferCertainty.isMoreCertainThan(dataTransferRecord.getCertainty())) {
                dataTransferRecord.setCertainty(dataTransferCertainty);
            }

            if (dataTransferRecord.isUpdated()) {
                updateDataTransferRecord(dataTransferRecord, connection);
            }
        }
        
        if (dataTransferRecord != null && dataTransferRecord.getTransferInternalID() != INVALID_RECORD_ID) {
            addNewDataTransferAnnotations(dataTransferRecord.getTransferInternalID(), annotationList, connection);
        } else {
            throw new IngestException("Failed to save data transfer");
        }
        
        return dataTransferRecord;
    }

    /**
     * Save information regarding invocation response transfer status to DB
     * @param notificationSummary summary of the source notification
     * @param invoker Entity of the invoker, i.e. initiator of the invocation
     * @param invokee Entity of the invokee, i.e. what is being invoked
     * @param invocationType type of invocation
     * @param transferStartTime time the transfer starts
     * @param dataType type of the response
     * @param response response data object
     * @param status status of the transfer
     * @param statusTime time of the status
     * @param annotationList list of annotations
     * @param connection an established connection to DB
     * @throws SQLException
     * @throws IngestException
     * 
     * 
     */
    protected void saveInvocationResponseTransferStatus(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar transferStartTime, InvocationDataEnum dataType, DataObject response, StatusEnum status, Calendar statusTime, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {

        InvocationResponseRecord invocationResponseRecord = saveInvocationResponse(notificationSummary, invoker, invokee, invocationType, transferStartTime, dataType, response, annotationList, connection);
        
        StatusWithSource invocationStatus = determineInvocationStatusFromNotification(notificationSummary);
        StatusWithSource executionStatus = determineExecutionStatusFromNotification(notificationSummary);
        StatusWithSource transferStatus = determineDataTransferStatusFromNotification(notificationSummary);
        
        InvocationRecord invocationRecord = invocationResponseRecord.getInvocationRecord();
        
        if (statusTime.getTimeInMillis() > invocationRecord.getExecutionEndTime()) {
            invocationRecord.setExeuctionEndTime(statusTime.getTimeInMillis());
        }
        if (invocationStatus.isMoreCertainThan(invocationRecord.getInvocationStatus())) {
            invocationRecord.setInvocationStatus(invocationStatus);
        }
        if (executionStatus.isMoreCertainThan(invocationRecord.getExecutionStatus())) {
            invocationRecord.setExecutionStatus(executionStatus);
        }
        if (invocationRecord.isUpdated()) {
            updateInvocationRecord(invocationRecord, connection);
        }
        
        DataTransferRecord dataTransferRecord = invocationResponseRecord.getDataTransferRecord();
        
        if (statusTime.getTimeInMillis() > dataTransferRecord.getTransferEndTime()) {
            dataTransferRecord.setTransferEndTime(statusTime.getTimeInMillis());
        }
        if (transferStatus.isMoreCertainThan(dataTransferRecord.getTransferStatus())) {
            dataTransferRecord.setTransferStatus(transferStatus);
        }
        if (dataTransferRecord.isUpdated()) {
            updateDataTransferRecord(dataTransferRecord, connection);
        }
    }

    
    /**
     * 
     * @param notificationSummary
     * @param invoker
     * @param invokee
     * @param invocationType
     * @param invocationStartTime
     * @param status
     * @param statusTime
     * @param annotationList
     * @param connection
     * @throws SQLException
     * @throws IngestException
     * 
     * 
     */

    protected InvocationRecord saveInvocationStatus(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar invocationStartTime, StatusEnum status, Calendar statusTime, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {

        InvocationRecord invocationRecord = saveInvocation(notificationSummary, invoker, invokee, invocationType, invocationStartTime, annotationList, connection);
        
        StatusWithSource invocationStatus = determineInvocationStatusFromNotification(notificationSummary);
        StatusWithSource executionStatus = determineExecutionStatusFromNotification(notificationSummary);
        
        if (statusTime.getTimeInMillis() > invocationRecord.getExecutionEndTime()) {
            invocationRecord.setExeuctionEndTime(statusTime.getTimeInMillis());
        }
        if (invocationStatus.isMoreCertainThan(invocationRecord.getInvocationStatus())) {
            invocationRecord.setInvocationStatus(invocationStatus);
        }
        if (executionStatus.isMoreCertainThan(invocationRecord.getExecutionStatus())) {
            invocationRecord.setExecutionStatus(executionStatus);
        }
        if (invocationRecord.isUpdated()) {
            updateInvocationRecord(invocationRecord, connection);
        }
        
        return invocationRecord;

    }


    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.IngesterImplementer#storeInvocationResponse(org.dataandsearch.www.karma.EntityType, org.dataandsearch.www.karma.EntityType, edu.indiana.dsi.karma.ingest.IngesterImplementer.InvocationTypeEnum, java.util.Calendar, edu.indiana.dsi.karma.ingest.IngesterImplementer.InvocationDataEnum, edu.indiana.dsi.karma.ingest.DataObject, java.util.List)
     * 
     * 
     */
    @Override
    public void storeInvocationResponse(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar time, InvocationDataEnum dataType, DataObject response, List<Annotation> annotationList) throws IngestException {
          
        Connection connection = null;
        try {
            connection = getConnection();
//            Quality quality = new Quality(Quality.DEFAULT_QUALITY_SCORE, QualitySourceEnum.UNKNOWN);
            saveInvocationResponse(notificationSummary, invoker, invokee, invocationType, time, dataType, response, annotationList, connection);
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }
    }
    
    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.IngesterImplementer#storeInvocationResponseTransferStatus(edu.indiana.dsi.karma.ingest.IngesterImplementer.NotificationTypeSummary, org.dataandsearch.www.karma.EntityType, org.dataandsearch.www.karma.EntityType, edu.indiana.dsi.karma.ingest.IngesterImplementer.InvocationTypeEnum, java.util.Calendar, edu.indiana.dsi.karma.ingest.IngesterImplementer.InvocationDataEnum, edu.indiana.dsi.karma.ingest.DataObject, edu.indiana.dsi.karma.ingest.IngesterImplementer.StatusEnum, java.util.Calendar, java.util.List)
     * 
     * 
     */
    @Override
    public void storeInvocationResponseTransferStatus(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar transferStartTime, InvocationDataEnum dataType, DataObject response, StatusEnum transferStatus, Calendar statusTime, List<Annotation> annotationList) throws IngestException {
        Connection connection = null;
        try {
            connection = getConnection();
            saveInvocationResponseTransferStatus(notificationSummary, invoker, invokee, invocationType, transferStartTime, dataType, response, transferStatus, statusTime, annotationList, connection);
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }
        
    }

    @Override
    public void storeDataLifeCycle(NotificationSummary notificationSummary, EntityObject entity, DataObject dataObject, Calendar time, DataLifeCycleEnum stage, String dataRole, List<Annotation> annotationList) throws IngestException {
        Connection connection = null;
        try {
            long startTime = 0;
//            long endTime = 0;
            
            connection = getConnection();
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            saveDataLifeCycle(notificationSummary, entity, dataObject, time, stage, dataRole, annotationList, connection);
            if (plog.isTraceEnabled()) plog.trace("saveDataLifeCycle: " + (System.currentTimeMillis() - startTime));
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }
    }

    /**
     * Get DB internal ID of a file object.
     * 
     * If the file object does not have MD5 checksum specified, the algorithm selects the first result from DB.  If the file object has MD5 checksum, the algorithm tries to find the first result in the DB that has the same checksum, and if that cannot be found, it uses the first one in the DB that does not have MD5 specified 
     * @param fileObject file object whose internal ID is to be retrieved
     * @param connection established connection to DB
     * @return DB internal ID of the file object, or null if the file object cannot be found in DB
     * @throws SQLException
     */
    protected Long getFileObjectInternalID(FileObject fileObject, Connection connection) throws SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String fileURI = fileObject.getFileURI();
            String md5Sum = fileObject.getMD5Sum();
            
            statement = connection.prepareStatement("SELECT file_id, md5_checksum FROM exe_file WHERE file_uri=?");
            statement.setString(1, fileURI);
//            if (log.isTraceEnabled()) log.trace("SELECT file_id, md5_checksum FROM exe_file WHERE file_uri=?" + "\n" + fileURI);
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("query file id time: " + (System.currentTimeMillis() - startTime));
            if (md5Sum == null) {
                if (resultSet.next()) {
                    internalID = Long.valueOf(resultSet.getLong("file_id"));
                }
            } else {
                long noMD5ID = -1;
                while (resultSet.next()) {
                    String checksum = resultSet.getString("md5_checksum");
                    if (md5Sum.equalsIgnoreCase(checksum)) {
                        internalID = Long.valueOf(resultSet.getLong("file_id"));
                        break;
                    } else if (checksum == null && noMD5ID > 0) {
                        noMD5ID = resultSet.getLong("file_id");
                    }
                }
                if (internalID == null && noMD5ID > 0) {
                    internalID = Long.valueOf(noMD5ID);
                }
                
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }
    
    /**
     * Get DB internal ID of the collection.
     * 
     * Get the DB internal ID of the collection whose collection URI matches that of the given collection
     * 
     * @param collectionObject collection object whose DB internal ID is to be retrieved
     * @param connection established connection to DB
     * @return DB internal ID of the collection, or null if the collection is not found in DB
     * @throws SQLException
     */
    protected Long getCollectionObjectInternalID(CollectionObject collectionObject, Connection connection) throws SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            String collectionURI = collectionObject.getCollectionURI();
            
            statement = connection.prepareStatement("SELECT collection_id FROM exe_data_collection WHERE collection_uri=?");
            statement.setString(1, collectionURI);
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("get collection object id time: " + (System.currentTimeMillis() - startTime));
            if (resultSet.next()) {
                internalID = Long.valueOf(resultSet.getLong("collection_id"));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }
    
    protected Long getBlockObjectInternalID(BlockObject blockObject, Connection connection) throws SQLException {
        Long internalID = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        
        try {
            String md5Sum = blockObject.getMD5();
            
            if (md5Sum != null) {
                statement = connection.prepareStatement("SELECT block_id FROM exe_block WHERE md5_checksum=?");
                statement.setString(1, md5Sum);
//                if (log.isTraceEnabled()) log.trace("SELECT block_id FROM exe_block WHERE md5_checksum=?" + "\n" + md5Sum);
                long startTime = 0;
                if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                resultSet = statement.executeQuery();
                if (plog.isTraceEnabled()) plog.trace("get block id based on checksum time: " + (System.currentTimeMillis() - startTime));
                if (resultSet.next()) {
                    internalID = Long.valueOf(resultSet.getLong("block_id"));
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }
    
    /**
     * Get DB internal ID of the data object
     * @param dataObject data object whose DB internal ID is to be retrieved
     * @param connection established connection to DB
     * @return DB internal ID of the data object, or null if the data object is not in DB
     * @throws SQLException
     * @throws IngestException
     */
    protected Long getDataObjectInternalID(DataObject dataObject, Connection connection) throws SQLException, IngestException {
        DataObjectEnum dataObjectType = dataObject.getDataObjectType();
        switch (dataObjectType) {
        case FILE:
            return getFileObjectInternalID((FileObject)dataObject, connection);
        case COLLECTION:
            return getCollectionObjectInternalID((CollectionObject)dataObject, connection);
        case BLOCK:
            return getBlockObjectInternalID((BlockObject)dataObject, connection);
        }
        return null;
    }
    
    
    /**
     * Save information regarding data life cycle into DB
     * @param notificationSummary summary of source notification
     * @param entity entity that acts on the data object
     * @param dataObject the data object whose life cycle is to be stored
     * @param time time of the action
     * @param stage action performed on the data object
     * @param dataRole optional role of the data object
     * @param annotationList list of annotation regarding the event
     * @param connection established connection to DB
     * @return DB internal ID of the data life cycle record
     * @throws SQLException
     * @throws IngestException
     */
    protected Long saveDataLifeCycle(NotificationSummary notificationSummary, EntityObject entity, DataObject dataObject, Calendar time, DataLifeCycleEnum stage, String dataRole, List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        Long internalID = null;

        long startTime = 0;
        
        if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                
        Long entityInternalID = insertEntityRecord(notificationSummary, entity, connection);

        if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();

        Long dataInternalID = getDataObjectInternalID(dataObject, connection);
        if (plog.isTraceEnabled()) plog.trace("getDataObjectInternalID: " + (System.currentTimeMillis() - startTime));
        
        if (dataInternalID == null) {
            Quality quality = new Quality(Quality.DEFAULT_QUALITY_SCORE, QualitySourceEnum.UNKNOWN);
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            dataInternalID = addNewDataObjectTree(dataObject, quality, connection);
            if (plog.isTraceEnabled()) plog.trace("addNewDataObjectTree: " + (System.currentTimeMillis() - startTime));
        } else {
        	/* Edit by You-Wei Cheah (added on 09/20/2011)
        	 * This is to enable the processing of the 
        	 * annotation block even though the file record is present. */
            addNewDataObjectAnnotations(dataInternalID, dataObject.getAnnotations(), connection);
        }
        
        
        /*Quality quality = new Quality(Quality.DEFAULT_QUALITY_SCORE, QualitySourceEnum.UNKNOWN);
        if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
        Long dataInternalID = addNewDataObjectTree(dataObject, quality, connection);
        if (plog.isTraceEnabled()) plog.trace("addNewDataObjectTree: " + (System.currentTimeMillis() - startTime));*/
        
        Certainty certainty = new Certainty(Certainty.DEFAULT_CERTAINTY_SCORE, CertaintySourceEnum.NOTIFICATION);

        if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
        internalID = addNewDataLifeCycle(notificationSummary, entityInternalID.longValue(), dataInternalID.longValue(), time, stage, dataRole, annotationList, certainty, connection);
        if (plog.isTraceEnabled()) plog.trace("addNewDataLifeCycle: " + (System.currentTimeMillis() - startTime));

        return internalID;

    }
    
    /**
     * Add a new data life cycle event to DB
     * @param notificationSummary summary of source notification
     * @param entityInternalID DB internal ID of the actor
     * @param dataInternalID DB internal ID of the data object
     * @param time time of the event
     * @param stage event action
     * @param dataRole optional role of the data object
     * @param annotationList List of annotations regarding the event
     * @param certainty certainty of the event
     * @param connection established connection to DB
     * @return DB internal ID of the newly added event
     * @throws IngestException thrown if failed to add the event to DB
     * @throws SQLException
     */
    protected Long addNewDataLifeCycle(NotificationSummary notificationSummary, long entityInternalID, long dataInternalID, Calendar time, DataLifeCycleEnum stage, String dataRole, List<Annotation> annotationList, Certainty certainty, Connection connection) throws IngestException, SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        try {
            StringBuilder builder = new StringBuilder("INSERT INTO exe_data_lifecycle (actor_id, data_id, event_action, event_time, certainty, certainty_source");
            StringBuilder tailBuilder = new StringBuilder(" VALUES(?, ?, ?, ?, ?, ?");
            if (dataRole != null) {
                builder.append(", role");
                tailBuilder.append(", ?");
            }
            builder.append(")");
            tailBuilder.append(")");
            
//            String logMsg = null;
//            if (log.isTraceEnabled()) logMsg = builder.toString() + tailBuilder.toString();
            
            statement = connection.prepareStatement(builder.toString() + tailBuilder.toString());
            
            int index = 1;
            
            statement.setLong(index++, entityInternalID);
            statement.setLong(index++, dataInternalID);
            statement.setString(index++, stage.name());
            statement.setTimestamp(index++, new java.sql.Timestamp(time.getTimeInMillis()));
            statement.setByte(index++, certainty.getCertaintyScore());
            statement.setString(index++, certainty.getCertaintySource().name());
            
//            if (log.isTraceEnabled()) logMsg += "\n" + entityInternalID + "\n" + dataInternalID + "\n" + stage.name() + "\n" + new java.sql.Timestamp(time.getTimeInMillis()) + "\n" + certainty.getCertaintyScore() + "\n" + certainty.getCertaintySource().name();
            if (dataRole != null) {
                statement.setString(index++, dataRole);
//                if (log.isTraceEnabled()) logMsg += "\n" + dataRole;
            }
            
//            if (log.isTraceEnabled()) log.trace(logMsg);
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewDataLifeCycle DB INSERT time: " + (System.currentTimeMillis() - startTime));
            if (result > 0) {
                internalID = getLastAutoID(connection);
                addNewDataLifeCycleAnnotations(internalID.longValue(), annotationList, connection);
            } else {
                throw new IngestException("Failed to add new data life cycle");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }

        }
        return internalID;
    }
    
//    public EntityCategoryEnum determineEntityCategory(EntityType entity) throws IngestException {
//        EntityCategoryEnum entityCategory = null;
//        
//        if (entity.isSetUserInformation()) {
//            entityCategory = EntityCategoryEnum.USER;
//        } else if (entity.isSetWorkflowInformation()) {
//            entityCategory = EntityCategoryEnum.WORKFLOW;
//        } else if (entity.isSetServiceInformation()) {
//            entityCategory = EntityCategoryEnum.SERVICE;
//        } else if (entity.isSetMethodInformation()) {
//            entityCategory = EntityCategoryEnum.METHOD;
//        }
//        
//        return entityCategory;
//    }
    
//    public EntitySubtypeEnum determineEntitySubtype(EntityType entity) throws IngestException {
//        EntitySubtypeEnum entitySubtype = null;
//        if(entity.getSubtype().toString().equals("CONTROLLER")){
//            entitySubtype = EntitySubtypeEnum.CONTROLLER;
//        }
//        else if(entity.getSubtype().toString().equals("PROXY")){
//            entitySubtype = EntitySubtypeEnum.PROXY;
//        }
//        else {
//            entitySubtype = EntitySubtypeEnum.REGULAR;
//        }
//        
//        return entitySubtype;
//    }

    /**
     * Retrieves a user reocrd
     * @param entity entity containing information about a user, specifically the DN of the user
     * @param connection established connection to DB
     * @return UserRecord object containing information about the user, or null if the user is not in DB
     * @throws SQLException
     */
    protected UserRecord getUserRecord(UserEntity entity, Connection connection) throws SQLException {
        if (log.isDebugEnabled()) log.debug("UserEntity DN: " + entity.getUserDN());
        
        UserRecord userRecord = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT personnel_id, name, affiliation, email FROM reg_personnel WHERE dn=?");
            String dn = entity.getUserDN();
            statement.setString(1, dn);
            
//            if (log.isTraceEnabled()) log.trace("SELECT personnel_id, name, affiliation, email FROM reg_personnel WHERE dn=?" + "\n" + dn);
  
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("get user record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                long internalID = resultSet.getLong("personnel_id");
                String name = resultSet.getString("name");
                if (resultSet.wasNull()) {
                    name = null;
                }
                String affiliation = resultSet.getString("affiliation");
                if (resultSet.wasNull()) {
                    affiliation = null;
                }
                String email = resultSet.getString("email");
                if (resultSet.wasNull()) {
                    email = null;
                }

                userRecord = new UserRecord(dn, internalID, name, affiliation, email);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }

        }
        return userRecord;
    }
    
    /**
     * Retrieve a workflow record
     * @param entity entity containing information about a workflow
     * @param connection established connection to DB
     * @return WorkflowRecord object containing information about the workflow, or null if the workflow is not in DB 
     * @throws SQLException
     */
    protected WorkflowRecord getWorkflowRecord(WorkflowEntity entity, Connection connection) throws SQLException {
        if (log.isDebugEnabled()) log.debug("workflow uri: " + entity.getWorkflowID());
        WorkflowRecord workflowRecord = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            EntitySubtypeEnum subtype = entity.getEntitySubtype();
            String workflowID = entity.getWorkflowID();
            
            if (subtype != null) {
                statement = connection.prepareStatement("SELECT entity_id, context_workflow_uri, context_wf_node_id_token, timestep FROM exe_entity WHERE entity_uri=? AND entity_type=? AND entity_subtype=?");
                statement.setString(1, workflowID);
                statement.setString(2, EntityCategoryEnum.WORKFLOW.name());
                statement.setString(3, subtype.name());
                if (log.isTraceEnabled()) {
                    log.trace("SELECT entity_id, context_workflow_uri, context_wf_node_id_token, timestep FROM exe_entity WHERE entity_uri=? AND entity_type=? AND entity_subtype=?" + "\n" + workflowID + "\n" + EntityCategoryEnum.WORKFLOW.name() + "\n" + subtype.name());
                }
            } else {
                statement = connection.prepareStatement("SELECT entity_id, context_workflow_uri, context_wf_node_id_token, timestep FROM exe_entity WHERE entity_uri=? AND entity_type=? AND (entity_subtype=? OR entity_subtype IS NULL)");
                statement.setString(1, workflowID);
                statement.setString(2, EntityCategoryEnum.WORKFLOW.name());
                statement.setString(3, EntitySubtypeEnum.REGULAR.name());
                if (log.isTraceEnabled()) {
                    log.trace("SELECT entity_id, context_workflow_uri, context_wf_node_id_token, timestep FROM exe_entity WHERE entity_uri=? AND entity_type=? AND (entity_subtype=? OR entity_subtype IS NULL)" + "\n" + workflowID + "\n" + EntityCategoryEnum.WORKFLOW.name() + "\n" + EntitySubtypeEnum.REGULAR.name());
                }
            }
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("get workflow record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                long internalID = resultSet.getLong("entity_id");
                int timestep = resultSet.getInt("timestep");
                String workflowNodeID = resultSet.getString("context_wf_node_id_token");
                if (resultSet.wasNull()) {
                    workflowNodeID = null;
                }
                workflowRecord = new WorkflowRecord(workflowID, internalID, subtype, workflowNodeID, timestep);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        
        return workflowRecord;
    }
    
    /**
     * Retrieve a service record
     * @param entity entity containing information about a service
     * @param connection connection established to DB
     * @return ServiceRecord object containing information about the service, or null if the service is not in DB
     * @throws SQLException
     */
    protected ServiceRecord getServiceRecord(ServiceEntity entity, Connection connection) throws SQLException {
        if (log.isDebugEnabled()) log.debug("service uri: " + entity.getServiceID());
        
        ServiceRecord serviceRecord = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            
            String serviceID = entity.getServiceID();
            
            StringBuilder builder = new StringBuilder("SELECT * FROM exe_entity WHERE entity_uri=? AND entity_type=?");
            
            EntitySubtypeEnum subtype = entity.getEntitySubtype();
            if (subtype == null) {
                builder.append(" AND (entity_subtype=? OR entity_subtype IS NULL)");
            } else {
                builder.append(" AND entity_subtype=?");
            }
            String workflowID = entity.getWorkflowID();
            if (workflowID != null) {
                builder.append(" AND context_workflow_uri=?");
            }
            String workflowNodeID = entity.getWorkflowNodeID();
            if (workflowNodeID != null) {
                builder.append(" AND context_wf_node_id_token=?");
            }
            int timestep = entity.getTimestep();
            if (timestep >= 0) {
                builder.append(" AND timestep=?");
            }
            String logMsg = null;
            if (log.isTraceEnabled()) logMsg = builder.toString();
            
            statement = connection.prepareStatement(builder.toString());
            
            int index = 1;
            statement.setString(index, serviceID);
            index++;
            
            statement.setString(index, EntityCategoryEnum.SERVICE.name());
            index++;
            
            if (log.isTraceEnabled()) logMsg = logMsg + "\n" + serviceID + "\n" + EntityCategoryEnum.SERVICE.name();
            
            if (subtype == null) {
                statement.setString(index, EntitySubtypeEnum.REGULAR.name());
                index++;
                if (log.isTraceEnabled()) logMsg = logMsg + "\n" + EntitySubtypeEnum.REGULAR.name();
            } else {
                statement.setString(index, subtype.name());
                index++;
                if (log.isTraceEnabled()) logMsg = logMsg + "\n" + subtype.name();
            }

            if (workflowID != null) {
                statement.setString(index, workflowID);
                index++;
                if (log.isTraceEnabled()) logMsg = logMsg + "\n" + workflowID;
            }
            if (workflowNodeID != null) {
                statement.setString(index, workflowNodeID);
                index++;
                if (log.isTraceEnabled()) logMsg = logMsg + "\n" + workflowNodeID;
            }
            if (timestep >= 0) {
                statement.setInt(index, timestep);
                index++;
                if (log.isTraceEnabled()) logMsg = logMsg + "\n" + timestep;
            }
            if (log.isTraceEnabled()) log.trace(logMsg);

            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("get service record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                long internalID = resultSet.getLong("entity_id");
                String wfID = resultSet.getString("context_workflow_uri");
                if (resultSet.wasNull()) {
                    wfID = null;
                }
                String wfNodeID = resultSet.getString("context_wf_node_id_token");
                if (resultSet.wasNull()) {
                    wfNodeID = null;
                }
                int wfTimestep = resultSet.getInt("timestep");
                
                serviceRecord = new ServiceRecord(serviceID, internalID, subtype, wfID, wfNodeID, wfTimestep);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return serviceRecord;
    }
    
    /**
     * Retrieve a method record
     * @param entity entity containing information regarding the method
     * @param connection established connection to DB
     * @return MethodRecord object containing information regarding the method, or null if the method is not in DB
     * @throws SQLException
     */
    protected MethodRecord getMethodRecord(MethodEntity entity, Connection connection) throws SQLException {
        MethodRecord methodRecord = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        
        try {
            String methodID = entity.getMethodID();
            String serviceID = entity.getServiceID();
            
            
            StringBuilder builder = new StringBuilder("SELECT * FROM exe_entity WHERE entity_uri=? AND entity_type=?");
            
            EntitySubtypeEnum subtype = entity.getEntitySubtype();
            if (subtype == null) {
                builder.append(" AND (entity_subtype=? OR entity_subtype IS NULL)");
            } else {
                builder.append(" AND entity_subtype=?");
            }
            String workflowID = entity.getWorkflowID();
            if (workflowID != null) {
                builder.append(" AND context_workflow_uri=?");
            }
            String workflowNodeID = entity.getWorkflowNodeID();
            if (workflowNodeID != null) {
                builder.append(" AND context_wrf_node_id_token=?");
            }
            int timestep = entity.getTimestep();
            if (timestep >= 0) {
                builder.append(" AND timestep=?");
            }
            
            builder.append(" AND context_service_uri=?");
            
            if (log.isTraceEnabled()) log.trace(builder.toString());
            
            statement = connection.prepareStatement(builder.toString());
            
            int index = 1;
            statement.setString(index, methodID);
            index++;
            
            statement.setString(index, EntityCategoryEnum.METHOD.name());
            index++;
            
            if (subtype == null) {
                statement.setString(index, EntitySubtypeEnum.REGULAR.name());
                index++;
            } else {
                statement.setString(index, subtype.name());
                index++;
            }

            if (workflowID != null) {
                statement.setString(index, workflowID);
                index++;
            }
            if (workflowNodeID != null) {
                statement.setString(index, workflowNodeID);
                index++;
            }
            if (timestep >= 0) {
                statement.setInt(index, timestep);
                index++;
            }

            statement.setString(index, serviceID);
            index++;
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("get method record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                long internalID = resultSet.getLong("entity_id");
                String wfID = resultSet.getString("context_workflow_uri");
                if (resultSet.wasNull()) {
                    wfID = null;
                }
                String wfNodeID = resultSet.getString("context_wf_node_id_token");
                if (resultSet.wasNull()) {
                    wfNodeID = null;
                }
                int wfTimestep = resultSet.getInt("timestep");
                
                methodRecord = new MethodRecord(methodID, internalID, subtype, serviceID, wfID, wfNodeID, wfTimestep);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }

        }
        return methodRecord;
    }
    
    
    /**
     * Get DB record of the entity
     * @param entity entity to be retrieved
     * @param connection established connection to DB
     * @return an EntityRecord object containing the DB record of the entity, or null if the entity is not found in DB
     * @throws SQLException
     * @throws IngestException
     */
    protected EntityRecord getEntityRecord(EntityObject entity, Connection connection) throws SQLException, IngestException {
        
        EntityRecord entityRecord = null;
        
        EntityCategoryEnum entityCategory = entity.getEntityCategory();
        switch (entityCategory) {
        case USER:
            entityRecord = getUserRecord((UserEntity)entity, connection);
            break;
        case METHOD:
            entityRecord = getMethodRecord((MethodEntity)entity, connection);
            break;
        case SERVICE:
            entityRecord = getServiceRecord((ServiceEntity)entity, connection);
            break;
        case WORKFLOW:
            entityRecord = getWorkflowRecord((WorkflowEntity)entity, connection);
            break;
        }
        return entityRecord;
    }


    /**
     * Add a new user entity into DB
     * @param entity user entity to be added
     * @param connection established connection to DB
     * @return DB internal ID of the newly added record
     * @throws IngestException thrown if failed to add the new entity;
     * @throws SQLException
     */
    protected Long addNewUserEntity(UserEntity entity, Connection connection) throws IngestException, SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        try {
            StringBuilder builder = new StringBuilder("INSERT INTO reg_personnel (dn");
            StringBuilder tailBuilder = new StringBuilder("VALUES (?");
            
            String userDN = entity.getUserDN();
            String fullName = entity.getFullName();
            String affiliation = entity.getAffiliation();
            String email = entity.getEmail();
            
            if (fullName != null) {
                builder.append(", name");
                tailBuilder.append(", ?");
            }
            if (affiliation != null) {
                builder.append(", affiliation");
                tailBuilder.append(", ?");
            }
            if (email != null) {
                builder.append(", email");
                tailBuilder.append(", ?");
            }
            builder.append(")");
            tailBuilder.append(")");
            
//            String logMsg = null;
//            if (log.isTraceEnabled()) logMsg = builder.toString() + tailBuilder.toString();
            statement = connection.prepareStatement(builder.toString() + tailBuilder.toString());
            
            int index = 1;
            statement.setString(index, userDN);
            index++;
            
//            if (log.isTraceEnabled()) logMsg += "\n" + userDN;
            
            if (fullName != null) {
                statement.setString(index, fullName);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + fullName;
            }
            if (affiliation != null) {
                statement.setString(index, affiliation);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + affiliation;
            }
            if (email != null) {
                statement.setString(index, email);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + email;
            }
            
//            if (log.isTraceEnabled()) log.trace(logMsg);
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewUserEntity DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                internalID = getLastAutoID(connection);
                List<Annotation> annotationList = entity.getAnnotations();
                addNewEntityAnnotations(internalID, annotationList, connection);                
            } else {
                throw new IngestException("Failed to add new user entity");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }
    
    /**
     * Add a new workflow entity into DB
     * @param entity workflow entity to be added
     * @param connection an established connection to DB
     * @return DB internal ID of the newly added workflow entity
     * @throws IngestException thrown if failed to add the new entity
     * @throws SQLException
     */
    protected Long addNewWorkflowEntity(WorkflowEntity entity, Connection connection) throws IngestException, SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        
        try {
            StringBuilder builder = new StringBuilder("INSERT INTO exe_entity (entity_uri, entity_type, entity_subtype");
            StringBuilder tailBuilder = new StringBuilder("VALUES (?, ?, ?");
            
            String workflowID = entity.getWorkflowID();
            EntitySubtypeEnum subtype = entity.getEntitySubtype();
            if (subtype == null) {
                subtype = EntitySubtypeEnum.REGULAR;
            }
            String workflowNodeID = entity.getWorkflowNodeID();
            if (workflowNodeID != null) {
                builder.append(", context_wf_node_id_token");
                tailBuilder.append(", ?");
            }
            
            /**
             * @author Devarshi: Storing Registry-level provenance information for WF-entity
             */
            Long regEntityId = null;
            InstanceOf instanceOf = entity.getInstanceOf();
            if(instanceOf != null){
            	String instanceId = instanceOf.getInstanceOfId();
	            if (log.isDebugEnabled()) log.debug("INST: " + instanceId);
		        if(manageDBLock(DBLockConfiguration.LOCK_ACQUIRE, instanceId, connection)){
		        	regEntityId = getRegEntityRecord((EntityObject)entity, instanceOf, connection);
			        if (regEntityId == null) {
			        	regEntityId = setRegistryInfo(EntityCategoryEnum.WORKFLOW.name(), subtype.name(), instanceOf, connection);
			            if (log.isDebugEnabled()) log.debug("reg-entity add new ID: " + regEntityId);
			        } else {
			            if (log.isDebugEnabled()) log.debug("reg-entity record ID: " + regEntityId);
			        }    
			        manageDBLock(DBLockConfiguration.LOCK_RELEASE, instanceId, connection);
		        }
		        
	            if(regEntityId != null) {
	                builder.append(", instance_of");
	                tailBuilder.append(", ?");
	            }
            }
            
            int timestep = entity.getTimestep();
            builder.append(", timestep)");
            tailBuilder.append(", ?)");
            
//            String logMsg = null;
//            if (log.isTraceEnabled()) logMsg = builder.toString() + tailBuilder.toString();
            
            statement = connection.prepareStatement(builder.toString() + tailBuilder.toString());
            
            int index = 1;
            statement.setString(index, workflowID);
            index++;
            
            statement.setString(index, EntityCategoryEnum.WORKFLOW.name());
            index++;
            
            statement.setString(index, subtype.name());
            index++;
            
//            if (log.isTraceEnabled()) logMsg = logMsg + "\n" + workflowID + "\n" + EntityCategoryEnum.WORKFLOW.name() + "\n" + subtype.name();
            
            if (workflowNodeID != null) {
                statement.setString(index, workflowNodeID);
                index++;
//                if (log.isTraceEnabled()) logMsg = logMsg + "\n" + workflowNodeID;
            }           
            
            
            if (regEntityId != null) {
                statement.setLong(index, regEntityId);
                index++;
            }
            
            statement.setInt(index, timestep);
            index++;
            
//            if (log.isTraceEnabled()) log.trace(logMsg + "\n" + timestep);
            long startTime = System.currentTimeMillis();
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewWorkflowEntity DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                internalID = getLastAutoID(connection);
                UserBehalf userBehalf = entity.getUserBehalf();
                if (userBehalf != null) {
                	Long behalfInternalID = null;
                	if (regEntityId != null){
                		behalfInternalID = addNewUserBehalf(internalID, regEntityId, userBehalf, connection);
                	}
                	else{
                		behalfInternalID = addNewUserBehalf(internalID, userBehalf, connection);
                	}
                }
                List<Annotation> annotationList = entity.getAnnotations();
                addNewEntityAnnotations(internalID, annotationList, connection);
            } else {
                throw new IngestException("Failed to add new workflow entity");
            }
            
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }
    
    /**
     * Add a new service entity to DB
     * @param entity service entity to be added
     * @param connection an established connection to DB
     * @return DB internal ID of the newly added service
     * @throws IngestException thrown if failed to add the entity
     * @throws SQLException
     */
    protected Long addNewServiceEntity(ServiceEntity entity, Connection connection) throws IngestException, SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        
        try {
            StringBuilder builder = new StringBuilder("INSERT INTO exe_entity (entity_uri, entity_type, entity_subtype");
            StringBuilder tailBuilder = new StringBuilder("VALUES (?, ?, ?");
            
            String serviceID = entity.getServiceID();
            
            String workflowID = entity.getWorkflowID();
            if (workflowID != null) {
                builder.append(", context_workflow_uri");
                tailBuilder.append(", ?");
            }
            EntitySubtypeEnum subtype = entity.getEntitySubtype();
            if (subtype == null) {
                subtype = EntitySubtypeEnum.REGULAR;
            }
            String workflowNodeID = entity.getWorkflowNodeID();
            if (workflowNodeID != null) {
                builder.append(", context_wf_node_id_token");
                tailBuilder.append(", ?");
            }
            
            /**
             * @author Devarshi: Storing Registry-level provenance information for service-entity
             */
            Long regEntityId = null;
            InstanceOf instanceOf = entity.getInstanceOf();
            if(instanceOf != null){
	            String instanceId = instanceOf.getInstanceOfId();      
		        if(manageDBLock(DBLockConfiguration.LOCK_ACQUIRE, instanceId, connection)){
		        	regEntityId = getRegEntityRecord((EntityObject)entity, instanceOf, connection);
			        if (regEntityId == null) {
			        	regEntityId = setRegistryInfo(EntityCategoryEnum.SERVICE.name(), subtype.name(), instanceOf, connection);
			            if (log.isDebugEnabled()) log.debug("entity add new ID: " + regEntityId);
			        } else {
			            if (log.isDebugEnabled()) log.debug("entity record ID: " + regEntityId);
			        }    
			        manageDBLock(DBLockConfiguration.LOCK_RELEASE, instanceId, connection);
		        }
		        
	            if(regEntityId != null) {
	                builder.append(", instance_of");
	                tailBuilder.append(", ?");
	            }
            }
            
            int timestep = entity.getTimestep();
            builder.append(", timestep)");
            tailBuilder.append(", ?)");
            
//            String logMsg = null;
//            if (log.isTraceEnabled()) logMsg = builder.toString() + tailBuilder.toString();
            
            statement = connection.prepareStatement(builder.toString() + tailBuilder.toString());
            
            int index = 1;
            statement.setString(index, serviceID);
            index++;
            
            statement.setString(index, EntityCategoryEnum.SERVICE.name());
            index++;
            
            statement.setString(index, subtype.name());
            index++;

//            if (log.isTraceEnabled()) logMsg += "\n" + serviceID + "\n" + EntityCategoryEnum.SERVICE.name() + "\n" + subtype.name();
            
            if (workflowID != null) {
                statement.setString(index, workflowID);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + workflowID;
            }

            if (workflowNodeID != null) {
                statement.setString(index, workflowNodeID);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + workflowNodeID;
            }
            
            if (regEntityId != null) {
                statement.setLong(index, regEntityId);
                index++;
//                if (log.isTraceEnabled()) logMsg += "\n" + workflowNodeID;
            }
            
            statement.setInt(index, timestep);
            index++;
            
//            if (log.isTraceEnabled()) log.trace(logMsg + "\n" + timestep);
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewServiceEntity DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                internalID = getLastAutoID(connection);
                UserBehalf userBehalf = entity.getUserBehalf();
                if (userBehalf != null) {
                	Long behalfInternalID = null;
                	if (regEntityId != null){
                		behalfInternalID = addNewUserBehalf(internalID, regEntityId, userBehalf, connection);
                	}
                	else{
                		behalfInternalID = addNewUserBehalf(internalID, userBehalf, connection);
                	}
                }
                List<Annotation> annotationList = entity.getAnnotations();
                addNewEntityAnnotations(internalID, annotationList, connection);
            } else {
                throw new IngestException("Failed to add new service entity");
            }
            
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
        
    }
    
    /**
     * Add a new method entity to DB
     * @param entity method entity to be added
     * @param connection an established connection to DB
     * @return DB internal ID of the newly added service
     * @throws IngestException thrown if failed to add the entity
     * @throws SQLException
     */
    protected Long addNewMethodEntity(MethodEntity entity, Connection connection) throws IngestException, SQLException {
        Long internalID = null;
        PreparedStatement statement = null;
        
        try {
            StringBuilder builder = new StringBuilder("INSERT INTO exe_entity (entity_uri, entity_type, entity_subtype, context_service_uri");
            StringBuilder tailBuilder = new StringBuilder("VALUES (?, ?, ?, ?");
            
            String methodID = entity.getMethodID();
            
            String serviceID = entity.getServiceID();
            
            String workflowID = entity.getWorkflowID();
            
            if (workflowID != null) {
                builder.append(", context_workflow_uri");
                tailBuilder.append(", ?");
            }
            EntitySubtypeEnum subtype = entity.getEntitySubtype();
            if (subtype == null) {
                subtype = EntitySubtypeEnum.REGULAR;
            }
            String workflowNodeID = entity.getWorkflowNodeID();
            if (workflowNodeID != null) {
                builder.append(", context_wf_node_id_token");
                tailBuilder.append(", ?");
            }
            
            /**
             * @author Devarshi: Storing Registry-level provenance information for method-entity
             */
            Long regEntityId = null;
            InstanceOf instanceOf = entity.getInstanceOf();
            if(instanceOf != null){
	            String instanceId = instanceOf.getInstanceOfId();            
		        if(manageDBLock(DBLockConfiguration.LOCK_ACQUIRE, instanceId, connection)){
		        	regEntityId = getRegEntityRecord((EntityObject)entity, instanceOf, connection);
			        if (regEntityId == null) {
			        	regEntityId = setRegistryInfo(EntityCategoryEnum.METHOD.name(), subtype.name(), instanceOf, connection);
			            if (log.isDebugEnabled()) log.debug("entity add new ID: " + regEntityId);
			        } else {
			            if (log.isDebugEnabled()) log.debug("entity record ID: " + regEntityId);
			        }    
			        manageDBLock(DBLockConfiguration.LOCK_RELEASE, instanceId, connection);
		        }
		        
	            if(regEntityId != null) {
	                builder.append(", instance_of");
	                tailBuilder.append(", ?");
	            }
            }
            
            int timestep = entity.getTimestep();
            builder.append(", timestep)");
            tailBuilder.append(", ?)");
            
            statement = connection.prepareStatement(builder.toString() + tailBuilder.toString());
            
            int index = 1;
            statement.setString(index, methodID);
            index++;
            
            statement.setString(index, EntityCategoryEnum.METHOD.name());
            index++;
            
            statement.setString(index, subtype.name());
            index++;

            statement.setString(index, serviceID);
            index++;
            
            if (workflowID != null) {
                statement.setString(index, workflowID);
                index++;
            }

            if (workflowNodeID != null) {
                statement.setString(index, workflowNodeID);
                index++;
            }
            
            if (regEntityId != null) {
                statement.setLong(index, regEntityId);
                index++;
            }
            
            statement.setInt(index, timestep);
            index++;
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewMethodEntity DB INSERT time: "  + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                internalID = getLastAutoID(connection);
                UserBehalf userBehalf = entity.getUserBehalf();
                if (userBehalf != null) {
                	Long behalfInternalID = null;
                	if (regEntityId != null){
                		behalfInternalID = addNewUserBehalf(internalID, regEntityId, userBehalf, connection);
                	}
                	else{
                		behalfInternalID = addNewUserBehalf(internalID, userBehalf, connection);
                	}
                }
                List<Annotation> annotationList = entity.getAnnotations();
                addNewEntityAnnotations(internalID, annotationList, connection);
            } else {
                throw new IngestException("Failed to add new method entity");
            }
            
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }
    
    /**
     * Add a new user behalf record
     * @param entityID DB internal ID of the entity
     * @param userBehalf information of the user on whose behalf the entity was executed
     * @param connection established connection to DB
     * @return DB internal ID of the newly added behalf record
     * @throws SQLException
     * @throws IngestException thrown when failed to add user behalf record to DB
     */
    protected Long addNewUserBehalf(long entityID, UserBehalf userBehalf, Connection connection) throws SQLException, IngestException {
        Long behalfInternalID = null;
        
        Long userInternalID = null;
        
        String userDN = userBehalf.getUserDN();
        UserEntity userEntity = new UserEntity(userDN);
        UserRecord userRecord = getUserRecord(userEntity, connection);
        if (userRecord == null) {
            userInternalID = addNewUserEntity(userEntity, connection);
            if (userInternalID == null) {
                throw new IngestException("Failed to add new user behalf user entity");
            }
        } else {
            userInternalID = Long.valueOf(userRecord.getInternalID());
        }
        
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO exe_behalf (entity_id, user_id) VALUES (?, ?)");
            statement.setLong(1, entityID);
            statement.setLong(2, userInternalID.longValue());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewUserBehalf DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                behalfInternalID = getLastAutoID(connection);
            } else {
                throw new IngestException("Failed to add new user behalf");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return behalfInternalID;
    }

    protected Long addNewUserBehalf(long entityID, Long regEntityId, UserBehalf userBehalf, Connection connection) throws SQLException, IngestException {
        Long behalfInternalID = null;
        
        Long userInternalID = null;
        
        String userDN = userBehalf.getUserDN();
        UserEntity userEntity = new UserEntity(userDN);
        UserRecord userRecord = getUserRecord(userEntity, connection);
        if (userRecord == null) {
            userInternalID = addNewUserEntity(userEntity, connection);
            if (userInternalID == null) {
                throw new IngestException("Failed to add new user behalf user entity");
            }
        } else {
            userInternalID = Long.valueOf(userRecord.getInternalID());
        }
        
        if(regEntityId != null){
        	addAuthorship(regEntityId, userInternalID, userBehalf.getAuthorshipType(), connection);
        }
        
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO exe_behalf (entity_id, user_id) VALUES (?, ?)");
            statement.setLong(1, entityID);
            statement.setLong(2, userInternalID.longValue());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewUserBehalf DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                behalfInternalID = getLastAutoID(connection);
            } else {
                throw new IngestException("Failed to add new user behalf");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return behalfInternalID;
    }

    /**
     * Thread-safe entity retrieval and insertion
     * @param notificationSummary
     * @param entity
     * @param connection
     * @return
     * @throws SQLException
     * @throws IngestException
     */
    public synchronized Long insertEntityRecord(NotificationSummary notificationSummary, EntityObject entity, 
    		Connection connection) throws SQLException, IngestException{
        Long entityID = null;
        String entityURI =  null;
        EntityCategoryEnum entityCategory = entity.getEntityCategory();
        switch (entityCategory) {
        case USER:
        	entityURI = ((UserEntity)entity).getUserDN();
            break;
        case METHOD:
        	entityURI = ((MethodEntity)entity).getMethodID();
            break;
        case SERVICE:
        	entityURI = ((ServiceEntity)entity).getServiceID();
            break;
        case WORKFLOW:
        	entityURI = ((WorkflowEntity)entity).getWorkflowID();
            break;
        }
        
        if(manageDBLock(DBLockConfiguration.LOCK_ACQUIRE, entityURI, connection)){
	    	EntityRecord entityRecord = getEntityRecord(entity, connection);
	        if (entityRecord == null) {
	            entityID = addNewEntity(notificationSummary, entity, connection);
	            if (log.isDebugEnabled()) log.debug("entity add new ID: " + entityID);
	        } else {
	            entityID = Long.valueOf(entityRecord.getInternalID());
	            if (log.isDebugEnabled()) log.debug("entity record ID: " + entityID);
	            /* Edit by You-Wei Cheah (added on 09/19/2011) 
	             * This is to enable the processing of the 
	             * annotation block even though the entity record is present. */
                addNewEntityAnnotations(entityID, entity.getAnnotations(), connection);
	        }    
	        manageDBLock(DBLockConfiguration.LOCK_RELEASE, entityURI, connection);
        }
        
        return entityID;
    }
    
    private boolean manageDBLock(int lockOperation, String objectID, Connection connection)
    throws IngestException{
    	CallableStatement lockStmt = null;
    	int lockStatus = 0;
    	int lockFailures = 0;
    	int maxRetries = 1;
    	int timeout = DBLockConfiguration.LOCK_WAIT_TIME;
    	
    	if(lockOperation == DBLockConfiguration.LOCK_ACQUIRE){
    		maxRetries = DBLockConfiguration.MAX_RETRIES;
    	}
    	boolean isLockAcquired = false;
    	try{
    		for (int i = 0; i < maxRetries; i++) {
    			lockStmt = connection.prepareCall("{call PR_OBJECT_LOCK(?, ?, ?, ?)}");
    			try{
	    			int actualTimeout = timeout * i * 2;	        		
	        		lockStmt.setInt(1, lockOperation);
	        		lockStmt.setInt(2, actualTimeout);
	        		lockStmt.setString(3, objectID);
	        		lockStmt.registerOutParameter(4, java.sql.Types.INTEGER);
	        		lockStmt.execute();
	        		lockStatus = lockStmt.getInt(4);
    			} catch(SQLException e){
    				lockFailures++;
    				if(lockFailures == maxRetries){
    					String msg = "Max retries " + maxRetries + 
    					" for the lock reached for the object: " + objectID;
    					if (log.isDebugEnabled()) log.debug("manageDBLock-Error: " + msg);
    					throw new IngestException(msg);
    				}
    			}
    			if(lockStatus == DBLockConfiguration.LOCK_OP_SUCCESS){
    				isLockAcquired = true;
    				break;
    			}
			}
    	} catch(SQLException e){
			String msg = "SQLException during call to PR_OBJECT_LOCK";
    		if (log.isDebugEnabled()) log.debug("manageDBLock-Error: " + msg + ":" +e.getMessage());
    		throw new IngestException(msg);
    	} finally{
    		try{
    			lockStmt.close();
    		} catch(SQLException e){
    			if (log.isDebugEnabled()) log.debug("manageDBLock-Error: " + e.getMessage());
    		}
    		lockStmt = null;    		
    	}
    	if(lockStatus != DBLockConfiguration.LOCK_OP_SUCCESS){
			String msg = "Lock not obtained after " + maxRetries + 
			" retries for the lock reached for the object: " + objectID;
			if (log.isDebugEnabled()) log.debug("manageDBLock-Error: " + msg);
			throw new IngestException(msg);
    	}
    	return isLockAcquired;
    }
    
    void acquireLock(String lockName, int timeout, Connection connection) throws SQLException{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	String lockStmt = "SELECT GET_LOCK(?,?)";
	        statement = connection.prepareStatement(lockStmt);
	        statement.setString(1, lockName);
	        statement.setInt(2, timeout);
	        resultSet = statement.executeQuery();
	        if(resultSet.next()){
	        	String result = resultSet.getString(1);
	        	if(result.equals("1")){
	        		if (plog.isTraceEnabled()) plog.trace("LOCK acquired for adding an entity!");
	        	}
	        	else{
	        		if (plog.isTraceEnabled()) plog.trace("GET_LOCK for adding entity failed!");
	        	}
	        }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    }
    
    void releaseLock(String lockName, Connection connection) throws SQLException{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
        	String lockStmt = "SELECT RELEASE_LOCK(?)";
	        statement = connection.prepareStatement(lockStmt);
	        statement.setString(1, lockName);
	        resultSet = statement.executeQuery();
	        if(resultSet.next()){
	        	String result = resultSet.getString(1);
	        	if(result.equals("1")){
	        		if (plog.isTraceEnabled()) plog.trace("LOCK released after adding an entity!");
	        	}
	        	else{
	        		if (plog.isTraceEnabled()) plog.trace("No LOCK acquired for the release!");
	        	}
	        }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    	
    }
    
    protected Long addNewEntity(NotificationSummary notificationSummary, EntityObject entity, Connection connection) throws IngestException, SQLException {
        EntityCategoryEnum entityCategory = entity.getEntityCategory();
        Long id = null;
        switch(entityCategory) {
        case USER:
            id = addNewUserEntity((UserEntity)entity, connection);
            break;
        case WORKFLOW:
            id = addNewWorkflowEntity((WorkflowEntity)entity, connection);
            break;
        case SERVICE:
            id = addNewServiceEntity((ServiceEntity)entity, connection);            
            break;
        case METHOD:
            id = addNewMethodEntity((MethodEntity)entity, connection);
            break;
        }
        return id;
    }
    
    

    protected Long checkIfDataFileObjectPresent(String fileUri, Connection connection) throws SQLException, IngestException {
        Long fileId = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            StringBuilder sqlStrBuilder = new StringBuilder("SELECT file_id FROM exe_file WHERE file_uri = '" +  fileUri +"'");
            statement = connection.prepareStatement(sqlStrBuilder.toString());
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            result = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("check file object present time: " + (System.currentTimeMillis() - startTime));
            if(result.next()) {
                fileId = result.getLong(1);
            }
        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return fileId;
        
    }
    private void addAnnotations(String tableName, String subjectIDColumnName, long internalID,  List<Annotation> annotationList, Connection connection) throws SQLException, IngestException {
        PreparedStatement statement = null;
        
        try {
            if (annotationList != null && annotationList.size() > 0) {
                StringBuilder builder = new StringBuilder("INSERT INTO " + tableName + " (" + subjectIDColumnName + ", annotation_name, annotation_value, annotation_type) VALUES (?, ?, ?, ?)");
                int size = annotationList.size();
                for (int i = 1; i < size; i++) {
                    builder.append(",(?, ?, ?, ?)");
                }
                
                if (log.isDebugEnabled()) log.debug(builder.toString()+": "+internalID);
                
                statement = connection.prepareStatement(builder.toString());
                
                for (int i = 0; i < size; i++) {
                    Annotation annotation = annotationList.get(i);
                    String property = annotation.getProperty();
                    String value = annotation.getValue();
                    AnnotationDefinitionScopeEnum scope = annotation.getScope();
                    
                    statement.setLong(i * 4 + 1, internalID);
                    statement.setString(i * 4 + 2, property);
                    statement.setString(i * 4 + 3, value);
                    statement.setString(i * 4 + 4, scope.name());
                    
                }
                
                
                long startTime = 0;
                if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                int result = statement.executeUpdate();
                if (plog.isTraceEnabled()) plog.trace("addAnnotations DB INSERT time: " + (System.currentTimeMillis() - startTime));
                
                if (result != size) {
                    throw new IngestException("Failed to add into " + tableName);
                }
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    }

    /**
     * Add a new invocation data combination to DB 
     * @param invocationID DB internal ID of invocation
     * @param blockID DB internal ID of the data block
     * @param dataType role of the data
     * @param connection established connection to DB
     * @return DB internal ID of the newly added combination
     * @throws SQLException
     * @throws IngestException thrown if failed to add the new combination to DB
     */
    protected Long addNewInvocationData(long invocationID, long blockID, InvocationDataEnum dataType, Connection connection) throws SQLException, IngestException {
        Long internalID = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO exe_invocation_data (invocation_id, block_id, role) VALUES (?, ?, ?)");
            statement.setLong(1, invocationID);
            statement.setLong(2, blockID);
            statement.setString(3, dataType.name());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewInvocationData DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                internalID = getLastAutoID(connection);
            } else {
                throw new IngestException("Failed to add new invocation data");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
    }

    /**
     * 
     * @param notificationSummary
     * @param invoker
     * @param invokee
     * @param invocationType
     * @param time
     * @param annotationList
     * @param connection
     * @return
     * @throws IngestException
     * @throws SQLException
     */
    protected InvocationRecord saveInvocation(NotificationSummary notificationSummary, EntityObject invoker, EntityObject invokee, InvocationTypeEnum invocationType, Calendar time, List<Annotation> annotationList, Connection connection) throws IngestException, SQLException {
        InvocationRecord invocationRecord = null;
        Long invokerID = null;
        Long invokeeID = null;
        
        if (log.isTraceEnabled()) {
            switch (invoker.getEntityCategory()) {
            case METHOD:
                log.trace("invoker method uri: " + ((MethodEntity)invoker).getMethodID());
                break;
            case SERVICE:
                log.trace("invoker service uri: " + ((ServiceEntity)invoker).getServiceID());
                break;
            case USER:
                log.trace("invoker user dn: " + ((UserEntity)invoker).getUserDN());
                break;
            case WORKFLOW:
                log.trace("invoker workflow uri: " + ((WorkflowEntity)invoker).getWorkflowID());
                break;
            }
            
            switch (invokee.getEntityCategory()) {
            case METHOD:
                log.trace("invokee method uri: " + ((MethodEntity)invokee).getMethodID());
                break;
            case SERVICE:
                log.trace("invokee service uri: " + ((ServiceEntity)invokee).getServiceID());
                break;
            case USER:
                log.trace("invokee user dn: " + ((UserEntity)invokee).getUserDN());
                break;
            case WORKFLOW:
                log.trace("invokee workflow uri: " + ((WorkflowEntity)invokee).getWorkflowID());
                break;
            }
            
        }
        
        invokerID = insertEntityRecord(notificationSummary, invoker, connection);
        
        invokeeID = insertEntityRecord(notificationSummary, invokee, connection);
        
        Certainty certainty = new Certainty(Certainty.DEFAULT_CERTAINTY_SCORE, CertaintySourceEnum.NOTIFICATION);
        if (log.isTraceEnabled()) {
            if (invokerID.longValue() == invokeeID.longValue()) {
                log.trace("WARNING: identical invoker and invokee IDs: invokerID: " + invokerID.longValue() + "  invokeeID: " + invokeeID.longValue());
            }
        }
        invocationRecord = saveInvocation(notificationSummary, invokerID.longValue(), invokeeID.longValue(), invocationType, time, annotationList, certainty, connection);

        return invocationRecord;
    }

    @Override
    public void storeInvocation(NotificationSummary notificationSummary, EntityObject invokerEntity, EntityObject invokeeEntity, InvocationTypeEnum invocationType, Calendar invocationTime, List<Annotation> invocationAnnotationList) throws IngestException {
        Connection connection = null;
        try {

            connection = getConnection();
            saveInvocation(notificationSummary, invokerEntity, invokeeEntity, invocationType, invocationTime, invocationAnnotationList, connection);
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }

    }

    @Override
    public void storeInvocationStatus(NotificationSummary notificationSummary, EntityObject invokerEntity, EntityObject invokeeEntity, InvocationTypeEnum invocationType, Calendar invocationStartTime, StatusEnum invocationStatus, Calendar statusTime, List<Annotation> invocationStatusAnnotationList) throws IngestException {

        Connection connection = null;
        try {
            connection = getConnection();
            saveInvocationStatus(notificationSummary, invokerEntity, invokeeEntity, invocationType, invocationStartTime, invocationStatus, statusTime, invocationStatusAnnotationList, connection);
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }
    }


    static final String STATEMENT_UPDATE_RAW_NOTIF_STATUS = "UPDATE raw_notification SET processing_status=? WHERE raw_id IN (";

    /**
     * @see edu.indiana.dsi.karma.ingest.IngesterImplementer#markRawNotifications(java.util.List, edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingStatus)
     */
    @Override
    public void markRawNotifications(List<StoredRawNotification<Long, String>> list, ProcessingStatus processingStatus) throws IngestException {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            if (list != null && list.size() > 0) {
                connection = getConnection();
                StringBuilder sqlStatementBuilder = new StringBuilder(STATEMENT_UPDATE_RAW_NOTIF_STATUS);
                int listSize = list.size();
                for (int i = 0; i < listSize - 1; i++) {
                    sqlStatementBuilder.append("?, ");
                }
                sqlStatementBuilder.append("?)");

                statement = connection.prepareStatement(sqlStatementBuilder.toString());
                statement.setString(1, processingStatus.toString());
                int counter = 2;
                for (StoredRawNotification<Long, String> storedRawNotification : list) {
                    Long internalIDObj = (Long)storedRawNotification.getInternalID();
                    statement.setLong(counter, internalIDObj.longValue());
                    counter++;
                }

                long startTime = 0;
                if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                int result = statement.executeUpdate();
                if (plog.isTraceEnabled()) plog.trace("markRawNotification DB UPDATE time: " + (System.currentTimeMillis() - startTime));
                
                statement.close();
                if (log.isDebugEnabled())log.debug("Number of entries marked " + processingStatus.toString() + ": " + result);
            }
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.warn("Unable to close statement", e);
                }
                statement = null;
            }
            connectionPool.releaseEntry(connection);
        }

    }


    /**
     * @see edu.indiana.dsi.karma.ingest.IngesterImplementer#resetUnfinishedRawNotifications()
     */
    @Override
    public void resetUnfinishedRawNotifications() throws IngestException {
        log.info("Resetting unfinished raw notifications");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("UPDATE raw_notification SET processing_status=? WHERE processing_status=?");
            statement.setString(1, ProcessingStatus.RAW.toString());
            statement.setString(2, ProcessingStatus.PROCESSING.toString());
            statement.executeUpdate();
            statement.close();
            log.info("Done resetting unfinished raw notifications");
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.warn("Unable to close statement", e);
                }
                statement = null;
            }
            connectionPool.releaseEntry(connection);
            
        }
        
    }


    /**
     * @see edu.indiana.dsi.karma.ingest.IngesterImplementer#retrieveUnprocessedRawNotifications(edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingFilterType, int)
     */
    @Override
    public List<StoredRawNotification<Long, String>> retrieveUnprocessedRawNotifications(ProcessingFilterType processingFilterType, int batchLimit) throws IngestException {
        List<StoredRawNotification<Long, String>> list = new ArrayList<StoredRawNotification<Long, String>>();

        if (ProcessingFilterType.KNOWN_TYPES.equals(processingFilterType)) {
            synchronized(rawKnownNotificationCache) {
                if (rawKnownNotificationCache.isEmpty()) {
                    try {
                        cacheRawNotificationsFromDB(processingFilterType);
                    } catch (Exception e) {
                        log.error("error caching raw notifications from db ", e);
                    }
                }
                int cacheSize = rawKnownNotificationCache.size();
                int count = batchLimit < cacheSize ? batchLimit : cacheSize;
                for (int i = 0; i < count; i++) {
                    StoredRawNotification<Long, String> rawNotification = rawKnownNotificationCache.remove(0);
                    list.add(rawNotification);
                }
            }
            
        } else if (ProcessingFilterType.UNKNOWN_TYPES.equals(processingFilterType)) {
            synchronized(rawUnknownNotificationCache) {
                if (rawUnknownNotificationCache.isEmpty()) {
                    try {
                        cacheRawNotificationsFromDB(processingFilterType);
                    } catch (Exception e) {
                        log.error("error caching raw notifications from db ", e);
                    }
                }
                int cacheSize = rawUnknownNotificationCache.size();
                int count = batchLimit < cacheSize ? batchLimit : cacheSize;
                for (int i = 0; i < count; i++) {
                    StoredRawNotification<Long, String> rawNotification = rawUnknownNotificationCache.remove(0);
                    list.add(rawNotification);
                }
            }
            
        }
        return list;
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.IngesterImplementer#storeEntityLifeCycle(edu.indiana.dsi.karma.ingest.NotificationSummary, edu.indiana.dsi.karma.ingest.EntityObject, java.util.Calendar, edu.indiana.dsi.karma.ingest.IngesterConstants.EntityLifeCycleEnum)
     */
    @Override
    public void storeEntityLifeCycle(NotificationSummary notificationSummary, EntityObject entity, Calendar time, EntityLifeCycleEnum stage) throws IngestException {
        // TODO Auto-generated method stub
        
    }


    /**
     * @see edu.indiana.dsi.karma.ingest.IngesterImplementer#storeRawNotification(edu.indiana.dsi.karma.ingest.NotificationSummary.NotificationTypeEnum, java.util.Calendar, org.apache.xmlbeans.XmlObject)
     */
    @Override
    public void storeRawNotification(NotificationTypeEnum notificationType, Calendar storeTime, XmlObject xmlObject) throws IngestException {
        Connection connection = null;
        try {
            connection = getConnection();
            addNewRawNotification(notificationType, storeTime, xmlObject, connection);
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }
    }

    
    protected Long addNewRawNotification(NotificationTypeEnum notificationType, Calendar storeTime, XmlObject xmlObject, Connection connection) throws SQLException, IngestException {
        Long internalID = null;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO raw_notification(store_time, notification_type, processing_status, notification) VALUES (?, ?, ?, ?)");
            java.sql.Timestamp timestamp = new java.sql.Timestamp(storeTime.getTimeInMillis());
            statement.setTimestamp(1, timestamp);
            statement.setString(2, notificationType.name());
            statement.setString(3, ProcessingStatus.RAW.name());
            statement.setString(4, xmlObject.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis(); 
            int result = statement.executeUpdate();
            if (plog.isTraceEnabled()) plog.trace("addNewRawNotification DB INSERT time: " + (System.currentTimeMillis() - startTime));
            
            if (result > 0) {
                internalID = getLastAutoID(connection);
            } else {
                throw new IngestException("Failed to add raw notification");
            }
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return internalID;
        
    }

    
    static final String STATEMENT_SELECT_KNOWN_NOTIF = "SELECT raw_id, notification_type, notification FROM raw_notification WHERE processing_status=? AND notification_type<>? LIMIT ?";
    static final String STATEMENT_SELECT_UNKNOWN_NOTIF = "SELECT raw_id, notification_type, notification FROM raw_notification WHERE processing_status=? AND notification_type=? LIMIT ?";
    
    protected void cacheRawNotificationsFromDB(ProcessingFilterType processingFilterType) throws SQLException, IngestException {
        
        Connection connection = null;
        List<StoredRawNotification<Long, String>> workList = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        PreparedStatement updateStatement = null;
        
        try {
            connection = getConnection();
            StringBuilder sqlStatementBuilder = null;
            String selectFilter = "";
            
            if (ProcessingFilterType.KNOWN_TYPES.equals(processingFilterType)) {
                sqlStatementBuilder = new StringBuilder(STATEMENT_SELECT_KNOWN_NOTIF);
                selectFilter = ProcessingFilterType.UNKNOWN_TYPES.name();
                workList = rawKnownNotificationCache;
            } else {
                sqlStatementBuilder = new StringBuilder(STATEMENT_SELECT_UNKNOWN_NOTIF);
                selectFilter = processingFilterType.name();
                workList = rawUnknownNotificationCache;
            }
            
            statement = connection.prepareStatement(sqlStatementBuilder.toString());
            statement.setString(1, ProcessingStatus.RAW.name());
            statement.setString(2, selectFilter);
            statement.setInt(3, rawNotificationCacheSize);
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("fetch raw from db time: " + (System.currentTimeMillis() - startTime));
            
            StringBuilder updateStatementBuilder = new StringBuilder(STATEMENT_UPDATE_RAW_NOTIF_STATUS);
            List<Long> internalIDList = new ArrayList<Long>();
            
            while (resultSet.next()) {
                long internalID = resultSet.getLong("raw_id");
                Long boxedInternalID = new Long(internalID);
                internalIDList.add(boxedInternalID);
                String notificationTypeString = resultSet.getString("notification_type");
                String notification = resultSet.getString("notification");
                BaseDBStoredRawNotification storedRawNotification = new BaseDBStoredRawNotification(boxedInternalID, NotificationTypeEnum.valueOf(notificationTypeString), notification);
                workList.add(storedRawNotification);
                
            }
            
            int listSize = internalIDList.size();
            if (listSize > 0) {
                for (int i = 0; i < listSize - 1; i++) {
                    updateStatementBuilder.append("?,");
                }
                updateStatementBuilder.append("?)");
                updateStatement = connection.prepareStatement(updateStatementBuilder.toString());
                updateStatement.setString(1, ProcessingStatus.PROCESSING.name());
                int index = 2;
                for (Long id : internalIDList) {
                    updateStatement.setLong(index++, id);
                }
                
                if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
                int result = updateStatement.executeUpdate();
                if (plog.isTraceEnabled()) plog.trace("update raw notif status DB UPDATE time: " + (System.currentTimeMillis() - startTime));
                
                if (result != listSize) {
                    throw new IngestException("List size mismatch. Cached: " + listSize + " updated: " + result);
                }
                
            }
            
            
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            if (updateStatement != null) {
                updateStatement.close();
                updateStatement = null;
            }
            
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
            connectionPool.releaseEntry(connection);
        }
    }


    /**
     * @author Devarshi Ghoshal
     * Methods to add annotations into the database for existing entities
     */

	@Override
	public void storeAddedAnnotation(NotificationSummary notificationSummary, AnnotableObject annotableObject, 
			Calendar notificationTime, Calendar annotatingTime, List<Annotation> annotationList)
			throws IngestException {
		// TODO Auto-generated method stub
        Connection connection = null;
        try {
            connection = getConnection();
            addNewAnnotations(notificationSummary, annotableObject, notificationTime, annotatingTime, annotationList, connection);
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }
		
	}
    
	public void storeAddedAnnotationById(NotificationSummary notificationSummary, long objectId, 
			AnnotableObjectEnumType.Enum objectCategory, Calendar notificationTime, Calendar annotatingTime, 
			List<Annotation> annotationList) throws IngestException {
		// TODO Auto-generated method stub
        Connection connection = null;
        try {
            long startTime = 0;
            
            connection = getConnection();
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            
            switch(objectCategory.intValue()){
    		case AnnotableObjectEnumType.INT_ENTITY:
    			addAnnotations("exe_entity_annotation", "entity_id", objectId, annotationList, connection);
    			break;
    		case AnnotableObjectEnumType.INT_FILE:
    			addAnnotations("exe_data_object_annotation", "object_id", objectId, annotationList, connection);
    			break;
    		default:
    			break;
    		}
            
            if (plog.isTraceEnabled()) plog.trace("storeAddedAnnotationById: " + (System.currentTimeMillis() - startTime));
        } catch (SQLException sqle) {
            throw new IngestException(sqle);
        } finally {
            connectionPool.releaseEntry(connection);
        }
		
	}
	
	@Override
	public void storeAddedMultipleObjectAnnotation(
			NotificationSummary notificationSummary,
			AnnotableObject[] annotableObject, Calendar notificationTime,
			Calendar annotatingTime, List<Annotation> annotationList)
			throws IngestException {
		// TODO Auto-generated method stub
		 Connection connection = null;
	        try {
	            connection = getConnection();
	            for (int i = 0; i < annotableObject.length; i++) {
	            	addNewAnnotations(notificationSummary, annotableObject[i], notificationTime, annotatingTime, annotationList, connection);
	    		}
	        } catch (SQLException sqle) {
	            throw new IngestException(sqle);
	        } finally {
	            connectionPool.releaseEntry(connection);
	        }		
	}
	
	@Override
	public void storeAddedRelationshipAnnotationById(
			NotificationSummary notificationSummary, long relationshipId,
			AnnotableRelationshipEnumType.Enum relationshipCategory, Calendar notificationTime,
			Calendar annotatingTime, List<Annotation> annotationList)
			throws IngestException {
		
		// TODO Auto-generated method stub
		  Connection connection = null;
	        try {
	            long startTime = 0;
	            
	            connection = getConnection();
	            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
	            
	            switch(relationshipCategory.intValue()){
	    		case AnnotableRelationshipEnumType.INT_INVOCATION:
	    			addAnnotations("exe_invocation_annotation", "invocation_id", relationshipId, annotationList, connection);
	    			break;
	    		case AnnotableRelationshipEnumType.INT_DATA_TRANSFER:
	    			addAnnotations("exe_data_transfer_annotation", "transfer_id", relationshipId, annotationList, connection);
	    			break;
	    		default:
	    			break;
	    		}
	            
	            if (plog.isTraceEnabled()) plog.trace("storeAddedRelationshipAnnotationById: " + (System.currentTimeMillis() - startTime));
	        } catch (SQLException sqle) {
	            throw new IngestException(sqle);
	        } finally {
	            connectionPool.releaseEntry(connection);
	        }
	}
	
	/**
	 * Method for adding new annotations for entities and files based on URIs
	 * @param notificationSummary
	 * @param annotableObject
	 * @param notificationTime
	 * @param annotatingTime
	 * @param annotationList
	 * @param connection
	 */
	protected void addNewAnnotations(NotificationSummary notificationSummary, AnnotableObject annotableObject, 
			Calendar notificationTime, Calendar annotatingTime, List<Annotation> annotationList, Connection connection){
		AnnotableObjectCategoryEnum objectCategory = annotableObject.getAnnotableObjectCategory();        
        long startTime = 0;   
        if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
        switch(objectCategory){
    	case ENTITY:
    		addEntityAnnotations((AnnotableEntity)annotableObject, notificationTime, annotatingTime, annotationList, connection);
    		break;
    	case FILE:
    		addFileAnnotations((AnnotableFile)annotableObject, notificationTime, annotatingTime, annotationList, connection);
    		break;
    	default:
    		break;
    	}
            
        if (plog.isTraceEnabled()) plog.trace("addAnnotationById: " + (System.currentTimeMillis() - startTime));
        
	}
	
	protected void addEntityAnnotations(AnnotableEntity annotableEntity, Calendar notificationTime, Calendar annotatingTime, 
			List<Annotation> annotationList, Connection connection){
		String entityID = annotableEntity.getEntityID();
		String contextEntityID = annotableEntity.getContextEntityID();
		//edu.indiana.dsi.karma.ingest.AnnotableObject.EntityCategoryEnum entityCategory = annotableEntity.getEntityCategory();
		
		ArrayList<Long> internalIDs;
		try {
			internalIDs = getInternalIDs("entity_uri", entityID, "context_workflow_uri", contextEntityID, null, 
					"exe_entity", "entity_id", connection, AnnotableObjectCategoryEnum.ENTITY);		
			if(internalIDs.size() > 0){
				if (log.isDebugEnabled()) log.debug("Annotations added to entities");
				for (int i = 0; i < internalIDs.size(); i++) {
					addAnnotations("exe_entity_annotation", "entity_id", internalIDs.get(i), annotationList, connection);				
				}
			}
			else{
				if (log.isDebugEnabled()) log.debug("EntityID missing at Execution-level, checking at Registry-level");
				internalIDs = getInternalIDs("name", entityID, null, null, null, 
						"reg_entity", "entity_id", connection, AnnotableObjectCategoryEnum.REGISTRY_ENTITY);	
				if(internalIDs.size() > 0){
					for (int i = 0; i < internalIDs.size(); i++) {
						addAnnotations("reg_entity_annotation", "entity_id", internalIDs.get(i), annotationList, connection);				
					}
				}
				else{
					if (log.isDebugEnabled()) log.debug("No matching entity-uri " + entityID + " for adding annotation");
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  catch (IngestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void addFileAnnotations(AnnotableFile annotableFile, Calendar notificationTime, Calendar annotatingTime, 
			List<Annotation> annotationList, Connection connection){
		String fileID = "%"+annotableFile.getFileID()+"%";
		String ownerDN = annotableFile.getOwnerDN();
		Calendar createDate = annotableFile.getCreateDate();
		ArrayList<Long> internalIDs;
		try {
			internalIDs = getInternalIDs("file_uri", fileID, "owner_id", ownerDN, createDate, "exe_file", 
					"file_id", connection, AnnotableObjectCategoryEnum.FILE);		
			for (int i = 0; i < internalIDs.size(); i++) {
				addAnnotations("exe_data_object_annotation", "object_id", internalIDs.get(i), annotationList, connection);				
			}	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  catch (IngestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	private ArrayList<Long> getInternalIDs(String objectColumn, String objectID, String contextObject, String contextObjectID,
			 Calendar date, String tableName, String columnName, Connection connection, AnnotableObjectCategoryEnum objectCategory) 
			 throws SQLException {
		ArrayList<Long>internalIDs = new ArrayList<Long>();		

        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;
        int columnId = 1;
        try {
        	String stmt = "SELECT "+ columnName + " from " + tableName + " WHERE " + objectColumn + " LIKE ?";
        	
        	if(contextObjectID != null){
        		if(objectCategory.equals(AnnotableObjectCategoryEnum.ENTITY)){
        			stmt  += " AND " + contextObject + " = ?";
        		}
        		else if(objectCategory.equals(AnnotableObjectCategoryEnum.FILE)){        			
        			stmt  += " AND owner_id" + " = ?";
        		}
        	}
        	if(date != null){
        		stmt  += " AND creation_date = ?";
        	}        
        	
            prepStatement = connection.prepareStatement(stmt);
            prepStatement.setString(columnId++, objectID);            
        	if(contextObjectID != null){        		        	
        		if(objectCategory.equals(AnnotableObjectCategoryEnum.ENTITY)){
        			prepStatement.setString(columnId++, contextObjectID);
        		}
        		else if(objectCategory.equals(AnnotableObjectCategoryEnum.FILE)){ 
        			Long ownerID = getOwnerID(contextObjectID, connection);
        			prepStatement.setLong(columnId++, ownerID);
        		}
        	}        	
        	if(date != null){
        		prepStatement.setTimestamp(columnId++, new java.sql.Timestamp(date.getTimeInMillis()));
        	}
        	
            resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
            	internalIDs.add(resultSet.getLong(1));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (prepStatement != null) {
                prepStatement.close();
                prepStatement = null;
            }
        }
        
        return internalIDs;
	}

	private Long getOwnerID(String ownerDN, Connection connection) throws SQLException{
		Long ownerID = null;
		PreparedStatement prepStatement = null;
        ResultSet resultSet = null;
        String stmt = "select personnel_id from reg_personnel where dn = ?";
        try{
        prepStatement = connection.prepareStatement(stmt);
        prepStatement.setString(1, ownerDN);
        resultSet = prepStatement.executeQuery();        
        if(resultSet.next()){
        	ownerID = resultSet.getLong(1);
        }
        }finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            
            if (prepStatement != null) {
                prepStatement.close();
                prepStatement = null;
            }
        }
        
        return ownerID;
	}	
	
	
	/**
	 * @author Devarshi: Methods to ingest Registry-level information
	 * @throws SQLException 
	 */
	protected Long setRegistryInfo(String entityType, String entitySubtype, InstanceOf instanceOf, Connection connection) throws SQLException{
    	Long internalID = null;
    	PreparedStatement statement = null;
    	int index = 1;
    	try {
    		StringBuilder builder = new StringBuilder("INSERT INTO reg_entity (entity_type, entity_subtype, name");
    		StringBuilder valueBuilder = new StringBuilder("VALUES(?, ?, ?");
    		
    		String instanceOfId = instanceOf.getInstanceOfId();
    		String versionNum = null;
    		if(instanceOf.getVersion() != null){
    			versionNum = instanceOf.getVersion();
    			builder.append(", version");
    			valueBuilder.append(", ?");
    		}
    		Calendar creationTime = null;
    		if(instanceOf.getCreationTime() != null){
    			creationTime = instanceOf.getCreationTime();
    			builder.append(", creation_time");
    			valueBuilder.append(", ?");
    		}
    		builder.append(")");
    		valueBuilder.append(")");
    		
    		statement = connection.prepareStatement(builder.toString() + valueBuilder.toString());
    		
    		statement.setString(index++, entityType);
    		statement.setString(index++, entitySubtype);
    		statement.setString(index++, instanceOfId);
    		if(versionNum != null){
    			statement.setString(index++, versionNum);    
    		}
    		if(creationTime != null){
    			statement.setTimestamp(index++, new java.sql.Timestamp(creationTime.getTimeInMillis()));
    		}
    		// set creation_time here
    				
    		int result = statement.executeUpdate();
			internalID = getLastAutoID(connection);
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
		return internalID;
    }
    
    protected Long getRegEntityRecord(EntityObject entity, InstanceOf instanceOf, Connection connection) throws SQLException {
        if (log.isDebugEnabled()) log.debug("registry-entity uri: " + instanceOf.getInstanceOfId());
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Long internalID = null;
        try {
            EntitySubtypeEnum subtype = entity.getEntitySubtype();
            String registryEntityId = instanceOf.getInstanceOfId();
            String version = instanceOf.getVersion();
            if(version == null){
            	version = "0"; 
            }
            if (subtype != null) {
                statement = connection.prepareStatement("SELECT entity_id FROM reg_entity WHERE name=? AND entity_type=? AND entity_subtype=? AND version=?");
                statement.setString(1, registryEntityId);
                statement.setString(2, entity.getEntityCategory().name());
                statement.setString(3, subtype.name());
                statement.setString(4, version);
                if (log.isDebugEnabled()) {
                    log.debug("Q1: SELECT entity_id FROM reg_entity WHERE name=? AND entity_type=? AND entity_subtype=? AND version=?" + "\n" + registryEntityId + "\n" + entity.getEntityCategory().name() + "\n" + subtype.name() + "\n" + version);
                }
            } else {
                statement = connection.prepareStatement("SELECT entity_id FROM reg_entity WHERE name=? AND entity_type=? AND version=? AND (entity_subtype=? OR entity_subtype IS NULL)");
                statement.setString(1, registryEntityId);
                statement.setString(2, entity.getEntityCategory().name());                
                statement.setString(3, version);
                statement.setString(4, EntitySubtypeEnum.REGULAR.name());
                if (log.isDebugEnabled()) {
                    log.debug("Q2: SELECT entity_id FROM reg_entity WHERE name=? AND entity_type=? AND version=? AND (entity_subtype=? OR entity_subtype IS NULL)" + "\n" + registryEntityId + "\n" + entity.getEntityCategory().name() + "\n" + EntitySubtypeEnum.REGULAR.name() + "\n" + version);
                }
            }
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("get workflow record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                internalID = Long.valueOf(resultSet.getLong("entity_id"));
                if (log.isDebugEnabled()) log.debug("REG INTERNAL ID: " + resultSet.getLong("entity_id"));
                if (resultSet.wasNull()) {
                	internalID = null;
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        
        return internalID;
    }
    
    protected Long addAuthorship(Long regEntityId, Long behalfInternalID, AuthorshipTypeEnum authorshipType, Connection connection) throws IngestException{
    	Long internalID = null;
    	try{
    		internalID = getAuthorshipRecord(regEntityId, behalfInternalID, authorshipType, connection);
    		if(internalID == null){
    			internalID = insertAuthorshipRecord(regEntityId, behalfInternalID, authorshipType, connection);
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    	return internalID;
    }

    protected Long getAuthorshipRecord(Long regEntityId, Long behalfInternalID, AuthorshipTypeEnum authorshipType,  Connection connection) throws SQLException {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Long internalID = null;
        try {
            statement = connection.prepareStatement("SELECT authorship_id FROM reg_entity_authorship WHERE author_id=? AND entity_id=? AND role=?");
            statement.setLong(1, regEntityId);
            statement.setLong(2, behalfInternalID);
            statement.setString(3, authorshipType.name());
            
            long startTime = 0;
            if (plog.isTraceEnabled()) startTime = System.currentTimeMillis();
            resultSet = statement.executeQuery();
            if (plog.isTraceEnabled()) plog.trace("get workflow record time: " + (System.currentTimeMillis() - startTime));
            
            if (resultSet.next()) {
                internalID = resultSet.getLong("authorship_id");
                if (resultSet.wasNull()) {
                	internalID = null;
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
                resultSet = null;
            }
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        
        return internalID;
    }
    
    protected Long insertAuthorshipRecord(Long regEntityId, Long behalfInternalID, AuthorshipTypeEnum authorshipType,  Connection connection) throws IngestException, SQLException{
    	Long internalID = null;
    	PreparedStatement statement = null;
    	int index = 1;
    	try {
    		StringBuilder builder = new StringBuilder("INSERT INTO reg_entity_authorship (author_id, entity_id, role");
    		StringBuilder valueBuilder = new StringBuilder("VALUES(?, ?, ?");
    		builder.append(")");
    		valueBuilder.append(")");
    		
    		statement = connection.prepareStatement(builder.toString() + valueBuilder.toString());
    		
    		statement.setLong(index++, regEntityId);
    		statement.setLong(index++, behalfInternalID);
    		statement.setString(index++, authorshipType.name());    
    				
    		int result = statement.executeUpdate();
    		internalID = getLastAutoID(connection);
    		if(result > 0){
    			if(log.isDebugEnabled()) log.debug("Authorship data ingested");
    		} 
    		else {
                throw new IngestException("Failed to add authorship data");
            }
            
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}finally {
             if (statement != null) {
                 statement.close();
                 statement = null;
             }
         }
    	return internalID;

    }
}

