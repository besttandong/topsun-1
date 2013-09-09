package com.topsun.posclient.sales.service.impl;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.datamodel.dto.OldGoldDTO;
import com.topsun.posclient.sales.dao.OldGoldDao;
import com.topsun.posclient.sales.service.IOldGoldSaleService;

/**
 * 
 * 贴金调换（旧金）服务实现
 * @author Dong
 *
 */
public class OldGoldSaleServiceImpl extends BaseServiceImpl implements IOldGoldSaleService{
	
	private OldGoldDao oldGoldDao = new OldGoldDao();

	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.service.IOldGoldSaleService#saveSaleData(com.topsun.posclient.datamodel.dto.OldGoldDTO)
	 */
	public void saveOldGoldData(OldGoldDTO oldGoldDTO) throws POSException {
		try {
			oldGoldDao.saveOldGoldData(oldGoldDTO);
		} catch (Exception e) {
			throw new POSException("上传旧金数据失败,数据已保存在本地");
		}
	}

}