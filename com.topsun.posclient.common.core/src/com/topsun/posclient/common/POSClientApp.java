package com.topsun.posclient.common;

import java.util.HashMap;
import java.util.Map;

import com.topsun.posclient.common.core.CommonCoreActivator;
import com.topsun.posclient.datamodel.SettingData;
import com.topsun.posclient.datamodel.User;

/**
 * @author Dong
 * 
 */
public class POSClientApp {

	static POSClientApp posClientApp;

	/**
	 * 保存系统相关数据
	 */
	private Map<String, Object> contextData = new HashMap<String, Object>();

	private POSClientApp() {}

	public static POSClientApp get() {
		if (null == posClientApp) {
			posClientApp = new POSClientApp();
			return posClientApp;
		}
		return posClientApp;
	}

	public void saveLoginUser(User loginUser) {
		contextData.put(AppConstants.LOGIN_USER, loginUser);
	}

	public User getLoginUser() {
		return (User) contextData.get(AppConstants.LOGIN_USER);
	}
	
	public void setData(String key ,Object value){
		if(key == null){
			return;
		}
		contextData.put(key,value);
	}

	public Object getData(String key){
		if(key == null){
			return null;
		}
		return contextData.get(key);
	}

	/**
	 * 获取系统配置信息
	 * @return
	 */
	public SettingData getSysConfig() {
		String filepath = ProjectUtil.getRuntimeClassPath()+AppConstants.SEETING_FILE;
		SettingData settingData = new SettingData();
		try {
			String serverIP = ProjectUtil.readValue(filepath, AppConstants.SERVER_IP);
			String serverPort = ProjectUtil.readValue(filepath, AppConstants.SERVER_PORT);
			String cdKey = ProjectUtil.readValue(filepath, AppConstants.CDKEY);
			String syncWaitTime = ProjectUtil.readValue(filepath, AppConstants.SYNC_WAITTIME);
			String posNo = ProjectUtil.readValue(filepath, AppConstants.POSNO);
			String ogDocNum = ProjectUtil.readValue(filepath, AppConstants.OG_DOCNUM);
			String docNum = ProjectUtil.readValue(filepath, AppConstants.DOCNUM);
			String currConnStatu = ProjectUtil.readValue(filepath, AppConstants.CURR_CONN_STATU);
			
			settingData.setServerIp(serverIP);
			settingData.setServerPort(serverPort);
			settingData.setCdKey(cdKey);
			settingData.setSyncWaitTime(syncWaitTime);
			settingData.setCurrConnStatu(currConnStatu);
			settingData.setPosNo(posNo);
			settingData.setOgDocNum(ogDocNum);
			settingData.setDocNum(docNum);
			
		} catch (Exception e) {
			LoggerUtil.logError(CommonCoreActivator.PLUGIN_ID, e);
		}
		return settingData;
	}
	
	public boolean isConnected(){
		String currConnStatu = getSysConfig().getCurrConnStatu();
		if(null == currConnStatu || "".equals(currConnStatu)){
			return false;
		}
		return currConnStatu.equals("0")?false:true;
	}
	
	/**
	 * @param serverIp
	 * @param port
	 */
	public void doConnect(String serverIp, int port){
		
	}
	
	/**
	 * @throws Exception 
	 */
	public void doExit() throws Exception{
		ProjectUtil.setValue(AppConstants.OG_DOCNUM, "0000");
		ProjectUtil.setValue(AppConstants.DOCNUM, "0000");
	}

}