package com.topsun.posclient.system.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.datamodel.SettingData;
import com.topsun.posclient.system.MessageResources;
import com.topsun.posclient.system.service.ISettingService;

/**
 * @author LiLei
 * 
 */
public class SettingServiceImpl extends BaseServiceImpl implements ISettingService {
	
	BaseDao baseDao = new BaseDao();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.topsun.posclient.system.service.ISettingService#saveSetting(com.topsun
	 * .posclient.datamodel.SettingData)
	 */
	public void saveSetting(SettingData settingData) throws POSException {
		String filepath = ProjectUtil.getRuntimeClassPath()+AppConstants.SEETING_FILE;
		try{
			Properties prop = new Properties();
			OutputStream outputStream = new FileOutputStream(filepath);  
			prop.setProperty("serverIP", settingData.getIp());  
			prop.setProperty("serverPort", settingData.getPort());  
			prop.store(outputStream, "author: topsun");  
	        outputStream.close();  
		}catch(Exception e){
			throw new POSException(MessageResources.message_error_savefailer);
		}
	}

	/* (non-Javadoc)
	 * @see com.topsun.posclient.system.service.ISettingService#getSetting()
	 */
	public SettingData getSetting() throws POSException {
		String filepath = ProjectUtil.getRuntimeClassPath()+AppConstants.SEETING_FILE;
		try{
			String serverIP = ProjectUtil.readValue(filepath, "serverIP");
			String serverPort = ProjectUtil.readValue(filepath, "serverPort");
			String reconnectionTime = ProjectUtil.readValue(filepath, "reconnectionTime");
			SettingData settingData = new SettingData();
			settingData.setIp(serverIP);
			settingData.setPort(serverPort);
			settingData.setReconnectionTime(reconnectionTime);
			return settingData;
		}catch(Exception e){
			throw new POSException(MessageResources.message_error_savefailer);
		}
	}

	/* (non-Javadoc)
	 * @see com.topsun.posclient.system.service.ISettingService#cleanBackData()
	 */
	public void cleanBackData() throws POSException {
		File userBackDataFile = new File(ProjectUtil.getRuntimeClassPath()+AppConstants.DATA_USER_FILENAME_BACK);
		baseDao.getLocalProcessor().cleanBackData(userBackDataFile);
	}
}
