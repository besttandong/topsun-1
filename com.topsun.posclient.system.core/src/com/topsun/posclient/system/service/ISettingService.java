package com.topsun.posclient.system.service;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.datamodel.SettingData;

/**
 * @author Dong
 *
 */
public interface ISettingService extends IBaseService {
	
	/**
	 * 保存系统设置
	 * @param settingData
	 * @throws POSException
	 */
	public void saveSetting(SettingData settingData) throws POSException;
	
	/**
	 * 清理备份数据
	 * 
	 * @throws POSException
	 */
	public void cleanBackData() throws POSException;
	
	/**
	 * 获取系统配置信息
	 * @return
	 * @throws POSException
	 */
	public SettingData getSetting() throws POSException;

}
