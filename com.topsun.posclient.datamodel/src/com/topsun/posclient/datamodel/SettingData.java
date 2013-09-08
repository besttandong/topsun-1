package com.topsun.posclient.datamodel;

public class SettingData {
	
	private String ip;
	
	private String port;
	
	private String reconnectionTime;
	
	private String posNo; //POS编号
	
	private String oldGoldCountNum; //旧金编号
	
	public final String getOldGoldCountNum() {
		return oldGoldCountNum;
	}

	public final void setOldGoldCountNum(String oldGoldCountNum) {
		this.oldGoldCountNum = oldGoldCountNum;
	}

	public final String getPosNo() {
		return posNo;
	}

	public final void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getReconnectionTime() {
		return reconnectionTime;
	}

	public void setReconnectionTime(String reconnectionTime) {
		this.reconnectionTime = reconnectionTime;
	}
}
