package com.topsun.posclient.sales.service;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.datamodel.dto.OldGoldDTO;

/**
 * 贴金调换（旧金）服务接口
 * 
 * @author Dong
 *
 */
public interface IOldGoldSaleService extends IBaseService {
	
	/**
	 * 保存旧金销售数据
	 * @param oldGoldDTO
	 * @throws Exception
	 */
	public void saveOldGoldData(OldGoldDTO oldGoldDTO) throws POSException;
	
}
