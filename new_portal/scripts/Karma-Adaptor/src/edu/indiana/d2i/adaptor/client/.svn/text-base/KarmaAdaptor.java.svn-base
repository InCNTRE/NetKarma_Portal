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
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# -----------------------------------------------------------------
#
# Project:  Karma-Adaptor
# File:  KarmaAdaptor.java
# Description:  generates the provenance-events and ingests
#				them into the Karma DB  
#
# -----------------------------------------------------------------
# 
 */

package edu.indiana.d2i.adaptor.client;

import edu.indiana.d2i.adaptor.LogParser;
import edu.indiana.dsi.karma.messaging.MessageConfig;

public class KarmaAdaptor {
	
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("Usage: java KarmaAdaptor <log-file>");
			System.exit(-1);
		}
		String logFile = args[0];

		String propertiesFile = "config/karma-adaptor.properties";
		PropertyReader propertyReader = new PropertyReader(propertiesFile);
		String expRulefile = propertyReader.getProperty("karma-adaptor.experiment_rulefile");	
		String cmdRulefile = propertyReader.getProperty("karma-adaptor.cmdline_rulefile");	
		String genericRulefile = propertyReader.getProperty("karma-adaptor.generic_rulefile");

		String MessageConfigPath= propertiesFile;
		System.out.println("Connecting to Server...");
		MessageConfig msgconf=new MessageConfig(MessageConfigPath); //Yuan removed this for testing
		//System.out.println("Config");
		
		LogParser lp = null;
		if(args.length == 2){
			String customRulefile = args[1];
			lp = new LogParser(customRulefile, logFile, msgconf);
		}
		else{
			lp = new LogParser(expRulefile, cmdRulefile, genericRulefile, logFile, msgconf);
		}
		lp.parseRuleFile();
	}	
}
