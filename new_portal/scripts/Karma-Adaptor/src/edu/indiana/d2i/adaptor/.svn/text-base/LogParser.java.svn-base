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
# Project: Netkarma
# File:  LogParser.java
# Description:  Parses the logfiles based on the rulefile to 
#				ingest notifications.
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import org.apache.xmlbeans.XmlException;
import org.dataandsearch.netkarma.DependencyDataType;
import org.dataandsearch.netkarma.DependencyLinkType;
import org.dataandsearch.netkarma.DependencyType;
import org.dataandsearch.netkarma.FilterType;
import org.dataandsearch.netkarma.InstanceType;
import org.dataandsearch.netkarma.KarmaNotificationsDocument;
import org.dataandsearch.netkarma.Rule;
import org.dataandsearch.netkarma.SelectMethodType;
import org.dataandsearch.netkarma.TimestampType;
import org.dataandsearch.netkarma.KarmaNotificationsDocument.KarmaNotifications;

import edu.indiana.dsi.karma.messaging.MessageConfig;
import edu.indiana.dsi.karma.messaging.MessagingOperationTypes;
import edu.indiana.dsi.karma.messaging.Sender;

public class LogParser {

	private File ruleFile = null;
	private String logFileName = null;
	private String instanceID = null;
	private String startTime = null;
	private String expRulefile = null;
	private String cmdRulefile = null;
	private String genericRulefile = null;
	
	Sender sender;
	
