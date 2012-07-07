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
# File:  DataSelector.java
# Description:  Selects provenance-data from log line
#
# -----------------------------------------------------------------
# 
*/

package edu.indiana.d2i.adaptor;

import org.dataandsearch.netkarma.ComplexSelectionType;
import org.dataandsearch.netkarma.ConstantType;
import org.dataandsearch.netkarma.LastNCharType;
import org.dataandsearch.netkarma.NotificationType;
import org.dataandsearch.netkarma.ProvenanceDataType;
import org.dataandsearch.netkarma.ReadArgumentOfType;
import org.dataandsearch.netkarma.ReadPropertyOfType;
import org.dataandsearch.netkarma.ReadTokenType;
import org.dataandsearch.netkarma.SelectMechanismEnumType;
import org.dataandsearch.netkarma.SelectMethodEnumType;
import org.dataandsearch.netkarma.SelectMethodType;
import org.dataandsearch.netkarma.SimpleSelectionType;
import org.dataandsearch.netkarma.SubstringType;

public class DataSelector {
	
	private String logFileName = null;
	private String provenanceObjectId = null;
	
	public DataSelector(){
		super();
	}
	
	public DataSelector(String logFileName){
		this.logFileName = getLogFileName(logFileName);		
		//this.logFileName = logFileName;
	}
	
	String getLogFileName(String logfile){
		return logfile.substring(0, logfile.indexOf('.'));
	}
	
	
	private void getSelectedData(String[] args, SimpleSelectionType selectMethod){
		provenanceObjectId = "";
		if (selectMethod.getSelectionType().equals(
				SelectMethodEnumType.COMPLETE_STRING)) {
			provenanceObjectId = args[selectMethod.getCompleteString()
					.getArgumentNumber()].trim();
		} else if (selectMethod.getSelectionType().equals(
				SelectMethodEnumType.SUBSTRING)) {
			SubstringType substringType = selectMethod.getSubstring();
			int substringArgNum = substringType.getArgumentNumber();
			int beginIndex = substringType.getBeginIndex();
			int endIndex = 0;
			String source = null;
			if(substringArgNum >= 0){
				source = args[substringArgNum];
			} else{
				source = logFileName;
			}
						
			if (substringType.isSetEndIndex()) {
				endIndex = substringType.getEndIndex();
				provenanceObjectId = source.substring(beginIndex, endIndex).trim();
			} else {
				provenanceObjectId = source.substring(beginIndex).trim();
			}
		} else if (selectMethod.getSelectionType().equals(
				SelectMethodEnumType.CONSTANT)) {
			ConstantType cons = selectMethod.getConstant();
			provenanceObjectId = cons.getConstantValue();
		} else if (selectMethod.getSelectionType().equals(
				SelectMethodEnumType.LAST_NCHAR)) {
			LastNCharType lastNCharType = selectMethod.getLastNChar();
			int nchars = lastNCharType.getNumChars();
			int argNumLastN = lastNCharType.getArgumentNumber();
			if (argNumLastN >= 0) {
				int beginIndex = args[argNumLastN].length();
				provenanceObjectId = args[argNumLastN].substring(beginIndex)
						.trim();
			} else {
				int beginIndex = logFileName.length() - nchars;
				provenanceObjectId = logFileName.substring(beginIndex).trim();
			}
		} else if (selectMethod.getSelectionType().equals(
				SelectMethodEnumType.READ_ARGUMENT_OF)) {
			ReadArgumentOfType argOf = selectMethod.getReadArgumentOf();
			String methodName = argOf.getMethodName();
			int argOfArgNum = argOf.getArgumentNumber();

			int[] paramList = argOf.getParamListArray();
			int methodStartIndex = args[argOfArgNum].indexOf(methodName);
			/*
			 * get the param-list bounds
			 */
			int startIndex = args[argOfArgNum].indexOf('(', methodStartIndex) + 1;
			int endIndex = args[argOfArgNum].indexOf(')', startIndex);

			String paramDelim = "";
			String[] methodData = null;
			/*
			 * get method parameters
			 */
			if (argOf.isSetParamDelimiter()) {
				paramDelim = argOf.getParamDelimiter();
				methodData = args[argOfArgNum].substring(startIndex, endIndex)
						.split(paramDelim);
			} else {
				methodData = new String[1];
				methodData[0] = new String();
				methodData[0] = args[argOfArgNum].substring(startIndex,
						endIndex);
			}
			/*
			 * create id from the params
			 */
			for (int j = 0; j < paramList.length; j++) {
				if (methodData.length >= paramList[j]) {
					provenanceObjectId += methodData[paramList[j] - 1].trim();// +
					// "#";
				}
			}
		} else if (selectMethod.getSelectionType().equals(
				SelectMethodEnumType.READ_PROPERTY_OF)) {
			ReadPropertyOfType propOf = selectMethod.getReadPropertyOf();
			String propDelim = propOf.getDelimiter();
			String propKey = propOf.getKey();
			int propOfArgNum = propOf.getArgumentNumber();
			int startIndex = args[propOfArgNum].indexOf(propKey);
			String[] tokens = args[propOfArgNum].substring(startIndex).split(
					propDelim);

			if (tokens.length > 1) {
				provenanceObjectId = tokens[1].trim();
			} else {
				provenanceObjectId = "NULL";
			}
		} else if (selectMethod.getSelectionType().equals(
				SelectMethodEnumType.READ_TOKEN)) {
			ReadTokenType tokenType = selectMethod.getReadToken();
			String tokenDelim = tokenType.getDelimiter();
			if (tokenDelim.equals("\" \"")) {
				tokenDelim = " ";
			}
			int maxTokens = tokenType.getMaxTokens();
			int[] tokenNums = tokenType.getTokenNumbersArray();
			int tokenArgNum = tokenType.getArgumentNumber();
			String[] tokens = args[tokenArgNum].trim().split(tokenDelim,
					maxTokens);

			/*
			 * get the property of the key
			 */
			for (int j = 0; j < tokenNums.length; j++) {
				if (tokens.length >= tokenNums[j]) {
					provenanceObjectId += tokens[tokenNums[j] - 1].trim();// +"#";
				}
			}
			if (provenanceObjectId.trim().equals("")) {
				provenanceObjectId = "NULL";
			}
		} else {
			// invalid selection-method
		}
	}

