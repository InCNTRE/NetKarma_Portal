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
# File:  RuleApplier.java
# Description:  Applies the provenance-rules to each log line
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections.MultiHashMap;
import org.dataandsearch.netkarma.ActorEntityEnumSubtype;
import org.dataandsearch.netkarma.ActorEntityEnumType;
import org.dataandsearch.netkarma.ActorEnumType;
import org.dataandsearch.netkarma.ActorsType;
import org.dataandsearch.netkarma.AnnotationType;
import org.dataandsearch.netkarma.AppenderType;
import org.dataandsearch.netkarma.ComparatorEnumType;
import org.dataandsearch.netkarma.ConstantType;
import org.dataandsearch.netkarma.DataEnumType;
import org.dataandsearch.netkarma.DataType;
import org.dataandsearch.netkarma.DependencyLinkType;
import org.dataandsearch.netkarma.DependencyType;
import org.dataandsearch.netkarma.FilterPredicateEnumType;
import org.dataandsearch.netkarma.FilterType;
import org.dataandsearch.netkarma.LastNCharType;
import org.dataandsearch.netkarma.MatchLineEnumType;
import org.dataandsearch.netkarma.MatchRuleType;
import org.dataandsearch.netkarma.NotificationEnumType;
import org.dataandsearch.netkarma.NotificationType;
import org.dataandsearch.netkarma.ParentEnumType;
import org.dataandsearch.netkarma.ParentType;
import org.dataandsearch.netkarma.ProvenanceDataType;
import org.dataandsearch.netkarma.ReadArgumentOfType;
import org.dataandsearch.netkarma.ReadPropertyOfType;
import org.dataandsearch.netkarma.ReadTokenType;
import org.dataandsearch.netkarma.Rule;
import org.dataandsearch.netkarma.SelectMechanismEnumType;
import org.dataandsearch.netkarma.SelectMethodEnumType;
import org.dataandsearch.netkarma.SelectMethodType;
import org.dataandsearch.netkarma.SimpleSelectionType;
import org.dataandsearch.netkarma.SubstringType;
import org.dataandsearch.netkarma.TimestampType;
import org.dataandsearch.netkarma.UriEnumType;
import org.dataandsearch.netkarma.UriType;

import edu.indiana.dsi.karma.messaging.Sender;

public class RuleApplier {

	private String logFileName;
	private String instanceID;
	private String timestamp = null;
	private DataSelector dataSelector = null;
	private int incrementer = 0;
	private DependencyType[] dependencies = null;
	private DependencyData depData = null;
	DependencyLinkType[] depLinks = null;
	Sender sender;
	Hashtable<String, String> idCounterMap = null;

	Hashtable<String, NotificationData> notificationMap;
	MultiHashMap notificationList = new MultiHashMap();
	ArrayList actorList=new ArrayList();
	Hashtable<String, Integer> incrementerList=new Hashtable();
	
	public RuleApplier() {
		super();
	}
	
	public RuleApplier(String logfile, String instanceID, Sender sender) {
		super();
		this.logFileName = getLogFileName(logfile);
		this.instanceID = instanceID;
		this.sender = sender;
		dataSelector = new DataSelector();
		notificationMap = new Hashtable<String, NotificationData>();
		idCounterMap = new Hashtable<String, String>(); 
	}

	public RuleApplier(String logfile, String instanceID, String timestamp,
			Sender sender) {
		super();
		this.logFileName = getLogFileName(logfile);
		this.instanceID = instanceID;
		this.timestamp = timestamp;
		this.sender = sender;
		dataSelector = new DataSelector();
		notificationMap = new Hashtable<String, NotificationData>();
	}
	
	public RuleApplier(String logfile, String instanceID, String timestamp,
			Sender sender, DependencyType[] dependencies, 
			DependencyData depData, DependencyLinkType[] depLinks) {
		super();
		this.logFileName = getLogFileName(logfile);
		this.instanceID = instanceID;
		this.timestamp = timestamp;
		this.sender = sender;
		this.dependencies = dependencies;
		this.depData = depData;
		this.depLinks = depLinks;
		dataSelector = new DataSelector();
		notificationMap = new Hashtable<String, NotificationData>();		
	}