	public LogParser(String ruleFile, String logFile, MessageConfig msgconf) {
		this.ruleFile = new File(ruleFile);
		this.logFileName = logFile;
		try {
			this.sender=new Sender(msgconf, MessagingOperationTypes.SEND_NOTIFICATION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public LogParser(String expRulefile, String cmdRulefile, String genericRulefile, 
			String logFile, MessageConfig msgconf) {
		this.expRulefile = expRulefile;
		this.cmdRulefile = cmdRulefile;
		this.genericRulefile = genericRulefile;
		this.logFileName = logFile;
		try {
			this.sender=new Sender(msgconf, MessagingOperationTypes.SEND_NOTIFICATION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private String[] tokenizeLine(String line, String delim, int limit) {
		String[] tokens = line.split(delim, limit);
		return tokens;
	}

	public void parseRuleFile() {
		long execStartTime = System.currentTimeMillis();	
		try {
			String line = null;
			ArrayList<String> fileData = new ArrayList<String>();
			
			BufferedReader br = new BufferedReader(new FileReader(logFileName));			
			while ((line = br.readLine()) != null) {
				fileData.add(line.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"));
			}
			if(ruleFile == null){
				boolean expRulefileSet = false;
				boolean cmdRulefileSet = false;
				for (int lineNum = 0; lineNum < fileData.size(); lineNum++) {
					line = fileData.get(lineNum);
					if((line.startsWith("gush.cc") && line.contains(":XML:"))
							|| (line.startsWith("project.cc") && line.contains(":Project")) ){
						//this.ruleFile = new File(expRulefile);
						expRulefileSet = true;
						//break;
					}
					else if((line.startsWith("gush.cc") && line.contains("shell"))){
						//this.ruleFile = new File(expRulefile);
						cmdRulefileSet = true;
					}
				}
				if(expRulefileSet && cmdRulefileSet){
					this.ruleFile = new File(genericRulefile);
				}
				else if(expRulefileSet && !cmdRulefileSet){
					this.ruleFile = new File(expRulefile);
				}
				else{
					this.ruleFile = new File(cmdRulefile);
				}
			}
			System.out.println("Using rulefile: " + ruleFile.getAbsolutePath());
		
			KarmaNotificationsDocument karmaNotificationsDoc = KarmaNotificationsDocument.Factory
					.parse(ruleFile);
			KarmaNotifications karmaNotifications = karmaNotificationsDoc
					.getKarmaNotifications();
			String project = karmaNotifications.getProject();
			String argDelim = karmaNotifications.getArgDelimiter();
			int maxArgs = 0;
			if (karmaNotifications.isSetMaxArgs()){
				maxArgs = karmaNotifications.getMaxArgs();
			}
			
			if(karmaNotifications.isSetInstanceID()){
				InstanceType instanceType = karmaNotifications.getInstanceID();
				if(instanceType.isSetDerivedInstanceLocator()){					
					// will implement it later
					//ProvenanceDataType derivedInstanceType = instanceType.getDerivedInstanceLocator();
				} else if(instanceType.isSetFileInstanceLocator()){
					SelectMethodType selectType = instanceType.getFileInstanceLocator();
					DataSelector ds = new DataSelector(logFileName);
					UUID uuid = UUID.randomUUID();
					/*
					 * Devarshi (02/17/2012): removed the use of logfile name for deriving the 
					 * WF-instance id. Doesn't make any sense if appending UUIDs for every run of
					 * a single logfile since in any case the instance-ids will be unique.
					 */
					instanceID = String.valueOf(uuid);
					//instanceID = ds.getProvenanceData(null, selectType) + "-"+ String.valueOf(uuid);
					
					//instanceID = ds.getProvenanceData(null, selectType);
				} else if(instanceType.isSetHeaderInstanceLocator()){
					
				}
			}
			
			if(karmaNotifications.isSetStartTime()){
				TimestampType timestampType = karmaNotifications.getStartTime();
				if(timestampType.isSetFileTimestampLocator()){
			 		SelectMethodType selectType = timestampType.getFileTimestampLocator();
					DataSelector ds = new DataSelector(logFileName);
					startTime = ds.getProvenanceData(null, selectType);
				} else{
					// handle other cases later
				}
			}			

			boolean isRuleApplicable;
			boolean ignoreDuplicates;
			Rule[] rules = karmaNotifications.getRulesetArray();
			boolean[] required = new boolean[rules.length];
			for (int i = 0; i < required.length; i++) {
				required[i] = true;
			}
			
			DependencyType[] dependencies = karmaNotifications.getDependencyArray();
			DependencyDataType[] depDataType = karmaNotifications.getDependencyDataArray();
			DependencyLinkType[] depLinks = karmaNotifications.getDependencyLinkArray();
			DependencyData depData = new DependencyData();
			RuleApplier ruleApplier = new RuleApplier(logFileName, instanceID, startTime, sender,
					dependencies, depData, depLinks);
			DependencyType[] globalDeps = karmaNotifications.getGlobalDependencyArray();
			
			/*
			 * read log line-by-line
			 */
	
			System.out.println("Creating Notifications...");
			for (int lineNum = 0; lineNum < fileData.size(); lineNum++) {
				line = fileData.get(lineNum);
				String[] args = tokenizeLine(line, argDelim, maxArgs); // implement this						
				
				/*
				 *  *scan for each line in the logfile* and send it for
				 *  rule-check
				 */ 
				for (int i = 0; i < rules.length; i++) {
					ignoreDuplicates = rules[i].getHasDuplicates();					
					isRuleApplicable = ruleApplier
							.doesRuleApply(args, rules[i]);
					if (isRuleApplicable && required[i]) {
						//ruleApplier.saveNotificationData(args, rules[i], fileData, lineNum, argDelim, maxArgs);
						ruleApplier.saveNotificationData(args, rules[i], fileData, lineNum, argDelim, maxArgs);
						if(ignoreDuplicates){
							required[i] = false;
						}
					}
				}
				
//				if(args.length >= maxArgs){
					DataSelector ds = new DataSelector();
					int length=depDataType.length;
					ArrayList<String> name=new ArrayList();
					ArrayList<String> value=new ArrayList();
					for (int i = 0; i < depDataType.length; i++) {
						FilterType[] filters =  depDataType[i].getFilterArray();
						boolean isApplicable = depData.doesRuleApply(args, filters);
						if(isApplicable){
							name.add(depDataType[i].getName());
							SelectMethodType selectMethod = depDataType[i].getValue();
							value.add(ds.getProvenanceData(args, selectMethod));
						}
					}
					if(name.size()==value.size()){
						if(name.size()>=2){
							for (int i=0;i<name.size()-1;i++){
								depData.savedependencyData(name.get(i), name.get(i+1), value.get(i), value.get(i+1));
							}
						}
					}
//				}
			}
			
			br.close();
			
			ruleApplier.ingestNotificationData(globalDeps);
			
			instanceID = "urn:tool:" + project + ":" + instanceID;
			System.out.println("Workflow Instance-ID: " + instanceID);
			
			long endTime = System.currentTimeMillis();
			double execTime = (endTime*1.0 - execStartTime)/1000;
			System.out.println("Time to queue notifications for ingestion: " + execTime + " secs");
			
		} catch (XmlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e){			
			System.out.println("Invalid rulefile, use the correct version of the rulefile!");
		} finally{	
			/*
			 * Log-file parsed, and notifications ingested so close the connection
			 */					
			closeConnection(); //Yuan removed this for testing
		}
	}

	/*
	 * Close Messaging Channel
	 */
	public void closeChannel(){
		this.sender.closeChannel();
	}
	
	/*
	 * Close Messaging Channel and Close Message Bus Connection
	 */
	public void closeConnection(){
		this.sender.closeConnection();
	}
}
