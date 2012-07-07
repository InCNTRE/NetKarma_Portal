package edu.indiana.d2i.netkarma.xsp.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.AnnotationType;
import org.dataandsearch.www.karma._2010._08.BlockType;
import org.dataandsearch.www.karma._2010._08.DataObjectType;
import org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataTransferType;
import org.dataandsearch.www.karma._2010._08.EntityEnumSubtype;
import org.dataandsearch.www.karma._2010._08.EntityEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
import org.dataandsearch.www.karma._2010._08.InvocationType;
import org.dataandsearch.www.karma._2010._08.LinkEntityDocument;
import org.dataandsearch.www.karma._2010._08.LinkEntityEnumType;
import org.dataandsearch.www.karma._2010._08.LinkEntityType;
import org.dataandsearch.www.karma._2010._08.LinkedType;
import org.dataandsearch.www.karma._2010._08.PersonnelEnumType;
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;
import org.dataandsearch.www.karma._2010._08.UserInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf;

import edu.indiana.dsi.karma.messaging.MessageConfig;
import edu.indiana.dsi.karma.messaging.MessagingOperationTypes;
import edu.indiana.dsi.karma.messaging.Sender;

public class RuntimeNotifications {
	private Ingester ingester = null;
	private Sender sender = null;
	private String instanceID = null;
	private String user = null;
	private String iperfLog = null;
	
	private RuntimeProvenance runtimeProvenance = null;
	private SliceProvenance sliceProvenance = null;
	
	public RuntimeNotifications(MessageConfig msgconf, RuntimeProvenance runtimeProvenance, 
			String instanceID, String user, String iperfLog){		
		this(msgconf, runtimeProvenance, instanceID, user, null, iperfLog);
	}
	
