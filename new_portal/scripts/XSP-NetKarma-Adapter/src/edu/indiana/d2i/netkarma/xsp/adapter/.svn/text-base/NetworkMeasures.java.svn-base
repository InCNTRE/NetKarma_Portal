package edu.indiana.d2i.netkarma.xsp.adapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NetworkMeasures {

	private String minLatency = null;
	private String maxLatency = null;
	private String avgLatency = null;
	private String startBandwidth = null;
	private String endBandwidth = null;
	private String datagramLossPerc = null;
	private ArrayList<String> iperfBandwidths = null;
	
	public NetworkMeasures(){
		this.iperfBandwidths = new ArrayList<String>();
	}

	public void parseLogfile(String logfile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(logfile));

			String line = null;
			while ((line = br.readLine()) != null) {
				String trimmedLine = line.trim();
				parseLogline(trimmedLine, br);
			}
			setBandwidths();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void parseLogline(String line, BufferedReader br) {
		if (line.startsWith("rtt")) {
			String[] data = line.split("=")[1].trim().split("\\s+")[0].split("/");
			setMinLatency(data[0]);
			setAvgLatency(data[1]);
			setMaxLatency(data[2]);
		}
		else if(line.contains("MBytes/sec")){
			iperfBandwidths.add(line);
		}
	}
	
	private void setBandwidths(){
		int numData = iperfBandwidths.size();
		startBandwidth = iperfBandwidths.get(0).split("\\s+")[6];
		endBandwidth = iperfBandwidths.get(numData-1).split("\\s+")[6];
		if(iperfBandwidths.get(numData-2).contains("%")){
			datagramLossPerc = iperfBandwidths.get(numData-2).split("\\s+")[12];
			datagramLossPerc = datagramLossPerc.substring(1, datagramLossPerc.length()-2);
		}
	}
	
	public String getMinLatency() {
		return minLatency;
	}


	public void setMinLatency(String minLatency) {
		this.minLatency = minLatency;
	}


	public String getMaxLatency() {
		return maxLatency;
	}


	public void setMaxLatency(String maxLatency) {
		this.maxLatency = maxLatency;
	}


	public String getAvgLatency() {
		return avgLatency;
	}


	public void setAvgLatency(String avgLatency) {
		this.avgLatency = avgLatency;
	}


	public String getStartBandwidth() {
		return startBandwidth;
	}


	public void setStartBandwidth(String startBandwidth) {
		this.startBandwidth = startBandwidth;
	}


	public String getEndBandwidth() {
		return endBandwidth;
	}


	public void setEndBandwidth(String endBandwidth) {
		this.endBandwidth = endBandwidth;
	}

	public String getDatagramLossPerc() {
		return datagramLossPerc;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
