package edu.indiana.d2i.netkarma.xsp.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.dataandsearch.www.karma._2010._08.AnnotationType;
import org.dataandsearch.www.karma._2010._08.EntityEnumSubtype;
import org.dataandsearch.www.karma._2010._08.EntityEnumType;
import org.dataandsearch.www.karma._2010._08.EntityType;
import org.dataandsearch.www.karma._2010._08.InvocationType;
import org.dataandsearch.www.karma._2010._08.PersonnelEnumType;
import org.dataandsearch.www.karma._2010._08.ServiceInformationType;
import org.dataandsearch.www.karma._2010._08.ServiceInvokedDocument;
import org.dataandsearch.www.karma._2010._08.UserInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType;
import org.dataandsearch.www.karma._2010._08.WorkflowInformationType.UserBehalf;

import edu.indiana.dsi.karma.messaging.MessageConfig;
import edu.indiana.dsi.karma.messaging.MessagingOperationTypes;
import edu.indiana.dsi.karma.messaging.Sender;

public class SliceProvenance {

	private File logfile = null;
	private ArrayList<String> loglines = null;

	private ArrayList<String> nodeIDs = null;
	private ArrayList<String> hostnames = null;
	private ArrayList<Pair<String, String>> linkIDs = null;
	private ArrayList<Pair<String, String>> linkIPs = null;
	private ArrayList<Triplets<String, String, String>> hostInfo = null;

	public SliceProvenance(String logfile) {

		this.nodeIDs = new ArrayList<String>();
		this.hostnames = new ArrayList<String>();
		this.linkIDs = new ArrayList<Pair<String, String>>();
		this.linkIPs = new ArrayList<Pair<String, String>>();
		this.hostInfo = new ArrayList<Triplets<String, String, String>>();

		this.logfile = new File(logfile);
	}

	public void parseLogfile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(logfile));
			loglines = new ArrayList<String>();

			String line = null;
			while ((line = br.readLine()) != null) {
				loglines.add(line);
				parseLogline(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parseLogline(String line) {
		String[] tokens = line.split("=\\s*", 2);
		String key = tokens[0];
		String value = tokens[1];

		if (key.contains("rspec:virtual_id")) {
			String[] virtualID = value.split("\\s+");
			for (int i = 0; i < virtualID.length; i++) {
				nodeIDs.add(virtualID[i].trim());
			}
		} else if (key.contains("services:hostname")) {
			hostnames.add(value.trim());
		} else if (key.contains("link:IP")) {
			String[] IP = value.split("\\s+");
			Pair<String, String> linkPair = new Pair<String, String>();
			linkPair.add(IP[0], IP[1]);
			linkIPs.add(linkPair);
		} else if (key.contains("link:virtual_node_id")) {
			String[] ID = value.split("\\s+");
			Pair<String, String> linkID = new Pair<String, String>();
			linkID.add(ID[0], ID[1]);
			linkIDs.add(linkID);
		}
	}
	
	public void mapHostInfo(){		
		for (int i = 0; i < nodeIDs.size(); i++) {
			Triplets<String, String, String> info = new Triplets<String, String, String>();
			info.add(nodeIDs.get(i), hostnames.get(i));
			hostInfo.add(info);
			//System.out.println(info.getElementOne());
		}
		
		Hashtable<String, String> nodeIPMap = new Hashtable<String, String>();
		for (int i = 0; i < linkIDs.size(); i++) {
			nodeIPMap.put(linkIDs.get(i).getElementOne(), linkIPs.get(i).getElementOne());
			nodeIPMap.put(linkIDs.get(i).getElementTwo(), linkIPs.get(i).getElementTwo());
		}
		
		for (int i = 0; i < hostInfo.size(); i++) {
			Triplets<String, String, String> info = hostInfo.get(i);
			String nodeID = info.getElementOne();
			//System.out.println(nodeID);
			String ip = nodeIPMap.get(nodeID);
			if(ip != null){
				info.setElementThree(ip);
			}
		}
	}

	public ArrayList<String> getNodeIDs() {
		return nodeIDs;
	}

	public ArrayList<String> getHostnames() {
		return hostnames;
	}

	public ArrayList<Pair<String, String>> getLinkIDs() {
		return linkIDs;
	}

	public ArrayList<Pair<String, String>> getLinkIPs() {
		return linkIPs;
	}

	public ArrayList<Triplets<String, String, String>> getHostInfo() {
		return hostInfo;
	}
}
