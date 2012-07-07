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
# File:			ServiceInvorkedNotification.java
# Description:	Sample code for sending ServiceInvorked notification 
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
import org.dataandsearch.www.karma._2010._08.BlockType;
import org.dataandsearch.www.karma._2010._08.DataObjectType;
import org.dataandsearch.www.karma._2010._08.EntityEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
import org.dataandsearch.www.karma._2010._08.InvocationType;
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;

import com.rabbitmq.client.ShutdownSignalException;

import edu.indiana.dsi.karma.client.messaging.Notification;
import edu.indiana.dsi.karma.messaging.MessageConfig;

/**
 * @author Yuan Luo (yuanluo@indiana.edu)
 *
 */
public class ServiceInvorkedNotification {
	public static void main(String[] args) throws ShutdownSignalException, IOException, InterruptedException, XmlException {
		if(args.length!=1){
			System.out.println("SendingResponseNotification Test:\nargs[0]: Message Configuration File.");
			System.out.println("Please check the parameters.");
			return;
		}
		MessageConfig msgconf=new MessageConfig(args[0]);
		Notification notification=new Notification(msgconf);
		
		/*
		 * Test: Set ServiceInvokedDocument
		 */
		ServiceInvokedDocument siDoc = ServiceInvokedDocument.Factory.newInstance();
        InvocationType serviceInvoked = siDoc.addNewServiceInvoked();
        EntityType invoker = serviceInvoked.addNewInvoker();
        EntityType invokee = serviceInvoked.addNewInvokee();
        DataObjectType params = serviceInvoked.addNewParams();
        serviceInvoked.setInvocationTime(Calendar.getInstance());

        ServiceInformationType invokerService = invoker.addNewServiceInformation();
        invokerService.setServiceID("http://service10.org");
        invokerService.setWorkflowID("http://workflow10.org");
        invokerService.setWorkflowNodeID("http://service10.org/Free_Service");
        invokerService.setTimestep(2);
       	invoker.setType(EntityEnumType.SERVICE);

        ServiceInformationType invokeeService = invokee.addNewServiceInformation();
        invokeeService.setServiceID("http://workflow20.org/service20");
        invokeeService.setWorkflowID("http://workflow20.org");
        invokeeService.setWorkflowNodeID("http://workflow20.org/Winning_Streak");
        invokeeService.setTimestep(3);
        invokee.setType(EntityEnumType.SERVICE);

        BlockType block3 = params.addNewBlock();
        block3.setBlockContent(XmlObject.Factory.parse("<block>name=value</block>"));

        System.out.println("[Testing Notification]\n"+siDoc.xmlText(new XmlOptions().setSavePrettyPrint()));
		
        /*
         * send Document to Karma Server and close Connection.
         */
		notification.sendNotification(siDoc);
		notification.closeConnection();
	}
}
