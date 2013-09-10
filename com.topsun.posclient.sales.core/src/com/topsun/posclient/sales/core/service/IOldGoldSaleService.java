package com.topsun.posclient.sales.core.service;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.datamodel.dto.OldGoldDTO;

/**
 * 旧金鉴定服务接口
 * 
 * @author Dong
 *
 */
public interface IOldGoldSaleService extends IBaseService {
	
	/**
	 * 保存旧金数据(旧金鉴定单)
	 * @param oldGoldDTO
	 * @throws Exception
	 */
	public void saveOldGoldData(OldGoldDTO oldGoldDTO) throws POSException;
	
	/**
	 * 下载旧金鉴定信息
	 * @param docNum 单据编号
	 * @return 
	 * @throws POSException
	 */
	public OldGoldDTO downloadOldGoldData(String docNum) throws POSException;
	
}
