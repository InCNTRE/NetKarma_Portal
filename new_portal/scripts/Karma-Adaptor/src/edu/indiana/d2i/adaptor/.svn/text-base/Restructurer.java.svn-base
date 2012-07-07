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
# File:  Restructurer.java
# Description:  Resets the actors based on the rules.
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import java.util.List;
import java.util.Vector;

import org.apache.commons.collections.MultiHashMap;
import org.dataandsearch.netkarma.ActorEntityEnumType;
import org.dataandsearch.netkarma.ActorEnumType;

public class Restructurer {
	
	public Restructurer(){
		super();
	}
	
	private boolean resetSpecificActor(Actor srcActor, Actor tgtActor){
		
		String[] srcActorIdTokens = srcActor.getActorId().split(":");
		String[] tgtActorIdTokens = tgtActor.getActorId().split(":");
		
		if(srcActorIdTokens[3].equals(tgtActorIdTokens[2]) ||
				srcActorIdTokens[2].equals(tgtActorIdTokens[3]) ||
				srcActorIdTokens[2].equals(tgtActorIdTokens[2]) ||
				srcActorIdTokens[3].equals(tgtActorIdTokens[3])){		
			tgtActor.setActorId(srcActor.getActorId());
			if(srcActor.getParentIds() != null){
				tgtActor.setParentIds(srcActor.getParentIds());
			}
			tgtActor.setTimestep(srcActor.getTimestep());
			tgtActor.setEntityType(srcActor.getEntityType());
			if(srcActor.getAnnotations() != null){
				tgtActor.setAnnotations(srcActor.getAnnotations());
			}
			//System.out.println("MATCH! "+srcActor.getActorId()+","+tgtActor.getActorId());
			return true;
		/*if(srcActor.getBehalfId() != null){
			tgtActor.setBehalfId(srcActor.getBehalfId());
		}*/
		}
		//System.out.println("MISMATCH! "+srcActor.getActorId()+","+tgtActor.getActorId());
		return false;
	}
	
	private void resetActor(Actor srcActor, Actor tgtActor){	
			tgtActor.setActorId(srcActor.getActorId());
			if(srcActor.getParentIds() != null){
				tgtActor.setParentIds(srcActor.getParentIds());
			}
			tgtActor.setTimestep(srcActor.getTimestep());
			tgtActor.setEntityType(srcActor.getEntityType());
			if(srcActor.getAnnotations() != null){
				tgtActor.setAnnotations(srcActor.getAnnotations());
			}
	}
	
