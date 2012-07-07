package edu.indiana.dsi.karma.test;

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
# File:  NotificationTester.java
# Description:  A test client for testing Karma-Service
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
import org.dataandsearch.www.karma._2010._08.AuthorshipEnumType;
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
import org.dataandsearch.www.karma._2010._08.InstanceOfType;
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
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf;
import org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument;

import edu.indiana.dsi.karma.ingest.EntityObject.InstanceOf;
import edu.indiana.dsi.karma.ingest.IngestException;
import edu.indiana.dsi.karma.ingest.NotificationIngester;
import edu.indiana.dsi.karma.util.ServiceLauncher;

public class NotificationTester implements Runnable{

	private static String constServiceID = "urn:qname:http://www.d2i.indiana.edu/karma:TestService_";
	private static String constWorkflowID = "tag:www.d2i.indiana.edu/TestWorkflow/instance";
	private static String constWorkflowNodeID = "WFNode:KarmaProcessor";

	//private static String constFileURI = "http://www.d2i.indiana.edu/testKarmaFile";
	//private static String constDN = "KarmaTester";

	private static String constProperty = "execution_environment";
	private static String constValue = "POSIX";
	private static String userDN = "tester";

	private static int ramanujanNum = 1729;	
	
	private NotificationIngester ingester = null;

	public NotificationTester(String propertiesPath) {
//	    ServiceLauncher.start("config\\properties_file_template.properties");
	    ServiceLauncher.start(propertiesPath);
	    ingester = ServiceLauncher.getIngester();
	}
	
