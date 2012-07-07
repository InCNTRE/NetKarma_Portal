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
# Project: KSC-2
# File:  KarmaAxis2Tester.java
# Description:  
#
# -----------------------------------------------------------------
# 
*/



/**
 * 
 */
package edu.indiana.dsi.karma.test;

import java.util.Random;

import org.dataandsearch.www.karma._2010._08.DataConsumedDocument;
import org.dataandsearch.www.karma._2010._08.DataDeletedDocument;
import org.dataandsearch.www.karma._2010._08.DataProducedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataReceivedStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendFinishedDocument;
import org.dataandsearch.www.karma._2010._08.DataSendStartedDocument;
import org.dataandsearch.www.karma._2010._08.DataUpdatedDocument;
import org.dataandsearch.www.karma._2010._08.GetOPMDocument;
import org.dataandsearch.www.karma._2010._08.InvokingServiceDocument;
import org.dataandsearch.www.karma._2010._08.InvokingServiceStatusDocument;
import org.dataandsearch.www.karma._2010._08.InvokingWorkflowDocument;
import org.dataandsearch.www.karma._2010._08.InvokingWorkflowStatusDocument;
import org.dataandsearch.www.karma._2010._08.KarmaServiceStub;
import org.dataandsearch.www.karma._2010._08.ReceivedFaultDocument;
import org.dataandsearch.www.karma._2010._08.ReceivedResponseDocument;
import org.dataandsearch.www.karma._2010._08.SendingFaultDocument;
import org.dataandsearch.www.karma._2010._08.SendingResponseDocument;
import org.dataandsearch.www.karma._2010._08.SendingResponseStatusDocument;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;
import org.dataandsearch.www.karma._2010._08.WorkflowInvokedDocument;
import org.dataandsearch.www.karma._2010._08.GetOPMDocument.GetOPM;
import org.openprovenance.model.v1_1_a.OpmGraphDocument;

/**
 * @author Yiming Sun
 *
 */
public class KarmaAxis2Tester implements Runnable {
    
    NotificationTester tester = null;
    KarmaServiceStub stub = null;
    
    public KarmaAxis2Tester(NotificationTester tester) throws Exception {
        this.tester = tester;
        stub = new KarmaServiceStub("http://127.0.0.1:20032/axis2/services/KarmaService?wsdl");
    }
    
    public void testInvokingWorkflow() {
        InvokingWorkflowDocument invokingWorkflow = tester.makeInvokingWorkflow();
        try {
            stub.invokingWorkflow(invokingWorkflow);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            
        }
    }
    
    public void testInvokingWorkflowStatus() {
        InvokingWorkflowStatusDocument invokingWorkflowStatus = tester.makeInvokingWorkflowStatus();
        try {
            stub.invokingWorkflowStatus(invokingWorkflowStatus);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
    }
    
    public void testWorkflowInvoked() {
        WorkflowInvokedDocument workflowInvoked = tester.makeWorkflowInvoked();
        try{
            stub.workflowInvoked(workflowInvoked);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testInvokingService() {
        InvokingServiceDocument invokingService = tester.makeInvokingService();
        try {
            stub.invokingService(invokingService);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testInvokingServiceStatus() {
        InvokingServiceStatusDocument invokingServiceStatus = tester.makeInvokingServiceStatus();
        try {
            stub.invokingServiceStatus(invokingServiceStatus);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testServiceInvoked() {
        ServiceInvokedDocument serviceInvoked = tester.makeServiceInvoked();
        try {
            stub.serviceInvoked(serviceInvoked);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataProduced() {
        DataProducedDocument dataProduced = tester.makeDataProduced();
        try {
            stub.dataProduced(dataProduced);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataConsumed() {
        DataConsumedDocument dataConsumed = tester.makeDataConsumed();
        try {
            stub.dataConsumed(dataConsumed);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataDeleted() {
        DataDeletedDocument dataDeleted = tester.makeDataDeleted();
        try {
            stub.dataDeleted(dataDeleted);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataUpdated() {
        DataUpdatedDocument dataUpdated = tester.makeDataUpdated();
        try {
            stub.dataUpdated(dataUpdated);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataSendStarted() {
        DataSendStartedDocument dataSendStarted = tester.makeDataSendStarted();
        try {
            stub.dataSendStarted(dataSendStarted);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataSendFinished() {
        DataSendFinishedDocument dataSendFinished = tester.makeDataSendFinished();
        try {
            stub.dataSendFinished(dataSendFinished);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataReceiveFinished() {
        DataReceivedFinishedDocument dataReceivedFinished = tester.makeDataReceivedFinished();
        try {
            stub.dataReceivedFinished(dataReceivedFinished);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testDataReceiveStarted() {
        DataReceivedStartedDocument dataReceivedStarted = tester.makeDataReceivedStarted();
        try {
            stub.dataReceivedStarted(dataReceivedStarted);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testReceivedResponse() {
        ReceivedResponseDocument receivedResponse = tester.makeReceivedResponse();
        try {
            stub.receivedResponse(receivedResponse);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testSendingResponseStatus() {
        SendingResponseStatusDocument sendingResponseStatus = tester.makeSendingResponseStatus();
        try {
            stub.sendingResponseStatus(sendingResponseStatus);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
    }
    
    public void testSendingResponse() {
        SendingResponseDocument sendingResponse = tester.makeSendingResponse();
        try {
            stub.sendingResponse(sendingResponse);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testReceivedFault() {
        ReceivedFaultDocument receivedFault = tester.makeReceivedFault();
        try {
            stub.receivedFault(receivedFault);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testSendingFault() {
        SendingFaultDocument sendingFault = tester.makeSendingFault();
        try {
            stub.sendingFault(sendingFault);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void testOPM() {
        GetOPMDocument getOPMDoc = GetOPMDocument.Factory.newInstance();
        GetOPM getOPM = getOPMDoc.addNewGetOPM();
        getOPM.setIn("tag:www.d2i.indiana.edu/TestWorkflow/instance1255");
        try {
            OpmGraphDocument opm = stub.getOPM(getOPMDoc);
            System.out.println(opm.xmlText());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
    }
    /**
     * processor method
     */
    public void startProcess(){
        //Random randomNumGen = new Random();
        //int num_tests = randomNumGen.nextInt(20);
        
        for (int i = 0; i < 20; i++) {
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
                System.out.println("Test-20: Get-OPM");
                testOPM();
            default:
                break;
            }
        }
        
    }

    public void run() {
        startProcess();
    }
    
    public static void main(String[] args) throws Exception {
        int is_threaded = 0;
        
        if(args.length == 1){
            is_threaded = Integer.parseInt(args[0]);
        }

        Random randomNumGen = new Random(); 
        
        if(is_threaded == 1){
            int num_threads = randomNumGen.nextInt(50); 
            for (int i = 0; i < num_threads; i++) {
                System.out.println("Tester-"+i);
                //need to modify this with updated constructor
//              IngesterImplementer<Long, String> implementer = new BaseDBIngesterImplementer();            
                NotificationTester tester = new NotificationTester();  
                KarmaAxis2Tester axis2Tester = new KarmaAxis2Tester(tester);
                new Thread(axis2Tester).start();
            }           
        }
        else{       
            //need to modify this with updated constructor
//          IngesterImplementer<Long, String> implementer = new BaseDBIngesterImplementer();
            
            NotificationTester tester = new NotificationTester();
            KarmaAxis2Tester axis2Tester = new KarmaAxis2Tester(tester);
            axis2Tester.startProcess();
        }
        

    }
}

