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
# File:  BaseDBIngester.java
# Description:  An implementation of NotificationIngester that works
#   with database
#
# -----------------------------------------------------------------
# 
*/



/**
 */
package edu.indiana.dsi.karma.ingest.db;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.ActionEnumType;
import org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType;
import org.dataandsearch.www.karma._2010._08.AddAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationType;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType;
import org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdType;
import org.dataandsearch.www.karma._2010._08.AnnotableEntityType;
import org.dataandsearch.www.karma._2010._08.AnnotableFileType;
import org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType;
import org.dataandsearch.www.karma._2010._08.AnnotableRelationshipEnumType;
import org.dataandsearch.www.karma._2010._08.DataConsumedDocument;
import org.dataandsearch.www.karma._2010._08.DataDeletedDocument;
import org.dataandsearch.www.karma._2010._08.DataLifeCycleType;
import org.dataandsearch.www.karma._2010._08.DataProducedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataTransferStatusType;
import org.dataandsearch.www.karma._2010._08.DataTransferType;
import org.dataandsearch.www.karma._2010._08.DataUpdatedDocument;
import org.dataandsearch.www.karma._2010._08.EntityLifeCycleType;
import org.dataandsearch.www.karma._2010._08.InvocationStatusType;
import org.dataandsearch.www.karma._2010._08.InvocationType;
import org.dataandsearch.www.karma._2010._08.InvokingServiceDocument;
import org.dataandsearch.www.karma._2010._08.InvokingServiceStatusDocument;
import org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument;
import org.dataandsearch.www.karma._2010._08.InvokingWorkflowStatusDocument;
import org.dataandsearch.www.karma._2010._08.ReceivedFaultDocument;
import org.dataandsearch.www.karma._2010._08.ReceivedResponseDocument;
import org.dataandsearch.www.karma._2010._08.SendingFaultDocument;
import org.dataandsearch.www.karma._2010._08.SendingResponseDocument;
import org.dataandsearch.www.karma._2010._08.SendingResponseStatusDocument;
import org.dataandsearch.www.karma._2010._08.ServiceInitializedDocument;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;
import org.dataandsearch.www.karma._2010._08.ServiceTerminatedDocument;
import org.dataandsearch.www.karma._2010._08.UnknownDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowFailedDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowInitializedDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowTerminatedDocument;

import edu.indiana.dsi.karma.ingest.AnnotableObject;
import edu.indiana.dsi.karma.ingest.Annotation;
import edu.indiana.dsi.karma.ingest.DataObject;
import edu.indiana.dsi.karma.ingest.EntityObject;
import edu.indiana.dsi.karma.ingest.IngestException;
import edu.indiana.dsi.karma.ingest.IngesterConstants;
import edu.indiana.dsi.karma.ingest.IngesterImplementer;
import edu.indiana.dsi.karma.ingest.NotificationIngester;
import edu.indiana.dsi.karma.ingest.NotificationSummary;
import edu.indiana.dsi.karma.ingest.EntityObject.EntityCategoryEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.DataLifeCycleEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.EntityLifeCycleEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.InvocationTypeEnum;
import edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingFilterType;
import edu.indiana.dsi.karma.ingest.IngesterConstants.ProcessingStatus;
import edu.indiana.dsi.karma.ingest.IngesterImplementer.StoredRawNotification;
import edu.indiana.dsi.karma.ingest.NotificationSummary.InvocationDataEnum;
import edu.indiana.dsi.karma.ingest.NotificationSummary.NotificationTypeEnum;
import edu.indiana.dsi.karma.ingest.NotificationSummary.StatusEnum;

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 * @author You-Wei Cheah
 *
 */
public class BaseDBIngester implements NotificationIngester {
    

    public static final int DEFAULT_RAW_NOTIFICATION_PROCESS_BATCH_SIZE = 10;
    
    protected static Logger log = Logger.getLogger(BaseDBIngester.class);
    protected int processingBatchSize;
    
    protected IngesterImplementer implementer = null;

    
    public BaseDBIngester(IngesterImplementer implementer, int processingBatchSize) {
        this.implementer = implementer;
        this.processingBatchSize = processingBatchSize > 0 ? processingBatchSize : DEFAULT_RAW_NOTIFICATION_PROCESS_BATCH_SIZE;
    }
    public BaseDBIngester(IngesterImplementer implementer) {
        this(implementer, DEFAULT_RAW_NOTIFICATION_PROCESS_BATCH_SIZE);
    }
    
    public BaseDBIngester() {
        this(null, DEFAULT_RAW_NOTIFICATION_PROCESS_BATCH_SIZE);
    }
    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#setImplementer(edu.indiana.dsi.karma.ingest.IngesterImplementer)
     */
    @Override
    public void setImplementer(IngesterImplementer implementer) {
        assert this.implementer == null : this.implementer.toString();
        this.implementer = implementer;
    }

    /**
     * A helper method that assists the process of DataTransferType notifications 
     * @param notificationSummary summary of the source notification
     * @param dataTransferType XmlBeans of DataTransferType
     * @throws IngestException thrown if the DataTranferType XmlBeans does not contain the expected data
     */
    protected void dataTransferProcessHelper(NotificationSummary notificationSummary, DataTransferType dataTransferType)  throws IngestException {
        
        InvocationDataEnum dataType = null;
        DataObject data = null;

        switch (notificationSummary.getNotificationType()) {
        case DATA_RECEIVED_FINISHED:
        case DATA_RECEIVED_STARTED:
        case DATA_SEND_FINISHED:
        case DATA_SEND_STARTED:
        case SENDING_RESPONSE_STATUS:
            switch(notificationSummary.getDataType()) {
            case FAULT:
                if (!dataTransferType.isSetFault()) {
                    throw new IngestException(IngesterConstants.EXPMSG_MISSING_FAULT_INFO + notificationSummary.getNotificationType().name());
                } else {
                    dataType = notificationSummary.getDataType();
                    data = DataObjectFactory.convertFromXmlBeansDataObjectType(dataTransferType.getFault());
                }
                break;
            case RESULT:
                if (!dataTransferType.isSetResult()) {
                    throw new IngestException(IngesterConstants.EXPMSG_MISSING_RESULT_INFO + notificationSummary.getNotificationType().name());
                } else {
                    dataType = notificationSummary.getDataType();
                    data = DataObjectFactory.convertFromXmlBeansDataObjectType(dataTransferType.getResult());
                }
                break;
            case PARAMS:
            default:
                assert false : "Should not have PARAMS " + notificationSummary.getNotificationType().name();
            }
            break;
        case RECEIVED_FAULT:
        case SENDING_FAULT:
            if (!dataTransferType.isSetFault()) {
                throw new IngestException(IngesterConstants.EXPMSG_MISSING_FAULT_INFO + notificationSummary.getNotificationType().name());
            } else {
                dataType = InvocationDataEnum.FAULT;
                data = DataObjectFactory.convertFromXmlBeansDataObjectType(dataTransferType.getFault());
            }
            break;
        case RECEIVED_RESPONSE:
        case SENDING_RESPONSE:
            if (!dataTransferType.isSetResult()) {
                throw new IngestException(IngesterConstants.EXPMSG_MISSING_RESULT_INFO + notificationSummary.getNotificationType().name());
            } else {
                dataType = InvocationDataEnum.RESULT;
                data = DataObjectFactory.convertFromXmlBeansDataObjectType(dataTransferType.getResult());
            }
            break;
        }


//        EntityType senderEntity = dataTransferType.getSender();
//        EntityType receiverEntity = dataTransferType.getReceiver();
        
        EntityObject senderEntity = EntityFactory.convertFromXmlBeansEntityType(dataTransferType.getSender());
        EntityObject receiverEntity = EntityFactory.convertFromXmlBeansEntityType(dataTransferType.getReceiver());

        InvocationTypeEnum invocationType = determineInvocationType(receiverEntity, senderEntity);

        Calendar transferTime = dataTransferType.getTransferTime();

        
        List<Annotation> annotationList = AnnotationFactory.convert(dataTransferType.getAnnotationsArray());


        // Fault is sent from an invokee to an invoker, so if an entity has received fault
        // this entity is the invoker, and whoever sent the fault is the invokee
//        EntityType invokerEntity = receiverEntity;
//        EntityType invokeeEntity = senderEntity;
        EntityObject invokerEntity = receiverEntity;
        EntityObject invokeeEntity = senderEntity;
//        NotificationTypeSummary notificationSummary = new NotificationTypeSummary(NotificationTypeEnum.DATA_RECEIVED_FINISHED);

        implementer.storeInvocationResponse(notificationSummary, invokerEntity, invokeeEntity, invocationType, transferTime, dataType, data, annotationList);

    }

