package edu.indiana.d2i.netkarma.xsp.adapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import edu.indiana.dsi.karma.messaging.MessageConfig;

public class XSPAdapter {
	public static void main(String[] args){

		if(args.length != 4){
			System.out.println("Usage: java XSPAdapter <user> <slicefile> <log-file-1> <iperf-log>");
			System.exit(-1);
		}
		String user = args[0];
		
			
		UUID uuid = UUID.randomUUID();
		String instanceID = String.valueOf(uuid);
		
		//for (int i = 1; i < args.length; i++) {	
		String sliceFile = args[1];
			String logfile = args[2];
			String iperfLog = args[3];
			
			String MessageConfigPath= "config/xsp-adapter.properties";		
			System.out.println("Connecting to Server...");
			MessageConfig msgconf=new MessageConfig(MessageConfigPath);	
			SliceProvenance sliceProvenance = new SliceProvenance(sliceFile);
			sliceProvenance.parseLogfile();
			SliceNotifications sliceNotifications = new SliceNotifications(msgconf, 
					sliceProvenance, instanceID, Calendar.getInstance(), user);
			sliceNotifications.ingestNotifications();		
			sliceNotifications.closeConnection();
			sliceProvenance.mapHostInfo();
			/*ArrayList<Triplets<String, String, String>> hostsInfo = sliceProvenance.getHostInfo();
			for (int i = 0; i < hostsInfo.size(); i++) {
				Triplets<String, String, String> host = hostsInfo.get(i);
				System.out.println(host.getElementOne()+"::"+host.getElementTwo()+"::"+
						host.getElementThree());
			}*/		
			System.out.println("Slice Provenance processed...");
			System.out.println("Processing Runtime Provenance...");
			RuntimeProvenance runtimeProvenance = new RuntimeProvenance();
			runtimeProvenance.parseLogfile(logfile);
			RuntimeNotifications runtimeNotifications = 
				new RuntimeNotifications(msgconf, runtimeProvenance, instanceID, user, sliceProvenance, iperfLog);
			runtimeNotifications.ingestNotifications();
			runtimeNotifications.closeConnection();
			System.out.println("Runtime Provenance processed for logfile: " + logfile);
		//}
		System.out.println("Workflow-Instance ID = " + instanceID);
		
	}
}
