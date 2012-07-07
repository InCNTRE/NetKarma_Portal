package edu.indiana.dsi.karma.client.test;

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
# Project: Karma-Client-core
# File:  NotificationTester.java
# Description:  A test client using RabbitMQ message-bus for testing 
#				Karma-Service
#
# -----------------------------------------------------------------
# 
*/

import java.util.Calendar;
import java.util.Random;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.ActionEnumType;
import org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationByIdType;
import org.dataandsearch.www.karma._2010._08.AddAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationType;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationType;
import org.dataandsearch.www.karma._2010._08.AnnotableEntityType;
import org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType;
import org.dataandsearch.www.karma._2010._08.AnnotationType;
import org.dataandsearch.www.karma._2010._08.BlockType;
import org.dataandsearch.www.karma._2010._08.DataConsumedDocument;
import org.dataandsearch.www.karma._2010._08.DataDeletedDocument;
import org.dataandsearch.www.karma._2010._08.DataLifeCycleType;
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
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;
import org.dataandsearch.www.karma._2010._08.StatusEnumType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument;
import edu.indiana.dsi.karma.client.messaging.Notification;
import edu.indiana.dsi.karma.messaging.MessageConfig;

public class NotificationTester implements Runnable{

	private static String constServiceID = "urn:qname:http://www.d2i.indiana.edu/karma:TestService_";
	private static String constWorkflowID = "tag:www.d2i.indiana.edu/TestWorkflow/instance";
	private static String constWorkflowNodeID = "WFNode:KarmaProcessor";

	//private static String constFileURI = "http://www.d2i.indiana.edu/testKarmaFile";
	//private static String constDN = "KarmaTester";

	private static String constProperty = "execution_environment";
	private static String constValue = "POSIX";

	private static int ramanujanNum = 1729;	
	
	private Notification ingester = null;
	
	public NotificationTester(String messageConfigPath) {
		MessageConfig msgconf=new MessageConfig(messageConfigPath);
		ingester=new Notification(msgconf);
	    
	}
	private static enum EntityTypeEnum {
		WORKFLOW, SERVICE;
	}

	private static enum DataTransferTypeEnum {
		RESULT, FAULT;
	}

	private void addEntityInformation(EntityType entity,
			EntityTypeEnum entityType) {
		
		Random randomNumGen = new Random();
		int id = randomNumGen.nextInt(ramanujanNum);

		String workflowID = constWorkflowID + id;
		String workflowNodeID = constWorkflowNodeID + id;
		int timestep = id;
		
		if (entityType.equals(EntityTypeEnum.SERVICE)) {
			ServiceInformationType entityServiceInfoType = entity
			.addNewServiceInformation();
			entityServiceInfoType.setWorkflowID(workflowID);
			entityServiceInfoType.setWorkflowNodeID(workflowNodeID);
			entityServiceInfoType.setTimestep(timestep);		
			
			String serviceID = constServiceID + id;
			entityServiceInfoType.setServiceID(serviceID);
			entity.setType(EntityEnumType.SERVICE);
		}
		else{
			WorkflowInformationType entityWorkflowInfoType = entity
			.addNewWorkflowInformation();
			entityWorkflowInfoType.setWorkflowID(workflowID);
			entityWorkflowInfoType.setWorkflowNodeID(workflowNodeID);
			entityWorkflowInfoType.setTimestep(timestep);	
			
			entity.setType(EntityEnumType.WORKFLOW);			
		}

	}

