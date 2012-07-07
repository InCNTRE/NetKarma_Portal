package edu.indiana.d2i.netkarma.xsp.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.AnnotationType;
import org.dataandsearch.www.karma._2010._08.EntityEnumSubtype;
import org.dataandsearch.www.karma._2010._08.EntityEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
import org.dataandsearch.www.karma._2010._08.LinkEntityDocument;
import org.dataandsearch.www.karma._2010._08.LinkEntityEnumType;
import org.dataandsearch.www.karma._2010._08.LinkEntityType;
import org.dataandsearch.www.karma._2010._08.LinkedType;
import org.dataandsearch.www.karma._2010._08.PersonnelEnumType;
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.UserInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf;

import edu.indiana.dsi.karma.messaging.MessageConfig;
import edu.indiana.dsi.karma.messaging.MessagingOperationTypes;
import edu.indiana.dsi.karma.messaging.Sender;

public class SliceNotifications {
	private Ingester ingester = null;
	private Sender sender = null;
	
	private String instanceID = null;
	private Calendar time = null;
	private String user = null;
	private SliceProvenance sliceProvenance = null;
	
	public SliceNotifications(MessageConfig msgconf, SliceProvenance sliceProvenance, 
			String instanceID, Calendar startTime, String user){
		try {
			this.sender = new Sender(msgconf, MessagingOperationTypes.SEND_NOTIFICATION);
			this.ingester = new Ingester(sender);
			this.sliceProvenance = sliceProvenance;
			this.instanceID = instanceID;
			this.user = user;
			this.time = startTime;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ingestExecutedOnNotification(String serviceID){
		LinkEntityDocument linkEntityDocument = LinkEntityDocument.Factory.newInstance();
		LinkEntityType linkEntityType = linkEntityDocument.addNewLinkEntity();
		EntityType endPoint1 = linkEntityType.addNewEndPoint1();
		linkEntityType.setLinkType(LinkEntityEnumType.EXECUTION);		
		LinkedType[] linkedType = new LinkedType[1];
		linkedType[0] = linkEntityType.addNewEndPoint2();
		EntityType endPoint2 = linkedType[0].addNewLinkedEntity();
		linkedType[0].setLinkTime(time);

		addWorkflow(endPoint1, instanceID, user, -1, null);
		addService(endPoint2, instanceID, serviceID, 1, null);
		
		linkEntityType.setEndPoint2Array(linkedType);
		
		try {
			ingester.sendNotification(linkEntityDocument);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ingestConnectedToNotification(String endpointID1, String endpointID2){
		LinkEntityDocument linkEntityDocument = LinkEntityDocument.Factory.newInstance();
		LinkEntityType linkEntityType = linkEntityDocument.addNewLinkEntity();
		EntityType endPoint1 = linkEntityType.addNewEndPoint1();
		linkEntityType.setLinkType(LinkEntityEnumType.CONNECTION);		
		LinkedType[] linkedType = new LinkedType[1];
		linkedType[0] = linkEntityType.addNewEndPoint2();
		EntityType endPoint2 = linkedType[0].addNewLinkedEntity();
		linkedType[0].setLinkTime(time);
		
		addService(endPoint1, instanceID, endpointID1, 1, null);
		addService(endPoint2, instanceID, endpointID2, 1, null);
		
		linkEntityType.setEndPoint2Array(linkedType);
		
		try {
			ingester.sendNotification(linkEntityDocument);
		} catch (XmlException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

	public void ingestNotifications(){
		/*ArrayList<String> nodeIDs = sliceProvenance.getNodeIDs();
		for (int i = 0; i < nodeIDs.size(); i++) {
			ingestExecutedOnNotification(nodeIDs.get(i));
		}*/
		
		ArrayList<Pair<String, String>> linkIDs = sliceProvenance.getLinkIDs();
		for (Iterator<Pair<String, String>> iterator = linkIDs.iterator(); iterator.hasNext();) {
			Pair<String, String> pair = (Pair<String, String>) iterator.next();
			String node1 = pair.getElementOne();
			String node2 = pair.getElementTwo();
			ingestConnectedToNotification(node1, node2);
		}
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
