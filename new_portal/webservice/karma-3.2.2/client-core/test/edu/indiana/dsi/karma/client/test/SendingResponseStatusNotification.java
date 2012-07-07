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
# File:			SendingResponseStatusNotification.java
# Description:	Sample code for sending SendingResponseStatus notification 
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
public class SendingResponseStatusNotification {
	public static void main(String[] args) throws ShutdownSignalException, IOException, InterruptedException, XmlException {
		if(args.length!=1){
			System.out.println("SendingResponseNotification Test:\nargs[0]: Message Configuration File.");
			System.out.println("Please check the parameters.");
			return;
		}
		MessageConfig msgconf=new MessageConfig(args[0]);
		Notification notification=new Notification(msgconf);
		/*
		 * Test: Set SendingResponseStatusDocument
		 */
		SendingResponseStatusDocument doc2 = SendingResponseStatusDocument.Factory.newInstance();
        DataTransferStatusType dataTransferStatusType = doc2.addNewSendingResponseStatus();
        EntityType sender2 = dataTransferStatusType.addNewSender();
        sender2.setType(EntityEnumType.SERVICE);
        ServiceInformationType invokee2 = sender2.addNewServiceInformation();
        invokee2.setServiceID("http://service3.org");
        invokee2.setWorkflowID("http://workflow3.org");
        invokee2.setWorkflowNodeID("http://Dirt_Cheap_Service");
        invokee2.setTimestep(1);
        
        EntityType receiver2 = dataTransferStatusType.addNewReceiver();
        receiver2.setType(EntityEnumType.SERVICE);
        ServiceInformationType invoker2 = receiver2.addNewServiceInformation();
        invoker2.setServiceID("http://service4.org");
        invoker2.setWorkflowID("http://workflow2.org");
        invoker2.setWorkflowNodeID("http://Free_Workflow");
        invoker2.setTimestep(2);
        
        DataObjectType fault = dataTransferStatusType.addNewFault();
        BlockType block2 = fault.addNewBlock();
        block2.setBlockContent(XmlObject.Factory.parse("<fault>bbbbb</fault>"));
        
        dataTransferStatusType.setTransferTime(Calendar.getInstance());
        dataTransferStatusType.setStatusTime(Calendar.getInstance());
        
        dataTransferStatusType.setStatus(StatusEnumType.SUCCESS);
        
        System.out.println("[Testing Notification]\n"+doc2.xmlText(new XmlOptions().setSavePrettyPrint()));
		
        /*
         * send Document to Karma Server and close Connection.
         */
		notification.sendNotification(doc2);
		notification.closeConnection();
	}
}
