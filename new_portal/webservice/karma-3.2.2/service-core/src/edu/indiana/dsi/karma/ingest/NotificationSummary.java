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
# File:  NotificationSummary.java
# Description:  Summary of notification messages
#
# -----------------------------------------------------------------
# 
*/



/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 */
package edu.indiana.dsi.karma.ingest;

import java.util.Calendar;

import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.BlockType;
import org.dataandsearch.www.karma._2010._08.DataConsumedDocument;
import org.dataandsearch.www.karma._2010._08.DataDeletedDocument;
import org.dataandsearch.www.karma._2010._08.DataObjectType;
import org.dataandsearch.www.karma._2010._08.DataProducedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataTransferStatusType;
import org.dataandsearch.www.karma._2010._08.DataTransferType;
import org.dataandsearch.www.karma._2010._08.DataUpdatedDocument;
import org.dataandsearch.www.karma._2010._08.EntityEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
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
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInitializedDocument;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;
import org.dataandsearch.www.karma._2010._08.ServiceTerminatedDocument;
import org.dataandsearch.www.karma._2010._08.StatusEnumType;
import org.dataandsearch.www.karma._2010._08.WorkflowFailedDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowInitializedDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowTerminatedDocument;

/**
 * @author Yiming Sun
 * @author You-Wei Cheah
 *
 */

public class NotificationSummary {
    
    public static final NotificationSummary UNKNOWN_NOTIFICATIN_SUMMARY = new NotificationSummary(NotificationTypeEnum.UNKNOWN_TYPES);
    
    public static enum NotificationTypeEnum {
        DATA_SEND_FINISHED,
        RECEIVED_RESPONSE,
        SENDING_RESPONSE_STATUS,
        SERVICE_INITIALIZED,
        INVOKING_WORKFLOW,
        SENDING_RESPONSE,
        SERVICE_TERMINATED,
        WORKFLOW_TERMINATED,
        DATA_CONSUMED,
        INVOKING_WORKFLOW_STATUS,
        INVOKING_SERVICE_STATUS,
        WORKFLOW_INVOKED,
        DATA_SEND_STARTED,
        SERVICE_INVOKED,
        RECEIVED_FAULT,
        INVOKING_SERVICE,
        DATA_RECEIVED_STARTED,
        DATA_RECEIVED_FINISHED,
        DATA_PRODUCED,
        WORKFLOW_INITIALIZED,
        SENDING_FAULT,
        WORKFLOW_FAILED,
        UNKNOWN_TYPES,
        DATA_DELETED,
        DATA_UPDATED,
        ADD_ANNOTATION,
        ADD_ANNOTATION_BY_ID,
        ADD_MULTIPLE_OBJECT_ANNOTATION,
        ADD_RELATIONSHIP_ANNOTATION_BY_ID;
        
        public static NotificationTypeEnum determineNotificationTypeFromXmlBeansDocument(XmlObject document) {
            if (document instanceof DataSendFinishedDocument) {
                return DATA_SEND_FINISHED;
            } else if (document instanceof ReceivedResponseDocument) {
                return RECEIVED_RESPONSE;
            } else if (document instanceof SendingResponseStatusDocument) {
                return SENDING_RESPONSE_STATUS;
            } else if (document instanceof ServiceInitializedDocument) {
                return SERVICE_INITIALIZED;
            } else if (document instanceof InvokingWorkflowDocument) {
                return INVOKING_WORKFLOW;
            } else if (document instanceof SendingResponseDocument) {
                return SENDING_RESPONSE;
            } else if (document instanceof ServiceTerminatedDocument) {
                return SERVICE_TERMINATED;
            } else if (document instanceof WorkflowTerminatedDocument) {
                return WORKFLOW_TERMINATED;
            } else if (document instanceof DataConsumedDocument) {
                return DATA_CONSUMED;
            } else if (document instanceof InvokingServiceStatusDocument) {
                return INVOKING_SERVICE_STATUS;
            } else if (document instanceof InvokingWorkflowStatusDocument) {
                return INVOKING_WORKFLOW_STATUS;
            } else if (document instanceof WorkflowInvokedDocument) {
                return WORKFLOW_INVOKED;
            } else if (document instanceof DataSendStartedDocument) {
                return DATA_SEND_STARTED;
            } else if (document instanceof ServiceInvokedDocument) {
                return SERVICE_INVOKED;
            } else if (document instanceof ReceivedFaultDocument) {
                return RECEIVED_FAULT;
            } else if (document instanceof InvokingServiceDocument) {
                return INVOKING_SERVICE;
            } else if (document instanceof DataReceivedStartedDocument) {
                return DATA_RECEIVED_STARTED;
            } else if (document instanceof DataReceivedFinishedDocument) {
                return DATA_RECEIVED_FINISHED;
            } else if (document instanceof DataProducedDocument) {
                return DATA_PRODUCED;
            } else if (document instanceof WorkflowInitializedDocument) {
                return WORKFLOW_INITIALIZED;
            } else if (document instanceof SendingFaultDocument) {
                return SENDING_FAULT;
            } else if (document instanceof WorkflowFailedDocument) {
                return WORKFLOW_FAILED;
            } else if (document instanceof DataDeletedDocument) {
                return DATA_DELETED;
            } else if (document instanceof DataUpdatedDocument) {
                return DATA_UPDATED;
            } else if (document instanceof AddAnnotationDocument) {
                return ADD_ANNOTATION;
            } else if (document instanceof AddAnnotationByIdDocument) {
                return ADD_ANNOTATION_BY_ID;
            } else if (document instanceof AddMultipleObjectAnnotationDocument) {
                return ADD_MULTIPLE_OBJECT_ANNOTATION;
            } else if (document instanceof AddRelationshipAnnotationByIdDocument) {
                return ADD_RELATIONSHIP_ANNOTATION_BY_ID;
            }
            return UNKNOWN_TYPES;
        }
    }