	/*
	 * derive provenance information from the available data Limitation: is able
	 * to capture only one information at a time
	 */
	public String getProvenanceData(String[] args, SelectMethodType selectMethod) {		
		provenanceObjectId = "";
		if(selectMethod.getSelectionMechanism().equals(SelectMechanismEnumType.SIMPLE)){
			SimpleSelectionType selectionType =  selectMethod.getSimpleSelection();
			getSelectedData(args, selectionType);
		}
		else if(selectMethod.getSelectionMechanism().equals(SelectMechanismEnumType.COMPLEX)){
			ComplexSelectionType selectionType = selectMethod.getComplexSelection();
			SimpleSelectionType[] simpleSelections = selectionType.getSimpleSelectionArray();
			String[] params = args;
			for (int i = 0; i < simpleSelections.length; i++) {
				getSelectedData(params, simpleSelections[i]);
				
				// this is bad, but handles complex, iterative selection type
				// --- this assumes that after the first iteration, all 
				// subsequent args are single strings
				params = new String[1];
				params[0] = new String(provenanceObjectId);
				//System.out.println("ID: " + provenanceObjectId);
			}
		}
		else{
			//invalid selection-method
		}

		return provenanceObjectId;
	}
	
	public String getProvenanceData(String[] args,
			NotificationType notification, ProvenanceDataType provenanceData) {
		provenanceObjectId = "";
		SelectMethodType selectMethod = provenanceData.getSelectMethod();
		
		getProvenanceData(args, selectMethod);

		// provenanceObjectId += "-" +instanceID;
		return provenanceObjectId;
	}

}