	public void globallyRestructureActors(String srcKey, String tgtKey,
			ActorEnumType.Enum srcType, ActorEnumType.Enum tgtType,
			MultiHashMap notificationList){
			List srcList = (List) notificationList.get(srcKey);
			List tgtList = (List) notificationList.get(tgtKey);
			if(srcList != null && tgtList != null){
				int srcSize = srcList.size();
				int tgtSize = tgtList.size();
				//System.out.println("K1: "+ srcKey + ", K2: " + tgtKey);
				//System.out.println("S: "+srcSize+", T:"+tgtSize);
				int innerIter = 0;
				if(srcSize < tgtSize){
					innerIter = srcSize;
				}
				else {
					innerIter = tgtSize;
				}
				
				int outerIter = tgtSize/srcSize;
				boolean isActorReset = true;
				//System.out.println("T: "+tgtSize+", S: "+srcSize);
				for (int i = 0; i < outerIter; i++) {
					for (int j = 0; j < innerIter; j++) {
						int x = i*innerIter+j;
						NotificationData tgtData = (NotificationData)tgtList.get(x);
						Notifications tgtNotification = tgtData.getNotification(); 
						Vector<Actor> tgtActors = tgtNotification.getActors();
						Actor tgtActor = null;
						for (int t = 0; t < tgtActors.size(); t++) {
							tgtActor = tgtActors.get(t);
							ActorEnumType.Enum actorType = tgtActor.getActorType();
							if(actorType == tgtType){
								break;
							}										
						}
						NotificationData srcData = (NotificationData)srcList.get(j);
						Notifications srcNotification = srcData.getNotification();
						Vector<Actor> srcActors = srcNotification.getActors();
						Actor srcActor = null;
						for (int s = 0; s < srcActors.size(); s++) {
							srcActor = srcActors.get(s);
							ActorEnumType.Enum actorType = srcActor.getActorType();
							if(actorType == srcType){
								break;
							}										
						}
						//System.out.println(srcActor.getActorId()+","+tgtActor.getActorId());
						resetSpecificActor(srcActor, tgtActor);		
					}
					//System.exit(0);
				}
				
				int rem = tgtSize%srcSize;			
				if(rem != 0){
					int x = outerIter*innerIter;
					int m = x;
					for (int j = 0; j < srcSize; j++) {
						if(isActorReset){
							m = x+j;
							//System.out.println("X = " + x);
						}
						if(m >= (outerIter*innerIter+rem)){
							break;
						}
						NotificationData tgtData = (NotificationData)tgtList.get(m);
						Notifications tgtNotification = tgtData.getNotification(); 
						Vector<Actor> tgtActors = tgtNotification.getActors();
						Actor tgtActor = null;
						for (int t = 0; t < tgtActors.size(); t++) {
							tgtActor = tgtActors.get(t);
							ActorEnumType.Enum actorType = tgtActor.getActorType();
							if(actorType == tgtType){
								break;
							}										
						}
						NotificationData srcData = (NotificationData)srcList.get(j);
						Notifications srcNotification = srcData.getNotification();
						Vector<Actor> srcActors = srcNotification.getActors();
						Actor srcActor = null;
						for (int s = 0; s < srcActors.size(); s++) {
							srcActor = srcActors.get(s);
							ActorEnumType.Enum actorType = srcActor.getActorType();
							if(actorType == srcType){
								break;
							}										
						}
						//System.out.println(srcActor.getActorId()+","+tgtActor.getActorId());					
						isActorReset = resetSpecificActor(srcActor, tgtActor);						
					}
				}
			}
			//System.exit(0);
	}
	
	public void restructureActors(String srcKey, String tgtKey,
			ActorEnumType.Enum srcType, ActorEnumType.Enum tgtType,
			NotificationData tgtData, MultiHashMap notificationList,
			String[] matchedData){
		
		List srcList = (List) notificationList.get(srcKey);
		if(srcList != null){
			int srcSize = srcList.size();
			
			Notifications tgtNotification = tgtData.getNotification(); 
			Vector<Actor> tgtActors = tgtNotification.getActors();
			Actor tgtActor = null;
			for (int t = 0; t < tgtActors.size(); t++) {
				tgtActor = tgtActors.get(t);
				ActorEnumType.Enum actorType = tgtActor.getActorType();
				if(actorType == tgtType){
					break;
				}										
			}
			for (int j = 0; j < srcSize; j++) {
				NotificationData srcData = (NotificationData)srcList.get(j);
				Notifications srcNotification = srcData.getNotification();
				Vector<Actor> srcActors = srcNotification.getActors();
				Actor srcActor = null;
				for (int s = 0; s < srcActors.size(); s++) {
					srcActor = srcActors.get(s);
					ActorEnumType.Enum actorType = srcActor.getActorType();
					if(actorType == srcType){
						break;
					}										
				}
				boolean isReplacable = true;
				for (int i = 0; i < matchedData.length; i++) {
					if(!(srcActor.getActorId().contains(matchedData[i]))){
						isReplacable = false;
						break;
					}
				}
				if(isReplacable){
					resetActor(srcActor, tgtActor);
					break;
				}			
			}
		}
		//srcData.getNotificationTime();
		//tgtData.getNotificationTime();				
	}
}