    public static enum StatusEnum {
        SUCCESS,
        FAILED;
        
        public static StatusEnum determineStatusFromXmlBeansDocument(XmlObject document) {
            if (document instanceof SendingResponseStatusDocument) {
                return convertFromXmlBeansStatusEnumType(((SendingResponseStatusDocument)document).getSendingResponseStatus().getStatus());
            } else if (document instanceof InvokingServiceStatusDocument) {
                return convertFromXmlBeansStatusEnumType(((InvokingServiceStatusDocument)document).getInvokingServiceStatus().getStatus());
            } else if (document instanceof InvokingWorkflowStatusDocument) {
                return convertFromXmlBeansStatusEnumType(((InvokingWorkflowStatusDocument)document).getInvokingWorkflowStatus().getStatus());
            }
            return null;
        }
        
        public static StatusEnum convertFromXmlBeansStatusEnumType(StatusEnumType.Enum xmlStatus) {
            switch (xmlStatus.intValue()) {
            case StatusEnumType.INT_FAILED:
                return StatusEnum.FAILED;
            case StatusEnumType.INT_SUCCESS:
                return StatusEnum.SUCCESS;
                
            }
            return null;
        }
    }

    public static enum InvocationDataEnum {
        PARAMS,
        RESULT,
        FAULT;
        
        public static InvocationDataEnum determineInvocationDataTypeFromXmlBeansDocument(XmlObject document) {
            if (document instanceof DataSendFinishedDocument) {
                return determineInvocationDataTypeFromXmlBeans(((DataSendFinishedDocument)document).getDataSendFinished());
            } else if (document instanceof DataSendStartedDocument) {
                return determineInvocationDataTypeFromXmlBeans(((DataSendStartedDocument)document).getDataSendStarted());
            } else if (document instanceof DataReceivedStartedDocument) {
                return determineInvocationDataTypeFromXmlBeans(((DataReceivedStartedDocument)document).getDataReceivedStarted());
            } else if (document instanceof DataReceivedFinishedDocument) {
                return determineInvocationDataTypeFromXmlBeans(((DataReceivedFinishedDocument)document).getDataReceivedFinished());
            } else if (document instanceof SendingResponseStatusDocument) {
                return determineInvocationDataTypeFromXmlBeans(((SendingResponseStatusDocument)document).getSendingResponseStatus());
            }
            
            return null;
        }
        
        public static InvocationDataEnum determineInvocationDataTypeFromXmlBeans(DataTransferType dataTransfer) {
            if (dataTransfer.isSetFault()) {
                return InvocationDataEnum.FAULT; 
            } else if (dataTransfer.isSetResult()) {
                return InvocationDataEnum.RESULT;
            }
            return null;
        }
    }

    private final NotificationTypeEnum type;
    private final StatusEnum status;
    private final InvocationDataEnum dataType;
    
    NotificationSummary(NotificationTypeEnum type) {
        this(type, null, null);
    }
    
    NotificationSummary(NotificationTypeEnum type, StatusEnum status) {
        this(type, status, null);
    }
    
    NotificationSummary(NotificationTypeEnum type, InvocationDataEnum dataType) {
        this(type, null, dataType);
    }
    
    NotificationSummary(NotificationTypeEnum type, StatusEnum status, InvocationDataEnum dataType) {
        this.type = type;
        this.status = status;
        this.dataType = dataType;
    }
    
    public NotificationTypeEnum getNotificationType() {
        return type;
    }
    
    public StatusEnum getStatus() {
        return status;
    }
    
    public InvocationDataEnum getDataType() {
        return dataType;
    }
    
    public static NotificationSummary generateSummary(XmlObject xmlDocument) {
        NotificationTypeEnum notificationType = NotificationTypeEnum.determineNotificationTypeFromXmlBeansDocument(xmlDocument);
        StatusEnum status = StatusEnum.determineStatusFromXmlBeansDocument(xmlDocument);
        InvocationDataEnum invocationData = InvocationDataEnum.determineInvocationDataTypeFromXmlBeansDocument(xmlDocument);
        NotificationSummary summary = new NotificationSummary(notificationType, status, invocationData);
        return summary;
    }
    
