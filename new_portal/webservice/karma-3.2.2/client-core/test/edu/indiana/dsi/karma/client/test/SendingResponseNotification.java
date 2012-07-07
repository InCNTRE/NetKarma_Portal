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
# Project:		Karma Provenance Client
# File:			SendingResponseNotification.java
# Description:	Sample code for sending SendingResponse notifications 
#				to Karma Provenance Server, through Messaging Bus.  
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.dsi.karma.client.test;

import java.io.IOException;
import java.util.Calendar;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.dataandsearch.www.karma._2010._08.*;


import com.rabbitmq.client.ShutdownSignalException;

import edu.indiana.dsi.karma.client.messaging.Notification;
import edu.indiana.dsi.karma.messaging.MessageConfig;

/**
 * @author Yuan Luo (yuanluo@indiana.edu)
 *
 */
public class SendingResponseNotification {
	public static void main(String[] args) throws ShutdownSignalException, IOException, InterruptedException, XmlException {
		if(args.length!=1){
			System.out.println("SendingResponseNotification Test:\nargs[0]: Message Configuration File.");
			System.out.println("Please check the parameters.");
			return;
		}
		MessageConfig msgconf=new MessageConfig(args[0]);
		Notification notification=new Notification(msgconf);
		
		/*
		 * Test: Set SendingResponseDocument
		 */
		SendingResponseDocument doc = SendingResponseDocument.Factory.newInstance();
        DataTransferType dataTransferType = doc.addNewSendingResponse();
        EntityType sender = dataTransferType.addNewSender();
        sender.setType(EntityEnumType.SERVICE);
        ServiceInformationType invokerService = sender.addNewServiceInformation();
        invokerService.setServiceID("http://service1.org");
        invokerService.setWorkflowID("http://workflow1.org");
        invokerService.setWorkflowNodeID("http://Basic_Workflow_Service");
        invokerService.setTimestep(1);
        
        EntityType receiver = dataTransferType.addNewReceiver();
        receiver.setType(EntityEnumType.SERVICE);
        ServiceInformationType invokeeService = receiver.addNewServiceInformation();
        invokeeService.setServiceID("http://service2.org");
        invokeeService.setWorkflowID("http://workflow2.org");
        invokeeService.setWorkflowNodeID("http://Premium_Workflow_Service");
        invokeeService.setTimestep(1);
        
        DataObjectType newResult = dataTransferType.addNewResult();
        BlockType block = newResult.addNewBlock();
        block.setBlockContent(XmlObject.Factory.parse("<block>aaaaa</block>"));
        
        dataTransferType.setTransferTime(Calendar.getInstance());
        
        System.out.println("[Testing Notification]\n"+doc.xmlText(new XmlOptions().setSavePrettyPrint()));
		
        /*
         * send Document to Karma Server and close Connection.
         */
		notification.sendNotification(doc);
		notification.closeConnection();
	}
}