	private String getLogFileName(String logfile) {
		return logfile.substring(0, (logfile.indexOf('.') - 1));
	}

	public Hashtable<String, NotificationData> getNotificationList() {
		return notificationMap;
	}

	private Date convertStrToDate(String dateAsStr) {
		String formattedDate = new java.text.SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss").format(new Date(Long
				.parseLong(dateAsStr) * 1000));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(formattedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * check whether a particular rule apply to the list of args in the current
	 * line
	 */
	public boolean doesRuleApply(String[] args, Rule rule) {
		FilterType[] filters = rule.getFilterArray();
		boolean ruleApplicable = true;
		int numFilters = filters.length;

		boolean prevRuleApplicable;

		for (int k = 0; k < numFilters; k++) {
			int argNum = filters[k].getArgumentNumber();
			String argVal = filters[k].getArgumentValue();
			ComparatorEnumType.Enum comparatorType = filters[k].getComparator();

			prevRuleApplicable = ruleApplicable;

			if (filters[k].isSetFilterPredicate()) {
				FilterPredicateEnumType.Enum predicateType = filters[k]
						.getFilterPredicate();
				if (predicateType.equals(FilterPredicateEnumType.AND)) {
					if (!prevRuleApplicable) {
						ruleApplicable = false;
						break;
					}
				} else {
					// do nothing
				}
			}
			if (comparatorType.equals(ComparatorEnumType.EQUALS)) {
				if (args.length > argNum) {
					/*
					 * check for ill-formatted, inconsistent log-lines
					 */
					if (args[argNum].equals(argVal)) {
						ruleApplicable = true;
					} else {
						ruleApplicable = false;
					}
				} else {
					ruleApplicable = false;
				}
			} else if (comparatorType.equals(ComparatorEnumType.CONTAINS)) {
				if (args.length > argNum) {
					if (args[argNum].contains(argVal)) {
						ruleApplicable = true;
					} else {
						ruleApplicable = false;
					}
				} else {
					ruleApplicable = false;
				}
			} else {
				// invalid comparator
				ruleApplicable = false;
				break;
			}

		}

		return ruleApplicable;
	}

	private String appendData(List<String> lineData, int lineNum, String argDelim, int maxArgs){
		String dataValue = "";
			int l = lineNum + 1;
			String line = "";
			//System.out.println("MAX_ARGS = " + maxArgs);
			while((line = lineData.get(l)) != null){				
				String[] tokens = line.split(argDelim);		
				// hacks, hacks and more hacks
				if(tokens.length < maxArgs && !line.equals("<?xml version=\"1.0\"?>")){
					dataValue += "\n" + line;					
				}
				else if(line.equals("<?xml version=\"1.0\"?>")){
					// do nothing
				}
				else{
					break;
				}
				l++;
			}
			//System.out.println("Data = " + dataValue);
		return dataValue;
	}
	
	private Annotation[] setAnnotations(String[] args, AnnotationType[] annotationType,
			NotificationType notificationType, List<String> lineData,
			int lineNum, String argDelim, int maxArgs){
		Annotation[] annotations = new Annotation[annotationType.length];
		for (int i = 0; i < annotationType.length; i++) {
			ProvenanceDataType annotationsData = annotationType[i]
					.getValue();

			UriType uriType = annotationsData.getUriInfo();
			String uriPrefix = uriType.getIdentifier();
			if (uriType.getType() == UriEnumType.URN) {
				uriPrefix = "urn:" + uriPrefix + ":";
			}

			String annotationValue = dataSelector.getProvenanceData(args,
					notificationType, annotationsData);
			//System.out.println("ANNOTATION: " + annotationValue);
			String property = uriPrefix
					+ annotationType[i].getProperty();
			
			//annotationValue += appendData(lineData, lineNum, argDelim, maxArgs);

			annotations[i] = new Annotation(property, annotationValue);
		}
		return annotations;
	}
	
	private String lookUpActorID(String substring){
		String actorId=substring;
		for(int i=0;i<actorList.size();i++)
		{
			if(actorList.get(i).toString().contains(substring)){
				actorId=actorList.get(i).toString();
				break;
			}
		}
		return actorId;
	}
	
	/*
	 * Application related provenance is extracted from application standard output.
	 */	
	private boolean createApplicationNotificationData(String[] args, Calendar notificationTime, NotificationType notificationType,
			NotificationData[] notificationDataList, List<String> lineData, int lineNum,
			String argDelim, int maxArgs){
		ActorsType[] actorsType = notificationType.getActorsArray();
		int notificationId = notificationType.getNotificatonId();
		//System.out.println("\n<CREATE_NOTIFICATION_DATA>\n"+lineData.get(lineNum));
		//System.out.println("\n<CREATE_NOTIFICATION_DATA>\n"+lineData.get(lineNum+8));
		DataType[] dataObjectType = notificationType.getDataBlocksArray();
		DataBlock[] dataBlocks = new DataBlock[dataObjectType.length];
		String data="";
		if (dataObjectType.length > 0) {
			for (int i = 0; i < dataObjectType.length; i++) {

				ProvenanceDataType dataValueData = dataObjectType[i]
						.getDataValue();

				UriType uriType = dataValueData.getUriInfo();
				String uriPrefix = uriType.getIdentifier();
				if (uriType.getType() == UriEnumType.URN) {
					uriPrefix = "urn:" + uriPrefix + ":";
				}
				String dataId = uriPrefix + dataObjectType[i].getDataId();
				// + "-" + instanceID;
				String dataName = dataObjectType[i].getDataId();

				String dataValue = dataSelector.getProvenanceData(args,
						notificationType, dataValueData);
				
				// hacks, hacks and more hacks
				if(dataValue.equals("XML:")){
					dataValue="";
				}
				// can be optimized by setting a flag in xml
				dataValue += appendData(lineData, lineNum, argDelim, maxArgs);
				DataEnumType.Enum dataType = dataObjectType[i]
						.getDataType();

				dataBlocks[i] = new DataBlock(dataId, dataName, dataValue,
						dataType);
				
				data=data+dataValue;
			}

			
			
		}
		String[] list=data.trim().split("\\s+");
		int hostcount=0;
		String[] hostlist=new String[4];
		int j=0;
		for(int i=0;i<list.length;i++){
			//System.out.println("++"+list[i]);
			if(list[i].startsWith("hostname=")){
				if((hostcount==0)||(hostcount==1)||(hostcount==2)||(hostcount==4)){
					hostlist[j]=list[i].replaceFirst("hostname=", "");
					j++;
				}
				hostcount++;
				
			}
		}
		//If hostcount==5, 
		//we know that the data was produced by Client, 
		//not the Master (hack)
		if(hostcount==5){
			for(int i=0;i<hostlist.length;i++){
//				System.out.println("++"+hostlist[i]);
			}
		}else{
			return false;
		}

		String hostname=lineData.get(lineNum+8).split(":")[3].split("@")[1];
		
		String[][] hostMaps=new String[4][2];
		for(int h=0;h<hostMaps.length;h++){
			hostMaps[h]=new String[2];
		}
		hostMaps[0][0]=hostname;
		hostMaps[0][1]=hostlist[0];
		hostMaps[1][0]=hostlist[1];
		hostMaps[1][1]=hostname;
		hostMaps[2][0]=hostlist[2];
		hostMaps[2][1]=hostname;
		hostMaps[3][0]=hostname;
		hostMaps[3][1]=hostlist[3];

		ActorEnumType.Enum[] actorType = new ActorEnumType.Enum[2];
		actorType[0]=ActorEnumType.INVOKER;
		actorType[1]=ActorEnumType.INVOKEE;
		ActorEntityEnumType.Enum actorEntityType =ActorEntityEnumType.SERVICE;
		Actor[][] actorList=new Actor[4][2];
		for(int h=0;h<actorList.length;h++){
			actorList[h]=new Actor[2];
		}
		for(int h=0;h<hostMaps.length;h++){
			for (int i = 0; i < actorList[h].length; i++) {
				actorList[h][i] = new Actor(lookUpActorID(hostMaps[h][i]), actorType[i], actorEntityType);
				ParentType[] parentType = actorsType[0].getParentArray();
				if (parentType.length > 0) {
					String[] parentId = new String[parentType.length];
					for (int j2 = 0; j2 < parentType.length; j2++) {
						ProvenanceDataType parentData = parentType[j2]
								.getParentId();
						UriType parentUriType = parentData.getUriInfo();
						String parentUriPrefix = parentUriType
								.getIdentifier();
						if (parentUriType.getType() == UriEnumType.URN) {
							parentUriPrefix = "urn:" + parentUriPrefix
									+ ":";
						}

						parentId[j2] = parentUriPrefix
								+ dataSelector.getProvenanceData(args, notificationType,
										parentData);
						parentId[j2] = parentId[j2] + ":" + instanceID;
					}
					actorList[h][i].setParentIds(parentId);
				}
/*
				AnnotationType[] actorAnnotationType = actorsType[0].getAnnotationsArray();
				if (actorAnnotationType.length > 0) {
					//System.out.println(actorId);
					Annotation[] actorAnnotations = new Annotation[actorAnnotationType.length];
					actorAnnotations = setAnnotations(args, actorAnnotationType, notificationType, lineData, lineNum, argDelim, maxArgs);
					actorList[h][i].setAnnotations(actorAnnotations);
				}
*/
				if (actorsType[0].isSetOnBehalfOf()) {
					ProvenanceDataType onBehalfOfData = actorsType[0]
							.getOnBehalfOf();
					UriType behUriType = onBehalfOfData.getUriInfo();
					String behUriPrefix = behUriType.getIdentifier();
					if (behUriType.getType() == UriEnumType.URN) {
						behUriPrefix = "urn:" + behUriPrefix + ":";
					}
					String onBehalfOfID = behUriPrefix
							+ dataSelector.getProvenanceData(args, notificationType,
									onBehalfOfData);
					actorList[h][i].setBehalfId(onBehalfOfID);
				}

				if (actorsType[0].isSetTimestep()) {
					actorList[h][i].setTimestep(actorsType[0].getTimestep());
				}
			
			}
			
			if (notificationType.isSetNotificationTime()) {
				/*
				 * else if notification-time is set then, get the
				 * notification-time based on the selection-type
				 */
				TimestampType timestampType = notificationType
						.getNotificationTime();
				if (timestampType.isSetFileTimestampLocator()) {
					SelectMethodType selectType = timestampType
							.getFileTimestampLocator();
					DataSelector ds = new DataSelector(logFileName);
					String ts = ds.getProvenanceData(null, selectType);
					Date date = convertStrToDate(ts);
					notificationTime.setTime(date);
				} else if (timestampType.isSetTimestamp()) {
					SelectMethodType selectType = timestampType.getTimestamp();
					DataSelector ds = new DataSelector();
					String ts = ds.getProvenanceData(args, selectType);
					Date date = convertStrToDate(ts);
					notificationTime.setTime(date);
				} else {
					// handle the rest later
				}
			}
			
			notificationDataList[h].saveActor(actorList[h]);
		}

		return true;
	}
	
	private void createNotificationData(String[] args, Calendar notificationTime, NotificationType notificationType,
			NotificationData notificationData, List<String> lineData, int lineNum,
			String argDelim, int maxArgs){
		
		ActorsType[] actorsType = notificationType.getActorsArray();
		int notificationId = notificationType.getNotificatonId();
		//System.out.println("NOTIFICATION_ID: " + notificationId); 
		Actor[] actors = new Actor[actorsType.length];
		if (actorsType.length > 0) {
//			System.out.println("\n<CREATE_NOTIFICATION_DATA>\n"+lineData.get(lineNum));
//			for(int kk=0;kk<args.length;kk++){
//			System.out.println(args[kk]);
//			}
//			System.out.println("NOTIFICATION_ID: " + notificationType.getNotificatonId()+" + "+notificationType.getNotificationType().toString()); //added by Yuan for testing
			for (int i = 0; i < actorsType.length; i++) {
				ProvenanceDataType actorData = actorsType[i].getActorId();

				/* argNum not reqd, need to remove from the API */
				// int argNum = actorData.getArgumentNumber();

				UriType uriType = actorData.getUriInfo();
				String uriPrefix = uriType.getIdentifier();
				if (uriType.getType() == UriEnumType.URN) {
					uriPrefix = "urn:" + uriPrefix + ":";
				}
				
				String prefix = uriPrefix;

				ActorEnumType.Enum actorType = actorsType[i].getActorType();
				ActorEntityEnumType.Enum actorEntityType = actorsType[i]
						.getEntityType();
				
				String originalId = dataSelector.getProvenanceData(args, notificationType, actorData);
				AppenderType[] idAppenders = actorsType[i].getAppendIdArray();
				String appender = "";
				if(idAppenders.length > 0){
					//System.out.println("*****originalId*****="+originalId);
					for (int j = 0; j < idAppenders.length; j++) {
						 
						if(idAppenders[j].isSetSelectMethod()){
							appender = dataSelector.getProvenanceData(args, idAppenders[j].getSelectMethod());
							prefix += appender + ":";
						}
						if(idAppenders[j].isSetAutoIncrement()){
							if(incrementerList.containsKey(originalId+notificationId)){
								appender += incrementerList.get(originalId+notificationId).toString();
								prefix += appender + ":";
								incrementerList.put(originalId+notificationId, Integer.valueOf(incrementerList.get(originalId+notificationId).intValue()+1));
							}else {
								incrementerList.put(originalId+notificationId, Integer.valueOf(1));
							}
						} 
						else{
							// invalid option
						}
					}								
				}
				String actorId = prefix + originalId;
				//System.out.println("----actorId === "+actorId);	
				/*if (actorEntityType == ActorEntityEnumType.WORKFLOW) {
					actorId = actorId + ":" + instanceID;
				}*/
				actorId = actorId + ":" + instanceID;
				
				
				//System.out.println("prefix === "+prefix);
				//System.out.println("originalId === "+originalId);
				//System.out.println("instanceID === "+instanceID);
				
				/*
				 * The if branch:
				 * hard coded the dependency type
				 * process-on-host  -> ("HOST", "PROCESS")
				 * better to put this in rule file, possible schema change
				 * 
				 * */
				if(uriPrefix=="process-on-host"){
					//System.out.println("process-on-host"+actorId.split(":")[2]+"**"+actorId.split(":")[3]+"**"+actorId.split(":")[3]);
					depData.savedependencyData("HOST", "PROCESS", actorId.split(":")[3], actorId.split(":")[2]);
				}
				
				actors[i] = new Actor(actorId, actorType, actorEntityType);

				ActorEntityEnumSubtype.Enum actorEntitySubtype = null;
				if (actorsType[i].isSetEntitySubtype()) {
					actorEntitySubtype = actorsType[i].getEntitySubtype();
					actors[i].setEntitySubtype(actorEntitySubtype);
				}

				ParentType[] parentType = actorsType[i].getParentArray();
				if (parentType.length > 0) {
					String[] parentId = new String[parentType.length];
					for (int j = 0; j < parentType.length; j++) {
						ProvenanceDataType parentData = parentType[j]
								.getParentId();
						UriType parentUriType = parentData.getUriInfo();
						String parentUriPrefix = parentUriType
								.getIdentifier();
						if (parentUriType.getType() == UriEnumType.URN) {
							parentUriPrefix = "urn:" + parentUriPrefix
									+ ":";
						}

						parentId[j] = parentUriPrefix
								+ dataSelector.getProvenanceData(args, notificationType,
										parentData);
						/*ParentEnumType.Enum parType = parentType[j]
								.getParentType();
						if (parType == ParentEnumType.WORKFLOW
								|| parType == ParentEnumType.USER) {
							parentId[j] = parentId[j] + ":" + instanceID;
						}*/
						parentId[j] = parentId[j] + ":" + instanceID;
					}
					actors[i].setParentIds(parentId);
				}

				AnnotationType[] actorAnnotationType = actorsType[i].getAnnotationsArray();
				if (actorAnnotationType.length > 0) {
					//System.out.println(actorId);
					Annotation[] actorAnnotations = new Annotation[actorAnnotationType.length];
					actorAnnotations = setAnnotations(args, actorAnnotationType, notificationType, lineData, lineNum, argDelim, maxArgs);
					actors[i].setAnnotations(actorAnnotations);
				}

				if (actorsType[i].isSetOnBehalfOf()) {
					ProvenanceDataType onBehalfOfData = actorsType[i]
							.getOnBehalfOf();
					UriType behUriType = onBehalfOfData.getUriInfo();
					String behUriPrefix = behUriType.getIdentifier();
					if (behUriType.getType() == UriEnumType.URN) {
						behUriPrefix = "urn:" + behUriPrefix + ":";
					}
					String onBehalfOfID = behUriPrefix
							+ dataSelector.getProvenanceData(args, notificationType,
									onBehalfOfData);
					actors[i].setBehalfId(onBehalfOfID);
				}

				if (actorsType[i].isSetTimestep()) {
					actors[i].setTimestep(actorsType[i].getTimestep());
				}
			}
	
			for(int k=0;k<actors.length;k++){
				//System.out.println("ACTOR ID="+actors[k].getActorId());
				actorList.add(actors[k].getActorId());
			}

			notificationData.saveActor(actors);
		}

		DataType[] dataObjectType = notificationType.getDataBlocksArray();
		DataBlock[] dataBlocks = new DataBlock[dataObjectType.length];
		if (dataObjectType.length > 0) {
			for (int i = 0; i < dataObjectType.length; i++) {

				ProvenanceDataType dataValueData = dataObjectType[i]
						.getDataValue();

				UriType uriType = dataValueData.getUriInfo();
				String uriPrefix = uriType.getIdentifier();
				if (uriType.getType() == UriEnumType.URN) {
					uriPrefix = "urn:" + uriPrefix + ":";
				}
				String dataId = uriPrefix + dataObjectType[i].getDataId();
				// + "-" + instanceID;
				String dataName = dataObjectType[i].getDataId();

				String dataValue = dataSelector.getProvenanceData(args,
						notificationType, dataValueData);
				
				
				// hacks, hacks and more hacks
				if(dataValue.equals("XML:")){
					dataValue="";
				}
				// can be optimized by setting a flag in xml
				dataValue += appendData(lineData, lineNum, argDelim, maxArgs);
				DataEnumType.Enum dataType = dataObjectType[i]
						.getDataType();

				dataBlocks[i] = new DataBlock(dataId, dataName, dataValue,
						dataType);
			}
			notificationData.saveDataBlock(dataBlocks);
		}

		AnnotationType[] annotationType = notificationType.getAnnotationsArray();
		
		if (annotationType.length > 0) {
			Annotation[] annotations = setAnnotations(args, annotationType, notificationType, lineData, lineNum, argDelim, maxArgs);
			notificationData.saveAnnotation(annotations);
		}

		/*
		 * if start-time is set and notification-time is not, then only use
		 * the start-time as the global notification-time
		 */
		//if (timestamp != null && !notificationType.isSetNotificationTime()) {
		if (notificationType.isSetNotificationTime()) {
			/*
			 * else if notification-time is set then, get the
			 * notification-time based on the selection-type
			 */
			TimestampType timestampType = notificationType
					.getNotificationTime();
			if (timestampType.isSetFileTimestampLocator()) {
				SelectMethodType selectType = timestampType
						.getFileTimestampLocator();
				DataSelector ds = new DataSelector(logFileName);
				String ts = ds.getProvenanceData(null, selectType);
				Date date = convertStrToDate(ts);
				notificationTime.setTime(date);
			} else if (timestampType.isSetTimestamp()) {
				SelectMethodType selectType = timestampType.getTimestamp();
				DataSelector ds = new DataSelector();
				String ts = ds.getProvenanceData(args, selectType);
				Date date = convertStrToDate(ts);
				notificationTime.setTime(date);
			} else {
				// handle the rest later
			}
		}
		/*else {
			if (timestamp != null) {
				Date date = convertStrToDate(timestamp);
				notificationTime.setTime(date);
			}
		}*/
		
		checkDependencies(notificationId, lineData, lineNum, argDelim, maxArgs, notificationData);
	}
	
	private String getMatchingName(String[] params, MatchRuleType rule){
		DataSelector ds = new DataSelector();
		SelectMethodType matchDataRule = rule.getMatchDataValue();
		String matchData = ds.getProvenanceData(params, matchDataRule);
		//System.out.println("----------- ()()()()()matchData: "+ matchData);
		
		return matchData;
	}
	
	private String getMatchingValue(String[] params, MatchRuleType rule){
		DataSelector ds = new DataSelector();
		SelectMethodType matchDataRule = rule.getMatchDataValue();
		String matchData = ds.getProvenanceData(params, matchDataRule);
		//System.out.println("----------- ()()()()()matchData: "+ matchData);
		
		String targetData = depData.getMappedValue(matchData);
		if(targetData == null){
			//System.out.println("----------- LINE: "+ params[params.length-1]);
			String name = rule.getMatchDataName();
			//targetData = depData.getRandomMappedValue(matchData, name);
		}
		return targetData;
	}
	
	private void createDependencyLinks(){
		for (int i = 0; i < depLinks.length; i++) {
			String sourceName = depLinks[i].getSource();
			String targetName = depLinks[i].getTarget();
			//System.out.println("CreateDependencyLinks...\nsourceName="+sourceName+"   targetName="+targetName);
			depData.doMapping(sourceName, targetName);			
		}
	}
	
	private void checkDependencies(int currId, List<String> lineData, int lineNum,
									String argDelim, int maxArgs, NotificationData notificationData){		
		String line = null;
		String[] params = null;
		String[] matchedData = null;
		int n;
		for (int i = 0; i < dependencies.length; i++) {
			int tgtId = dependencies[i].getTargetNotificationId();
			if(currId == tgtId){
				createDependencyLinks();
				
				MatchRuleType[] rules = dependencies[i].getMatchRuleArray();
				matchedData = new String[rules.length];
				for (int j = 0; j < rules.length; j++) {
					if(rules[j].getMatchLineType().equals(MatchLineEnumType.PREV_NTH_LINE)){
						n = lineNum-1;
						params = lineData.get(n).split(argDelim);
						//System.out.println("$$$$$$$$"+lineData.get(lineNum));
						String mapData = getMatchingValue(params, rules[j]);
						//System.out.println("########["+j+"] "+mapData);
						matchedData[j] = new String(mapData);
					}
					else if(rules[j].getMatchLineType().equals(MatchLineEnumType.NEXT_NTH_LINE)){
						for (int k = 0; k < lineData.size(); k++) {
							n = lineNum+k+1;
							if((line = lineData.get(n)) != null){
								String[] vals = line.split(argDelim);
								if (vals.length >= maxArgs && 
										vals[0].equals(lineData.get(lineNum).split(argDelim)[0])){ // hack... need to resolve using rules!!!
									params = line.split(argDelim);
									/* 
									 * Use getMatchingName() instead of getMatchingValue()
									 * May not work for different applications...
									 */
									//String mapData = getMatchingValue(params, rules[j]);
									String mapData = getMatchingName(params, rules[j]);
									matchedData[j] = new String(mapData);
									//System.out.println("########2["+j+"] "+mapData);
									break;
								}
							}
						}
					}
					else{
						// invalid line-type
					}
				}
				// restructure actors
				ActorEnumType.Enum srcType = dependencies[i].getSourceActorType();
				ActorEnumType.Enum tgtType = dependencies[i].getTargetActorType();
				String srcKey = Integer.toString(dependencies[i].getSourceNotificationId());
				String tgtKey = Integer.toString(dependencies[i].getTargetNotificationId());
				Restructurer reformat = new Restructurer();
				//System.out.println("++++++++++++         srcKey="+srcKey+" tgtKey="+tgtKey+" srcType"+srcType+" tgtType"+tgtType);
				reformat.restructureActors(srcKey, tgtKey, srcType, tgtType, 
						notificationData, notificationList, matchedData);
			}
		}
		
	}
	
	public void saveNotificationData(String[] args, Rule rule, List<String> lineData, int lineNum,
			String argDelim, int maxArgs) {
		NotificationType notificationType = rule.getNotification();
		int notificationId = notificationType.getNotificatonId();		

		Calendar notificationTime = Calendar.getInstance();
		NotificationEnumType.Enum notificationEnumType = notificationType
				.getNotificationType();

		boolean isDistinct = false;
		if(rule.isSetIsDistinct()){
			isDistinct = rule.getIsDistinct();
		}

		NotificationData notificationData = null;
		Notifications notification = null;

		String id = Integer.toString(notificationId);
		List idlist = null;

		if (notificationList.containsKey(id) && !isDistinct) {
			idlist = (List) notificationList.get(id);			
		} 
		else {
			notification = new Notifications();
			notificationData = new NotificationData(notification,
					notificationEnumType, notificationTime);
			if(notificationType.getNotificatonId()==-1){
				NotificationData[] notificationDataList=new NotificationData[4];
				for(int i=0;i<notificationDataList.length;i++){
					notification = new Notifications();
					notificationDataList[i]=new NotificationData(notification, notificationEnumType, notificationTime);
				}
				if(createApplicationNotificationData(args, notificationTime, notificationType, notificationDataList, lineData, lineNum, argDelim, maxArgs)){
					for(int i=0;i<notificationDataList.length;i++){
						notificationList.put(id, notificationDataList[i]);
					}
				}
			}else{
				createNotificationData(args, notificationTime, notificationType, notificationData, lineData, lineNum, argDelim, maxArgs);
				notificationList.put(id, notificationData);
			}
			
		}
		
		if(notificationList.containsKey(id)){
			//incrementer = ((List) notificationList.get(id)).size();
		}

		if(idlist != null){
			for (int notifId = 0; notifId < idlist.size(); notifId++) {
				NotificationData notifData = (NotificationData)idlist.get(notifId);
				createNotificationData(args, notificationTime, notificationType, notifData,
						lineData, lineNum, argDelim, maxArgs);
			}
		}
	}

	public void ingestNotificationData(DependencyType[] dependencies) {
		Restructurer reformat = new Restructurer();
		
		/*String srcKey = "4";
		String tgtKey = "7";
		ActorEnumType.Enum srcType = ActorEnumType.INVOKEE;
		ActorEnumType.Enum tgtType = ActorEnumType.INVOKER;
		reformat.restructureActors(srcKey, tgtKey, srcType, tgtType);
		
		srcKey = "7";
		tgtKey = "3";
		srcType = ActorEnumType.INVOKEE;
		tgtType = ActorEnumType.PRODUCER;
		reformat.restructureActors(srcKey, tgtKey, srcType, tgtType);*/
		
		if(dependencies != null){
			System.out.println("Applying dependency rules...");
			for (int i = 0; i < dependencies.length; i++) {
				String srcKey = Integer.toString(dependencies[i].getSourceNotificationId());
				String tgtKey = Integer.toString(dependencies[i].getTargetNotificationId());
				ActorEnumType.Enum srcType = dependencies[i].getSourceActorType();
				ActorEnumType.Enum tgtType = dependencies[i].getTargetActorType();
				//reformat.globallyRestructureActors(srcKey, tgtKey, srcType, tgtType, notificationList);
			}
		}
		
		NotificationIngester ingester = new NotificationIngester(sender,
				notificationList);
		ingester.ingestNotifications();
	}
}
