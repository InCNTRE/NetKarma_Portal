package edu.indiana.d2i.netkarma.xsp.adapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RuntimeProvenance {
	
	private Calendar startTime = null;
	private Calendar endTime = null;
	private String sourceIP = null;
	private String destIP = null;
	private String dataItem = null;
	private String command = null;
	private String execHost = null;
	private ArrayList<Triplets<String, String, String>> transferStats = null;
	private String logfile = null;
	
	public RuntimeProvenance(){
		this.transferStats = new ArrayList<Triplets<String, String, String>>();
		this.startTime = Calendar.getInstance();
		this.endTime = Calendar.getInstance();
	}
	
	public void parseLogfile(String logfile) {
		this.logfile = logfile;
		try {
			BufferedReader br = new BufferedReader(new FileReader(logfile));

			String line = null;
			while ((line = br.readLine()) != null) {
				String trimmedLine = line.trim();
				parseLogline(trimmedLine, br);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parseLogline(String line, BufferedReader br) {
		String[] tokens = line.split(":\\s*", 2);
		String key = tokens[0];
		String value = null;
		if(tokens.length > 1)
			value = tokens[1];

		if (key.contains("Start-time")) {
			Date date = convertStrToDate(value);
			startTime.setTime(date);
		} else if (key.contains("Source")) {
			String[] params = value.trim().split(":");
			sourceIP = params[1].substring(2);
		} else if (key.contains("Dest")) {
			String[] params = value.trim().split(":");
			destIP = params[1].substring(2);
			String nextLine = null;
			try {
				if((nextLine = br.readLine().trim()) != null){
					dataItem = nextLine;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (key.contains("End-time")) {
			Date date = convertStrToDate(value);
			endTime.setTime(date);
		} else if (key.contains("bytes") && key.contains("avg") && key.contains("inst")){
			String[] stats = key.split("\\s+");
			Triplets<String, String, String> partialStats = 
				new Triplets<String, String, String>(stats[0], stats[2], stats[5]);
			transferStats.add(partialStats);
		} else if (key.contains("Command")) {
			command = value;
		} else if (key.contains("Execution-host")) {
			String[] params = value.trim().split("\\.");
			execHost = params[0];
		}
	}
	
	private Date convertStrToDate(String dateAsStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = (Date)df.parse(dateAsStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public String getSourceIP() {
		return sourceIP;
	}

	public String getDestIP() {
		return destIP;
	}

	public String getCommand() {
		return command;
	}

	public String getExecHost() {
		return execHost;
	}

	public String getDataItem() {
		return dataItem;
	}
	
	public String getLogfileName(){
		return logfile;
	}

	public ArrayList<Triplets<String, String, String>> getTransferStats() {
		return transferStats;
	}
}

