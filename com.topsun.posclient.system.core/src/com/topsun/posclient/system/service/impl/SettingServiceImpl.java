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
		
		// 删除公共目录的备份数据，商品数据、用户、店铺、结算方式等
		String path = ProjectUtil.getRuntimeClassPath();
		File backDataPath = new File(path+AppConstants.DATA_COMMON_PATH_BACK);
		if(backDataPath.isDirectory()){
			File[] files = backDataPath.listFiles();
			for(int i=0; i<files.length; i++){
				baseDao.getLocalProcessor().cleanBackData(files[i]);
			}
		}
		
		//删除店铺缴款备份数据 
		File backDataShopPay = new File(path+AppConstants.DATA_SHOPPAY_PATH_BACK);
		if(backDataShopPay.isDirectory()){
			File[] shopPayFiles = backDataShopPay.listFiles();
			for(int i=0; i<shopPayFiles.length; i++){
				baseDao.getLocalProcessor().cleanBackData(shopPayFiles[i]);
			}
		}
		
		//删除零售数据备份
		File backDataPartSales = new File(path+AppConstants.DATA_PARTSALES_PATH_BACK);
		if(backDataPartSales.isDirectory()){
			File[] salesDataFiles = backDataPartSales.listFiles();
			for(int i=0; i<salesDataFiles.length; i++){
				baseDao.getLocalProcessor().cleanBackData(salesDataFiles[i]);
			}
		}
		
		//删除调店备份数据
		File backDataAdShop = new File(path+AppConstants.DATA_ADJUSTSHOP_PATH_BACK);
		if(backDataAdShop.isDirectory()){
			File[] adShopFiles = backDataAdShop.listFiles();
			for(int i=0; i<adShopFiles.length; i++){
				baseDao.getLocalProcessor().cleanBackData(adShopFiles[i]);
			}
		}
		
		//删除回仓备份数据
		File backDataAdReposi = new File(path+AppConstants.DATA_ADJUSTREPOSITORY_PATH_BACK);
		if(backDataAdReposi.isDirectory()){
			File[] adReposiFiles = backDataAdReposi.listFiles();
			for(int i=0; i<adReposiFiles.length; i++){
				baseDao.getLocalProcessor().cleanBackData(adReposiFiles[i]);
			}
		}
		
		//删除库存盘点备份数据
		File backDataCheckS = new File(path+AppConstants.DATA_CHECKREPOSITORY_PATH_BACK);
		if(backDataCheckS.isDirectory()){
			File[] checkSFiles = backDataCheckS.listFiles();
			for(int i=0; i<checkSFiles.length; i++){
				baseDao.getLocalProcessor().cleanBackData(checkSFiles[i]);
			}
		}
		
		//删除付款备份数据
		File backDataPay = new File(path+AppConstants.DATA_PAYMENT_PATH_BACK);
		if(backDataPay.isDirectory()){
			File[] payFiles = backDataPay.listFiles();
			for(int i=0; i<payFiles.length; i++){
				baseDao.getLocalProcessor().cleanBackData(payFiles[i]);
			}
		}
		
		//删除收款备份数据
		File backDataReceive = new File(path+AppConstants.DATA_RECEIVE_PATH_BACK);
		if(backDataReceive.isDirectory()){
			File[] receFiles = backDataReceive.listFiles();
			for(int i=0; i<receFiles.length; i++){
				baseDao.getLocalProcessor().cleanBackData(receFiles[i]);
			}
		}
	}
}
