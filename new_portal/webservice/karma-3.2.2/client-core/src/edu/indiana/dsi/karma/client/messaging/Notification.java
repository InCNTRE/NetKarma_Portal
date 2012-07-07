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
# File:			Notification.java
# Description:	API for sending notifications to Karma Provenance Server, 
#				through Messaging Bus.  
#
# -----------------------------------------------------------------
# 
*/
package edu.indiana.dsi.karma.client.messaging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import com.rabbitmq.client.ShutdownSignalException;
import edu.indiana.dsi.karma.messaging.MessageConfig;
import edu.indiana.dsi.karma.messaging.MessagingOperationTypes;
import edu.indiana.dsi.karma.messaging.Sender;

/**
 * @author Yuan Luo (yuanluo@indiana.edu)
 *
 */
public class Notification {
	private Sender sender;
	/**
	 * 
	 * @param msgconf
	 */
	public Notification(MessageConfig msgconf){
		try {
			this.sender=new Sender(msgconf, MessagingOperationTypes.SEND_NOTIFICATION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Send Notification to Karma Server through Message Bus.
	 * @param Notification
	 * @throws XmlException
	 */
	public void sendNotification(XmlObject Notification) throws XmlException{
		/*
		 * TO DO: Add Notification Validation code here
		 */
		try{
		if(!Notification.validate()){
			throw new XmlException("Fail to Send Message: Invalid Notification Format");
		}else{
			try {
				sender.sendMessage(Notification.xmlText(new XmlOptions().setSavePrettyPrint()));
			} catch (ShutdownSignalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}catch (XmlException e){
			e.printStackTrace();
		}
	}
	/**
	 * Send Notification to Karma Server through Message Bus.
	 * @param notification
	 */
	public void sendNotification(String notification){
		//Validate Notification Format
    	try {
			if(!XmlObject.Factory.parse(notification).validate()){
				throw new XmlException("Fail to Send Message: Invalid Notification Format");
			}else{
				try {
					sender.sendMessage(notification);
				} catch (ShutdownSignalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Send Notification to Karma Server through Message Bus.
	 * @param NotificationFile
	 * @throws IOException
	 */
	public void sendNotification(File NotificationFile) throws IOException{
		
		try {
	    	XmlObject notification=XmlObject.Factory.parse(NotificationFile);
			//Validate Notification Format
	    	if(!notification.validate()){
				throw new XmlException("Fail to Send Message: Invalid Notification Format");
			}else{
			    try {
					sender.sendMessage(notification.xmlText(new XmlOptions().setSavePrettyPrint()));
				} catch (ShutdownSignalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Close Messaging Channel
	 */
	public void closeChannel(){
		this.sender.closeChannel();
	}
	/**
	 * Close Messaging Channel and Close Message Bus Connection
	 */
	public void closeConnection(){
		this.sender.closeConnection();
	}

	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("SendNotification:\nargs[0]: Message Configuration File.\nargs[1]: Notification in XML file format.");
			System.out.println("Please check the parameters.");
			return;
		}
		String MessageConfigPath=args[0];
		String pathToNotificationFile=args[1];
		long startTime = System.currentTimeMillis();
		MessageConfig msgconf=new MessageConfig(MessageConfigPath);
		Notification notification=new Notification(msgconf);
		try {
			notification.sendNotification(new File(pathToNotificationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notification.closeConnection();

		long endTime = System.currentTimeMillis();
		System.out.println("Total Execution Time: "+(endTime-startTime));
		
		
	

	}

}
