package com.topsun.posclient.sales.service.impl;

import com.topsun.posclient.common.LoggerUtil;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.datamodel.dto.PartSalesDTO;
import com.topsun.posclient.datamodel.dto.RetailDTO;
import com.topsun.posclient.sales.core.SalesCoreActivator;
import com.topsun.posclient.sales.dao.PartSaleDao;
import com.topsun.posclient.sales.service.IPartSaleService;

/**
 * 
 * @author Dong
 *
 */
public class PartSaleServiceImpl extends BaseServiceImpl implements IPartSaleService {
	
	/**
	 * 
	 */
	private PartSaleDao partSaleDao = new PartSaleDao();

	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.service.IPartSaleService#saveSaleData(com.topsun.posclient.sales.entity.PartSales)
	 */
	public void saveSaleData(PartSalesDTO salesDTO) throws Exception {
		try {
			partSaleDao.saveSalesData(salesDTO);
		} catch (Exception e) {
			LoggerUtil.logError(SalesCoreActivator.PLUGIN_ID, e);
			throw new Exception("上传零售数据失败,数据已保存在本地");
		}
	}

	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.service.IPartSaleService#savePartSalesData(com.topsun.posclient.datamodel.dto.RetailDTO)
	 */
	public void savePartSalesData(RetailDTO retailDTO) throws Exception {
		try {
			partSaleDao.saveSalesData(retailDTO);
		} catch (Exception e) {
			LoggerUtil.logError(SalesCoreActivator.PLUGIN_ID, e);
			throw new Exception("上传零售数据失败,数据已保存在本地");
		}
		
	}

}
