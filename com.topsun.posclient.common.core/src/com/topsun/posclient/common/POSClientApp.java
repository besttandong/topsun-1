package com.topsun.posclient.common;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

	public SettingData getSysConfig() {
		String filepath = ProjectUtil.getRuntimeClassPath()
				+ AppConstants.SEETING_FILE;
		SettingData settingData = new SettingData();
		try {
			String serverIP = ProjectUtil.readValue(filepath, "serverIP");
			String serverPort = ProjectUtil.readValue(filepath, "serverPort");
			String reconnectionTime = ProjectUtil.readValue(filepath,
					"reconnectionTime");
			settingData.setIp(serverIP);
			settingData.setPort(serverPort);
			settingData.setReconnectionTime(reconnectionTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return settingData;
	}

}