	public RuntimeNotifications(MessageConfig msgconf, RuntimeProvenance runtimeProvenance, 
			String instanceID, String user, SliceProvenance sliceProvenance, String iperfLog){
		try {
			this.sender = new Sender(msgconf, MessagingOperationTypes.SEND_NOTIFICATION);
			this.ingester = new Ingester(sender);
			this.runtimeProvenance = runtimeProvenance;
			this.instanceID = instanceID;
			this.user = user;
			this.sliceProvenance = sliceProvenance;
			this.iperfLog = iperfLog;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ingestDataSendStartedNotification(Calendar transferTime, String senderID, 
			String receiverID, String dataItem, Triplets<String, String, String> stats){
		DataSendStartedDocument dataSendStartedDoc = 
			DataSendStartedDocument.Factory.newInstance();
		DataTransferType dataTransferType = dataSendStartedDoc.addNewDataSendStarted();
		createDataSendNotification(dataTransferType, transferTime, senderID, receiverID, dataItem, stats);
		
		try {
			ingester.sendNotification(dataSendStartedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ingestDataSendFinishedNotification(Calendar transferTime, String senderID, 
			String receiverID, String dataItem, Triplets<String, String, String> stats){
		DataSendFinishedDocument dataSendFinishedDoc = 
			DataSendFinishedDocument.Factory.newInstance();
		DataTransferType dataTransferType = dataSendFinishedDoc.addNewDataSendFinished();
		createDataSendNotification(dataTransferType, transferTime, senderID, receiverID, dataItem, stats);
		
		try {
			ingester.sendNotification(dataSendFinishedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void createDataSendNotification(DataTransferType dataTransferType, 
			Calendar transferTime, String senderID, String receiverID, String dataItem, 
			Triplets<String, String, String> stats){
		EntityType sender = dataTransferType.addNewSender();
		EntityType receiver = dataTransferType.addNewReceiver();
		
		addService(sender, instanceID, senderID, 2, null);
		addService(receiver, instanceID, receiverID, 2, null);
		
		dataTransferType.setTransferTime(transferTime);
		
		DataObjectType transferData = dataTransferType.addNewResult();
		addDataObject(transferData, dataItem);
		
		AnnotationType[] annotationType = new AnnotationType[3];	
		for (int i = 0; i < annotationType.length; i++) {
			annotationType[i] = AnnotationType.Factory.newInstance();
		}		
		addAnnotations(annotationType[0], "Bytes Transferred", stats.getElementOne());
		addAnnotations(annotationType[1], "Avg Transfer Rate(MB/sec)", stats.getElementTwo());
		addAnnotations(annotationType[2], "Inst Transfer Rate(MB/sec)", stats.getElementThree());
		dataTransferType.setAnnotationsArray(annotationType);
	}
	
    public void ingestInvokingService(String workflowID, String invokerID,
    		String invokeeID, Triplets<String, String, String> stats, 
    		Calendar invocationTime, String dataItem, int invokerTimestep, 
    		int invokeeTimestep) {
        ServiceInvokedDocument serviceInvokedDoc = ServiceInvokedDocument.Factory
                .newInstance();
        InvocationType invocationType = serviceInvokedDoc
                .addNewServiceInvoked();

        invocationHelper(invocationType, workflowID, invokerID, invokeeID, 
        		invocationTime, dataItem, invokerTimestep, invokeeTimestep);

        AnnotationType[] annotationType = new AnnotationType[3];	
		for (int i = 0; i < annotationType.length; i++) {
			annotationType[i] = AnnotationType.Factory.newInstance();
		}		
		addAnnotations(annotationType[0], "Initial Bytes Transferred", stats.getElementOne());
		addAnnotations(annotationType[1], "Initial Avg Transfer Rate(MBps)", stats.getElementTwo());
		addAnnotations(annotationType[2], "Initial Inst Transfer Rate(MBps)", stats.getElementThree());
		invocationType.setAnnotationsArray(annotationType);
		
        try {
			ingester.sendNotification(serviceInvokedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }
    
    public void ingestServiceInvoked(String workflowID, String invokerID,
    		String invokeeID, Triplets<String, String, String> stats,
    		Calendar invocationTime, String dataItem, int invokerTimestep, 
    		int invokeeTimestep) {
        ServiceInvokedDocument serviceInvokedDoc = ServiceInvokedDocument.Factory
                .newInstance();
        InvocationType invocationType = serviceInvokedDoc
                .addNewServiceInvoked();

        invocationHelper(invocationType, workflowID, invokerID, invokeeID, 
        		invocationTime, dataItem, invokerTimestep, invokeeTimestep);

        if(stats != null){
        	NetworkMeasures networkMeasures = new NetworkMeasures();
        	networkMeasures.parseLogfile(iperfLog);
			AnnotationType[] annotationType = new AnnotationType[9];	
			for (int i = 0; i < annotationType.length; i++) {
				annotationType[i] = AnnotationType.Factory.newInstance();
			}		
			addAnnotations(annotationType[0], "Final Bytes Transferred", stats.getElementOne());
			addAnnotations(annotationType[1], "Final Avg Transfer Rate(MBps)", stats.getElementTwo());
			addAnnotations(annotationType[2], "Final Inst Transfer Rate(MBps)", stats.getElementThree());
			addAnnotations(annotationType[3], "Min Latency (ms)", networkMeasures.getMinLatency());
			addAnnotations(annotationType[4], "Max Latency (ms)", networkMeasures.getMaxLatency());
			addAnnotations(annotationType[5], "Avg Latency (ms)", networkMeasures.getAvgLatency());
			addAnnotations(annotationType[6], "Start Bandwidth (MBps)", networkMeasures.getStartBandwidth());
			addAnnotations(annotationType[7], "End Bandwidth (MBps)", networkMeasures.getEndBandwidth());
			if(networkMeasures.getDatagramLossPerc() != null){
				addAnnotations(annotationType[8], "Datagram Loss %", networkMeasures.getDatagramLossPerc());
			}
			else{
				addAnnotations(annotationType[8], "Datagram Loss %", "NA");
			}
			invocationType.setAnnotationsArray(annotationType);
        }
		
        try {
			ingester.sendNotification(serviceInvokedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }
    
	private void invocationHelper(InvocationType invocationType, String workflowID, 
			String invokerID, String invokeeID, Calendar invocationTime, 
			String dataItem, int invokerTimestep, int invokeeTimestep) {
		
		invocationType.setInvocationTime(invocationTime);
		
		EntityType invoker = invocationType.addNewInvoker();
		EntityType invokee = invocationType.addNewInvokee();

		//System.out.println(invokerID + "->" + invokeeID);
		addService(invoker, workflowID, invokerID, invokerTimestep, null);
		addService(invokee, workflowID, invokeeID, invokeeTimestep, null);

		if(dataItem != null){
			DataObjectType params = invocationType.addNewParams();
			addDataObject(params, dataItem);
		}
	}
	
    public void ingestServiceInvoked(String workflowID, String invokerID,
    		String invokeeID, String userDN,
    		Calendar invocationTime, String dataItem, int invokerTimestep, 
    		int invokeeTimestep) {
        ServiceInvokedDocument serviceInvokedDoc = ServiceInvokedDocument.Factory
                .newInstance();
        InvocationType invocationType = serviceInvokedDoc
                .addNewServiceInvoked();

        invocationHelper(invocationType, workflowID, userDN, invokerID, invokeeID, 
        		invocationTime, dataItem, invokerTimestep, invokeeTimestep);
		
        try {
			ingester.sendNotification(serviceInvokedDoc);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
    }
    
	private void invocationHelper(InvocationType invocationType, String workflowID, 
			String userDN, String invokerID, String invokeeID, Calendar invocationTime, 
			String dataItem, int invokerTimestep, int invokeeTimestep) {
		
		invocationType.setInvocationTime(invocationTime);
		
		EntityType invoker = invocationType.addNewInvoker();
		EntityType invokee = invocationType.addNewInvokee();

		//System.out.println(invokerID + "->" + invokeeID);
		addWorkflow(invoker, workflowID, userDN, invokerTimestep, null);
		addService(invokee, workflowID, invokeeID, invokeeTimestep, null);

		if(dataItem != null){
			DataObjectType params = invocationType.addNewParams();
			addDataObject(params, dataItem);
		}
	}
	
	public void ingestExecutedOnNotification(String program, String host, 
			Calendar time, int endPoint1Timestep, int endPoint2Timestep){
		LinkEntityDocument linkEntityDocument = LinkEntityDocument.Factory.newInstance();
		LinkEntityType linkEntityType = linkEntityDocument.addNewLinkEntity();
		EntityType endPoint1 = linkEntityType.addNewEndPoint1();
		linkEntityType.setLinkType(LinkEntityEnumType.EXECUTION);		
		LinkedType[] linkedType = new LinkedType[1];
		linkedType[0] = linkEntityType.addNewEndPoint2();
		EntityType endPoint2 = linkedType[0].addNewLinkedEntity();
		linkedType[0].setLinkTime(time);

		addService(endPoint2, instanceID, host, endPoint2Timestep, null);
		addService(endPoint1, instanceID, program, endPoint1Timestep, null);
		
		linkEntityType.setEndPoint2Array(linkedType);
		
		try {
			ingester.sendNotification(linkEntityDocument);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
	private void addAnnotations(AnnotationType annotation, String property,
			String value) {
		String xmlChunk = "<value>" + value + "</value>";        	
            annotation.setProperty(property);
            try {
                annotation.setValue(XmlObject.Factory.parse(xmlChunk));                
            } catch (Exception e) { e.printStackTrace(); }                 
	}
	
	private void addDataObject(DataObjectType params, String dataItem) {
		
		BlockType block = params.addNewBlock();
        try {
			block.setBlockContent(XmlObject.Factory.parse("<file>"+ dataItem +"</file>"));
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addUser(EntityType entity, String userDN){
		UserInformationType actorUser = entity.addNewUserInformation();
		actorUser.setUserDN(userDN);
		actorUser.setType(PersonnelEnumType.PERSON);
		entity.setType(EntityEnumType.USER);
	}
	
	public void addWorkflow(EntityType entity, String workflowID, String behalfID,
			int timestep, Annotation[] entityAnnotations){
		WorkflowInformationType actorWorkflow = entity.addNewWorkflowInformation();				    
        actorWorkflow.setWorkflowID(workflowID);
        
        if(behalfID != null){
        	UserBehalf userBehalf = actorWorkflow.addNewUserBehalf();
        	userBehalf.setUserDN(behalfID);
        	entity.setSubtype(EntityEnumSubtype.HUMAN_PROXY);
        }
   
        actorWorkflow.setTimestep(timestep);

        entity.setType(EntityEnumType.WORKFLOW);
        
		if(entityAnnotations != null){
			AnnotationType[] annotationTypes = new AnnotationType[entityAnnotations.length];				
			try {
				for (int i = 0; i < annotationTypes.length; i++) {
					annotationTypes[i] = actorWorkflow.addNewAnnotations();
					annotationTypes[i].setProperty(entityAnnotations[i].getProperty());
					String value = "<value>" + entityAnnotations[i].getValue() + "</value>";
					annotationTypes[i].setValue(XmlObject.Factory.parse(value));
				}
				actorWorkflow.setAnnotationsArray(annotationTypes);
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}

	}
	
	public void addService(EntityType entity, String workflowID, String serviceID,
			int timestep, Annotation[] entityAnnotations){
		ServiceInformationType actorService = entity.addNewServiceInformation();
		actorService.setServiceID(serviceID);
		actorService.setWorkflowID(workflowID);
        
		actorService.setTimestep(timestep);

		entity.setType(EntityEnumType.SERVICE);
        
		if(entityAnnotations != null){
			AnnotationType[] annotationTypes = new AnnotationType[entityAnnotations.length];				
			try {
				for (int i = 0; i < annotationTypes.length; i++) {
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
	}
	
	// HAVE TO IMPLEMENT ERROR_HANDLING
	public void ingestNotifications(){
		String senderIP = runtimeProvenance.getSourceIP();
		String receiverIP = runtimeProvenance.getDestIP();
		Calendar transferStartTime = runtimeProvenance.getStartTime();
		Calendar transferEndTime = runtimeProvenance.getEndTime();
		String dataItem = runtimeProvenance.getDataItem();
		String command = runtimeProvenance.getCommand();
		String execHost = runtimeProvenance.getExecHost();
		ArrayList<Triplets<String, String, String>> incrementalStats = 
			runtimeProvenance.getTransferStats(); 
		int numStats = incrementalStats.size();
		Triplets<String, String, String> initialStat = incrementalStats.get(0);
		Triplets<String, String, String> finalStat = incrementalStats.get(numStats-1);
		//ingestDataSendStartedNotification(transferStartTime, senderIP, receiverIP, dataItem, initialStat);
		//ingestDataSendFinishedNotification(transferEndTime, senderIP, receiverIP, dataItem, finalStat);
		ingestInvokingService(instanceID, "grid-ftp@"+senderIP, "grid-ftp@"+receiverIP, initialStat, 
				transferStartTime, dataItem, 2, 2);
		ingestServiceInvoked(instanceID, "grid-ftp@"+senderIP, "grid-ftp@"+receiverIP, finalStat, 
				transferEndTime, dataItem, 2, 2);
		
		//ingestExecutedOnNotification(command, execHost, transferStartTime);
		
		//Hashtable<String, String> nodeIPMap = new Hashtable<String, String>();
		ArrayList<Triplets<String, String, String>> hostsInfo = sliceProvenance.getHostInfo();
		for (int i = 0; i < hostsInfo.size(); i++) {
			Triplets<String, String, String> host = hostsInfo.get(i);
			//System.out.println(host.getElementOne()+"::"+host.getElementTwo()+"::"+
				//	host.getElementThree());
			String ip = host.getElementThree();
			if( ip != null &&
					(senderIP.equals(ip) || receiverIP.equals(ip))){
				//nodeIPMap.put(ip, host.getElementOne());
				//ingestServiceInvoked(instanceID, host.getElementOne(), ip, null, 
				//		transferStartTime, null, 1, 2);
				ingestExecutedOnNotification("grid-ftp@"+ip, host.getElementOne(), 
						transferStartTime, 2, 1);
				//System.out.println(host.getElementOne() + "::" + ip);
			}
		}
		String ip = null;
		//ArrayList<Triplets<String, String, String>> hostsInfo = sliceProvenance.getHostInfo();
		for (int i = 0; i < hostsInfo.size(); i++) {
			Triplets<String, String, String> host = hostsInfo.get(i);
			//System.out.println(host.getElementOne()+"::"+host.getElementTwo()+"::"+
				//	host.getElementThree());
			String hostname = host.getElementOne();
			if( hostname.equals(execHost)){
				ip =  host.getElementThree();
				if(ip != null){
					ingestExecutedOnNotification(command, "grid-ftp@"+ip, 
							transferStartTime, 2, 2);
					break;
				}
			}
		}
		
		ingestServiceInvoked(instanceID, instanceID, command, user, transferStartTime, null, -1, 2);
		
	}
	
	/*
	 * Close Messaging Channel
	 */
	public void closeChannel() {
		this.sender.closeChannel();
	}

	/*
	 * Close Messaging Channel and Close Message Bus Connection
	 */
	public void closeConnection() {
		this.sender.closeConnection();
	}

}
