package edu.indiana.dsi.karma.messaging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.DataConsumedDocument;
import org.dataandsearch.www.karma._2010._08.DataDeletedDocument;
import org.dataandsearch.www.karma._2010._08.DataProducedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataUpdatedDocument;
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
import org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseDocument;

import org.dataandsearch.www.karma._2010._08.*;


import edu.indiana.dsi.karma.ingest.IngestException;
import edu.indiana.dsi.karma.ingest.NotificationIngester;
import edu.indiana.dsi.karma.ingest.NotificationSummary;
import edu.indiana.dsi.karma.query.QueryException;
import edu.indiana.dsi.karma.query.QueryImplementer;
import edu.indiana.dsi.karma.query.QuerySummary.QueryTypeEnum;

/**
 * @author Yuan Luo (yuanluo@indiana.edu)
 */

public class KarmaOperations {
	public static final Log l = LogFactory.getLog(KarmaOperations.class);
	public static final String  ERROR_STRING = "SERVER ERROR";


	/*
	public enum NotificationType {
		receivedResponse,
		receivedFault,
		workflowInitialized,
		serviceInitialized,
		workflowTerminated,
		serviceTerminated,
		serviceInvoked,
		workflowInvoked,
		dataConsumed,
		dataProduced,
		dataUpdated,
		dataDeleted,
		sendingResponse,
		sendingResponseStatus,
		dataSendStarted,
		dataSendFinished,
		dataReceivedStarted,
		sendingFault,
		storeUnknown
	}
	*/
	

	public static void storeNotification(NotificationIngester ingester, NotificationSummary.NotificationTypeEnum notificationType, String notification){
		
		try {
			switch(notificationType){
				case RECEIVED_RESPONSE:
					ingester.ingestReceivedResponse(ReceivedResponseDocument.Factory.parse(notification));
					return;
				case RECEIVED_FAULT:
					ingester.ingestReceivedFault(ReceivedFaultDocument.Factory.parse(notification));
					return;
				case INVOKING_WORKFLOW:
					ingester.ingestInvokingWorkflow(InvokingWorkflowDocument.Factory.parse(notification));
					return;
				case INVOKING_SERVICE:
					ingester.ingestInvokingService(InvokingServiceDocument.Factory.parse(notification));
					return;
				case INVOKING_WORKFLOW_STATUS:
					ingester.ingestInvokingWorkflowStatus(InvokingWorkflowStatusDocument.Factory.parse(notification));
					return;
				case INVOKING_SERVICE_STATUS:
					ingester.ingestInvokingServiceStatus(InvokingServiceStatusDocument.Factory.parse(notification));
					return;
				case WORKFLOW_INITIALIZED:
					ingester.ingestWorkflowInitialized(WorkflowInitializedDocument.Factory.parse(notification));
					return;
				case SERVICE_INITIALIZED:
					ingester.ingestServiceInitialized(ServiceInitializedDocument.Factory.parse(notification));
					return;
				case WORKFLOW_TERMINATED:
					ingester.ingestWorkflowTerminated(WorkflowTerminatedDocument.Factory.parse(notification));
					return;
				case SERVICE_TERMINATED:
					ingester.ingestServiceTerminated(ServiceTerminatedDocument.Factory.parse(notification));
					return;
				case SERVICE_INVOKED:
					ingester.ingestServiceInvoked(ServiceInvokedDocument.Factory.parse(notification));
					return;
				case WORKFLOW_INVOKED:
					ingester.ingestWorkflowInvoked(WorkflowInvokedDocument.Factory.parse(notification));
					return;
				case DATA_CONSUMED:
					ingester.ingestDataConsumed(DataConsumedDocument.Factory.parse(notification));
					return;
				case DATA_PRODUCED:
					ingester.ingestDataProduced(DataProducedDocument.Factory.parse(notification));
					return;
				case DATA_UPDATED:
					ingester.ingestDataUpdated(DataUpdatedDocument.Factory.parse(notification));
					return;
				case WORKFLOW_FAILED:
					ingester.ingestWorkflowFailed(WorkflowFailedDocument.Factory.parse(notification));
					return;
				case DATA_DELETED:
					ingester.ingestDataDeleted(DataDeletedDocument.Factory.parse(notification));
					return;
				case SENDING_RESPONSE:
					ingester.ingestSendingResponse(SendingResponseDocument.Factory.parse(notification));
					return;
				case SENDING_RESPONSE_STATUS:
					ingester.ingestSendingResponseStatus(SendingResponseStatusDocument.Factory.parse(notification));
					return;
				case DATA_SEND_STARTED:
					ingester.ingestDataSendStarted(DataSendStartedDocument.Factory.parse(notification));
					return;
				case DATA_SEND_FINISHED:
					ingester.ingestDataSendFinished(DataSendFinishedDocument.Factory.parse(notification));
					return;
				case DATA_RECEIVED_STARTED:
					ingester.ingestDataReceivedStarted(DataReceivedStartedDocument.Factory.parse(notification));
					return;
				case DATA_RECEIVED_FINISHED:
					ingester.ingestDataReceivedFinished(DataReceivedFinishedDocument.Factory.parse(notification));
					return;
				case SENDING_FAULT:
					ingester.ingestSendingFault(SendingFaultDocument.Factory.parse(notification));
					return;
				case ADD_ANNOTATION:
					ingester.addAnnotation(AddAnnotationDocument.Factory.parse(notification));
					return;
				case ADD_ANNOTATION_BY_ID:
					ingester.addAnnotationById(AddAnnotationByIdDocument.Factory.parse(notification));
					return;
				case ADD_MULTIPLE_OBJECT_ANNOTATION:
					ingester.addMultipleObjectAnnotation(AddMultipleObjectAnnotationDocument.Factory.parse(notification));
					return;
				case ADD_RELATIONSHIP_ANNOTATION_BY_ID:
					ingester.addRelationshipAnnotationById(AddRelationshipAnnotationByIdDocument.Factory.parse(notification));
					return;
				case UNKNOWN_TYPES:
					ingester.ingestUnknownNotification(UnknownDocument.Factory.parse(notification));
					return;
				default:
					return;
		
			}
		} catch (IngestException e1) {
			e1.printStackTrace();
			l.error("Ingest Exception.");
			l.error(e1.getStackTrace());
		} catch (XmlException e) {
			l.error("XML Exception.");
			l.error(e.getStackTrace());
		}
	}

