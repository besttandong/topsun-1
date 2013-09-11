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

	/**
	 * 
	 */
	static POSClientApp posClientApp;

	/**
	 * 
	 */
	private Map<String, Object> contextData = new HashMap<String, Object>();

	private POSClientApp() {
	}

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
			
			settingData.setServerIp(serverIP);
			settingData.setServerPort(serverPort);
			settingData.setCdKey(cdKey);
			settingData.setSyncWaitTime(syncWaitTime);
			settingData.setPosNo(posNo);
			settingData.setOgDocNum(ogDocNum);
			settingData.setDocNum(docNum);
			
		} catch (Exception e) {
			LoggerUtil.logError(CommonCoreActivator.PLUGIN_ID, e);
		}
		return settingData;
	}
	
	/**
	 * 业务员签退
	 * @throws Exception 
	 */
	public void doExit() throws Exception{
		ProjectUtil.setValue(AppConstants.OG_DOCNUM, "0000");
		ProjectUtil.setValue(AppConstants.DOCNUM, "0000");
	}

}