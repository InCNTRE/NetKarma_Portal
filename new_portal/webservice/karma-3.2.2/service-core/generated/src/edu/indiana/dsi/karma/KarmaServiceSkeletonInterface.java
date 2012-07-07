
/**
 * KarmaServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */
    package edu.indiana.dsi.karma;
    /**
     *  KarmaServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface KarmaServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                    * @param serviceInitialized
         */

        
                public void serviceInitialized
                (
                  org.dataandsearch.www.karma._2010._08.ServiceInitializedDocument serviceInitialized
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param workflowInitialized
         */

        
                public void workflowInitialized
                (
                  org.dataandsearch.www.karma._2010._08.WorkflowInitializedDocument workflowInitialized
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param invokingWorkflow
         */

        
                public void invokingWorkflow
                (
                  org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument invokingWorkflow
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param findDataProductRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.FindDataProductResponseDocument findDataProduct
                (
                  org.dataandsearch.www.karma.query._2010._10.FindDataProductRequestDocument findDataProductRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param workflowTerminated
         */

        
                public void workflowTerminated
                (
                  org.dataandsearch.www.karma._2010._08.WorkflowTerminatedDocument workflowTerminated
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataReceivedStarted
         */

        
                public void dataReceivedStarted
                (
                  org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument dataReceivedStarted
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataSendFinished
         */

        
                public void dataSendFinished
                (
                  org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument dataSendFinished
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param invokingServiceStatus
         */

        
                public void invokingServiceStatus
                (
                  org.dataandsearch.www.karma._2010._08.InvokingServiceStatusDocument invokingServiceStatus
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param addRelationshipAnnotationById
         */

        
                public void addRelationshipAnnotationById
                (
                  org.dataandsearch.www.karma._2010._08.AddRelationshipAnnotationByIdDocument addRelationshipAnnotationById
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param addMultipleObjectAnnotation
         */

        
                public void addMultipleObjectAnnotation
                (
                  org.dataandsearch.www.karma._2010._08.AddMultipleObjectAnnotationDocument addMultipleObjectAnnotation
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataDeleted
         */

        
                public void dataDeleted
                (
                  org.dataandsearch.www.karma._2010._08.DataDeletedDocument dataDeleted
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataConsumed
         */

        
                public void dataConsumed
                (
                  org.dataandsearch.www.karma._2010._08.DataConsumedDocument dataConsumed
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getClientDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetClientDetailResponseDocument getClientDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetClientDetailRequestDocument getClientDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param findServiceRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.FindServiceResponseDocument findService
                (
                  org.dataandsearch.www.karma.query._2010._10.FindServiceRequestDocument findServiceRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getAbstractMethodDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailResponseDocument getAbstractMethodDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetAbstractMethodDetailRequestDocument getAbstractMethodDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param findAbstractServiceRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceResponseDocument findAbstractService
                (
                  org.dataandsearch.www.karma.query._2010._10.FindAbstractServiceRequestDocument findAbstractServiceRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param receivedResponse
         */

        
                public void receivedResponse
                (
                  org.dataandsearch.www.karma._2010._08.ReceivedResponseDocument receivedResponse
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getWorkflowGraphRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphResponseDocument getWorkflowGraph
                (
                  org.dataandsearch.www.karma.query._2010._10.GetWorkflowGraphRequestDocument getWorkflowGraphRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataUpdated
         */

        
                public void dataUpdated
                (
                  org.dataandsearch.www.karma._2010._08.DataUpdatedDocument dataUpdated
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param workflowInvoked
         */

        
                public void workflowInvoked
                (
                  org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument workflowInvoked
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getNodeCountOfGraphRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphResponseDocument getNodeCountOfGraph
                (
                  org.dataandsearch.www.karma.query._2010._10.GetNodeCountOfGraphRequestDocument getNodeCountOfGraphRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param invokingWorkflowStatus
         */

        
                public void invokingWorkflowStatus
                (
                  org.dataandsearch.www.karma._2010._08.InvokingWorkflowStatusDocument invokingWorkflowStatus
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataProduced
         */

        
                public void dataProduced
                (
                  org.dataandsearch.www.karma._2010._08.DataProducedDocument dataProduced
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param unknown
         */

        
                public void storeUnknown
                (
                  org.dataandsearch.www.karma._2010._08.UnknownDocument unknown
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param workflowFailed
         */

        
                public void workflowFailed
                (
                  org.dataandsearch.www.karma._2010._08.WorkflowFailedDocument workflowFailed
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param sendingResponse
         */

        
                public void sendingResponse
                (
                  org.dataandsearch.www.karma._2010._08.SendingResponseDocument sendingResponse
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param receivedFault
         */

        
                public void receivedFault
                (
                  org.dataandsearch.www.karma._2010._08.ReceivedFaultDocument receivedFault
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param invokingService
         */

        
                public void invokingService
                (
                  org.dataandsearch.www.karma._2010._08.InvokingServiceDocument invokingService
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param addAnnotation
         */

        
                public void addAnnotation
                (
                  org.dataandsearch.www.karma._2010._08.AddAnnotationDocument addAnnotation
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataReceivedFinished
         */

        
                public void dataReceivedFinished
                (
                  org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument dataReceivedFinished
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getDataProductDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailResponseDocument getDataProductDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetDataProductDetailRequestDocument getDataProductDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param findAbstractDataProductRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductResponseDocument findAbstractDataProduct
                (
                  org.dataandsearch.www.karma.query._2010._10.FindAbstractDataProductRequestDocument findAbstractDataProductRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param dataSendStarted
         */

        
                public void dataSendStarted
                (
                  org.dataandsearch.www.karma._2010._08.DataSendStartedDocument dataSendStarted
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param findAbstractMethodRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodResponseDocument findAbstractMethod
                (
                  org.dataandsearch.www.karma.query._2010._10.FindAbstractMethodRequestDocument findAbstractMethodRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param sendingFault
         */

        
                public void sendingFault
                (
                  org.dataandsearch.www.karma._2010._08.SendingFaultDocument sendingFault
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param serviceTerminated
         */

        
                public void serviceTerminated
                (
                  org.dataandsearch.www.karma._2010._08.ServiceTerminatedDocument serviceTerminated
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getMethodInvocationDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailResponseDocument getMethodInvocationDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetMethodInvocationDetailRequestDocument getMethodInvocationDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param findMethodInvocationRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationResponseDocument findMethodInvocation
                (
                  org.dataandsearch.www.karma.query._2010._10.FindMethodInvocationRequestDocument findMethodInvocationRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param serviceInvoked
         */

        
                public void serviceInvoked
                (
                  org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument serviceInvoked
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param sendingResponseStatus
         */

        
                public void sendingResponseStatus
                (
                  org.dataandsearch.www.karma._2010._08.SendingResponseStatusDocument sendingResponseStatus
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param compareWorkflowGraphsRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsResponseDocument compareWorkflowGraphs
                (
                  org.dataandsearch.www.karma.query._2010._10.CompareWorkflowGraphsRequestDocument compareWorkflowGraphsRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getAnnotationDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailResponseDocument getAnnotationDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetAnnotationDetailRequestDocument getAnnotationDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getAbstractDataProductDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailResponseDocument getAbstractDataProductDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetAbstractDataProductDetailRequestDocument getAbstractDataProductDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param addAnnotationById
         */

        
                public void addAnnotationById
                (
                  org.dataandsearch.www.karma._2010._08.AddAnnotationByIdDocument addAnnotationById
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getAbstractServiceDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailResponseDocument getAbstractServiceDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetAbstractServiceDetailRequestDocument getAbstractServiceDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getServiceDetailRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetServiceDetailResponseDocument getServiceDetail
                (
                  org.dataandsearch.www.karma.query._2010._10.GetServiceDetailRequestDocument getServiceDetailRequest
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param getProvenanceHistoryRequest
         */

        
                public org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryResponseDocument getProvenanceHistory
                (
                  org.dataandsearch.www.karma.query._2010._10.GetProvenanceHistoryRequestDocument getProvenanceHistoryRequest
                 )
            ;
        
         }
    