	private void addDataObject(DataObjectType params) {
		BlockType block3 = params.addNewBlock();
        try {
			block3.setBlockContent(XmlObject.Factory.parse("<block>name=value</block>"));
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addAnnotations(AnnotationType[] annotations, String property,
			String value) {
		String xmlChunk = "<value>" + value + "</value>";

        for (int i = 0; i < annotations.length; i++) {
        	annotations[i] = AnnotationType.Factory.newInstance();
            annotations[i].setProperty(property);
            try {
                annotations[i].setValue(XmlObject.Factory.parse(xmlChunk));                
            } catch (Exception e) { e.printStackTrace(); }
		}                
        
	}

	InvokingServiceDocument makeInvokingService() {
        InvokingServiceDocument invokingServiceDoc = InvokingServiceDocument.Factory
                .newInstance();
        InvocationType invocationType = invokingServiceDoc
                .addNewInvokingService();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        invocationHelper(invocationType, entityType);
        return invokingServiceDoc;
	}
	
	/**
	 * Service Invocation Testers
	 */
	public void testInvokingService() {
	    InvokingServiceDocument invokingServiceDoc = makeInvokingService();
	    
		try {
			ingester.sendNotification(invokingServiceDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    InvokingServiceStatusDocument makeInvokingServiceStatus() {
        InvokingServiceStatusDocument invokingServiceStatusDoc = InvokingServiceStatusDocument.Factory
                .newInstance();
        InvocationStatusType invocationStatusType = invokingServiceStatusDoc
                .addNewInvokingServiceStatus();

        invocationStatusType.setStatus(StatusEnumType.SUCCESS);
        invocationStatusType.setStatusTime(Calendar.getInstance());

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
        invocationHelper(invocationStatusType, entityType);
        return invokingServiceStatusDoc;
    }
	
	public void testInvokingServiceStatus() {
	    InvokingServiceStatusDocument invokingServiceStatusDoc = makeInvokingServiceStatus();
		try {
			ingester.sendNotification(invokingServiceStatusDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    ServiceInvokedDocument makeServiceInvoked() {
        ServiceInvokedDocument serviceInvokedDoc = ServiceInvokedDocument.Factory
                .newInstance();
        InvocationType invocationType = serviceInvokedDoc
                .addNewServiceInvoked();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
        invocationHelper(invocationType, entityType);

        return serviceInvokedDoc;
    }
	
	public void testServiceInvoked() {

	    ServiceInvokedDocument serviceInvokedDoc = makeServiceInvoked();
	    try {
			ingester.sendNotification(serviceInvokedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}


	InvokingWorkflowDocument makeInvokingWorkflow() {
        InvokingWorkflowDocument invokingWorkflowDoc = InvokingWorkflowDocument.Factory
                .newInstance();
        InvocationType invocationType = invokingWorkflowDoc
                .addNewInvokingWorkflow();

        EntityTypeEnum entityType = EntityTypeEnum.WORKFLOW;
        invocationHelper(invocationType, entityType);
        return invokingWorkflowDoc;

	}
	/**
	 * Workflow Invocation Testers
	 */
	public void testInvokingWorkflow() {
	    InvokingWorkflowDocument invokingWorkflowDoc = makeInvokingWorkflow();
		try {
			ingester.sendNotification(invokingWorkflowDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	InvokingWorkflowStatusDocument makeInvokingWorkflowStatus() {
        InvokingWorkflowStatusDocument invokingWorkflowStatusDoc = InvokingWorkflowStatusDocument.Factory
                .newInstance();
        InvocationStatusType invocationStatusType = invokingWorkflowStatusDoc
                .addNewInvokingWorkflowStatus();
        invocationStatusType.setStatus(StatusEnumType.SUCCESS);
        invocationStatusType.setStatusTime(Calendar.getInstance());

        EntityTypeEnum entityType = EntityTypeEnum.WORKFLOW;
        invocationHelper(invocationStatusType, entityType);
        return invokingWorkflowStatusDoc;
	}
	
	public void testInvokingWorkflowStatus() {
	    InvokingWorkflowStatusDocument invokingWorkflowStatusDoc = makeInvokingWorkflowStatus();
	    try {
			ingester.sendNotification(invokingWorkflowStatusDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	WorkflowInvokedDocument makeWorkflowInvoked() {
        WorkflowInvokedDocument workflowInvokedDoc = WorkflowInvokedDocument.Factory
                .newInstance();
        InvocationType invocationType = workflowInvokedDoc
                .addNewWorkflowInvoked();

        EntityTypeEnum entityType = EntityTypeEnum.WORKFLOW;
        invocationHelper(invocationType, entityType);
        return workflowInvokedDoc;
	}
	
	public void testWorkflowInvoked() {
	    WorkflowInvokedDocument workflowInvokedDoc = makeWorkflowInvoked();
	    
		try {
			ingester.sendNotification(workflowInvokedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	
	
	/**
	 * *Helper method for Invocation Tests*
	 * 
	 * @param invocationType
	 * @param entityType
	 */
	private void invocationHelper(InvocationType invocationType,
			EntityTypeEnum entityType) {
		
		invocationType.setInvocationTime(Calendar.getInstance());
		
		EntityType invoker = invocationType.addNewInvoker();
		EntityType invokee = invocationType.addNewInvokee();
		DataObjectType params = invocationType.addNewParams();

		addEntityInformation(invoker, entityType);

		addEntityInformation(invokee, entityType);

		addDataObject(params);

		AnnotationType[] annotations = new AnnotationType[1];        
        addAnnotations(annotations, constProperty, constValue);
        invocationType.setAnnotationsArray(annotations);
	}

	private void invocationHelper(InvocationStatusType invocationType,
			EntityTypeEnum entityType) {
		
		invocationType.setInvocationTime(Calendar.getInstance());
		invocationType.setStatus(StatusEnumType.SUCCESS);
		invocationType.setStatusTime(Calendar.getInstance());
		
		EntityType invoker = invocationType.addNewInvoker();
		EntityType invokee = invocationType.addNewInvokee();
		DataObjectType params = invocationType.addNewParams();

		addEntityInformation(invoker, entityType);

		addEntityInformation(invokee, entityType);

		addDataObject(params);

		AnnotationType[] annotations = new AnnotationType[1];        
        addAnnotations(annotations, constProperty, constValue);
        invocationType.setAnnotationsArray(annotations);
	}
	
	
	DataProducedDocument makeDataProduced() {
        DataProducedDocument dataProducedDoc = DataProducedDocument.Factory
                .newInstance();
        DataLifeCycleType dataLifeCycle = dataProducedDoc.addNewDataProduced();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        dataLifeCycle.setAction(ActionEnumType.PRODUCE);

        dataLifeCycleHelper(dataLifeCycle, entityType);
        return dataProducedDoc;
	}
	/**
	 * Data Lifecycle Testers
	 */
	public void testDataProduced() {
	    DataProducedDocument dataProducedDoc = makeDataProduced();
		try {
			ingester.sendNotification(dataProducedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

	DataConsumedDocument makeDataConsumed() {
        DataConsumedDocument dataConsumedDoc = DataConsumedDocument.Factory
                .newInstance();
        DataLifeCycleType dataLifeCycle = dataConsumedDoc.addNewDataConsumed();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        dataLifeCycle.setAction(ActionEnumType.CONSUME);

        dataLifeCycleHelper(dataLifeCycle, entityType);

        return dataConsumedDoc;
	}
	
	public void testDataConsumed() {
	    DataConsumedDocument dataConsumedDoc = makeDataConsumed();
		try {
			ingester.sendNotification(dataConsumedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	DataDeletedDocument makeDataDeleted() {
        DataDeletedDocument dataDeletedDoc = DataDeletedDocument.Factory
                .newInstance();
        DataLifeCycleType dataLifeCycle = dataDeletedDoc.addNewDataDeleted();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        dataLifeCycle.setAction(ActionEnumType.DELETE);

        dataLifeCycleHelper(dataLifeCycle, entityType);
        return dataDeletedDoc;
	}
	
	public void testDataDeleted() {
	    DataDeletedDocument dataDeletedDoc = makeDataDeleted();
	    
		try {
			ingester.sendNotification(dataDeletedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	DataUpdatedDocument makeDataUpdated() {
        DataUpdatedDocument dataUpdatedDoc = DataUpdatedDocument.Factory
                .newInstance();
        DataLifeCycleType dataLifeCycle = dataUpdatedDoc.addNewDataUpdated();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        dataLifeCycle.setAction(ActionEnumType.UPDATE);

        dataLifeCycleHelper(dataLifeCycle, entityType);
        return dataUpdatedDoc;
	}

	public void testDataUpdated() {
	    DataUpdatedDocument dataUpdatedDoc = makeDataUpdated();
		try {
			ingester.sendNotification(dataUpdatedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	/**
	 * *Helper method for Data Lifecycle Tests*
	 * 
	 * @param dataLifeCycle
	 * @param entityType
	 */
	private void dataLifeCycleHelper(DataLifeCycleType dataLifeCycle,
			EntityTypeEnum entityType) {
		EntityType actor = dataLifeCycle.addNewActor();
		DataObjectType dataObject = dataLifeCycle.addNewDataObject();
		
		dataLifeCycle.setTimestamp(Calendar.getInstance());
		
		addEntityInformation(actor, entityType);

		addDataObject(dataObject);

		AnnotationType[] annotations = new AnnotationType[1];        
        addAnnotations(annotations, constProperty, constValue);
        dataLifeCycle.setAnnotationsArray(annotations);
	}

	DataSendStartedDocument makeDataSendStarted() {
        DataSendStartedDocument dataSendStartedDoc = DataSendStartedDocument.Factory
                .newInstance();
        DataTransferType dataTransferType = dataSendStartedDoc
                .addNewDataSendStarted();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        DataTransferTypeEnum transferType = DataTransferTypeEnum.RESULT;
        dataTransferHelper(dataTransferType, entityType, transferType);
        return dataSendStartedDoc;
	}
	/**
	 * Data Transfer Testers
	 */
	public void testDataSendStarted() {
	    DataSendStartedDocument dataSendStartedDoc = makeDataSendStarted();
	    
		try {
			ingester.sendNotification(dataSendStartedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	DataSendFinishedDocument makeDataSendFinished() {
        DataSendFinishedDocument dataSendFinishedDoc = DataSendFinishedDocument.Factory
                .newInstance();
        DataTransferType dataTransferType = dataSendFinishedDoc
                .addNewDataSendFinished();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        DataTransferTypeEnum transferType = DataTransferTypeEnum.RESULT;
        dataTransferHelper(dataTransferType, entityType, transferType);
        return dataSendFinishedDoc;
	}

	public void testDataSendFinished() {
	    DataSendFinishedDocument dataSendFinishedDoc = makeDataSendFinished();
	    
		try {
			ingester.sendNotification(dataSendFinishedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	DataReceivedStartedDocument makeDataReceivedStarted() {
        DataReceivedStartedDocument dataReceivedStartedDoc = DataReceivedStartedDocument.Factory
                .newInstance();
        DataTransferType dataTransferType = dataReceivedStartedDoc
                .addNewDataReceivedStarted();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        DataTransferTypeEnum transferType = DataTransferTypeEnum.FAULT;
        dataTransferHelper(dataTransferType, entityType, transferType);
        return dataReceivedStartedDoc;

	}

	public void testDataReceiveStarted() {
	    DataReceivedStartedDocument dataReceivedStartedDoc = makeDataReceivedStarted();
		try {
			ingester.sendNotification(dataReceivedStartedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	DataReceivedFinishedDocument makeDataReceivedFinished() {
        DataReceivedFinishedDocument dataReceiveFinishedDoc = DataReceivedFinishedDocument.Factory
                .newInstance();
        DataTransferType dataTransferType = dataReceiveFinishedDoc
                .addNewDataReceivedFinished();

        EntityTypeEnum entityType = EntityTypeEnum.SERVICE;

        DataTransferTypeEnum transferType = DataTransferTypeEnum.FAULT;
        dataTransferHelper(dataTransferType, entityType, transferType);
        return dataReceiveFinishedDoc;
	}

	public void testDataReceiveFinished() {
	    DataReceivedFinishedDocument dataReceivedFinishedDoc = makeDataReceivedFinished();
		try {
			ingester.sendNotification(dataReceivedFinishedDoc);
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	ReceivedResponseDocument makeReceivedResponse() {
	    ReceivedResponseDocument receivedResponsedoc = ReceivedResponseDocument.Factory.newInstance();
	    DataTransferType dataTransferType = receivedResponsedoc.addNewReceivedResponse();
	    dataTransferHelper(dataTransferType, EntityTypeEnum.SERVICE, DataTransferTypeEnum.RESULT);
	    return receivedResponsedoc;
	}
	
	public void testReceivedResponse() {
	    ReceivedResponseDocument receivedResponseDoc = makeReceivedResponse();
	    try {
	        ingester.sendNotification(receivedResponseDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	SendingResponseStatusDocument makeSendingResponseStatus() {
	    SendingResponseStatusDocument sendingResponseStatusDoc = SendingResponseStatusDocument.Factory.newInstance();
	    DataTransferStatusType sendingResponseStatus = sendingResponseStatusDoc.addNewSendingResponseStatus();
	    dataTransferHelper(sendingResponseStatus, EntityTypeEnum.SERVICE, DataTransferTypeEnum.RESULT);
	    sendingResponseStatus.setStatus(StatusEnumType.SUCCESS);
	    sendingResponseStatus.setStatusTime(Calendar.getInstance());
	    return sendingResponseStatusDoc;
	}
	
	public void testSendingResponseStatus() {
	    SendingResponseStatusDocument sendingResponseStatusDoc = makeSendingResponseStatus();
	    try {
	        ingester.sendNotification(sendingResponseStatusDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	SendingResponseDocument makeSendingResponse() {
	    SendingResponseDocument sendingResponseDoc = SendingResponseDocument.Factory.newInstance();
	    DataTransferType dataTransferType = sendingResponseDoc.addNewSendingResponse();
	    dataTransferHelper(dataTransferType, EntityTypeEnum.SERVICE, DataTransferTypeEnum.RESULT);
	    return sendingResponseDoc;
	}
	
	public void testSendingResponse() {
	    SendingResponseDocument sendingResponseDoc = makeSendingResponse();
	    try {
	        ingester.sendNotification(sendingResponseDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	ReceivedFaultDocument makeReceivedFault() {
	    ReceivedFaultDocument receivedFaultDoc = ReceivedFaultDocument.Factory.newInstance();
	    DataTransferType dataTransferType = receivedFaultDoc.addNewReceivedFault();
	    dataTransferHelper(dataTransferType, EntityTypeEnum.SERVICE, DataTransferTypeEnum.FAULT);
	    return receivedFaultDoc;
	}
	
	public void testReceivedFault() {
	    ReceivedFaultDocument receivedFaultDoc = makeReceivedFault();
	    try {
	        ingester.sendNotification(receivedFaultDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	SendingFaultDocument makeSendingFault() {
	    SendingFaultDocument sendingFaultDoc = SendingFaultDocument.Factory.newInstance();
	    DataTransferType sendingFault = sendingFaultDoc.addNewSendingFault();
	    dataTransferHelper(sendingFault, EntityTypeEnum.SERVICE, DataTransferTypeEnum.FAULT);
	    return sendingFaultDoc;
	}
	
	public void testSendingFault() {
	    SendingFaultDocument sendingFaultDoc = makeSendingFault();
	    try {
	        ingester.sendNotification(sendingFaultDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	/**
	 * *Helper Method for Data Transfer Tests*
	 * 
	 * @param dataTransferType
	 * @param entityType
	 * @param transferType
	 */
	private void dataTransferHelper(DataTransferType dataTransferType,
		EntityTypeEnum entityType, DataTransferTypeEnum transferType) {
		EntityType sender = dataTransferType.addNewSender();
		EntityType receiver = dataTransferType.addNewReceiver();

		dataTransferType.setTransferTime(Calendar.getInstance());
		
		DataObjectType dataObject = null;
		if (transferType.equals(DataTransferTypeEnum.RESULT)) {
			dataObject = dataTransferType.addNewResult();
		} else if (transferType.equals(DataTransferTypeEnum.FAULT)) {
			dataObject = dataTransferType.addNewFault();
		}

		addEntityInformation(sender, entityType);
		addEntityInformation(receiver, entityType);

		addDataObject(dataObject);
		
		AnnotationType[] annotations = new AnnotationType[1];        
        addAnnotations(annotations, constProperty, constValue);
        dataTransferType.setAnnotationsArray(annotations);
	}
	
	
	AddAnnotationDocument makeAddAnnotationDoc() {
		AddAnnotationDocument addAnnotationDocument = AddAnnotationDocument.Factory.newInstance();
	    AddAnnotationType annotationType = addAnnotationDocument.addNewAddAnnotation();
	    AnnotableEntityType annotableEntityType = annotationType.addNewAnnotableEntity();
	    annotableEntityType.setEntityID("TestService");
	    annotableEntityType.setType(EntityEnumType.SERVICE);
	    
	    AnnotationType[] annotations = new AnnotationType[2];
	    addAnnotations(annotations, constProperty, constValue);
	    
	    annotationType.setAnnotationsArray(annotations);
	    annotationType.setAnnotatingTimestamp(Calendar.getInstance());
	    annotationType.setAnnotableObjectType(AnnotableObjectEnumType.ENTITY);
	    annotationType.setNotificationtimestamp(Calendar.getInstance());
	    
	    return addAnnotationDocument;
	}
	
	AddAnnotationByIdDocument makeAddAnnotationByIdDoc() {
		AddAnnotationByIdDocument addAnnotationDocument = AddAnnotationByIdDocument.Factory.newInstance();
	    AddAnnotationByIdType annotationType = addAnnotationDocument.addNewAddAnnotationById();
	    annotationType.setObjectID(3);
	    
	    AnnotationType[] annotations = new AnnotationType[2];
	    addAnnotations(annotations, constProperty, constValue);
	    
	    annotationType.setAnnotationsArray(annotations);
	    annotationType.setAnnotatingTimestamp(Calendar.getInstance());
	    annotationType.setAnnotableObjectType(AnnotableObjectEnumType.ENTITY);
	    annotationType.setNotificationtimestamp(Calendar.getInstance());
	    
	    return addAnnotationDocument;
	}
	
	AddMultipleObjectAnnotationDocument makeMultipleAddAnnotationDoc() {
		AddMultipleObjectAnnotationDocument addAnnotationDocument = AddMultipleObjectAnnotationDocument.Factory.newInstance();		
	    AddMultipleObjectAnnotationType annotationType = addAnnotationDocument.addNewAddMultipleObjectAnnotation();
	    AnnotableEntityType[] annotableEntityArray = new AnnotableEntityType[2];
	    	
	    annotableEntityArray[0] = annotationType.addNewAnnotableEntity();
	    annotableEntityArray[0].setEntityID("TestService_1");
	    annotableEntityArray[0].setType(EntityEnumType.SERVICE);
	    
	    annotableEntityArray[1] = annotationType.addNewAnnotableEntity();
	    annotableEntityArray[1].setEntityID("TestService_2");
	    annotableEntityArray[1].setType(EntityEnumType.SERVICE);
	    
	    annotationType.setAnnotableEntityArray(annotableEntityArray);
	    
	    AnnotationType[] annotations = new AnnotationType[2];
	    addAnnotations(annotations, constProperty, constValue);
	    
	    annotationType.setAnnotationsArray(annotations);
	    annotationType.setAnnotatingTimestamp(Calendar.getInstance());
	    annotationType.setAnnotableObjectType(AnnotableObjectEnumType.ENTITY);
	    annotationType.setNotificationtimestamp(Calendar.getInstance());
	    
	    return addAnnotationDocument;
	}
	
	public void testAddAnnotations() {
	    AddAnnotationDocument addAnnotationDoc = makeAddAnnotationDoc();
	    try {
	        ingester.sendNotification(addAnnotationDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void testAddAnnotationsById() {
	    AddAnnotationByIdDocument addAnnotationDoc = makeAddAnnotationByIdDoc();
	    try {
	        ingester.sendNotification(addAnnotationDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void testMultipleAddAnnotations() {
	    AddMultipleObjectAnnotationDocument addAnnotationDoc = makeMultipleAddAnnotationDoc();
	    try {
	        ingester.sendNotification(addAnnotationDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	/**
	 * Calling main()
	 * @param args
	 */
	public static void main(String[] args) {	
		
		int is_threaded = 0;
		
		if(args.length < 1){
			System.out.println("NotificatioTester:\nargs[0]: Message Configuration File.\n" +
					"args[1]: Optional parameter to test multithreaded program, 0: single-threaded, 1: multi-threaded");
			return;
		}
		else if(args.length == 2){
			is_threaded = Integer.parseInt(args[1]);
		}
		
		String messageConfigPath = args[0];

		Random randomNumGen = new Random();
		
		if(is_threaded == 1){
			int num_threads = randomNumGen.nextInt(20);	
			for (int i = 0; i < num_threads; i++) {
				System.out.println("Tester-"+i);     	
		        NotificationTester tester = new NotificationTester(messageConfigPath);  
				new Thread(tester).start();
			}			
		}
		else{		
			//need to modify this with updated constructor     	       	
	        NotificationTester tester = new NotificationTester(messageConfigPath);           	       
			tester.startProcess();
		}
		
	}

	/**
	 * processor method
	 */
	public void startProcess(){
		
		for (int i = 0; i < 22; i++) {
			int test_num = i;			
			switch (test_num) {
			case 0:
				System.out.println("Test-1: Invoking-Workflow Notification");
				testInvokingWorkflow();
				break;
			case 1:
				System.out.println("Test-2: Invoking-Workflow-Status Notification");
				testInvokingWorkflowStatus();
				break;
			case 2:
				System.out.println("Test-3: Workflow-Invoked Notification");
				testWorkflowInvoked();
				break;
			case 3:
				System.out.println("Test-4: Invoking-Service Notification");
				testInvokingService();
				break;
			case 4:
				System.out.println("Test-5: Invoking-Service-Status Notification");
				testInvokingServiceStatus();
				break;
			case 5:
				System.out.println("Test-6: Service-Invoked Notification");
				testServiceInvoked();
				break;
			case 6:
				System.out.println("Test-7: Data-Produced Notification");
				testDataProduced();
				break;
			case 7:
				System.out.println("Test-8: Data-Consumed Notification");
				testDataConsumed();
				break;
			case 8:
				System.out.println("Test-9: Data-Deleted Notification");
				testDataDeleted();
				break;
			case 9:
				System.out.println("Test-10: Data-Updated Notification");
				testDataUpdated();
				break;
			case 10:
				System.out.println("Test-11: Data-Send-Started Notification");
				testDataSendStarted();
				break;
			case 11:
				System.out.println("Test-12: Data-Send-Finished Notification");
				testDataSendFinished();
				break;
			case 12:
				System.out.println("Test-13: Data-Receive-Started Notification");
				testDataReceiveStarted();
				break;
			case 13:
				System.out.println("Test-14: Data-Receive-Finished Notification");
				testDataReceiveFinished();
				break;
			case 14:
			    System.out.println("Test-15: Received-Response Notification");
			    testReceivedResponse();
			    break;
			case 15:
			    System.out.println("Test-16: Sending-Response-Status Notification");
			    testSendingResponseStatus();
			    break;
			case 16:
			    System.out.println("Test-17: Sending-Response Notification");
			    testSendingResponse();
			    break;
			case 17:
			    System.out.println("Test-18: Received-Fault Notification");
			    testReceivedFault();
			    break;
			case 18:
			    System.out.println("Test-19: Sending-Fault Notification");
			    testSendingFault();
			    break;
			case 19:
				System.out.println("Test-20: Adding Annotations to an Entity");
				testAddAnnotations();
				break;
			case 20:
				System.out.println("Test-21: Adding Annotations By Id to an Entity");
				testAddAnnotationsById();
				break;
			case 21:
				System.out.println("Test-22: Adding Annotations to an Multiple Entities");
				testMultipleAddAnnotations();
				break;
			default:
				break;
			}
		}
		ingester.closeConnection();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		startProcess();
	}

}