    /**
     * A helper method to assist the initial check and store of notifications regarding data life cycle
     * @param notificationSummary summary of the notification
     * @param document the XmlBeans document of the notification
     * @param dataLifeCycle the DataLifeCycle XmlBeans extracted from the document
     * @param expectedAction action expected to be set in the DataLifeCycle XmlBeans
     * @throws IngestException thrown if the action set in the document does not match the expected action
     *
     */
    protected void dataLifeCycleIngestHelper(NotificationSummary notificationSummary, XmlObject document, DataLifeCycleType dataLifeCycle, ActionEnumType.Enum expectedAction) throws IngestException {
        ActionEnumType.Enum action = dataLifeCycle.getAction();
        
        if (expectedAction.equals(action)) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(notificationSummary.getNotificationType(), storeTime, document);
        } else {
            log.warn(IngesterConstants.EXPMSG_ACTION_MISMATCH_NOTIFICATION_TYPE + notificationSummary.getNotificationType().name());
            throw new IngestException(IngesterConstants.EXPMSG_ACTION_MISMATCH_NOTIFICATION_TYPE + notificationSummary.getNotificationType().name());
        }
    }
    
    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataConsumed(org.dataandsearch.www.karma.DataConsumedDocument)
     * 
     */
    @Override
    public void ingestDataConsumed(DataConsumedDocument dataConsumedDoc) throws IngestException {
        log.info("in ingestDataConsumed");
        if (log.isDebugEnabled()) log.debug("dataConsumedDoc:\n" + dataConsumedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (dataConsumedDoc.validate()) {
            
            dataLifeCycleIngestHelper(NotificationSummary.generateSummary(dataConsumedDoc), dataConsumedDoc, dataConsumedDoc.getDataConsumed(), ActionEnumType.CONSUME);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_CONSUMED.name());
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_CONSUMED.name());
        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataProduced(org.dataandsearch.www.karma.DataProducedDocument)
     * 
     */
    @Override
    public void ingestDataProduced(DataProducedDocument dataProducedDoc) throws IngestException {
        log.info("in ingestDataProduced");
        if (log.isDebugEnabled()) log.debug("dataProducedDoc:\n" + dataProducedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (dataProducedDoc.validate()) {
            dataLifeCycleIngestHelper(NotificationSummary.generateSummary(dataProducedDoc), dataProducedDoc, dataProducedDoc.getDataProduced(), ActionEnumType.PRODUCE);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_PRODUCED.name());
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_PRODUCED.name());
        }

    }
    
    
    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataDeleted(org.dataandsearch.www.karma.DataDeletedDocument)
     * 
     */
    @Override
    public void ingestDataDeleted(DataDeletedDocument dataDeletedDoc) throws IngestException {
        log.info("in ingestDataDeleted");
        if (log.isDebugEnabled()) log.debug("dataDeletedDoc:\n" + dataDeletedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (dataDeletedDoc.validate()) {
            dataLifeCycleIngestHelper(NotificationSummary.generateSummary(dataDeletedDoc), dataDeletedDoc, dataDeletedDoc.getDataDeleted(), ActionEnumType.DELETE);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_DELETED.name());
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_DELETED.name());
        }
    }
    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataUpdated(org.dataandsearch.www.karma.DataUpdatedDocument)
     */
    @Override
    public void ingestDataUpdated(DataUpdatedDocument dataUpdatedDoc) throws IngestException {
        log.info("in ingestDataUpdated");
        if (log.isDebugEnabled()) log.debug("dataUpdatedDoc:\n" + dataUpdatedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (dataUpdatedDoc.validate()) {
            dataLifeCycleIngestHelper(NotificationSummary.generateSummary(dataUpdatedDoc), dataUpdatedDoc, dataUpdatedDoc.getDataUpdated(), ActionEnumType.UPDATE);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_UPDATED.name());
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.DATA_UPDATED.name());
        }
    }
    


    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataReceivedFinished(org.dataandsearch.www.karma.DataReceivedFinishedDocument)
     */
    @Override
    public void ingestDataReceivedFinished(DataReceivedFinishedDocument dataReceivedFinishedDoc) throws IngestException {
        log.info("in ingestDataReceivedFinished");
        if (log.isDebugEnabled()) log.debug("dataReceivedFinishedDoc:\n" + dataReceivedFinishedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = DataReceivedFinishedDocument.class.getSimpleName();
        
        if (dataReceivedFinishedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.DATA_RECEIVED_FINISHED, storeTime, dataReceivedFinishedDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataSendFinished(org.dataandsearch.www.karma.DataSendFinishedDocument)
     */
    @Override
    public void ingestDataSendFinished(DataSendFinishedDocument dataSendFinishedDoc) throws IngestException {
        log.info("in ingestDataSendFinished");
        if (log.isDebugEnabled()) log.debug("dataSendFinishedDoc:\n" + dataSendFinishedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = DataSendFinishedDocument.class.getSimpleName();
        
        if (dataSendFinishedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.DATA_SEND_FINISHED, storeTime, dataSendFinishedDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
        }

    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataSendStarted(org.dataandsearch.www.karma.DataSendStartedDocument)
     */
    @Override
    public void ingestDataSendStarted(DataSendStartedDocument dataSendStartedDoc) throws IngestException {
        log.info("in ingestDataSendStarted");
        if (log.isDebugEnabled()) log.debug("dataSendStartedDoc:\n" + dataSendStartedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = DataSendStartedDocument.class.getSimpleName();
        
        if (dataSendStartedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.DATA_SEND_STARTED, storeTime, dataSendStartedDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestReceivedFault(org.dataandsearch.www.karma.ReceivedFaultDocument)
     */
    @Override
    public void ingestReceivedFault(ReceivedFaultDocument receivedFaultDoc) throws IngestException {
        log.info("in ingestReceivedFault");
        if (log.isDebugEnabled()) log.debug("receivedFaultDoc:\n" + receivedFaultDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = ReceivedFaultDocument.class.getSimpleName();
        
        if (receivedFaultDoc.validate()) {
            DataTransferType receivedFault = receivedFaultDoc.getReceivedFault();

            if (receivedFault.isSetFault()) {
                Calendar storeTime = Calendar.getInstance();
                implementer.storeRawNotification(NotificationTypeEnum.RECEIVED_FAULT, storeTime, receivedFaultDoc);

                // processNotifications();
            } else {
                log.warn(IngesterConstants.EXPMSG_MISSING_FAULT_INFO + docType);
                throw new IngestException(IngesterConstants.EXPMSG_MISSING_FAULT_INFO + docType);
            }
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestReceivedResponse(org.dataandsearch.www.karma.ReceivedResponseDocument)
     */
    @Override
    public void ingestReceivedResponse(ReceivedResponseDocument receivedResponseDoc) throws IngestException {
        log.info("in ingestReceivedResponse");
        if (log.isDebugEnabled()) log.debug("receivedResponseDoc:\n" + receivedResponseDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = ReceivedResponseDocument.class.getSimpleName();

        if (receivedResponseDoc.validate()) {
            DataTransferType receivedResponse = receivedResponseDoc.getReceivedResponse();

            if (receivedResponse.isSetResult()) {
                Calendar storeTime = Calendar.getInstance();
                implementer.storeRawNotification(NotificationTypeEnum.RECEIVED_RESPONSE, storeTime, receivedResponseDoc);

                // processNotifications();
            } else {
                log.warn(IngesterConstants.EXPMSG_MISSING_RESULT_INFO + docType);
                throw new IngestException(IngesterConstants.EXPMSG_MISSING_RESULT_INFO + docType);
            }
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestDataReceivedStarted(org.dataandsearch.www.karma.DataReceivedStartedDocument)
     */
    @Override
    public void ingestDataReceivedStarted(DataReceivedStartedDocument dataReceivedStartedDoc) throws IngestException {
        log.info("in ingestDataReceivedStarted");
        if (log.isDebugEnabled()) log.debug("dataReceivedStartedDoc:\n" + dataReceivedStartedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = DataReceivedFinishedDocument.class.getSimpleName();
        
        if (dataReceivedStartedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.DATA_RECEIVED_STARTED, storeTime, dataReceivedStartedDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestSendingFault(org.dataandsearch.www.karma.SendingFaultDocument)
     */
    @Override
    public void ingestSendingFault(SendingFaultDocument sendingFaultDoc) throws IngestException {
        log.info("in ingestSendingFault");
        if (log.isDebugEnabled()) log.debug("sendingFaultDoc:\n" + sendingFaultDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = SendingFaultDocument.class.getSimpleName();
        
        
        if (sendingFaultDoc.validate()) {
            DataTransferType sendingFault = sendingFaultDoc.getSendingFault();

            if (sendingFault.isSetFault()) {
                Calendar storeTime = Calendar.getInstance();
                implementer.storeRawNotification(NotificationTypeEnum.SENDING_FAULT, storeTime, sendingFaultDoc);

            } else {
                log.warn(IngesterConstants.EXPMSG_MISSING_FAULT_INFO + docType);
                throw new IngestException(IngesterConstants.EXPMSG_MISSING_FAULT_INFO + docType);

            }

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
        }

    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestSendingResponse(org.dataandsearch.www.karma.SendingResponseDocument)
     */
    @Override
    public void ingestSendingResponse(SendingResponseDocument sendingResponseDoc) throws IngestException {
        log.info("in ingestSendingResponse");
        if (log.isDebugEnabled()) log.debug("sendingResponseDoc:\n" + sendingResponseDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = SendingResponseDocument.class.getSimpleName();

        if (sendingResponseDoc.validate()) {
            DataTransferType sendingResponse = sendingResponseDoc.getSendingResponse();

            if (sendingResponse.isSetResult()) {
                Calendar storeTime = Calendar.getInstance();
                implementer.storeRawNotification(NotificationTypeEnum.SENDING_RESPONSE, storeTime, sendingResponseDoc);

            } else {
                log.warn(IngesterConstants.EXPMSG_MISSING_RESULT_INFO + docType);
                throw new IngestException(IngesterConstants.EXPMSG_MISSING_RESULT_INFO + docType);

            }

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
        }
    }
    
    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestSendingResponseStatus(org.dataandsearch.www.karma.SendingResponseStatusDocument)
     */
    @Override
    public void ingestSendingResponseStatus(SendingResponseStatusDocument sendingResponseStatusDoc) throws IngestException {
        log.info("in ingestSendingResponseStatus");
        if (log.isDebugEnabled()) log.debug("sendingResponseStatusDoc:\n" + sendingResponseStatusDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = SendingResponseStatusDocument.class.getSimpleName();
        
        if (sendingResponseStatusDoc.validate()) {

            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.SENDING_RESPONSE_STATUS, storeTime, sendingResponseStatusDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestInvokingService(org.dataandsearch.www.karma.InvokingServiceDocument)
     */
    @Override
    public void ingestInvokingService(InvokingServiceDocument invokingServiceDoc) throws IngestException {
        log.info("in ingestInvokingService");
        if (log.isDebugEnabled()) log.debug("invokingServiceDoc:\n" + invokingServiceDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = InvokingServiceDocument.class.getSimpleName();
        
        if (invokingServiceDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.INVOKING_SERVICE, storeTime, invokingServiceDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }


    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestInvokingServiceStatus(org.dataandsearch.www.karma.InvokingServiceStatusDocument)
     */
    @Override
    public void ingestInvokingServiceStatus(InvokingServiceStatusDocument invokingServiceStatusDoc) throws IngestException {
        log.info("in ingest InvokingServiceStatus");
        if (log.isDebugEnabled()) log.debug("invokingServiceStatusDoc:\n" + invokingServiceStatusDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = InvokingServiceStatusDocument.class.getSimpleName();
        
        if (invokingServiceStatusDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.INVOKING_SERVICE_STATUS, storeTime, invokingServiceStatusDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }

    }
    
    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestServiceInitialized(org.dataandsearch.www.karma.ServiceInitializedDocument)
     */
    @Override
    public void ingestServiceInitialized(ServiceInitializedDocument serviceInitializedDoc) throws IngestException {
        log.info("in ingestServiceInitialized");
        if (log.isDebugEnabled()) log.debug("serviceInitializedDoc:\n" + serviceInitializedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = ServiceInitializedDocument.class.getSimpleName();
        
        if (serviceInitializedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.SERVICE_INITIALIZED, storeTime, serviceInitializedDoc);

            log.warn(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);
            throw new UnsupportedOperationException(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestServiceInvoked(org.dataandsearch.www.karma.ServiceInvokedDocument)
     */
    @Override
    public void ingestServiceInvoked(ServiceInvokedDocument serviceInvokedDoc) throws IngestException {
        log.info("in ingestServiceInvoked");
        if (log.isDebugEnabled()) log.debug("serviceInvokedDoc:\n" + serviceInvokedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = ServiceInvokedDocument.class.getSimpleName();
        if (serviceInvokedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.SERVICE_INVOKED, storeTime, serviceInvokedDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestServiceTerminated(org.dataandsearch.www.karma.ServiceTerminatedDocument)
     */
    @Override
    public void ingestServiceTerminated(ServiceTerminatedDocument serviceTerminatedDoc) throws IngestException {
        log.info("in ingestServiceTerminated");
        if (log.isDebugEnabled()) log.debug("serviceTerminatedDoc:\n" + serviceTerminatedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = ServiceTerminatedDocument.class.getSimpleName();
        
        if (serviceTerminatedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.SERVICE_TERMINATED, storeTime, serviceTerminatedDoc);

            log.warn(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);
            throw new UnsupportedOperationException(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestWorkflowFailed(org.dataandsearch.www.karma.WorkflowFailedDocument)
     */
    @Override
    public void ingestWorkflowFailed(WorkflowFailedDocument workflowFailedDoc) throws IngestException {
        log.info("in ingestWorkflowFailed");
        if (log.isDebugEnabled()) log.debug("workflowFailedDoc:\n" + workflowFailedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = WorkflowFailedDocument.class.getSimpleName();
        
        if (workflowFailedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.WORKFLOW_FAILED, storeTime, workflowFailedDoc);

            log.warn(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);
            throw new UnsupportedOperationException(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }

    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestWorkflowInitialized(org.dataandsearch.www.karma.WorkflowInitializedDocument)
     */
    @Override
    public void ingestWorkflowInitialized(WorkflowInitializedDocument workflowInitializedDoc) throws IngestException {
        log.info("in ingestWorkflowInitialized");
        if (log.isDebugEnabled()) log.debug("workflowInitializedDoc:\n" + workflowInitializedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = WorkflowInitializedDocument.class.getSimpleName();
        
        if (workflowInitializedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.WORKFLOW_INITIALIZED, storeTime, workflowInitializedDoc);
    
            log.warn(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);
            throw new UnsupportedOperationException(IngesterConstants.EXPMSG_NOT_IMPLEMENTED + docType);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestWorkflowInvoked(org.dataandsearch.www.karma.WorkflowInvokedDocument)
     */
    @Override
    public void ingestWorkflowInvoked(WorkflowInvokedDocument workflowInvokedDoc) throws IngestException {
        log.info("in ingestWorkflowInvoked");
        if (log.isDebugEnabled()) log.debug("workflowInvokedDoc:\n" + workflowInvokedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = WorkflowInitializedDocument.class.getSimpleName();
        
        if (workflowInvokedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.WORKFLOW_INVOKED, storeTime, workflowInvokedDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestWorkflowTerminated(org.dataandsearch.www.karma.WorkflowTerminatedDocument)
     */
    @Override
    public void ingestWorkflowTerminated(WorkflowTerminatedDocument workflowTerminatedDoc) throws IngestException {
        log.info("in ingestWorkflowTerminated");
        if (log.isDebugEnabled()) log.debug("workflowTerminatedDoc:\n" + workflowTerminatedDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = WorkflowTerminatedDocument.class.getSimpleName();
        
        if (workflowTerminatedDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.WORKFLOW_TERMINATED, storeTime, workflowTerminatedDoc);

        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
        }
    }
    
    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestUnknownNotification(org.dataandsearch.www.karma.UnknownDocument)
     */
    @Override
    public void ingestUnknownNotification(UnknownDocument unknownDoc) throws IngestException {
        log.info("in ingestUnknownNotification");
        if (log.isDebugEnabled()) log.debug("unknownDoc:\n" + unknownDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        
        Calendar storeTime = Calendar.getInstance();
        implementer.storeRawNotification(NotificationTypeEnum.UNKNOWN_TYPES, storeTime, unknownDoc);

    }
    

    /**
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestInvokingWorkflow(org.dataandsearch.www.karma.InvokingWorkflowDocument)
     */
    @Override
    public void ingestInvokingWorkflow(InvokingWorkflowDocument invokingWorkflowDoc) throws IngestException {
        log.info("in ingestInvokingWorkflow");
        if (log.isDebugEnabled()) log.debug("invokingWorkflowDoc:\n" + invokingWorkflowDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = InvokingWorkflowDocument.class.getSimpleName();
        
        if (invokingWorkflowDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.INVOKING_WORKFLOW, storeTime, invokingWorkflowDoc);

//            log.warn(KarmaConstants.EXPMSG_NOT_IMPLEMENTED + docType);
//            throw new UnsupportedOperationException(KarmaConstants.EXPMSG_NOT_IMPLEMENTED + docType);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#ingestInvokingWorkflowStatus(org.dataandsearch.www.karma.InvokingWorkflowStatusDocument)
     */
    @Override
    public void ingestInvokingWorkflowStatus(InvokingWorkflowStatusDocument invokingWorkflowStatusDoc) throws IngestException {
        log.info("in ingestInvokingWorkflowStatus");
        if (log.isDebugEnabled()) log.debug("invokingWorkflowStatusDoc:\n" + invokingWorkflowStatusDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        String docType = InvokingWorkflowStatusDocument.class.getSimpleName();
        
        if (invokingWorkflowStatusDoc.validate()) {
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.INVOKING_WORKFLOW_STATUS, storeTime, invokingWorkflowStatusDoc);

//            log.warn(KarmaConstants.EXPMSG_NOT_IMPLEMENTED + docType);
//            throw new UnsupportedOperationException(KarmaConstants.EXPMSG_NOT_IMPLEMENTED + docType);
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + docType);

        }
    }

    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#processNotifications()
     */
    @Override
    public int processNotifications() throws IngestException {
        List<StoredRawNotification<Long, String>> list = implementer.retrieveUnprocessedRawNotifications(ProcessingFilterType.KNOWN_TYPES, processingBatchSize);
        List<StoredRawNotification<Long, String>> sweepList = new ArrayList<StoredRawNotification<Long, String>>();
        List<StoredRawNotification<Long, String>> errorList = new ArrayList<StoredRawNotification<Long, String>>();
        
        int rawCount = (list != null) ? list.size() : 0;
        //log.debug("in ingester rawCount: " + rawCount);
        
        if (list != null) {
            for (StoredRawNotification<Long, String> storedRawNotification : list) {
                NotificationTypeEnum notificationType = storedRawNotification.getNotificationType();
                try {
                    switch(notificationType) {
                        case DATA_CONSUMED:
                        {
                            DataConsumedDocument dataConsumedDoc = DataConsumedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataConsumed(dataConsumedDoc);
                            break;
                        }
                        case DATA_DELETED:
                        {
                            DataDeletedDocument dataDeletedDoc = DataDeletedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataDeleted(dataDeletedDoc);
                            break;
                        }
                        case DATA_PRODUCED:
                        {
                            DataProducedDocument dataProducedDoc = DataProducedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataProduced(dataProducedDoc);
                            break;
                        }
                        case DATA_UPDATED:
                        {
                            DataUpdatedDocument dataUpdatedDoc = DataUpdatedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataUpdated(dataUpdatedDoc);
                            break;
                        }
                        case DATA_RECEIVED_FINISHED:
                        {
                            DataReceivedFinishedDocument dataReceivedFinishedDoc = DataReceivedFinishedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataReceivedFinished(dataReceivedFinishedDoc);
                            break;
                        }
                        case DATA_RECEIVED_STARTED:
                        {
                            DataReceivedStartedDocument dataReceivedStartedDoc = DataReceivedStartedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataReceivedStarted(dataReceivedStartedDoc);
                            break;
                        }
                        case DATA_SEND_FINISHED:
                        {
                            DataSendFinishedDocument dataSendFinishedDoc = DataSendFinishedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataSendFinished(dataSendFinishedDoc);
                            break;
                        }
                        case DATA_SEND_STARTED:
                        {
                            DataSendStartedDocument dataSendStartedDoc = DataSendStartedDocument.Factory.parse(storedRawNotification.getNotification());
                            processDataSendStarted(dataSendStartedDoc);
                            break;
                        }
                        case INVOKING_SERVICE:
                        {
                            InvokingServiceDocument invokingServiceDoc = InvokingServiceDocument.Factory.parse(storedRawNotification.getNotification());
                            processInvokingService(invokingServiceDoc);
                            break;
                        }
                        case INVOKING_SERVICE_STATUS:
                        {
                            InvokingServiceStatusDocument invokingServiceStatusDoc = InvokingServiceStatusDocument.Factory.parse(storedRawNotification.getNotification());
                            processInvokingServiceStatus(invokingServiceStatusDoc);
                            break;
                        }
                        case INVOKING_WORKFLOW:
                        {
                            InvokingWorkflowDocument invokingWorkflowDoc = InvokingWorkflowDocument.Factory.parse(storedRawNotification.getNotification());
                            processInvokingWorkflow(invokingWorkflowDoc);
                            break;
                        }
                        case INVOKING_WORKFLOW_STATUS:
                        {
                            InvokingWorkflowStatusDocument invokingWorkflowStatusDoc = InvokingWorkflowStatusDocument.Factory.parse(storedRawNotification.getNotification());
                            processInvokingWorkflowStatus(invokingWorkflowStatusDoc);
                            break;
                        }
                        case RECEIVED_FAULT:
                        {
                            ReceivedFaultDocument receivedFaultDoc = ReceivedFaultDocument.Factory.parse(storedRawNotification.getNotification());
                            processReceivedFault(receivedFaultDoc);
                            break;
                        }
                        case RECEIVED_RESPONSE:
                        {
                            ReceivedResponseDocument receivedResponseDoc = ReceivedResponseDocument.Factory.parse(storedRawNotification.getNotification());
                            processReceivedResponse(receivedResponseDoc);
                            break;
                        }
                        case SENDING_FAULT:
                        {
                            SendingFaultDocument sendingFaultDoc = SendingFaultDocument.Factory.parse(storedRawNotification.getNotification());
                            processSendingFault(sendingFaultDoc);
                            break;
                        }
                        case SENDING_RESPONSE:
                        {
                            SendingResponseDocument sendingResponseDoc = SendingResponseDocument.Factory.parse(storedRawNotification.getNotification());
                            processSendingResponse(sendingResponseDoc);
                            break;
                        }
                        case SENDING_RESPONSE_STATUS:
                        {
                            SendingResponseStatusDocument sendingResponseStatusDoc = SendingResponseStatusDocument.Factory.parse(storedRawNotification.getNotification());
                            processSendingResponseStatus(sendingResponseStatusDoc);
                            break;
                        }
                        case SERVICE_INITIALIZED:
                        {
                            ServiceInitializedDocument serviceInitializedDoc = ServiceInitializedDocument.Factory.parse(storedRawNotification.getNotification());
                            processServiceInitialized(serviceInitializedDoc);
                            break;
                        }
                        case SERVICE_INVOKED:
                        {
                            ServiceInvokedDocument serviceInvokedDoc = ServiceInvokedDocument.Factory.parse(storedRawNotification.getNotification());
                            processServiceInvoked(serviceInvokedDoc);
                            break;
                        }
                        case SERVICE_TERMINATED:
                        {
                            ServiceTerminatedDocument serviceTerminatedDoc = ServiceTerminatedDocument.Factory.parse(storedRawNotification.getNotification());
                            processServiceTerminated(serviceTerminatedDoc);
                            break;
                        }
                        case WORKFLOW_FAILED:
                        {
                            WorkflowFailedDocument workflowFailedDoc = WorkflowFailedDocument.Factory.parse(storedRawNotification.getNotification());
                            processWorkflowFailed(workflowFailedDoc);
                            break;
                        }
                        case WORKFLOW_INITIALIZED:
                        {
                            WorkflowInitializedDocument workflowInitializedDoc = WorkflowInitializedDocument.Factory.parse(storedRawNotification.getNotification());
                            processWorkflowInitialized(workflowInitializedDoc);
                            break;
                        }
                        case WORKFLOW_INVOKED:
                        {
                            WorkflowInvokedDocument workflowInvokedDoc = WorkflowInvokedDocument.Factory.parse(storedRawNotification.getNotification());
                            processWorkflowInvoked(workflowInvokedDoc);
                            break;
                        }
                        case WORKFLOW_TERMINATED:
                        {
                            WorkflowTerminatedDocument workflowTerminatedDoc = WorkflowTerminatedDocument.Factory.parse(storedRawNotification.getNotification());
                            processWorkflowTerminated(workflowTerminatedDoc);
                            break;
                        }
                        case ADD_ANNOTATION:
                        {
                        	AddAnnotationDocument addAnnotationDoc = AddAnnotationDocument.Factory.parse(storedRawNotification.getNotification());
                        	processAddedAnnotation(addAnnotationDoc);
                        	break;
                        }
                        case ADD_ANNOTATION_BY_ID:
                        {
                        	AddAnnotationByIdDocument addAnnotationDoc = AddAnnotationByIdDocument.Factory.parse(storedRawNotification.getNotification());
                        	processAddedAnnotationById(addAnnotationDoc);
                        	break;
                        }
                        case ADD_MULTIPLE_OBJECT_ANNOTATION:
                        {
                        	AddMultipleObjectAnnotationDocument addAnnotationDoc = AddMultipleObjectAnnotationDocument.Factory.parse(storedRawNotification.getNotification());
                        	processAddMultipleObjectAnnotations(addAnnotationDoc);
                        	break;
                        }
                        case ADD_RELATIONSHIP_ANNOTATION_BY_ID:
                        {
                        	AddRelationshipAnnotationByIdDocument addRelationshipAnnotationDoc = AddRelationshipAnnotationByIdDocument.Factory.parse(storedRawNotification.getNotification());
                        	processAddRelationshipAnnotationById(addRelationshipAnnotationDoc);
                        	break;                        
                        }                        
                        case UNKNOWN_TYPES:
                        {
                            XmlObject xmlObject = XmlObject.Factory.parse(storedRawNotification.getNotification());
                            processUnknownNotification(xmlObject);
                            break;
                        }
                    }
                    sweepList.add(storedRawNotification);

                } catch (Exception e) {
                    Long internalIDObj = (Long)storedRawNotification.getInternalID();
                    log.error("Unable to process raw notification with internalID " + internalIDObj.longValue() , e);
                    errorList.add(storedRawNotification);

                }
            }
            implementer.markRawNotifications(sweepList, ProcessingStatus.PROCESSED);
            implementer.markRawNotifications(errorList, ProcessingStatus.ERROR);
        }
        return rawCount;
        
    }
    

    /**
     * Process DataReceivedFinished notification by disassembling the notification and store different information parts
     * @param dataReceivedFinishedDoc XmlBeans document of the DataReceivedFinished notification
     * @throws IngestException
     * 
     */
    protected void processDataReceivedFinished(DataReceivedFinishedDocument dataReceivedFinishedDoc) throws IngestException {

        DataTransferType dataTransferType = dataReceivedFinishedDoc.getDataReceivedFinished();

        dataTransferProcessHelper(NotificationSummary.generateSummary(dataReceivedFinishedDoc), dataTransferType);
        
    }

    /**
     * Process DataSendFinished notification by disassembling the notification and store different information parts
     * @param dataSendFinishedDoc XmlBeans document of the DataSendFinished notification
     * @throws IngestException
     */
    protected void processDataSendFinished(DataSendFinishedDocument dataSendFinishedDoc) throws IngestException {

        DataTransferType dataTransferType = dataSendFinishedDoc.getDataSendFinished();

        dataTransferProcessHelper(NotificationSummary.generateSummary(dataSendFinishedDoc), dataTransferType);
        
    }

    /**
     * Process DataSendStarted notification by disassembling the notification and store different information parts
     * @param dataSendStartedDoc XmlBeans document of the DataSendStarted notification
     * @throws IngestException
     */
    protected void processDataSendStarted(DataSendStartedDocument dataSendStartedDoc) throws IngestException {

        DataTransferType dataTransferType = dataSendStartedDoc.getDataSendStarted();

        dataTransferProcessHelper(NotificationSummary.generateSummary(dataSendStartedDoc), dataTransferType);
        
    }

    /**
     * Process DataReceivedStarted notification by disassembling the notification and store different information parts
     * @param dataReceivedStartedDoc XmlBeans document of the DataReceivedStarted notification
     * @throws IngestException
     */
    protected void processDataReceivedStarted(DataReceivedStartedDocument dataReceivedStartedDoc) throws IngestException {

        DataTransferType dataTransferType = dataReceivedStartedDoc.getDataReceivedStarted();

        dataTransferProcessHelper(NotificationSummary.generateSummary(dataReceivedStartedDoc), dataTransferType);
    }

    /**
     * Process ReceivedFault notification by disassembling the notification and store different information parts
     * @param receivedFaultDoc XmlBeans document of the ReceivedFault notification
     * @throws IngestException
     */
    protected void processReceivedFault(ReceivedFaultDocument receivedFaultDoc) throws IngestException {

        DataTransferType dataTransferType = receivedFaultDoc.getReceivedFault();

        dataTransferProcessHelper(NotificationSummary.generateSummary(receivedFaultDoc), dataTransferType);

    }
    

    /**
     * Process ReceivedResponse notification by disassembling the notification and store different information parts
     * @param receivedResponseDoc XmlBeans document of the ReceivedResponse notification
     * @throws IngestException
     */
    protected void processReceivedResponse(ReceivedResponseDocument receivedResponseDoc) throws IngestException {
        
        DataTransferType dataTransferType = receivedResponseDoc.getReceivedResponse();

        dataTransferProcessHelper(NotificationSummary.generateSummary(receivedResponseDoc), dataTransferType);
    }


    /**
     * Process SendingFault notification by disassembling the notification and store different information parts
     * @param sendingFaultDoc XmlBeans document of the SendingFault notification
     * @throws IngestException
     */
    protected void processSendingFault(SendingFaultDocument sendingFaultDoc) throws IngestException {

        DataTransferType dataTransferType = sendingFaultDoc.getSendingFault();

        dataTransferProcessHelper(NotificationSummary.generateSummary(sendingFaultDoc), dataTransferType);

    }
    
    
    /**
     * Process SendingResponse notification by disassembling the notification and store different information parts
     * @param sendingResponseDoc XmlBeans document of the SendingResponse notification
     * @throws IngestException
     */
    protected void processSendingResponse(SendingResponseDocument sendingResponseDoc) throws IngestException {
    
        DataTransferType dataTransferType = sendingResponseDoc.getSendingResponse();

        dataTransferProcessHelper(NotificationSummary.generateSummary(sendingResponseDoc), dataTransferType);

        
    }
    
    /**
     * Process SendingResponseStatus notification by disassembling the notification and store different information parts
     * @param sendingResponseStatusDoc XmlBeans document of the SendingResponseStatus notification
     * @throws IngestException
     */
    protected void processSendingResponseStatus(SendingResponseStatusDocument sendingResponseStatusDoc) throws IngestException {

        DataTransferStatusType sendingResponseStatus = sendingResponseStatusDoc.getSendingResponseStatus();


        EntityObject senderEntity = EntityFactory.convertFromXmlBeansEntityType(sendingResponseStatus.getSender());
        EntityObject receiverEntity = EntityFactory.convertFromXmlBeansEntityType(sendingResponseStatus.getReceiver());
        
        InvocationTypeEnum invocationType = determineInvocationType(receiverEntity, senderEntity);

        Calendar transferTime = sendingResponseStatus.getTransferTime();


        InvocationDataEnum responseType = null;
        DataObject responseTree = null;

        if (sendingResponseStatus.isSetFault()) {
            responseTree = DataObjectFactory.convertFromXmlBeansDataObjectType(sendingResponseStatus.getFault());
            responseType = InvocationDataEnum.FAULT;
        } else if (sendingResponseStatus.isSetResult()) {
            responseTree = DataObjectFactory.convertFromXmlBeansDataObjectType(sendingResponseStatus.getResult());
            responseType = InvocationDataEnum.RESULT;
        }

        List<Annotation> transferAnnotationList = AnnotationFactory.convert(sendingResponseStatus.getAnnotationsArray());

        Calendar statusTime = sendingResponseStatus.getStatusTime();

        EntityObject invokerEntity = receiverEntity;
        EntityObject invokeeEntity = senderEntity;                

        NotificationSummary summary = NotificationSummary.generateSummary(sendingResponseStatusDoc);
        
        implementer.storeInvocationResponseTransferStatus(summary, invokerEntity, invokeeEntity, invocationType, transferTime, responseType, responseTree, summary.getStatus(), statusTime, transferAnnotationList);

    }
    
    protected void processServiceInitialized(ServiceInitializedDocument serviceInitializedDoc) throws IngestException {
        
    }


    /**
     * 
     * @param serviceInvokedDoc
     * @throws IngestException
     */
    protected void processServiceInvoked(ServiceInvokedDocument serviceInvokedDoc) throws IngestException {
        InvocationType serviceInvoked = serviceInvokedDoc.getServiceInvoked();

        invokedProcessHelper(NotificationSummary.generateSummary(serviceInvokedDoc), serviceInvoked);
    }    
 
    protected void processServiceTerminated(ServiceTerminatedDocument serviceTerminatedDoc) throws IngestException {
        
    }

    protected void processWorkflowFailed(WorkflowFailedDocument workflowFailedDoc) throws IngestException {
        
    }

    protected void processWorkflowInitialized(WorkflowInitializedDocument workflowInitializedDoc) throws IngestException {
        EntityLifeCycleType workflowInitialized = workflowInitializedDoc.getWorkflowInitialized();
        EntityObject workflowEntity = EntityFactory.convertFromXmlBeansEntityType(workflowInitialized.getEntity());
        Calendar initialTime = workflowInitialized.getTimestamp();
        
        implementer.storeEntityLifeCycle(NotificationSummary.generateSummary(workflowInitializedDoc), workflowEntity, initialTime, EntityLifeCycleEnum.INITIALIZED);

    }

    /**
     * 
     * @param workflowInvokedDoc
     * @throws IngestException
     */
    protected void processWorkflowInvoked(WorkflowInvokedDocument workflowInvokedDoc) throws IngestException {
        InvocationType serviceInvoked = workflowInvokedDoc.getWorkflowInvoked();

        invokedProcessHelper(NotificationSummary.generateSummary(workflowInvokedDoc), serviceInvoked);
    }
    
    /**
     * 
     * @param notificationSummary
     * @param serviceInvoked
     * @throws IngestException
     */
    protected void invokedProcessHelper(NotificationSummary notificationSummary, InvocationType serviceInvoked)throws IngestException{

        EntityObject invokerEntity = EntityFactory.convertFromXmlBeansEntityType(serviceInvoked.getInvoker());
        EntityObject invokeeEntity = EntityFactory.convertFromXmlBeansEntityType(serviceInvoked.getInvokee());

        Calendar invocationTime = serviceInvoked.getInvocationTime();
        
        
         
        InvocationTypeEnum invocationTypeEnum = determineInvocationType(invokerEntity, invokeeEntity);
        
//      Edit by You-Wei Cheah (10/10/2011) Removed params from invocationType
//        DataObject params = DataObjectFactory.convertFromXmlBeansDataObjectType(serviceInvoked.getParams());
        
        List<Annotation> invokedAnnotationList = AnnotationFactory.convert(serviceInvoked.getAnnotationsArray());
        
        log.info("Store invocation");
        implementer.storeInvocationStatus(notificationSummary, invokerEntity, invokeeEntity, invocationTypeEnum, invocationTime, StatusEnum.SUCCESS, invocationTime, invokedAnnotationList);

    }
    

    /**
     * 
     * @param workflowTerminatedDoc
     * @throws IngestException
     */
    protected void processWorkflowTerminated(WorkflowTerminatedDocument workflowTerminatedDoc) throws IngestException {
        EntityLifeCycleType workflowTerminated = workflowTerminatedDoc.getWorkflowTerminated();

        EntityObject workflowEntity = EntityFactory.convertFromXmlBeansEntityType(workflowTerminated.getEntity());
        Calendar termTime = workflowTerminated.getTimestamp();
        
        implementer.storeEntityLifeCycle(NotificationSummary.generateSummary(workflowTerminatedDoc), workflowEntity, termTime, EntityLifeCycleEnum.TERMINATED);


    }

    /**
     * 
     * @param invokingServiceDoc
     * @throws IngestException
     */
    protected void processInvokingService(InvokingServiceDocument invokingServiceDoc) throws IngestException {
        InvocationType invocationType = invokingServiceDoc.getInvokingService();

        invokingProcessHelper(NotificationSummary.generateSummary(invokingServiceDoc), invocationType);

    }

    /**
     * 
     * @param invokingServiceStatusDoc
     * @throws IngestException
     */
    protected void processInvokingServiceStatus(InvokingServiceStatusDocument invokingServiceStatusDoc) throws IngestException {
        InvocationStatusType invokingServiceStatus = invokingServiceStatusDoc.getInvokingServiceStatus();

        invocationStatusProcessHelper(NotificationSummary.generateSummary(invokingServiceStatusDoc), invokingServiceStatus);

    }
    

    /**
     * 
     * @param invokingWorkflowDoc
     * @throws IngestException
     */
    protected void processInvokingWorkflow(InvokingWorkflowDocument invokingWorkflowDoc) throws IngestException {
         InvocationType invocationType = invokingWorkflowDoc.getInvokingWorkflow();

         invokingProcessHelper(NotificationSummary.generateSummary(invokingWorkflowDoc), invocationType);
    }

    /**
     * 
     * @param notificationSummary
     * @param invocationType
     * @throws IngestException
     */
    protected void invokingProcessHelper(NotificationSummary notificationSummary, InvocationType invocationType) throws IngestException{

        EntityObject invokerEntity = EntityFactory.convertFromXmlBeansEntityType(invocationType.getInvoker());
        EntityObject invokeeEntity = EntityFactory.convertFromXmlBeansEntityType(invocationType.getInvokee());

        Calendar invocationTime = invocationType.getInvocationTime();
              
        InvocationTypeEnum invocationTypeEnum = determineInvocationType(invokerEntity, invokeeEntity);
        
//      Edit by You-Wei Cheah (10/10/2011) Removed params from invocationType
//        DataObject params = DataObjectFactory.convertFromXmlBeansDataObjectType(invocationType.getParams());
        
        List<Annotation> invocationAnnotationList = AnnotationFactory.convert(invocationType.getAnnotationsArray());

        log.info("Store invocation");
        implementer.storeInvocation(notificationSummary, invokerEntity, invokeeEntity, invocationTypeEnum, invocationTime, invocationAnnotationList);

    }

    /**
     * 
     * @param invokingWorkflowStatusDoc
     * @throws IngestException
     */
    protected void processInvokingWorkflowStatus(InvokingWorkflowStatusDocument invokingWorkflowStatusDoc) throws IngestException {
        InvocationStatusType invokingServiceStatus = invokingWorkflowStatusDoc.getInvokingWorkflowStatus();

        invocationStatusProcessHelper(NotificationSummary.generateSummary(invokingWorkflowStatusDoc), invokingServiceStatus);
        
    }
    
    /**
     * 
     * @param notificationSummary
     * @param invokingServiceStatus
     * @throws IngestException
     */
    protected void invocationStatusProcessHelper(NotificationSummary notificationSummary, InvocationStatusType invokingServiceStatus) throws IngestException{

        EntityObject invokerEntity = EntityFactory.convertFromXmlBeansEntityType(invokingServiceStatus.getInvoker());
        EntityObject invokeeEntity = EntityFactory.convertFromXmlBeansEntityType(invokingServiceStatus.getInvokee());

        InvocationTypeEnum invocationTypeEnum = determineInvocationType(invokerEntity, invokeeEntity);
        
        Calendar statusTime = invokingServiceStatus.getStatusTime();
        Calendar  invocationTime = invokingServiceStatus.getInvocationTime();
  
//        Edit by You-Wei Cheah (10/10/2011) Removed params from invocationType
//        DataObject params = DataObjectFactory.convertFromXmlBeansDataObjectType(invokingServiceStatus.getParams());
        
        List<Annotation> invocationStatusAnnotationList = AnnotationFactory.convert(invokingServiceStatus.getAnnotationsArray());

        log.info("Update invocation status");

        implementer.storeInvocationStatus(notificationSummary, invokerEntity, invokeeEntity, invocationTypeEnum, invocationTime, notificationSummary.getStatus(), statusTime, invocationStatusAnnotationList);

    }    

    
    protected void processUnknownNotification(XmlObject xmlObject) throws IngestException {
        
    }

    /**
     * 
     * @see edu.indiana.dsi.karma.ingest.NotificationIngester#resetUnfinishedNotifications()
     */
    public void resetUnfinishedNotifications() throws IngestException {
        implementer.resetUnfinishedRawNotifications();
    }

    /**
     * 
     * @param invoker
     * @param invokee
     * @return
     * @throws IngestException
     */
    private InvocationTypeEnum determineInvocationType (EntityObject invoker, EntityObject invokee) throws IngestException {
        EntityCategoryEnum invokerCategory = invoker.getEntityCategory();
        EntityCategoryEnum invokeeCategory = invokee.getEntityCategory();

        switch (invokerCategory) {
        case USER:
            switch(invokeeCategory) {
            case METHOD:
            case SERVICE:
            case WORKFLOW:
                return InvocationTypeEnum.CONTROL;
            case USER:
                throw new IngestException("Invalid invocation entity pair. Invoker: " + invokerCategory.name() + " Invokee: " + invokeeCategory.name());
            }
            break;
        case METHOD:
        case SERVICE:
        case WORKFLOW:
            switch(invokeeCategory) {
            case METHOD:
            case SERVICE:
            case WORKFLOW:
                return InvocationTypeEnum.INVOKE;
            case USER:
                throw new IngestException("Invalid invocation entity pair. Invoker: " + invokerCategory.name() + " Invokee: " + invokeeCategory.name());
            }
            
        }
        
        return InvocationTypeEnum.INVOKE;
    }
    

    /**
     * A helper method to assist the process of DataLifeCycle notifications
     * @param notificationSummary summary of source notification
     * @param dataLifeCycle DataLifeCycleType object
     * @throws IngestException
     */
    protected void dataLifeCycleProcessHelper(NotificationSummary notificationSummary, DataLifeCycleType dataLifeCycle) throws IngestException {
        DataLifeCycleEnum action = DataLifeCycleEnum.convertFromXmlBeansActionEnumType(dataLifeCycle.getAction());
        EntityObject actor = EntityFactory.convertFromXmlBeansEntityType(dataLifeCycle.getActor());
        String role = null;
        if (dataLifeCycle.isSetDataRole()) {
            role = dataLifeCycle.getDataRole();
        }
        
        Calendar time = dataLifeCycle.getTimestamp();
        DataObject dataObject = DataObjectFactory.convertFromXmlBeansDataObjectType(dataLifeCycle.getDataObject());
        List<Annotation> annotationList = AnnotationFactory.convert(dataLifeCycle.getAnnotationsArray());

        implementer.storeDataLifeCycle(notificationSummary, actor, dataObject, time, action, role, annotationList);
    }

    /**
     * Process data deleted notification
     * @param dataDeletedDoc XmlBeans document of the notification
     * @throws IngestException
     */
    protected void processDataDeleted(DataDeletedDocument dataDeletedDoc) throws IngestException {
        DataLifeCycleType dataDeleted = dataDeletedDoc.getDataDeleted();
        dataLifeCycleProcessHelper(NotificationSummary.generateSummary(dataDeletedDoc), dataDeleted);
    }
    
    /**
     * Process data updated notification
     * @param dataUpdatedDoc XmlBeans document of the notification
     * @throws IngestException
     */
    protected void processDataUpdated(DataUpdatedDocument dataUpdatedDoc) throws IngestException {
        DataLifeCycleType dataUpdated = dataUpdatedDoc.getDataUpdated();
        dataLifeCycleProcessHelper(NotificationSummary.generateSummary(dataUpdatedDoc), dataUpdated);
    }
    
    /**
     * Process data consumed notification
     * @param dataConsumedDoc XmlBeans document of the notification
     * @throws IngestException
     * 
     */
    protected void processDataConsumed(DataConsumedDocument dataConsumedDoc) throws IngestException {
        DataLifeCycleType dataConsumed = dataConsumedDoc.getDataConsumed();
        dataLifeCycleProcessHelper(NotificationSummary.generateSummary(dataConsumedDoc), dataConsumed);
        
    }
    
    /**
     * Process data produced notification
     * @param dataProducedDoc XmlBeans document of the notification
     * @throws IngestException
     */
    protected void processDataProduced(DataProducedDocument dataProducedDoc) throws IngestException {
        DataLifeCycleType dataProduced = dataProducedDoc.getDataProduced();
        dataLifeCycleProcessHelper(NotificationSummary.generateSummary(dataProducedDoc), dataProduced);

    }
    
    /**
     * Process adding new annotations to existing entities
     * @param addAnnotationDoc
     * @throws IngestException
     * @author Devarshi Ghoshal
     */
    
    protected void processAddedAnnotation(AddAnnotationDocument addAnnotationDoc) throws IngestException {
    	AddAnnotationType addAnnotationType = addAnnotationDoc.getAddAnnotation();
    	AnnotableObject annotableObject = null;
    	annotableObject = AnnotableObjectFactory.convertFromXmlBeansAnnotableType(addAnnotationType);
        
        Calendar notificationTime = addAnnotationType.getNotificationtimestamp();
        Calendar annotatingTime = addAnnotationType.getAnnotatingTimestamp();
        List<Annotation> annotationList = AnnotationFactory.convert(addAnnotationType.getAnnotationsArray());

        implementer.storeAddedAnnotation(NotificationSummary.generateSummary(addAnnotationDoc), annotableObject, notificationTime, annotatingTime, annotationList);
    }
    
    protected void processAddedAnnotationById(AddAnnotationByIdDocument addAnnotationByIdDoc) throws IngestException {
    	AddAnnotationByIdType addAnnotationType = addAnnotationByIdDoc.getAddAnnotationById();
    	long objectID = addAnnotationType.getObjectID();
        
        Calendar notificationTime = addAnnotationType.getNotificationtimestamp();
        Calendar annotatingTime = addAnnotationType.getAnnotatingTimestamp();
        List<Annotation> annotationList = AnnotationFactory.convert(addAnnotationType.getAnnotationsArray());
        AnnotableObjectEnumType.Enum objectCategory = addAnnotationType.getAnnotableObjectType();

        implementer.storeAddedAnnotationById(NotificationSummary.generateSummary(addAnnotationByIdDoc), objectID, objectCategory, notificationTime, annotatingTime, annotationList);
    }
    
    protected void processAddMultipleObjectAnnotations(AddMultipleObjectAnnotationDocument addMultipleObjectAnnotationDoc) throws IngestException {
    	AddMultipleObjectAnnotationType addAnnotationType = addMultipleObjectAnnotationDoc.getAddMultipleObjectAnnotation();
    	
    	AnnotableObject[] annotableObject = null;
    	annotableObject = AnnotableObjectFactory.convertFromXmlBeansAnnotableType(addAnnotationType);
        
        Calendar notificationTime = addAnnotationType.getNotificationtimestamp();
        Calendar annotatingTime = addAnnotationType.getAnnotatingTimestamp();
        List<Annotation> annotationList = AnnotationFactory.convert(addAnnotationType.getAnnotationsArray());

        implementer.storeAddedMultipleObjectAnnotation(NotificationSummary.generateSummary(addAnnotationType), annotableObject, notificationTime, annotatingTime, annotationList);
    }
    
    protected void processAddRelationshipAnnotationById(AddRelationshipAnnotationByIdDocument addRelationshipAnnotationByIdDoc) throws IngestException {
    	AddRelationshipAnnotationByIdType addAnnotationType = addRelationshipAnnotationByIdDoc.getAddRelationshipAnnotationById();    	
    	long relationshipID = addAnnotationType.getRelationshipID();
        
        Calendar notificationTime = addAnnotationType.getNotificationtimestamp();
        Calendar annotatingTime = addAnnotationType.getAnnotatingTimestamp();
        List<Annotation> annotationList = AnnotationFactory.convert(addAnnotationType.getAnnotationsArray());
        AnnotableRelationshipEnumType.Enum relationshipCategory = addAnnotationType.getAnnotableRelationshipType();

        implementer.storeAddedRelationshipAnnotationById(NotificationSummary.generateSummary(addRelationshipAnnotationByIdDoc), relationshipID, relationshipCategory, notificationTime, annotatingTime, annotationList);    
    }
    
	@Override
	public void addAnnotation(AddAnnotationDocument addAnnotationDoc)
			throws IngestException {
		// TODO Auto-generated method stub
        log.info("in addAnnotation");        
        if (log.isDebugEnabled()) log.debug("addAnnotationDoc:\n" + addAnnotationDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (addAnnotationDoc.validate()) {        	
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.ADD_ANNOTATION, storeTime, addAnnotationDoc);
            
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_ANNOTATION.name());            
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_ANNOTATION.name());
        }
		
	}
	@Override
	public void addAnnotationById(AddAnnotationByIdDocument addAnnotationByIdDoc)
			throws IngestException {
		// TODO Auto-generated method stub
		log.info("in addAnnotationById");        
        if (log.isDebugEnabled()) log.debug("addAnnotationByIdDoc:\n" + addAnnotationByIdDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (addAnnotationByIdDoc.validate()) {        	
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.ADD_ANNOTATION_BY_ID, storeTime, addAnnotationByIdDoc);
            
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_ANNOTATION_BY_ID.name());            
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_ANNOTATION_BY_ID.name());
        }
	}
	@Override
	public void addMultipleObjectAnnotation(
			AddMultipleObjectAnnotationDocument addMultipleObjectAnnotationDoc)
			throws IngestException {
		// TODO Auto-generated method stub
		log.info("in addMultipleObjectAnnotation");        
        if (log.isDebugEnabled()) log.debug("addMultipleObjectAnnotationDoc:\n" + addMultipleObjectAnnotationDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (addMultipleObjectAnnotationDoc.validate()) {        	
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.ADD_MULTIPLE_OBJECT_ANNOTATION, storeTime, addMultipleObjectAnnotationDoc);            
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_MULTIPLE_OBJECT_ANNOTATION.name());            
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_MULTIPLE_OBJECT_ANNOTATION.name());
        }
	}
	@Override
	public void addRelationshipAnnotationById(
			AddRelationshipAnnotationByIdDocument addRelationshipAnnotationByIdDoc)
			throws IngestException {
		// TODO Auto-generated method stub
		log.info("in addRelationshipAnnotationById");        
        if (log.isDebugEnabled()) log.debug("addRelationshipAnnotationByIdDoc:\n" + addRelationshipAnnotationByIdDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
        if (addRelationshipAnnotationByIdDoc.validate()) {        	
            Calendar storeTime = Calendar.getInstance();
            implementer.storeRawNotification(NotificationTypeEnum.ADD_RELATIONSHIP_ANNOTATION_BY_ID, storeTime, addRelationshipAnnotationByIdDoc);            
        } else {
            log.warn(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_RELATIONSHIP_ANNOTATION_BY_ID.name());            
            throw new IngestException(IngesterConstants.EXPMSG_INVALID_NOTIFICATION + NotificationTypeEnum.ADD_RELATIONSHIP_ANNOTATION_BY_ID.name());
        }
		
	}
    
}

