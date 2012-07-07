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
# File:  DependencyData.java
# Description:  Stores the dependency-data and links.
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections.MultiHashMap;
import org.dataandsearch.netkarma.ComparatorEnumType;
import org.dataandsearch.netkarma.FilterPredicateEnumType;
import org.dataandsearch.netkarma.FilterType;
import org.dataandsearch.netkarma.Rule;

public class DependencyData {
	MultiHashMap dependencyDataList = null;
	Hashtable<MapType, MultiHashMap> dependencyDataLists = null; 
	MultiHashMap dependencyMappingList = null;
	Hashtable<MapType, MultiHashMap> dependencyMappingLists = null; 
	RuleApplier ruleApplier = null;
	
	class MapType{
		String source=null;
		String target=null;
	}
		
	public DependencyData(){
		dependencyDataList = new MultiHashMap();
		dependencyDataLists = new Hashtable<MapType, MultiHashMap>(); 
		dependencyMappingList = new MultiHashMap();
		dependencyMappingLists = new Hashtable<MapType, MultiHashMap>(); 
		ruleApplier = new RuleApplier();
	}
	
	public boolean doesRuleApply(String args[], FilterType[] filters){
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
	
	public void savedependencyData(String source, String target, String name, String value){		
		MultiHashMap dependencyDataList=null;
		Enumeration<MapType> maptypelist= dependencyDataLists.keys();
		MapType maptype=null;
		while (maptypelist.hasMoreElements()){
			MapType mt=maptypelist.nextElement();
			if(mt.source.equals(source)&&mt.target.equals(target)){
				 dependencyDataList=dependencyDataLists.get(mt);
				 maptype=mt;
				 break;
			}
		}
			
		if(dependencyDataList==null){
			//System.out.println("*************Creating new dependencyDataList, source="+source+" target="+target);
			dependencyDataList=new MultiHashMap();
			maptype=new MapType();
			maptype.source=source;
			maptype.target=target;
		}
		dependencyDataList.put(name, value);
		dependencyDataLists.put(maptype, dependencyDataList);
		//System.out.println("======saveData==  S:"+source+" T:"+target+" =====  N: "+ name + ", V: " + value);
	}
	
	public MultiHashMap getdependencyData(String source, String target){
		MultiHashMap dependencyDataList=null;
		Enumeration<MapType> maptypelist= dependencyDataLists.keys();
		MapType maptype=null;
		while (maptypelist.hasMoreElements()){
			MapType mt=maptypelist.nextElement();
			if(mt.source.equals(source)&&mt.target.equals(target)){
				 dependencyDataList=dependencyDataLists.get(mt);
				 return dependencyDataList;
			}
		}
		return null;
	}
	public MultiHashMap getdependencyMapping(String source, String target){
		MultiHashMap dependencyMappingList=null;
		Enumeration<MapType> maptypelist= dependencyMappingLists.keys();
		MapType maptype=null;
		while (maptypelist.hasMoreElements()){
			MapType mt=maptypelist.nextElement();
			if(mt.source.equals(source)&&mt.target.equals(target)){
				 dependencyMappingList=dependencyMappingLists.get(mt);
				 return dependencyMappingList;
			}
		}
		return null;
	}
	
/*	private void setMapping(List sourceData, List targetData, int sourceIter, int targetIter){
		int iter = sourceIter/targetIter;
		int remIter = sourceIter%targetIter;
		int k;
		
		for(int i =0; i<sourceIter;i++){
			dependencyMapping.put((String)sourceData.get(i), (String)dependencyData.get(sourceData.get(i)));
			System.out.println("<1> S = " + (String)sourceData.get(i) + ", T = " + (String)dependencyData.get(targetData.get(i)));
		}
		
		for (int i = 0; i < iter; i++) {			
			for (int j = 0; j < targetIter; j++) {
				k = j+i*targetIter;
				dependencyMapping.put((String)sourceData.get(k), (String)targetData.get(j));
				System.out.println("<1> S = " + (String)sourceData.get(k) + ", T = " + (String)targetData.get(j));
			}
		}
		
		if(sourceIter > targetIter && remIter != 0){
			for (int i = 0; i < remIter; i++) {	
				k = targetIter*iter+i;
				dependencyMapping.put((String)sourceData.get(k), (String)targetData.get(i));
				System.out.println("<2> S = " + (String)sourceData.get(k) + ", T = " + (String)targetData.get(i));
			}
		}	
		else if(sourceIter < targetIter){
			for (int i = 0; i < remIter; i++) {	
				dependencyMapping.put((String)sourceData.get(i), (String)targetData.get(i));
				System.out.println("<3> S = " + (String)sourceData.get(i) + ", T = " + (String)targetData.get(i));
			}
		}

	}
*/	
	public void doMapping(String sourceName, String targetName){
		
		MultiHashMap MapList_x=getdependencyData(sourceName, targetName);
		MultiHashMap MapList_y=getdependencyMapping(sourceName, targetName);
		if(MapList_y!=null){
			return;
		}
		MapType mt=new MapType();
		mt.source=sourceName;
		mt.target=targetName;
		
		if(MapList_x!=null){
			dependencyMappingLists.put(mt, MapList_x);
			return;
		}
		MultiHashMap MapList=new MultiHashMap();
		//System.out.println("doMapping.................");
		Enumeration<MapType> maptypelist1= dependencyDataLists.keys();
		Enumeration<MapType> maptypelist2= dependencyDataLists.keys();
		while (maptypelist1.hasMoreElements()){
			MapType mt1=maptypelist1.nextElement();
			//System.out.println("source="+mt1.source+" target="+mt1.target);
			if (mt1.source.equals(sourceName)){
				while (maptypelist2.hasMoreElements()){
					MapType mt2=maptypelist2.nextElement();
					if(mt2.target.equals(targetName)){
						//Currently, we only join two mappinglists that can be joined directly
						if(mt1.target.equals(mt2.source)){
							//System.out.println("source1="+mt1.source+" target1="+mt1.target+" source2="+mt2.source+" target2="+mt2.target);
							
							MultiHashMap MapList1=dependencyDataLists.get(mt1);
							MultiHashMap MapList2=dependencyDataLists.get(mt2);
							Set<String> keyset1=MapList1.keySet();
							Set<String> keyset2=MapList2.keySet();
							
							Iterator keys1 = keyset1.iterator();
							Iterator keys2 = keyset2.iterator();
							
							while(keys1.hasNext()){
								Object key1=keys1.next();
								ArrayList<String> valueSet1=(ArrayList)MapList1.get(key1);
								
								for(int b=0;b<valueSet1.size();b++){
									ArrayList<String> valueSet2=(ArrayList)MapList2.get(valueSet1.get(b));
									//System.out.println("key1="+(String)key1+" value1="+valueSet1.get(b));
									if(valueSet2!=null){
										for(int c=0;c<valueSet2.size();c++){
											MapList.put(key1, valueSet2.get(c));
											//System.out.println("DO MAPPING....KEY="+(String)key1+" VALUE="+valueSet2.get(c));
										}
									}
								}
								
							}
						}
					}
				}
			}
		}
		dependencyMappingLists.put(mt, MapList);
				
/*		
		List sourceData = (List) dependencyData.get(sourceName);
		List targetData = (List) dependencyData.get(targetName);
		if(sourceData != null && targetData != null){
			int sourceSize = sourceData.size();
			int targetSize = targetData.size();
			setMapping(sourceData, targetData, sourceSize, targetSize);
		}
*/	
	}
	
	public Hashtable<MapType, MultiHashMap> getMapping(){
		return dependencyMappingLists;
	}
	
	public String getMappedValue(String name){
		Enumeration<MapType> maptypelist= dependencyMappingLists.keys();
		ArrayList valueSet=null;
		while (maptypelist.hasMoreElements()){
			MapType mt=maptypelist.nextElement();
			MultiHashMap maps=dependencyMappingLists.get(mt);
			if(maps!=null){
				valueSet=(ArrayList)maps.get(name);
				if(valueSet!=null){
					for(int c=0;c<valueSet.size();c++){
						//System.out.println("=============@@@@@@@@@@@ To get name="+ name+" value="+(String)valueSet.get(c));
						return (String)valueSet.get(c);	
					}
				}

			}
		}	
		maptypelist= dependencyDataLists.keys();
		valueSet=null;
		while (maptypelist.hasMoreElements()){
			MapType mt=maptypelist.nextElement();
			MultiHashMap maps=dependencyDataLists.get(mt);
			if(maps!=null){
				valueSet=(ArrayList)maps.get(name);
				if(valueSet!=null){
					for(int c=0;c<valueSet.size();c++){
						//System.out.println("=============@@@@@@@@@@@ To get name="+ name+" value="+(String)valueSet.get(c));
						return (String)valueSet.get(c);	
					}
				}

			}
		}
		//System.out.println("=============@@@@@@@@@@@ To get name="+ name+" value=null");
		return null;
	}
	
	// can implement a better, more accurate algo. for random-mapping 
/*
	public String getRandomMappedValue(String actualKey, String name){
		String key = actualKey;
		String value = null;
		while(key.equals(actualKey) || value == null){
			List similarKeys = (List) dependencyData.get(name);
			if(similarKeys != null){
				int numKeys = similarKeys.size();
				Random r = new Random();
				int index = r.nextInt(numKeys);
				key = (String)similarKeys.get(index);
				value = dependencyMapping.get(key);
			}
			else{
				break;
			}
		}
		value = dependencyMapping.get(key);
		if(value == null){
			value = actualKey;
		}
		//System.out.println("Doing random mapping with key: " + key + ", instead of actual-key: "+ actualKey + " for value: " + value);
		return value;
	}
*/	
}
