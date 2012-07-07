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
# Project:  Karma Provenance Service
# File:  KarmaServiceSkeleton.java
# Description:  This file was auto-generated from WSDL by 
# Apache Axis2 version 1.4 built on 26 April 2008 at 06:24:30 EDT.
#
# -----------------------------------------------------------------
# 
 */

/**
 * KarmaServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */
package edu.indiana.dsi.karma;

import java.sql.Connection;

import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.service.Lifecycle;
import org.apache.log4j.Logger;
import org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.DataDeletedDocument;
import org.dataandsearch.www.karma._2010._08.DataUpdatedDocument;
import org.dataandsearch.www.karma._2010._08.UnknownDocument;
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
import org.dataandsearch.www.karma.query._2010._10.FormatEnumType;
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
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestType;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseType;
import org.openprovenance.model.v1_1_a.OPMGraph;
import org.w3.www._1999._02._22_rdf_syntax_ns.RdfType;

import edu.indiana.dsi.karma.ingest.IngestException;
import edu.indiana.dsi.karma.ingest.NotificationIngester;
import edu.indiana.dsi.karma.ingest.db.DBConnectionPool;
import edu.indiana.dsi.karma.query.QueryException;
import edu.indiana.dsi.karma.query.QueryImplementer;
import edu.indiana.dsi.karma.util.ServiceLauncher;

/**
 * KarmaServiceSkeleton java skeleton for the axisService
 * 
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 * @author Yuan Luo
 * @author You-Wei Cheah
 */
