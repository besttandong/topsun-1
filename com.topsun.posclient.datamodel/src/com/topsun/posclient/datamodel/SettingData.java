package com.topsun.posclient.datamodel;

/**
 * 系统设置数据
 * 
 * @author Dong
 *
 */
public class SettingData {
	
	private String serverIp;//服务器IP地址
	
	private String serverPort;//服务器端口
	
	private String cdKey;//授权码
	
	private String syncWaitTime;//自动同步默认间隔时间
	
	private String currConnStatu; //当前连接状态
	
	private String posNo; //POS机器号
	
	private String ogDocNum; //旧金编号
	
	private String docNum; //零售单据编号
	
	public final String getServerIp() {
		return serverIp;
	}

	public final void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public final String getServerPort() {
		return serverPort;
	}

	public final void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public final String getSyncWaitTime() {
		return syncWaitTime;
	}

	public final void setSyncWaitTime(String syncWaitTime) {
		this.syncWaitTime = syncWaitTime;
	}

	public final String getOgDocNum() {
		return ogDocNum;
	}

	public final void setOgDocNum(String ogDocNum) {
		this.ogDocNum = ogDocNum;
	}

	public final String getDocNum() {
		return docNum;
	}

	public final void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public final String getPosNo() {
		return posNo;
	}

	public final void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public final String getCdKey() {
		return cdKey;
	}

	public final void setCdKey(String cdKey) {
		this.cdKey = cdKey;
	}

	public final String getCurrConnStatu() {
		if(currConnStatu.equals("0")){
			return "离线";
		}else if(currConnStatu.equals("1")){
			return "在线";
		}else{
			return "未知";
		}
	}

	public final void setCurrConnStatu(String currConnStatu) {
		this.currConnStatu = currConnStatu;
	}
}
