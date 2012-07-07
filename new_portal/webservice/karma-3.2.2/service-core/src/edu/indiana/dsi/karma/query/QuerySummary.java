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
package edu.indiana.dsi.karma.query;

import java.util.Calendar;

import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.GetOPMDocument;
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
import org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.FindServiceRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument;
import org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument;

/**
 * @author Yuan Luo
 * 
 */

public class QuerySummary {

	public static final QuerySummary UNKNOWN_QUERY_SUMMARY = new QuerySummary(
			QueryTypeEnum.UNKNOWN_TYPES);

	public static enum QueryTypeEnum {
		COMPARE_WORKFLOW_GRAPHS, 
		FIND_ABSTRACT_DATA_PRODUCT, 
		FIND_ABSTRACT_METHOD, 
		FIND_ABSTRACT_SERVICE, 
		FIND_DATA_PRODUCT, 
		FIND_METHOD_INVOCATION, 
		FIND_SERVICE, 
		GET_ABSTRACT_DATA_PRODUCT_DETAIL, 
		GET_ABSTRACT_METHOD_DETAIL, 
		GET_ABSTRACT_SERVICE_DETAIL, 
		GET_ANNOTATION_DETAIL, 
		GET_METHOD_INVOCATION_DETAIL, 
		GET_CLIENT_DETAIL, 
		GET_DATA_PRODUCT_DETAIL, 
		GET_NODE_COUNT_OF_GRAPH, 
		GET_PROVENANCE_HISTORY, 
		GET_SERVICE_DETAIL, 
		GET_WORKFLOW_GRAPH, 
		UNKNOWN_TYPES;

		public static QueryTypeEnum determineQueryTypeFromXmlBeansDocument(
				XmlObject document) {
			if (document instanceof CompareWorkflowGraphsRequestDocument) {
				return COMPARE_WORKFLOW_GRAPHS;
			} else if (document instanceof FindAbstractDataProductRequestDocument) {
				return FIND_ABSTRACT_DATA_PRODUCT;
			} else if (document instanceof FindAbstractMethodRequestDocument) {
				return FIND_ABSTRACT_METHOD;
			} else if (document instanceof FindAbstractServiceRequestDocument) {
				return FIND_ABSTRACT_SERVICE;
			} else if (document instanceof FindDataProductRequestDocument) {
				return FIND_DATA_PRODUCT;
			} else if (document instanceof FindMethodInvocationRequestDocument) {
				return FIND_METHOD_INVOCATION;
			} else if (document instanceof FindServiceRequestDocument) {
				return FIND_SERVICE;
			} else if (document instanceof GetAbstractDataProductDetailRequestDocument) {
				return GET_ABSTRACT_DATA_PRODUCT_DETAIL;
			} else if (document instanceof GetAbstractMethodDetailRequestDocument) {
				return GET_ABSTRACT_METHOD_DETAIL;
			} else if (document instanceof GetAbstractServiceDetailRequestDocument) {
				return GET_ABSTRACT_SERVICE_DETAIL;
			} else if (document instanceof GetAnnotationDetailRequestDocument) {
				return GET_ANNOTATION_DETAIL;
			} else if (document instanceof GetMethodInvocationDetailRequestDocument) {
				return GET_METHOD_INVOCATION_DETAIL;
			} else if (document instanceof GetClientDetailRequestDocument) {
				return GET_CLIENT_DETAIL;
			} else if (document instanceof GetDataProductDetailRequestDocument) {
				return GET_DATA_PRODUCT_DETAIL;
			} else if (document instanceof GetNodeCountOfGraphRequestDocument) {
				return GET_NODE_COUNT_OF_GRAPH;
			} else if (document instanceof GetProvenanceHistoryRequestDocument) {
				return GET_PROVENANCE_HISTORY;
			} else if (document instanceof GetServiceDetailRequestDocument) {
				return GET_SERVICE_DETAIL;
			} else if (document instanceof GetWorkflowGraphRequestDocument) {
				return GET_WORKFLOW_GRAPH;
			}
			return UNKNOWN_TYPES;
		}
	}

	private final QueryTypeEnum type;

	QuerySummary(QueryTypeEnum type) {
		this.type = type;
	}

	public QueryTypeEnum getQueryType() {
		return type;
	}

	public static void main(String args[]) {

	}
}