    public static void main(String args[]) {
        
        try {
            {
                ServiceInvokedDocument siDoc = ServiceInvokedDocument.Factory.newInstance();
                InvocationType serviceInvoked = siDoc.addNewServiceInvoked();
                EntityType invoker = serviceInvoked.addNewInvoker();
                EntityType invokee = serviceInvoked.addNewInvokee();
                serviceInvoked.setInvocationTime(Calendar.getInstance());

                ServiceInformationType invokerService = invoker.addNewServiceInformation();
                invokerService.setServiceID("http://service10.org");
                invokerService.setWorkflowID("http://workflow10.org");
                invokerService.setWorkflowNodeID("http://service10.org/Free_Service");
                invokerService.setTimestep(2);
                invoker.setType(EntityEnumType.SERVICE);
                
                ServiceInformationType invokeeService = invokee.addNewServiceInformation();
                invokeeService.setServiceID("http://workflow20.org/service20");
                invokeeService.setWorkflowID("http://workflow20.org");
                invokeeService.setWorkflowNodeID("http://workflow20.org/Winning_Streak");
                invokeeService.setTimestep(3);
                invokee.setType(EntityEnumType.SERVICE);
                
                
                siDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS);
                System.out.println(siDoc.xmlText(IngesterConstants.PRETTY_PRINT_OPTS));
                
            }
            
            
        SendingResponseDocument doc = SendingResponseDocument.Factory.newInstance();
        DataTransferType dataTransferType = doc.addNewSendingResponse();
        EntityType sender = dataTransferType.addNewSender();
        sender.setType(EntityEnumType.SERVICE);
        ServiceInformationType invokerService = sender.addNewServiceInformation();
        invokerService.setServiceID("http://service1.org");
        invokerService.setWorkflowID("http://workflow1.org");
        invokerService.setWorkflowNodeID("http://Basic_Workflow_Service");
        invokerService.setTimestep(1);
        
        EntityType receiver = dataTransferType.addNewReceiver();
        receiver.setType(EntityEnumType.SERVICE);
        ServiceInformationType invokeeService = receiver.addNewServiceInformation();
        invokeeService.setServiceID("http://service2.org");
        invokeeService.setWorkflowID("http://workflow2.org");
        invokeeService.setWorkflowNodeID("http://Premium_Workflow_Service");
        invokeeService.setTimestep(1);
        
        DataObjectType newResult = dataTransferType.addNewResult();
        BlockType block = newResult.addNewBlock();
        block.setBlockContent(XmlObject.Factory.parse("<block>aaaaa</block>"));
        
        dataTransferType.setTransferTime(Calendar.getInstance());
        
        System.out.println(doc.validate());
        NotificationSummary summary = NotificationSummary.generateSummary(doc);
        System.out.println(summary.getNotificationType());
        System.out.println(summary.getDataType());
        System.out.println(summary.getStatus());
        
        
        
        SendingResponseStatusDocument doc2 = SendingResponseStatusDocument.Factory.newInstance();
        DataTransferStatusType dataTransferStatusType = doc2.addNewSendingResponseStatus();
        EntityType sender2 = dataTransferStatusType.addNewSender();
        sender2.setType(EntityEnumType.SERVICE);
        ServiceInformationType invokee2 = sender2.addNewServiceInformation();
        invokee2.setServiceID("http://service3.org");
        invokee2.setWorkflowID("http://workflow3.org");
        invokee2.setWorkflowNodeID("http://Dirt_Cheap_Service");
        invokee2.setTimestep(1);
        
        EntityType receiver2 = dataTransferStatusType.addNewReceiver();
        receiver2.setType(EntityEnumType.SERVICE);
        ServiceInformationType invoker2 = receiver2.addNewServiceInformation();
        invoker2.setServiceID("http://service4.org");
        invoker2.setWorkflowID("http://workflow2.org");
        invoker2.setWorkflowNodeID("http://Free_Workflow");
        invoker2.setTimestep(2);
        
        DataObjectType fault = dataTransferStatusType.addNewFault();
        BlockType block2 = fault.addNewBlock();
        block2.setBlockContent(XmlObject.Factory.parse("<fault>bbbbb</fault>"));
        
        dataTransferStatusType.setTransferTime(Calendar.getInstance());
        dataTransferStatusType.setStatusTime(Calendar.getInstance());
        
        dataTransferStatusType.setStatus(StatusEnumType.SUCCESS);
        
        System.out.println(doc2.validate());
        NotificationSummary summary2 = NotificationSummary.generateSummary(doc2);
        System.out.println(summary2.getNotificationType().name());
        System.out.println(summary2.getDataType().name());
        System.out.println(summary2.getStatus().name());
        
        
        
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
    }
}