	public NotificationTester() {
	    
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
		//int id = 100;

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
			
			InstanceOfType instanceOf = entityServiceInfoType.addNewInstanceOf();
			instanceOf.setInstanceOfID(constServiceID);
			instanceOf.setVersion("1.0.0");
			instanceOf.setCreationTime(Calendar.getInstance());
			
			entity.setType(EntityEnumType.SERVICE);
		}
		else{
			WorkflowInformationType entityWorkflowInfoType = entity
			.addNewWorkflowInformation();
			entityWorkflowInfoType.setWorkflowID(workflowID);
			entityWorkflowInfoType.setWorkflowNodeID(workflowNodeID);
			entityWorkflowInfoType.setTimestep(timestep);	
			
			InstanceOfType instanceOf = entityWorkflowInfoType.addNewInstanceOf();
			instanceOf.setInstanceOfID(constWorkflowID);
			instanceOf.setVersion("1.0.0");
			instanceOf.setCreationTime(Calendar.getInstance());
			entityWorkflowInfoType.setInstanceOf(instanceOf);
			
			UserBehalf userBehalf = entityWorkflowInfoType.addNewUserBehalf();
			userBehalf.setUserDN(userDN);
			userBehalf.setAuthorship(AuthorshipEnumType.AUTHOR);
			entityWorkflowInfoType.setUserBehalf(userBehalf);
			
			entity.setType(EntityEnumType.WORKFLOW);			
		}

	}

	private void addDataObject(DataObjectType params) {

		/*Random randomNumGen = new Random();
		int id = randomNumGen.nextInt(ramanujanNum);

		String fileURI = constFileURI + id;
		String ownerDN = Integer.toString(id);
		long size = 0;

		FileType file = params.addNewFile();
		file.setFileURI(fileURI);
		file.setOwnerDN(ownerDN);
		file.setSize(size);
		file.setCreateDate(Calendar.getInstance());*/
		
		
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
		/*try {
			annotations.setProperty(property);
			annotations.set(XmlObject.Factory.parse(xmlChunk));
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
//		InvokingServiceDocument invokingServiceDoc = InvokingServiceDocument.Factory
//				.newInstance();
//		InvocationType invocationType = invokingServiceDoc
//				.addNewInvokingService();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//
//		invocationHelper(invocationType, entityType);
//		
	    InvokingServiceDocument invokingServiceDoc = makeInvokingService();
	    
		try {
			ingester.ingestInvokingService(invokingServiceDoc);
		} catch (IngestException e) {
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
//		InvokingServiceStatusDocument invokingServiceStatusDoc = InvokingServiceStatusDocument.Factory
//				.newInstance();
//		InvocationStatusType invocationStatusType = invokingServiceStatusDoc
//				.addNewInvokingServiceStatus();
//
//		invocationStatusType.setStatus(StatusEnumType.SUCCESS);
//		invocationStatusType.setStatusTime(Calendar.getInstance());
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//		invocationHelper(invocationStatusType, entityType);
		
	    InvokingServiceStatusDocument invokingServiceStatusDoc = makeInvokingServiceStatus();
		try {
			ingester.ingestInvokingServiceStatus(invokingServiceStatusDoc);
		} catch (IngestException e) {
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
//		ServiceInvokedDocument serviceInvokedDoc = ServiceInvokedDocument.Factory
//				.newInstance();
//		InvocationType invocationType = serviceInvokedDoc
//				.addNewServiceInvoked();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//		invocationHelper(invocationType, entityType);
//		
	    ServiceInvokedDocument serviceInvokedDoc = makeServiceInvoked();
	    try {
			ingester.ingestServiceInvoked(serviceInvokedDoc);
		} catch (IngestException e) {
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
//		InvokingWorkflowDocument invokingWorkflowDoc = InvokingWorkflowDocument.Factory
//				.newInstance();
//		InvocationType invocationType = invokingWorkflowDoc
//				.addNewInvokingWorkflow();
//
//		EntityTypeEnum entityType = EntityTypeEnum.WORKFLOW;
//		invocationHelper(invocationType, entityType);
	    InvokingWorkflowDocument invokingWorkflowDoc = makeInvokingWorkflow();
		try {
			ingester.ingestInvokingWorkflow(invokingWorkflowDoc);
		} catch (IngestException e) {
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
//		InvokingWorkflowStatusDocument invokingWorkflowStatusDoc = InvokingWorkflowStatusDocument.Factory
//				.newInstance();
//		InvocationStatusType invocationStatusType = invokingWorkflowStatusDoc
//				.addNewInvokingWorkflowStatus();
//		invocationStatusType.setStatus(StatusEnumType.SUCCESS);
//		invocationStatusType.setStatusTime(Calendar.getInstance());
//
//		EntityTypeEnum entityType = EntityTypeEnum.WORKFLOW;
//		invocationHelper(invocationStatusType, entityType);
	    InvokingWorkflowStatusDocument invokingWorkflowStatusDoc = makeInvokingWorkflowStatus();
	    try {
			ingester.ingestInvokingWorkflowStatus(invokingWorkflowStatusDoc);
		} catch (IngestException e) {
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
//		WorkflowInvokedDocument workflowInvokedDoc = WorkflowInvokedDocument.Factory
//				.newInstance();
//		InvocationType invocationType = workflowInvokedDoc
//				.addNewWorkflowInvoked();
//
//		EntityTypeEnum entityType = EntityTypeEnum.WORKFLOW;
//		invocationHelper(invocationType, entityType);
	    WorkflowInvokedDocument workflowInvokedDoc = makeWorkflowInvoked();
	    
		try {
			ingester.ingestWorkflowInvoked(workflowInvokedDoc);
		} catch (IngestException e) {
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
		//AnnotationType annotations = invocationType.addNewAnnotations();

		addEntityInformation(invoker, entityType);

		addEntityInformation(invokee, entityType);

		addDataObject(params);

		//String property = constProperty;
		//String value = constValue;
		//addAnnotations(annotations, property, value);
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
		//AnnotationType annotations = invocationType.addNewAnnotations();

		addEntityInformation(invoker, entityType);

		addEntityInformation(invokee, entityType);

		addDataObject(params);

		//String property = constProperty;
		//String value = constValue;
		//addAnnotations(annotations, property, value);
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
//		DataProducedDocument dataProducedDoc = DataProducedDocument.Factory
//				.newInstance();
//		DataLifeCycleType dataLifeCycle = dataProducedDoc.addNewDataProduced();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//		
//		dataLifeCycle.setAction(ActionEnumType.PRODUCE);
//		
//		dataLifeCycleHelper(dataLifeCycle, entityType);
	    DataProducedDocument dataProducedDoc = makeDataProduced();
		try {
			ingester.ingestDataProduced(dataProducedDoc);
		} catch (IngestException e) {
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
//		DataConsumedDocument dataConsumedDoc = DataConsumedDocument.Factory
//				.newInstance();
//		DataLifeCycleType dataLifeCycle = dataConsumedDoc.addNewDataConsumed();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//		
//		dataLifeCycle.setAction(ActionEnumType.CONSUME);
//
//		dataLifeCycleHelper(dataLifeCycle, entityType);
	    DataConsumedDocument dataConsumedDoc = makeDataConsumed();
		try {
			ingester.ingestDataConsumed(dataConsumedDoc);
		} catch (IngestException e) {
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
//		DataDeletedDocument dataDeletedDoc = DataDeletedDocument.Factory
//				.newInstance();
//		DataLifeCycleType dataLifeCycle = dataDeletedDoc.addNewDataDeleted();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//		
//		dataLifeCycle.setAction(ActionEnumType.DELETE);
//
//		dataLifeCycleHelper(dataLifeCycle, entityType);
	    DataDeletedDocument dataDeletedDoc = makeDataDeleted();
	    
		try {
			ingester.ingestDataDeleted(dataDeletedDoc);
		} catch (IngestException e) {
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
//		DataUpdatedDocument dataUpdatedDoc = DataUpdatedDocument.Factory
//				.newInstance();
//		DataLifeCycleType dataLifeCycle = dataUpdatedDoc.addNewDataUpdated();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//
//		dataLifeCycle.setAction(ActionEnumType.UPDATE);
//		
//		dataLifeCycleHelper(dataLifeCycle, entityType);
	    
	    DataUpdatedDocument dataUpdatedDoc = makeDataUpdated();
		try {
			ingester.ingestDataUpdated(dataUpdatedDoc);
		} catch (IngestException e) {
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
//		DataSendStartedDocument dataSendStartedDoc = DataSendStartedDocument.Factory
//				.newInstance();
//		DataTransferType dataTransferType = dataSendStartedDoc
//				.addNewDataSendStarted();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;		
//		
//		DataTransferTypeEnum transferType = DataTransferTypeEnum.RESULT;
//		dataTransferHelper(dataTransferType, entityType, transferType);
	    DataSendStartedDocument dataSendStartedDoc = makeDataSendStarted();
	    
		try {
			ingester.ingestDataSendStarted(dataSendStartedDoc);
		} catch (IngestException e) {
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
//		DataSendFinishedDocument dataSendFinishedDoc = DataSendFinishedDocument.Factory
//				.newInstance();
//		DataTransferType dataTransferType = dataSendFinishedDoc
//				.addNewDataSendFinished();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//
//		DataTransferTypeEnum transferType = DataTransferTypeEnum.RESULT;
//		dataTransferHelper(dataTransferType, entityType, transferType);
	    DataSendFinishedDocument dataSendFinishedDoc = makeDataSendFinished();
	    
		try {
			ingester.ingestDataSendFinished(dataSendFinishedDoc);
		} catch (IngestException e) {
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
//		DataReceivedStartedDocument dataReceiveStartedDoc = DataReceivedStartedDocument.Factory
//				.newInstance();
//		DataTransferType dataTransferType = dataReceiveStartedDoc
//				.addNewDataReceivedStarted();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//
//		DataTransferTypeEnum transferType = DataTransferTypeEnum.FAULT;
//		dataTransferHelper(dataTransferType, entityType, transferType);
	    DataReceivedStartedDocument dataReceivedStartedDoc = makeDataReceivedStarted();
		try {
			ingester.ingestDataReceivedStarted(dataReceivedStartedDoc);
		} catch (IngestException e) {
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
//		DataReceivedFinishedDocument dataReceiveFinishedDoc = DataReceivedFinishedDocument.Factory
//				.newInstance();
//		DataTransferType dataTransferType = dataReceiveFinishedDoc
//				.addNewDataReceivedFinished();
//
//		EntityTypeEnum entityType = EntityTypeEnum.SERVICE;
//
//		DataTransferTypeEnum transferType = DataTransferTypeEnum.FAULT;
//		dataTransferHelper(dataTransferType, entityType, transferType);
	    DataReceivedFinishedDocument dataReceivedFinishedDoc = makeDataReceivedFinished();
		try {
			ingester.ingestDataReceivedFinished(dataReceivedFinishedDoc);
		} catch (IngestException e) {
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
	        ingester.ingestReceivedResponse(receivedResponseDoc);
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
	        ingester.ingestSendingResponseStatus(sendingResponseStatusDoc);
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
	        ingester.ingestSendingResponse(sendingResponseDoc);
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
	        ingester.ingestReceivedFault(receivedFaultDoc);
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
	        ingester.ingestSendingFault(sendingFaultDoc);
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
	    //annotableEntityType.setEntityID("plab1-itec.uni-klu.ac.at");
	    annotableEntityType.setEntityID(constServiceID);
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
	    annotationType.setObjectID(34);
	    
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
	    annotableEntityArray[0].setEntityID("plab1-itec.uni-klu.ac.at");
	    annotableEntityArray[0].setType(EntityEnumType.SERVICE);
	    
	    annotableEntityArray[1] = annotationType.addNewAnnotableEntity();
	    annotableEntityArray[1].setEntityID("plab1-c703.uibk.ac.at");
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
	        ingester.addAnnotation(addAnnotationDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void testAddAnnotationsById() {
	    AddAnnotationByIdDocument addAnnotationDoc = makeAddAnnotationByIdDoc();
	    try {
	        ingester.addAnnotationById(addAnnotationDoc);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void testMultipleAddAnnotations() {
	    AddMultipleObjectAnnotationDocument addAnnotationDoc = makeMultipleAddAnnotationDoc();
	    try {
	        ingester.addMultipleObjectAnnotation(addAnnotationDoc);
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
		
		if(args.length == 1){
			is_threaded = Integer.parseInt(args[0]);
		}

		Random randomNumGen = new Random();	
		
		if(is_threaded == 1){
			int num_threads = randomNumGen.nextInt(20);	
			for (int i = 0; i < num_threads; i++) {
				System.out.println("Tester-"+i);
				//need to modify this with updated constructor
//		        IngesterImplementer<Long, String> implementer = new BaseDBIngesterImplementer();        	
		        NotificationTester tester = new NotificationTester();  
				new Thread(tester).start();
			}			
		}
		else{		
			//need to modify this with updated constructor
//	        IngesterImplementer<Long, String> implementer = new BaseDBIngesterImplementer();        	       	
	        NotificationTester tester = new NotificationTester("/home/peng/workspace/Karma-Service/config/karma.properties");           	       
			tester.startProcess();
		}
		
	}

	/**
	 * processor method
	 */
	public void startProcess(){
		//Random randomNumGen = new Random();
		//int num_tests = randomNumGen.nextInt(20);
		
		for (int i = 0; i < 22; i++) {
			//int test_num = randomNumGen.nextInt(14);
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
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		startProcess();
	}

}
