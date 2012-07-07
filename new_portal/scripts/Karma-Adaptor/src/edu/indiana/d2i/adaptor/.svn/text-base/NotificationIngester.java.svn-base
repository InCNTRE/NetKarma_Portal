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
# Project: Netkarma
# File:  NotificationIngester.java
# Description:  Creates a list of Notifications to be ingested
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MultiHashMap;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.dataandsearch.netkarma.ActorEntityEnumType;
import org.dataandsearch.netkarma.ActorEnumType;
import org.dataandsearch.netkarma.DataEnumType;
import org.dataandsearch.netkarma.NotificationEnumType;
import org.dataandsearch.www.karma._2010._08.ActionEnumType;
import org.dataandsearch.www.karma._2010._08.AddAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationType;
import org.dataandsearch.www.karma._2010._08.AnnotableEntityType;
import org.dataandsearch.www.karma._2010._08.AnnotableFileType;
import org.dataandsearch.www.karma._2010._08.AnnotableObjectEnumType;
import org.dataandsearch.www.karma._2010._08.AnnotationType;
import org.dataandsearch.www.karma._2010._08.BlockType;
import org.dataandsearch.www.karma._2010._08.DataConsumedDocument;
import org.dataandsearch.www.karma._2010._08.DataLifeCycleType;
import org.dataandsearch.www.karma._2010._08.DataObjectType;
import org.dataandsearch.www.karma._2010._08.DataProducedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataTransferType;
import org.dataandsearch.www.karma._2010._08.EntityEnumSubtype;
import org.dataandsearch.www.karma._2010._08.EntityEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
import org.dataandsearch.www.karma._2010._08.FileType;
import org.dataandsearch.www.karma._2010._08.InvocationType;
import org.dataandsearch.www.karma._2010._08.InvokingServiceDocument;
import org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument;
import org.dataandsearch.www.karma._2010._08.PersonnelEnumType;
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;
import org.dataandsearch.www.karma._2010._08.UserInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf;
import org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument;

import edu.indiana.dsi.karma.messaging.Sender;

public class NotificationIngester {

	String action;
	Calendar notificationTime;
	NotificationEnumType.Enum notificationType;	
	Actor[] actors;
	DataBlock[] dataBlocks;
	Annotation[] annotations;
	String filePrefix;
	int notificationId;
	int timestep = -1;
	String notificationFile;
	MultiHashMap notificationList;
	
	Sender sender;
	Ingester ingester;
	XmlObject notification;
	
	public NotificationIngester(Sender sender, MultiHashMap notificationList) {
		super();
		this.notificationList = notificationList;
		this.sender = sender;		
		this.ingester = new Ingester(sender);
	}
	
