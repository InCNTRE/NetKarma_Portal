/*
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
# File:  NotificationIngester.java
# Description:  interface definition of provenance events 
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.ingest;

import org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument;
import org.dataandsearch.www.karma._2010._08.AddAnnotationDocument;
import org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument;
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

/**
 * @author Yiming Sun
 * @author Devarshi Ghoshal
 * @author You-Wei Cheah
 */
public interface NotificationIngester {
    
    public void ingestDataSendFinished(DataSendFinishedDocument dataSendFinishedDoc) throws IngestException;
    public void ingestReceivedResponse(ReceivedResponseDocument receivedResponseDoc) throws IngestException;
    public void ingestSendingResponseStatus(SendingResponseStatusDocument sendingResponseStatusDoc) throws IngestException;
    
    public void ingestServiceInitialized(ServiceInitializedDocument serviceInitializedDoc) throws IngestException;
    public void ingestInvokingWorkflow(InvokingWorkflowDocument invokingWorkflowDoc) throws IngestException;
    public void ingestSendingResponse(SendingResponseDocument sendingResponseDoc) throws IngestException;
    public void ingestServiceTerminated(ServiceTerminatedDocument serviceTerminatedDoc) throws IngestException;
    public void ingestWorkflowTerminated(WorkflowTerminatedDocument workflowTerminatedDoc) throws IngestException;
    public void ingestDataConsumed(DataConsumedDocument dataConsumedDoc) throws IngestException;
    public void ingestInvokingWorkflowStatus(InvokingWorkflowStatusDocument invokingWorkflowStatusDoc) throws IngestException;
    
    public void ingestInvokingServiceStatus(InvokingServiceStatusDocument invokingServiceStatusDoc) throws IngestException;
    public void ingestWorkflowInvoked(WorkflowInvokedDocument workflowInvokedDoc) throws IngestException;
    public void ingestDataSendStarted(DataSendStartedDocument dataSendStartedDoc) throws IngestException;
    public void ingestServiceInvoked(ServiceInvokedDocument serviceInvokedDoc) throws IngestException;
    public void ingestReceivedFault(ReceivedFaultDocument receivedFaultDoc) throws IngestException;
    public void ingestInvokingService(InvokingServiceDocument invokingServiceDoc) throws IngestException;
    public void ingestDataReceivedStarted(DataReceivedStartedDocument dataReceivedStartedDoc) throws IngestException;
    public void ingestDataReceivedFinished(DataReceivedFinishedDocument dataReceivedFinishedDoc) throws IngestException;
    public void ingestDataProduced(DataProducedDocument dataProducedDoc) throws IngestException;
    public void ingestDataDeleted(DataDeletedDocument dataDeletedDoc) throws IngestException;
    public void ingestDataUpdated(DataUpdatedDocument dataUpdatedDoc) throws IngestException;
    public void ingestWorkflowInitialized(WorkflowInitializedDocument workflowInitializedDoc) throws IngestException;
    public void ingestSendingFault(SendingFaultDocument sendingFaultDoc) throws IngestException;
    public void ingestWorkflowFailed(WorkflowFailedDocument workflowFailedDoc) throws IngestException;
    public void addAnnotation(AddAnnotationDocument addAnnotationDoc) throws IngestException;
    public void addAnnotationById(AddAnnotationByIdDocument addAnnotationByIdDoc) throws IngestException;
    public void addMultipleObjectAnnotation(AddMultipleObjectAnnotationDocument addMultipleObjectAnnotationDoc) throws IngestException;
    public void addRelationshipAnnotationById(AddRelationshipAnnotationByIdDocument addRelationshipAnnotationByIdDoc) throws IngestException;

    
    public void ingestUnknownNotification(UnknownDocument unknownDoc) throws IngestException;
    
    public int processNotifications() throws IngestException;
    public void resetUnfinishedNotifications() throws IngestException;
    
    public void setImplementer(IngesterImplementer implementer);

}