public class KarmaServiceSkeleton implements KarmaServiceSkeletonInterface,
		Lifecycle {

	public static final int DEFAULT_ASYNC_PROCESSOR_COUNT = 1;

	private static Logger log;

	private static NotificationIngester ingester;

	private static QueryImplementer querier;

	private static Boolean initialized = Boolean.FALSE;

	/**
	 * 
	 * @see org.apache.axis2.service.Lifecycle#init(org.apache.axis2.context.ServiceContext)
	 */
	public void init(ServiceContext sc) {
		synchronized (initialized) {
			if (!initialized.booleanValue()) {
				AxisService axisService = sc.getAxisService();

				String propertiesPath = (String) axisService
						.getParameterValue("karma.properties.file.path");

				// remove potential whitespace introduced in karma.properties
				if (propertiesPath != null)
					propertiesPath = propertiesPath.trim();

				ServiceLauncher.start(propertiesPath);

				log = Logger.getLogger(KarmaServiceSkeleton.class);

				if (log.isDebugEnabled())
					log.debug("in init");

				ingester = ServiceLauncher.getIngester();
				querier = ServiceLauncher.getQuerier();

				try {
					ingester.resetUnfinishedNotifications();
				} catch (IngestException e) {
					log.error("Error resetting unfinished notifications", e);
				}

				initialized = Boolean.TRUE;

			}
		}
	}

	/**
	 * 
	 * @see org.apache.axis2.service.Lifecycle#destroy(org.apache.axis2.context.ServiceContext)
	 */
	public void destroy(ServiceContext sc) {
		log.debug("in destroy");
		initialized = Boolean.FALSE;
		ServiceLauncher.shutdown();

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataSendFinished(org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument)
	 */
	public void dataSendFinished(
			org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument dataSendFinished0) {

		log.info(dataSendFinished0);
		try {
			ingester.ingestDataSendFinished(dataSendFinished0);
		} catch (IngestException ie) {
			log.error("Failed to ingest SendFinished", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#receivedResponse(org.dataandsearch.www.karma._2010._08.ReceivedResponseDocument)
	 */
	public void receivedResponse(
			org.dataandsearch.www.karma._2010._08.ReceivedResponseDocument receivedResponse1) {
		// print out notification
		log.info(receivedResponse1);

		try {
			ingester.ingestReceivedResponse(receivedResponse1);
		} catch (IngestException ie) {
			log.error("Failed to ingest ReceivedResponse", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#sendingResponseStatus(org.dataandsearch.www.karma._2010._08.SendingResponseStatusDocument)
	 */
	public void sendingResponseStatus(
			org.dataandsearch.www.karma._2010._08.SendingResponseStatusDocument sendingResponseStatus2) {
		log.info(sendingResponseStatus2);

		try {
			ingester.ingestSendingResponseStatus(sendingResponseStatus2);
		} catch (IngestException ie) {
			log.error("Failed to ingest SendingResponseStatus", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#serviceInitialized(org.dataandsearch.www.karma._2010._08.ServiceInitializedDocument)
	 */
	public void serviceInitialized(
			org.dataandsearch.www.karma._2010._08.ServiceInitializedDocument serviceInitialized3) {
		// print out notification
		log.info(serviceInitialized3);

		try {
			ingester.ingestServiceInitialized(serviceInitialized3);

		} catch (IngestException ie) {
			log.error("Failed to ingest ServiceInitialized", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#invokingWorkflow(org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument)
	 */
	public void invokingWorkflow(
			org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument invokingWorkflow4) {
		// print out notification
		log.info(invokingWorkflow4);

		try {
			ingester.ingestInvokingWorkflow(invokingWorkflow4);
		} catch (IngestException ie) {
			log.error("Failed to ingest InvokingWorkflow", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#sendingResponse(org.dataandsearch.www.karma._2010._08.SendingResponseDocument)
	 */
	public void sendingResponse(
			org.dataandsearch.www.karma._2010._08.SendingResponseDocument sendingResponse5) {
		// print out notification
		log.info(sendingResponse5.toString());

		try {
			ingester.ingestSendingResponse(sendingResponse5);
		} catch (IngestException ie) {
			log.error("Failed to ingest SendingResponse", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#serviceTerminated(org.dataandsearch.www.karma._2010._08.ServiceTerminatedDocument)
	 */
	public void serviceTerminated(
			org.dataandsearch.www.karma._2010._08.ServiceTerminatedDocument serviceTerminated6) {
		log.info(serviceTerminated6);

		try {
			ingester.ingestServiceTerminated(serviceTerminated6);
		} catch (IngestException ie) {
			log.error("Failed to ingest ServiceTerminated", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#invokingWorkflowStatus(org.dataandsearch.www.karma._2010._08.InvokingWorkflowStatusDocument)
	 */
	public void invokingWorkflowStatus(
			org.dataandsearch.www.karma._2010._08.InvokingWorkflowStatusDocument invokingWorkflowStatus7) {
		log.info(invokingWorkflowStatus7);
		try {
			ingester.ingestInvokingWorkflowStatus(invokingWorkflowStatus7);
		} catch (IngestException ie) {
			log.error("Failed to ingest WorkflowFailed", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#workflowTerminated(org.dataandsearch.www.karma._2010._08.WorkflowTerminatedDocument)
	 */
	public void workflowTerminated(
			org.dataandsearch.www.karma._2010._08.WorkflowTerminatedDocument workflowTerminated8) {
		log.info(workflowTerminated8);
		try {
			ingester.ingestWorkflowTerminated(workflowTerminated8);
		} catch (IngestException ie) {
			log.error("Failed to ingest WorkflowTerminated", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataConsumed(org.dataandsearch.www.karma._2010._08.DataConsumedDocument)
	 */
	public void dataConsumed(
			org.dataandsearch.www.karma._2010._08.DataConsumedDocument dataConsumed9) {
		// print out notification
		log.info(dataConsumed9.toString());

		try {
			ingester.ingestDataConsumed(dataConsumed9);
		} catch (IngestException ie) {
			log.error("Failed to ingest DataConsumed", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#invokingServiceStatus(org.dataandsearch.www.karma._2010._08.InvokingServiceStatusDocument)
	 */
	public void invokingServiceStatus(
			org.dataandsearch.www.karma._2010._08.InvokingServiceStatusDocument invokingServiceStatus10) {

		log.info(invokingServiceStatus10);
		try {
			ingester.ingestInvokingServiceStatus(invokingServiceStatus10);
		} catch (IngestException ie) {
			log.error("Failed to ingest InvokingServiceStatus", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#workflowInvoked(org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument)
	 */
	public void workflowInvoked(
			org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument workflowInvoked13) {

		log.info(workflowInvoked13);

		try {
			ingester.ingestWorkflowInvoked(workflowInvoked13);
		} catch (IngestException ie) {
			log.error("Failed to ingest WorkflowInvoked", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataSendStarted(org.dataandsearch.www.karma._2010._08.DataSendStartedDocument)
	 */
	public void dataSendStarted(
			org.dataandsearch.www.karma._2010._08.DataSendStartedDocument dataSendStarted14) {
		log.info(dataSendStarted14);
		try {
			ingester.ingestDataSendStarted(dataSendStarted14);
		} catch (IngestException ie) {
			log.error("Failed to ingest DataSendStarted", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#serviceInvoked(org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument)
	 */
	public void serviceInvoked(
			org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument serviceInvoked15) {

		log.info(serviceInvoked15.toString());

		try {
			ingester.ingestServiceInvoked(serviceInvoked15);
		} catch (IngestException ie) {
			log.error("Failed to ingest ServiceInvoked", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#receivedFault(org.dataandsearch.www.karma._2010._08.ReceivedFaultDocument)
	 */
	public void receivedFault(
			org.dataandsearch.www.karma._2010._08.ReceivedFaultDocument receivedFault16) {

		log.info(receivedFault16);
		try {
			ingester.ingestReceivedFault(receivedFault16);
		} catch (IngestException ie) {
			log.error("Failed to ingest ReceivedFault", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#invokingService(org.dataandsearch.www.karma._2010._08.InvokingServiceDocument)
	 */
	public void invokingService(
			org.dataandsearch.www.karma._2010._08.InvokingServiceDocument invokingService17) {

		log.info(invokingService17.toString());

		try {
			ingester.ingestInvokingService(invokingService17);
		} catch (IngestException ie) {
			log.error("Failed to ingest InvokingService", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataReceivedStarted(org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument)
	 */
	public void dataReceivedStarted(
			org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument dataReceivedStarted18) {

		log.info(dataReceivedStarted18);
		try {
			ingester.ingestDataReceivedStarted(dataReceivedStarted18);
		} catch (IngestException ie) {
			log.error("Failed to ingest DataReceivedStarted", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataReceivedFinished(org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument)
	 */
	public void dataReceivedFinished(
			org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument dataReceivedFinished19) {
		log.info(dataReceivedFinished19);
		try {
			ingester.ingestDataReceivedFinished(dataReceivedFinished19);
		} catch (IngestException ie) {
			log.error("Failed to ingest DataReceivedFinished", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataProduced(org.dataandsearch.www.karma._2010._08.DataProducedDocument)
	 */
	public void dataProduced(
			org.dataandsearch.www.karma._2010._08.DataProducedDocument dataProduced21) {

		log.info(dataProduced21.toString());

		try {
			ingester.ingestDataProduced(dataProduced21);
		} catch (IngestException ie) {
			log.error("Failed to ingest DataProduced", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#workflowInitialized(org.dataandsearch.www.karma._2010._08.WorkflowInitializedDocument)
	 */
	public void workflowInitialized(
			org.dataandsearch.www.karma._2010._08.WorkflowInitializedDocument worklowInitialized22) {

		log.info(worklowInitialized22);
		try {
			ingester.ingestWorkflowInitialized(worklowInitialized22);
		} catch (IngestException ie) {
			log.error("Failed to ingest WorkflowInitialized", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#sendingFault(org.dataandsearch.www.karma._2010._08.SendingFaultDocument)
	 */
	public void sendingFault(
			org.dataandsearch.www.karma._2010._08.SendingFaultDocument sendingFault23) {
		// print out notification
		log.info(sendingFault23);

		try {
			ingester.ingestSendingFault(sendingFault23);
		} catch (IngestException ie) {
			log.error("Failed to ingest SendingFault", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#workflowFailed(org.dataandsearch.www.karma._2010._08.WorkflowFailedDocument)
	 */
	public void workflowFailed(
			org.dataandsearch.www.karma._2010._08.WorkflowFailedDocument workflowFailed24) {

		log.info(workflowFailed24);

		try {
			ingester.ingestWorkflowFailed(workflowFailed24);
		} catch (IngestException ie) {
			log.error("Failed to ingest WorkflowFailed", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataDeleted(org.dataandsearch.www.karma._2010._08.DataDeletedDocument)
	 */
	@Override
	public void dataDeleted(DataDeletedDocument dataDeleted) {
		log.info(dataDeleted);

		try {
			ingester.ingestDataDeleted(dataDeleted);
		} catch (IngestException ie) {
			log.error("Failed to ingest DataDeleted", ie);
		}

	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#dataUpdated(org.dataandsearch.www.karma._2010._08.DataUpdatedDocument)
	 */
	@Override
	public void dataUpdated(DataUpdatedDocument dataUpdated) {
		log.info(dataUpdated);
		try {
			ingester.ingestDataUpdated(dataUpdated);
		} catch (IngestException ie) {
			log.error("Failed to ingest DataUpdated", ie);
		}
	}

	/**
	 * 
	 * @see edu.indiana.dsi.karma.KarmaServiceSkeletonInterface#storeUnknown(org.dataandsearch.www.karma._2010._08.UnknownDocument)
	 */
	@Override
	public void storeUnknown(UnknownDocument unknown) {
		log.info(unknown);

		try {
			ingester.ingestUnknownNotification(unknown);
		} catch (IngestException ie) {
			log.error("Failed to ingest Unknown", ie);
		}

	}

	@Override
	public CompareWorkflowGraphsResponseDocument compareWorkflowGraphs(
			CompareWorkflowGraphsRequestDocument compareWorkflowGraphsRequest) {
		log.info(compareWorkflowGraphsRequest);

		CompareWorkflowGraphsResponseDocument compareWorkflowGraphsResponseDocument = null;

		try {
			compareWorkflowGraphsResponseDocument = querier
					.compareWorkflowGraphs(compareWorkflowGraphsRequest);
		} catch (QueryException qe) {
			log.error("Failed to query compareWorkflowGraphs");
		}

		return compareWorkflowGraphsResponseDocument;
	}

	@Override
	public FindAbstractDataProductResponseDocument findAbstractDataProduct(
			FindAbstractDataProductRequestDocument findAbstractDataProductRequest) {
		log.info(findAbstractDataProductRequest);

		FindAbstractDataProductResponseDocument findAbstractDataProductResponseDocument = null;

		try {
			findAbstractDataProductResponseDocument = querier
					.findAbstractDataProduct(findAbstractDataProductRequest);
		} catch (QueryException qe) {
			log.error("Failed to query findAbstractDataProduct");
		}

		return findAbstractDataProductResponseDocument;
	}

	@Override
	public FindAbstractMethodResponseDocument findAbstractMethod(
			FindAbstractMethodRequestDocument findAbstractMethodRequest) {
		log.info(findAbstractMethodRequest);

		FindAbstractMethodResponseDocument findAbstractMethodResponseDocument = null;

		try {
			findAbstractMethodResponseDocument = querier
					.findAbstractMethod(findAbstractMethodRequest);
		} catch (QueryException qe) {
			log.error("Failed to query findAbstractMethod");
		}

		return findAbstractMethodResponseDocument;
	}

	@Override
	public FindAbstractServiceResponseDocument findAbstractService(
			FindAbstractServiceRequestDocument findAbstractServiceRequest) {
		log.info(findAbstractServiceRequest);

		FindAbstractServiceResponseDocument findAbstractServiceResponseDocument = null;

		try {
			findAbstractServiceResponseDocument = querier
					.findAbstractService(findAbstractServiceRequest);
		} catch (QueryException qe) {
			log.error("Failed to query findAbstractService");
		}

		return findAbstractServiceResponseDocument;
	}

	@Override
	public FindDataProductResponseDocument findDataProduct(
			FindDataProductRequestDocument findDataProductRequest) {
		log.info(findDataProductRequest);

		FindDataProductResponseDocument findDataProductResponseDocument = null;

		try {
			findDataProductResponseDocument = querier
					.findDataProduct(findDataProductRequest);
		} catch (QueryException qe) {
			log.error("Failed to query findDataProduct");
		}

		return findDataProductResponseDocument;
	}

	@Override
	public FindMethodInvocationResponseDocument findMethodInvocation(
			FindMethodInvocationRequestDocument findMethodInvocationRequest) {
		log.info(findMethodInvocationRequest);

		FindMethodInvocationResponseDocument findMethodInvocationResponseDocument = null;

		try {
			findMethodInvocationResponseDocument = querier
					.findMethodInvocation(findMethodInvocationRequest);
		} catch (QueryException qe) {
			log.error("Failed to query findMethodInvocation");
		}

		return findMethodInvocationResponseDocument;
	}

	@Override
	public FindServiceResponseDocument findService(
			FindServiceRequestDocument findServiceRequest) {
		log.info(findServiceRequest);

		FindServiceResponseDocument findServiceResponseDocument = null;

		try {
			findServiceResponseDocument = querier
					.findService(findServiceRequest);
		} catch (QueryException qe) {
			log.error("Failed to query findService");
		}

		return findServiceResponseDocument;
	}

	@Override
	public GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetail(
			GetAbstractDataProductDetailRequestDocument getAbstractDataProductDetailRequest) {
		log.info(getAbstractDataProductDetailRequest);

		GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetailResponseDocument = null;

		try {
			getAbstractDataProductDetailResponseDocument = querier
					.getAbstractDataProductDetail(getAbstractDataProductDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getAbstractDataProductDetail");
		}

		return getAbstractDataProductDetailResponseDocument;
	}

	@Override
	public GetAbstractMethodDetailResponseDocument getAbstractMethodDetail(
			GetAbstractMethodDetailRequestDocument getAbstractMethodDetailRequest) {
		log.info(getAbstractMethodDetailRequest);

		GetAbstractMethodDetailResponseDocument getAbstractMethodDetailResponseDocument = null;

		try {
			getAbstractMethodDetailResponseDocument = querier
					.getAbstractMethodDetail(getAbstractMethodDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getAbstractMethodDetail");
		}

		return getAbstractMethodDetailResponseDocument;
	}

	@Override
	public GetAbstractServiceDetailResponseDocument getAbstractServiceDetail(
			GetAbstractServiceDetailRequestDocument getAbstractServiceDetailRequest) {
		log.info(getAbstractServiceDetailRequest);

		GetAbstractServiceDetailResponseDocument getAbstractServiceDetailResponseDocument = null;

		try {
			getAbstractServiceDetailResponseDocument = querier
					.getAbstractServiceDetail(getAbstractServiceDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getAbstractServiceDetail");
		}

		return getAbstractServiceDetailResponseDocument;
	}

	@Override
	public GetAnnotationDetailResponseDocument getAnnotationDetail(
			GetAnnotationDetailRequestDocument getAnnotationDetailRequest) {
		log.info(getAnnotationDetailRequest);

		GetAnnotationDetailResponseDocument getAnnotationDetailResponseDocument = null;

		try {
			getAnnotationDetailResponseDocument = querier
					.getAnnotationDetail(getAnnotationDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getAnnotationDetail");
		}

		return getAnnotationDetailResponseDocument;
	}

	@Override
	public GetClientDetailResponseDocument getClientDetail(
			GetClientDetailRequestDocument getClientDetailRequest) {
		log.info(getClientDetailRequest);

		GetClientDetailResponseDocument getClientDetailResponseDocument = null;

		try {
			getClientDetailResponseDocument = querier
					.getClientDetail(getClientDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getClientDetail");
		}

		return getClientDetailResponseDocument;
	}

	@Override
	public GetDataProductDetailResponseDocument getDataProductDetail(
			GetDataProductDetailRequestDocument getDataProductDetailRequest) {
		log.info(getDataProductDetailRequest);

		GetDataProductDetailResponseDocument getDataProductDetailResponseDocument = null;

		try {
			getDataProductDetailResponseDocument = querier
					.getDataProductDetail(getDataProductDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getDataProductDetail");
		}

		return getDataProductDetailResponseDocument;
	}

	@Override
	public GetNodeCountOfGraphResponseDocument getNodeCountOfGraph(
			GetNodeCountOfGraphRequestDocument getNodeCountOfGraphRequest) {
		log.info(getNodeCountOfGraphRequest);

		GetNodeCountOfGraphResponseDocument getNodeCountOfGraphResponseDocument = null;

		try {
			getNodeCountOfGraphResponseDocument = querier
					.getNodeCountOfGraph(getNodeCountOfGraphRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getNodeCountOfGraph");
		}

		return getNodeCountOfGraphResponseDocument;
	}

	@Override
	public GetProvenanceHistoryResponseDocument getProvenanceHistory(
			GetProvenanceHistoryRequestDocument getProvenanceHistoryRequest) {
		// TODO Auto-generated method stub
		log.info(getProvenanceHistoryRequest);

		GetProvenanceHistoryResponseDocument getProvenanceHistoryResponseDocument = null;

		try {
			getProvenanceHistoryResponseDocument = querier
					.getProvenanceHistory(getProvenanceHistoryRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getProvenanceHistory");
		}

		return getProvenanceHistoryResponseDocument;
	}

	@Override
	public GetServiceDetailResponseDocument getServiceDetail(
			GetServiceDetailRequestDocument getServiceDetailRequest) {
		log.info(getServiceDetailRequest);
		GetServiceDetailResponseDocument getServiceDetailResponseDocument = null;

		try {
			getServiceDetailResponseDocument = querier
					.getServiceDetail(getServiceDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getServiceDetail");
		}

		return getServiceDetailResponseDocument;
	}

	@Override
	public GetWorkflowGraphResponseDocument getWorkflowGraph(
			GetWorkflowGraphRequestDocument getWorkflowGraphRequest) {

		log.info(getWorkflowGraphRequest);
		GetWorkflowGraphResponseDocument getWorkflowGraphResponseDocument = null;

		try {
			getWorkflowGraphResponseDocument = querier
					.getWorkflowGraph(getWorkflowGraphRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getWorkflowGraph");
		}

		return getWorkflowGraphResponseDocument;
	}

	@Override
	public GetMethodInvocationDetailResponseDocument getMethodInvocationDetail(
			GetMethodInvocationDetailRequestDocument getMethodInvocationDetailRequest) {
		log.info(getMethodInvocationDetailRequest);
		GetMethodInvocationDetailResponseDocument getMethodInvocationDetailResponseDocument = null;

		try {
			getMethodInvocationDetailResponseDocument = querier
					.getMethodInvocationDetail(getMethodInvocationDetailRequest);
		} catch (QueryException qe) {
			log.error("Failed to query getMethodInvocationDetail");
		}

		return getMethodInvocationDetailResponseDocument;
	}

	@Override
	public void addAnnotation(AddAnnotationDocument addAnnotationDoc) {
		// TODO Auto-generated method stub
		log.info(addAnnotationDoc);
		try {
			ingester.addAnnotation(addAnnotationDoc);
		} catch (IngestException ie) {
			log.error("Failed to add annotations", ie);
		}
	}

	@Override
	public void addMultipleObjectAnnotation(
			AddMultipleObjectAnnotationDocument addMultipleObjectAnnotationDoc) {
		// TODO Auto-generated method stub
		log.info(addMultipleObjectAnnotationDoc);
		try {
			ingester.addMultipleObjectAnnotation(addMultipleObjectAnnotationDoc);
		} catch (IngestException ie) {
			log.error("Failed to add annotations for multiple objects", ie);
		}
	}

	@Override
	public void addAnnotationById(AddAnnotationByIdDocument addAnnotationByIdDoc) {
		// TODO Auto-generated method stub
		log.info(addAnnotationByIdDoc);
		try {
			ingester.addAnnotationById(addAnnotationByIdDoc);
		} catch (IngestException ie) {
			log.error("Failed to add annotations by id", ie);
		}
	}

	@Override
	public void addRelationshipAnnotationById(
			AddRelationshipAnnotationByIdDocument addRelationshipAnnotationByIdDoc) {
		// TODO Auto-generated method stub
		log.info(addRelationshipAnnotationByIdDoc);
		try {
			ingester.addRelationshipAnnotationById(addRelationshipAnnotationByIdDoc);
		} catch (IngestException ie) {
			log.error("Failed to add relationship annotations by id", ie);
		}		
	}
}