	public static String queryProvenance(QueryImplementer querier, XmlObject query){
		try {
			QueryTypeEnum QueryType= QueryTypeEnum.determineQueryTypeFromXmlBeansDocument(query);
			switch(QueryType){
			case COMPARE_WORKFLOW_GRAPHS:
				CompareWorkflowGraphsResponseDocument compareWorkflowGraphsResponseDocument = null;

				try {
					compareWorkflowGraphsResponseDocument = querier.compareWorkflowGraphs((CompareWorkflowGraphsRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in compareWorkflowGraphs().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return compareWorkflowGraphsResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());

			case FIND_ABSTRACT_DATA_PRODUCT:
				FindAbstractDataProductResponseDocument findAbstractDataProductResponseDocument = null;

				try {
					findAbstractDataProductResponseDocument = querier.findAbstractDataProduct((FindAbstractDataProductRequestDocument)query);
				} catch (QueryException qe) {	
					l.error("Error in findAbstractDataProduct().");
					l.error(qe.getMessage());					
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return findAbstractDataProductResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case FIND_ABSTRACT_METHOD:
				FindAbstractMethodResponseDocument findAbstractMethodResponseDocument = null;

				try {
					findAbstractMethodResponseDocument = querier.findAbstractMethod((FindAbstractMethodRequestDocument)query);
				} catch (QueryException qe) {	
					l.error("Error in findAbstractMethod().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}
				
				return findAbstractMethodResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case FIND_ABSTRACT_SERVICE:
				FindAbstractServiceResponseDocument findAbstractServiceResponseDocument = null;

				try {
					findAbstractServiceResponseDocument = querier.findAbstractService((FindAbstractServiceRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in findAbstractService().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return findAbstractServiceResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case FIND_DATA_PRODUCT:
				FindDataProductResponseDocument findDataProductResponseDocument = null;

				try {
					findDataProductResponseDocument = querier.findDataProduct((FindDataProductRequestDocument)query);
				} catch (QueryException qe) {	
					l.error("Error in findDataProduct().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return findDataProductResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case FIND_METHOD_INVOCATION:
				FindMethodInvocationResponseDocument findMethodInvocationResponseDocument = null;

				try {
					findMethodInvocationResponseDocument = querier.findMethodInvocation((FindMethodInvocationRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in findMethodInvocation().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return findMethodInvocationResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case FIND_SERVICE:
				FindServiceResponseDocument findServiceResponseDocument = null;

				try {
					findServiceResponseDocument = querier.findService((FindServiceRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in findService().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return findServiceResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
		
			case GET_ABSTRACT_DATA_PRODUCT_DETAIL:
				GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetailResponseDocument = null;

				try {
					getAbstractDataProductDetailResponseDocument = querier.getAbstractDataProductDetail((GetAbstractDataProductDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getAbstractDataProductDetail().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getAbstractDataProductDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case GET_ABSTRACT_METHOD_DETAIL:
				GetAbstractMethodDetailResponseDocument getAbstractMethodDetailResponseDocument = null;

				try {
					getAbstractMethodDetailResponseDocument = querier.getAbstractMethodDetail((GetAbstractMethodDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getAbstractMethodDetail().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getAbstractMethodDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case GET_ABSTRACT_SERVICE_DETAIL:
				GetAbstractServiceDetailResponseDocument getAbstractServiceDetailResponseDocument = null;

				try {
					getAbstractServiceDetailResponseDocument = querier
							.getAbstractServiceDetail((GetAbstractServiceDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getAbstractServiceDetail().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getAbstractServiceDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case GET_ANNOTATION_DETAIL:
				GetAnnotationDetailResponseDocument getAnnotationDetailResponseDocument = null;

				try {
					getAnnotationDetailResponseDocument = querier
							.getAnnotationDetail((GetAnnotationDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getAnnotationDetail().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getAnnotationDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case GET_CLIENT_DETAIL:
				GetClientDetailResponseDocument getClientDetailResponseDocument = null;

				try {
					getClientDetailResponseDocument = querier.getClientDetail((GetClientDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getClientDetail()");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getClientDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
				
			case GET_DATA_PRODUCT_DETAIL:
				GetDataProductDetailResponseDocument getDataProductDetailResponseDocument = null;

				try {
					getDataProductDetailResponseDocument = querier
							.getDataProductDetail((GetDataProductDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getDataProductDetail().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getDataProductDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case GET_SERVICE_DETAIL:
				GetServiceDetailResponseDocument getServiceDetailResponseDocument = null;

				try {
					getServiceDetailResponseDocument = querier.getServiceDetail((GetServiceDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getServiceDetail().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getServiceDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			case GET_METHOD_INVOCATION_DETAIL:
				GetMethodInvocationDetailResponseDocument getMethodInvocationDetailResponseDocument = null;

				try {
					getMethodInvocationDetailResponseDocument = querier.getMethodInvocationDetail((GetMethodInvocationDetailRequestDocument)query);
				} catch (QueryException qe) {
					l.error("Error in getMethodInvocationDetail().");
					l.error(qe.getMessage());
					return ERROR_STRING + ": " + qe.getMessage();
				}

				return getMethodInvocationDetailResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
			
			
			case GET_WORKFLOW_GRAPH:
					/*
					String instanceID = ((GetOPMDocument)query).getGetOPM().getIn();
					Connection connection = null;
					OpmGraphDocument opmGraphDoc = null;
					try {
					    connection = DBConnectionPool.getInstance().getEntry();
					    opmGraphDoc = QueryByWorkflowURIUtil.getOPMGraphDocument(connection, instanceID);
					} finally {
					    if (connection != null) {
					        DBConnectionPool.getInstance().releaseEntry(connection);
					    }
					}
					return opmGraphDoc.xmlText(new XmlOptions().setSavePrettyPrint());
					*/
					
					GetWorkflowGraphResponseDocument getWorkflowGraphResponseDocument = null;
					
					try {			
						getWorkflowGraphResponseDocument = querier.getWorkflowGraph((GetWorkflowGraphRequestDocument)query);			
					} catch (QueryException qe) {
						l.error("Error in getWorkflowGraph().");
						l.error(qe.getMessage());
						return ERROR_STRING + ": " + qe.getMessage();
					}
					return getWorkflowGraphResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());
				
				case GET_PROVENANCE_HISTORY:
					GetProvenanceHistoryResponseDocument getProvenanceHistoryResponseDocument = null;
					try {
						getProvenanceHistoryResponseDocument = querier.getProvenanceHistory((GetProvenanceHistoryRequestDocument)query);		
					} catch (QueryException qe) {	
						l.error("Error in getProvenanceHistory().");
						l.error(qe.getMessage());
						return ERROR_STRING + ": " + qe.getMessage();
					}
					return getProvenanceHistoryResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());

				case GET_NODE_COUNT_OF_GRAPH:	
					GetNodeCountOfGraphResponseDocument getNodeCountOfGraphResponseDocument = null;
					try {
						getNodeCountOfGraphResponseDocument = querier.getNodeCountOfGraph((GetNodeCountOfGraphRequestDocument)query);
					} catch (QueryException qe) {
						l.error("Error in getNodeCountOfGraph().");
						l.error(qe.getMessage());
						return ERROR_STRING + ": " + qe.getMessage();
					}
					return getNodeCountOfGraphResponseDocument.xmlText(new XmlOptions().setSavePrettyPrint());

				case UNKNOWN_TYPES:
					l.error("Unknown query type.");					
					return "Unknown Query";
				default:
					l.error("Unknown query type.");
					return "Unknown Query";
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "[Exception in queryProvenance]" + e.getMessage();
		}
	}
}
