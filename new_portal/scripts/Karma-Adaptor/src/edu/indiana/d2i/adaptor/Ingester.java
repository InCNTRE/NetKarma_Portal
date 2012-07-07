package edu.indiana.d2i.adaptor;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import com.rabbitmq.client.ShutdownSignalException;

import edu.indiana.dsi.karma.messaging.Sender;

public class Ingester {
	
	private Sender sender;
	
	public Ingester(Sender sender){
		this.sender = sender;		
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
		//System.out.println("Sending Notification");
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
	 * Send Notification to Karma Server through Message Bus
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
	 * 
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
	
}