	private void addActors(Actor actor, EntityType entity){
		ActorEntityEnumType.Enum entityType = actor.getEntityType();
		Annotation[] entityAnnotations = actor.getAnnotations();
		
		switch(entityType.intValue()){
		case ActorEntityEnumType.INT_USER:
			UserInformationType actorUser = entity.addNewUserInformation();
			actorUser.setUserDN(actor.getActorId());
			actorUser.setType(PersonnelEnumType.PERSON);
			entity.setType(EntityEnumType.USER);
			break;
		case ActorEntityEnumType.INT_WORKFLOW:
			WorkflowInformationType actorWorkflow = entity.addNewWorkflowInformation();				    
	        if(actor.getParentIds() != null){
	        	actorWorkflow.setWorkflowNodeID(actor.getActorId());
	        	actorWorkflow.setWorkflowID(actor.getParentIds()[0]);
	        } else{
	        	actorWorkflow.setWorkflowID(actor.getActorId());
	        }
	        if(actor.getBehalfId() != null){
	        	UserBehalf userBehalf = actorWorkflow.addNewUserBehalf();
	        	userBehalf.setUserDN(actor.getBehalfId());
	        	entity.setSubtype(EntityEnumSubtype.HUMAN_PROXY);
	        }
	        if(actor.getTimestep() != -1){
	        	timestep = actor.getTimestep();
	        }
	        actorWorkflow.setTimestep(timestep);
	        timestep = -1;
	        entity.setType(EntityEnumType.WORKFLOW);
	        
			if(entityAnnotations != null){
				AnnotationType[] annotationTypes = new AnnotationType[entityAnnotations.length];				
				try {
					//xmlData.set(XmlObject.Factory.parse(annotationData));
					for (int i = 0; i < annotationTypes.length; i++) {
						//AnnotationType annotation = annotationTypes[i].addNewValue();
						annotationTypes[i] = actorWorkflow.addNewAnnotations();
						annotationTypes[i].setProperty(entityAnnotations[i].getProperty());
						String value = "<value>" + entityAnnotations[i].getValue() + "</value>";
						annotationTypes[i].setValue(XmlObject.Factory.parse(value));
						//System.out.println("EA: "+value);
					}
					actorWorkflow.setAnnotationsArray(annotationTypes);
				} catch (XmlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			
	        break;
		case ActorEntityEnumType.INT_SERVICE:
			ServiceInformationType actorService = entity.addNewServiceInformation();
	        actorService.setServiceID(actor.getActorId()); // need to generalize this
	        String[] parents = actor.getParentIds();
	        if(parents.length == 1){
	        	actorService.setWorkflowID(parents[0]);   
	        } else{
	        	actorService.setWorkflowNodeID(parents[0]);
		        actorService.setWorkflowID(parents[1]);  
	        }
	        if(actor.getTimestep() != -1){
	        	timestep = actor.getTimestep();
	        }
	        actorService.setTimestep(timestep);
	        timestep = -1;
	        entity.setType(EntityEnumType.SERVICE);
			
			if(entityAnnotations != null && entityAnnotations.length > 0){
				//System.out.println("INGESTING ENTITY ANNOTATIONS");
				AnnotationType[] annotationTypes = new AnnotationType[entityAnnotations.length];				
				try {
					//xmlData.set(XmlObject.Factory.parse(annotationData));
					for (int i = 0; i < annotationTypes.length; i++) {
						//AnnotationType annotation = annotationTypes[i].addNewValue();
						annotationTypes[i] = actorService.addNewAnnotations();
						annotationTypes[i].setProperty(entityAnnotations[i].getProperty());
						String value = "<value>" + entityAnnotations[i].getValue() + "</value>";
						annotationTypes[i].setValue(XmlObject.Factory.parse(value));
					}
					actorService.setAnnotationsArray(annotationTypes);
				} catch (XmlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			
			break;
		case ActorEntityEnumType.INT_METHOD:
			// not implemented right now
			break;
		default:
			break;			
		}

	}
	
	public void createServiceInvokedDoc(){		
		ServiceInvokedDocument serviceInvokedDoc = ServiceInvokedDocument.Factory.newInstance();
        InvocationType serviceInvoked = serviceInvokedDoc.addNewServiceInvoked();
        EntityType invoker = serviceInvoked.addNewInvoker();
        EntityType invokee = serviceInvoked.addNewInvokee();
        serviceInvoked.setInvocationTime(notificationTime);
        
        for (int i = 0; i < actors.length; i++) {
        	//System.out.println("========"+actors[i].getActorId()); //Added by Yuan for testing
            switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_INVOKER:
	        	addActors(actors[i], invoker);
	            break;
	        case ActorEnumType.INT_INVOKEE:
	        	addActors(actors[i], invokee);
	            break;
	        default: // invalid type
	        	break;
	        }
		}	
        
        if(dataBlocks.length > 0){
        	DataObjectType params = serviceInvoked.addNewParams();
	        String dataBlockXML = createDataBlockXML();
	        BlockType block = params.addNewBlock();
	        try {
				block.setBlockContent(XmlObject.Factory.parse(dataBlockXML));
			} catch (XmlException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			}
        }
        
		if(annotations.length > 0){
			AnnotationType annotation = serviceInvoked.addNewAnnotations();
			String invocationProp = "service-invoked-annotations";
			annotation.setProperty(invocationProp);
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
        //notificationFile = filePrefix+"_service_invoked_"+notificationId+".xml";
        //System.out.println(notificationFile);
        //notification = serviceInvokedDoc;
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(serviceInvokedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));

        try {
			ingester.sendNotification(serviceInvokedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        /*notificationFile = "service_invoked_"+notificationId+".xml";
		try {
			serviceInvokedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void createWorkflowInvokedDoc(){
		WorkflowInvokedDocument workflowInvokedDoc = WorkflowInvokedDocument.Factory.newInstance();
        InvocationType workflowInvoked = workflowInvokedDoc.addNewWorkflowInvoked();
        EntityType invoker = workflowInvoked.addNewInvoker();
        EntityType invokee = workflowInvoked.addNewInvokee();        
        workflowInvoked.setInvocationTime(notificationTime);

        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_INVOKER:
	        	addActors(actors[i], invoker);
	            break;
	        case ActorEnumType.INT_INVOKEE:
	        	addActors(actors[i], invokee);
	            break;
	        default: // invalid type
	        	break;
	        }
		}	
        
        if(dataBlocks.length > 0){
        	DataObjectType params = workflowInvoked.addNewParams();
        	addDataBlock(params);
        }
        
		if(annotations.length > 0){
			/*AnnotationType annotation = workflowInvoked.addNewAnnotations();
			String invocationProp = "workflow-invoked-annotations";
			annotation.setProperty(invocationProp);
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";*/
			AnnotationType[] annotationTypes = new AnnotationType[annotations.length];

			
			try {
				//xmlData.set(XmlObject.Factory.parse(annotationData));
				for (int i = 0; i < annotationTypes.length; i++) {
					//AnnotationType annotation = annotationTypes[i].addNewValue();
					annotationTypes[i] = workflowInvoked.addNewAnnotations();
					annotationTypes[i].setProperty(annotations[i].getProperty());
					String value = "<value>" + annotations[i].getValue() + "</value>";
					annotationTypes[i].setValue(XmlObject.Factory.parse(value));
				}
				workflowInvoked.setAnnotationsArray(annotationTypes);
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(workflowInvokedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(workflowInvokedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        /*notificationFile = "workflow_invoked_"+notificationId+".xml";
		try {
			workflowInvokedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	private void addDataBlock(DataObjectType dataObject){
		for (int i = 0; i < dataBlocks.length; i++) {
			DataEnumType.Enum dataType = dataBlocks[i].getDataObjectType();
			if(dataType.equals(DataEnumType.BLOCK)){
		        String dataBlockXML = createDataBlockXML();
		        //System.out.println("---- DATA BLOCK: " + dataBlockXML);
		        BlockType block = dataObject.addNewBlock();
		        try {
					block.setBlockContent(XmlObject.Factory.parse(dataBlockXML));
				} catch (XmlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}
				
				// only one block possible at a time
				break;
			}
			else if(dataType.equals(DataEnumType.FILE)){
		        FileType fileType = dataObject.addNewFile();
		        fileType.setFileURI(dataBlocks[i].getDataObjectValue());  
		        fileType.setObjectName(dataBlocks[i].getDataObjectName());
		        // need to set this by derivation rules
		        //fileType.setOwnerDN();
		        		        
		        break;
			}
		}
	}
	
	// need to complete this implementation
	private String createDataBlockXML(){
		String dataBlockXML = "<dataBlocks>";		
		for (int i = 0; i < dataBlocks.length; i++) {
			String objectId = dataBlocks[i].getDataObjectId();
			String objectName = dataBlocks[i].getDataObjectName();
			String objectValue = dataBlocks[i].getDataObjectValue();
			String objectType = dataBlocks[i].getDataObjectType().toString();
			
			dataBlockXML += "<block><objectID>" + objectId + "</objectID>"
			+ "<objectName>" + objectName + "</objectName>"
			+ "<objectValue>" + objectValue + "</objectValue>"
			+ "<objectType>" + objectType + "</objectType></block>";
		}
		dataBlockXML += "</dataBlocks>";
		return dataBlockXML;
	}
	
	public void createDataProducedDoc(){
		DataProducedDocument dataProducedDoc = DataProducedDocument.Factory.newInstance();
		DataLifeCycleType dataProduced = dataProducedDoc.addNewDataProduced();
		EntityType producer = dataProduced.addNewActor();
		
		dataProduced.setAction(ActionEnumType.PRODUCE);
		
        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        // Actually, there should be only one producer for an artifact
	        case ActorEnumType.INT_PRODUCER:
	        	addActors(actors[i], producer);
	        	//System.out.println("========"+actors[i].getActorId()); //Added by Yuan for testing
	            break;
	        default: // invalid type
	        	break;
	        }
		}
        
		if(dataBlocks.length > 0){
			DataObjectType dataObjects = dataProduced.addNewDataObject();
			addDataBlock(dataObjects);
		}
		if(annotations.length > 0){
			AnnotationType annotation = dataProduced.addNewAnnotations();
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dataProduced.setTimestamp(notificationTime);
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(dataProducedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(dataProducedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*notificationFile = "data_produced_"+notificationId+".xml";
		try {
			dataProducedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void createDataConsumedDoc(){
		DataConsumedDocument dataConsumedDoc = DataConsumedDocument.Factory.newInstance();
		DataLifeCycleType dataConsumed = dataConsumedDoc.addNewDataConsumed();
		EntityType consumer = dataConsumed.addNewActor();
		
		dataConsumed.setAction(ActionEnumType.CONSUME);
		
		//System.out.println("In Data-consumed: "+ actors.length);
        for (int i = 0; i < actors.length; i++) {        	
	        switch(actors[i].getActorType().intValue()){
	        // Actually, there should be only one consumer for an artifact
	        case ActorEnumType.INT_CONSUMER:
	        	addActors(actors[i], consumer);
	            break;
	        default: // invalid type
	        	break;
	        }
		}
        
		if(dataBlocks.length > 0){
			//System.out.println("In Data-consumed: "+ dataBlocks.length);
			DataObjectType dataObjects = dataConsumed.addNewDataObject();
			addDataBlock(dataObjects);
		}
		if(annotations.length > 0){
			AnnotationType annotation = dataConsumed.addNewAnnotations();
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dataConsumed.setTimestamp(notificationTime);
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(dataConsumedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(dataConsumedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*notificationFile = "data_consumed_"+notificationId+".xml";
		try {
			dataConsumedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void createDataSendStartedDoc(){
		DataSendStartedDocument dataSendStartedDoc = DataSendStartedDocument.Factory.newInstance();
		DataTransferType dataTransferType = dataSendStartedDoc.addNewDataSendStarted();
		EntityType sender = dataTransferType.addNewSender();
		
        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_SENDER:
	        	addActors(actors[i], sender);
	            break;
	        default: // invalid type
	        	break;
	        }
		}        
        
		if(dataBlocks.length > 0){
			// need to modify the API
			//DataEnumType.Enum dataType = dataBlocks[0].dataObjectType;
			DataObjectType dataObjects = dataTransferType.addNewFault();
			addDataBlock(dataObjects);
		}
		if(annotations.length > 0){
			AnnotationType annotation = dataTransferType.addNewAnnotations();
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(dataSendStartedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(dataSendStartedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*notificationFile = filePrefix+"_data_send_started_"+notificationId+".xml";
		try {
			dataSendStartedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void createDataSendFinishedDoc(){
		DataSendFinishedDocument dataSendFinishedDoc = DataSendFinishedDocument.Factory.newInstance();
		DataTransferType dataTransferType = dataSendFinishedDoc.addNewDataSendFinished();
		EntityType sender = dataTransferType.addNewSender();
		
        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_SENDER:
	        	addActors(actors[i], sender);
	            break;
	        default: // invalid type
	        	break;
	        }
		}        
        
		if(dataBlocks.length > 0){
			// need to modify the API
			//DataEnumType.Enum dataType = dataBlocks[0].dataObjectType;
			DataObjectType dataObjects = dataTransferType.addNewFault();
			addDataBlock(dataObjects);
		}
		if(annotations.length > 0){
			AnnotationType annotation = dataTransferType.addNewAnnotations();
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(dataSendFinishedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(dataSendFinishedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*notificationFile = filePrefix+"_data_send_finished_"+notificationId+".xml";
		try {
			dataSendFinishedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void createDataReceiveStartedDoc(){
		DataReceivedStartedDocument dataReceiveStartedDoc = DataReceivedStartedDocument.Factory.newInstance();
		DataTransferType dataTransferType = dataReceiveStartedDoc.addNewDataReceivedStarted();
		EntityType receiver = dataTransferType.addNewSender();
		
        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_RECEIVER:
	        	addActors(actors[i], receiver);
	            break;
	        default: // invalid type
	        	break;
	        }
		}        
        
		if(dataBlocks.length > 0){
			// need to modify the API
			//DataEnumType.Enum dataType = dataBlocks[0].dataObjectType;
			DataObjectType dataObjects = dataTransferType.addNewFault();
			addDataBlock(dataObjects);
		}
		if(annotations.length > 0){
			AnnotationType annotation = dataTransferType.addNewAnnotations();
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(dataReceiveStartedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(dataReceiveStartedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*notificationFile = filePrefix+"_data_receive_started_"+notificationId+".xml";
		try {
			dataReceiveStartedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void createDataReceiveFinishedDoc(){
		DataReceivedFinishedDocument dataReceiveFinishedDoc = DataReceivedFinishedDocument.Factory.newInstance();
		DataTransferType dataTransferType = dataReceiveFinishedDoc.addNewDataReceivedFinished();
		EntityType receiver = dataTransferType.addNewSender();
		
        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_RECEIVER:
	        	addActors(actors[i], receiver);
	            break;
	        default: // invalid type
	        	break;
	        }
		}        
        
		if(dataBlocks.length > 0){
			// need to modify the API
			//DataEnumType.Enum dataType = dataBlocks[0].dataObjectType;
			DataObjectType dataObjects = dataTransferType.addNewFault();
			addDataBlock(dataObjects);
		}
		if(annotations.length > 0){
			AnnotationType annotation = dataTransferType.addNewAnnotations();
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(dataReceiveFinishedDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(dataReceiveFinishedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*notificationFile = filePrefix+"_data_receive_finished_"+notificationId+".xml";
		try {
			dataReceiveFinishedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/		
		
	}
	
	public void createInvokingServiceDoc(){
		InvokingServiceDocument invokingServiceDoc = InvokingServiceDocument.Factory.newInstance();
        InvocationType invocationType = invokingServiceDoc.addNewInvokingService();
        EntityType invoker = invocationType.addNewInvoker();
        EntityType invokee = invocationType.addNewInvokee();        
        invocationType.setInvocationTime(notificationTime);

        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_INVOKER:
	        	addActors(actors[i], invoker);
	            break;
	        case ActorEnumType.INT_INVOKEE:
	        	addActors(actors[i], invokee);
	            break;
	        default: // invalid type
	        	break;
	        }
		}	
        
        if(dataBlocks.length > 0){
        	DataObjectType params = invocationType.addNewParams();
	        String dataBlockXML = createDataBlockXML();
	        BlockType block = params.addNewBlock();
	        try {
				block.setBlockContent(XmlObject.Factory.parse(dataBlockXML));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }		
		
        // Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(invokingServiceDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(invokingServiceDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*notificationFile = filePrefix+"_invoking_service_"+notificationId+".xml";
		try {
			invokingServiceDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void createInvokingWorkflowDoc(){
		InvokingWorkflowDocument invokingWorkflowDoc = InvokingWorkflowDocument.Factory.newInstance();
        InvocationType invocationType = invokingWorkflowDoc.addNewInvokingWorkflow();
        EntityType invoker = invocationType.addNewInvoker();
        EntityType invokee = invocationType.addNewInvokee();        
        invocationType.setInvocationTime(notificationTime);
        for (int i = 0; i < actors.length; i++) {
	        switch(actors[i].getActorType().intValue()){
	        case ActorEnumType.INT_INVOKER:
	        	addActors(actors[i], invoker);
	            break;
	        case ActorEnumType.INT_INVOKEE:
	        	addActors(actors[i], invokee);
	            break;
	        default: // invalid type
	        	break;
	        }
		}	
        
        if(dataBlocks.length > 0){
        	DataObjectType params = invocationType.addNewParams();
	        String dataBlockXML = createDataBlockXML();
	        BlockType block = params.addNewBlock();
	        try {
				block.setBlockContent(XmlObject.Factory.parse(dataBlockXML));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
				
        // Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(invokingWorkflowDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(invokingWorkflowDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        /*String invokingWorkflowXML = filePrefix+"_invoking_workflow_"+notificationId+".xml";
		try {
			invocationType.save(new File(invokingWorkflowXML));
			System.out.println("FILE SAVED: "+invokingWorkflowXML);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		
	}
	
	private EntityEnumType.Enum decodeActorEntityType(int actorEntityTye){
		switch(actorEntityTye){
		case ActorEntityEnumType.INT_METHOD:
			return EntityEnumType.METHOD;
		case ActorEntityEnumType.INT_SERVICE:
			return EntityEnumType.SERVICE;
		case ActorEntityEnumType.INT_WORKFLOW:
			return EntityEnumType.WORKFLOW;
		case ActorEntityEnumType.INT_USER:
			return EntityEnumType.USER;
		default:
			return null;
		}
	}
	
	public void createAddAnnotationDoc(){		
		AddAnnotationDocument addAnnotationDoc = AddAnnotationDocument.Factory.newInstance();
        AddAnnotationType addAnnotationType = addAnnotationDoc.addNewAddAnnotation();               
        
        if(actors.length > 0) {
        	AnnotableEntityType annotableEntity = addAnnotationType.addNewAnnotableEntity();
        	annotableEntity.setEntityID(actors[0].getActorId());
        	if(actors[0].getParentIds() != null){
        		annotableEntity.setContextEntityID(actors[0].getParentIds()[0]);
        	}
        	annotableEntity.setType(decodeActorEntityType(actors[0].getEntityType().intValue()));
        	addAnnotationType.setAnnotableObjectType(AnnotableObjectEnumType.ENTITY);
		}	
        
        if(dataBlocks.length > 0){
        	AnnotableFileType annotableFile = addAnnotationType.addNewAnnotableFile();
        	annotableFile.setFileURI(dataBlocks[0].getDataObjectId());
        	addAnnotationType.setAnnotableObjectType(AnnotableObjectEnumType.FILE);
        }
        
		if(annotations.length > 0){
			AnnotationType annotation = addAnnotationType.addNewAnnotations();
			String invocationProp = "add-annotations";
			annotation.setProperty(invocationProp);
			XmlObject xmlData = annotation.addNewValue();
			String annotationData = "<annotations>";
			for (int i = 0; i < annotations.length; i++) {
				String property = annotations[i].getProperty();
				String value = annotations[i].getValue();
				
				annotationData += "<annotation><property>"+property+
				"</property><value>"+value+"</value></annotation>";
			}
			annotationData += "</annotations>";
			try {
				xmlData.set(XmlObject.Factory.parse(annotationData));
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		addAnnotationType.setAnnotatingTimestamp(notificationTime);
		addAnnotationType.setNotificationtimestamp(notificationTime);
		
        //notificationFile = filePrefix+"_service_invoked_"+notificationId+".xml";
        //System.out.println(notificationFile);
        //notification = serviceInvokedDoc;
		
		// Yuan added the following line and removed the try/catch() block below that, for testing
		//System.out.println(addAnnotationDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		try {
			ingester.sendNotification(addAnnotationDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        /*notificationFile = "service_invoked_"+notificationId+".xml";
		try {
			serviceInvokedDoc.save(new File(notificationFile));
			System.out.println("FILE SAVED: "+notificationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void saveNotificationsDoc(){
		//System.out.println("Notification: " + notificationType.toString());
		switch(notificationType.intValue()){
		case NotificationEnumType.INT_SERVICE_INVOKED:
			createServiceInvokedDoc();
			break;
		case NotificationEnumType.INT_WORKFLOW_INVOKED:
			createWorkflowInvokedDoc();
			break;
		case NotificationEnumType.INT_DATA_PRODUCED:
			createDataProducedDoc();
			break;
		case NotificationEnumType.INT_DATA_CONSUMED:
			createDataConsumedDoc();
			break;
		case NotificationEnumType.INT_DATA_SEND_STARTED:
			createDataSendStartedDoc();
			break;
		case NotificationEnumType.INT_DATA_SEND_FINISHED:
			createDataSendFinishedDoc();
			break;
		case NotificationEnumType.INT_DATA_RECEIVE_STARTED:
			createDataReceiveStartedDoc();
			break;
		case NotificationEnumType.INT_DATA_RECEIVE_FINISHED:
			createDataReceiveFinishedDoc();
			break;
		case NotificationEnumType.INT_INVOKING_SERVICE:
			createInvokingServiceDoc();
			break;
		case NotificationEnumType.INT_INVOKING_WORKFLOW:
			createInvokingWorkflowDoc();
			break;
		case NotificationEnumType.INT_ADD_ANNOTATION:
			createAddAnnotationDoc();
			break;
		default:
			break;
		}
	}
	
	public void ingestNotifications(){
		int num_notification = 0;
		Set<NotificationData> notificationData = notificationList.entrySet();
		Iterator<NotificationData> iterator = notificationData.iterator();
		System.out.println("Ingesting Notifications...");
		while(iterator.hasNext()){
			Map.Entry mapData = (Map.Entry)iterator.next();
			List list = (List) notificationList.get(mapData.getKey());
			for (int i = 0; i < list.size(); i++) {
				NotificationData data = (NotificationData)list.get(i);
				notificationId = num_notification;
				notificationType = data.getNotificationType();
				notificationTime = data.getNotificationTime();
				Notifications notification = data.getNotification();
				actors = new Actor[notification.getActors().size()];
//				for(int j=0;j<notification.getActors().size();j++){
//					System.out.println("ACTOR_ID="+notification.getActors().get(j).getActorId());
//				}
				dataBlocks = new DataBlock[notification.getDataBlocks().size()];
				annotations = new Annotation[notification.getAnnotations().size()];
				notification.getActors().copyInto(actors);
				notification.getDataBlocks().copyInto(dataBlocks);
				notification.getAnnotations().copyInto(annotations);
				//System.out.println("Saving Notification Doc...");
				saveNotificationsDoc();
				num_notification++;
			}
		}
		System.out.println("Number of Notifications = "+ num_notification);
	}
	
}
