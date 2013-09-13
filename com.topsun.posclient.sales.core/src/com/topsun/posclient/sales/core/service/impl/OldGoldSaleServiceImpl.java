package com.topsun.posclient.sales.core.service.impl;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.LoggerUtil;
import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.datamodel.dto.OldGoldDTO;
import com.topsun.posclient.sales.core.SalesCoreActivator;
import com.topsun.posclient.sales.core.dao.OldGoldDao;
import com.topsun.posclient.sales.core.service.IOldGoldSaleService;

/**
 * 
 * 旧金鉴定服务实现
 * @author Dong
 *
 */
public class OldGoldSaleServiceImpl extends BaseServiceImpl implements IOldGoldSaleService{
	
	private OldGoldDao oldGoldDao = new OldGoldDao();

	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.core.service.IOldGoldSaleService#saveOldGoldData(com.topsun.posclient.datamodel.dto.OldGoldDTO, java.lang.String)
	 */
	public void saveOldGoldData(OldGoldDTO oldGoldDTO, String docNum) throws POSException {
		try {
			oldGoldDao.saveOldGoldData(oldGoldDTO);//保存旧金鉴定数据
			// 旧金编号累加1
			ProjectUtil.setValue(AppConstants.OG_DOCNUM, docNum);
		} catch (Exception e) {
			LoggerUtil.logError(SalesCoreActivator.PLUGIN_ID, e);
			throw new POSException("上传旧金鉴定单失败,数据已保存在本地");
		}
	}

	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.service.IOldGoldSaleService#downloadOldGoldData(java.lang.String)
	 */
	public OldGoldDTO downloadOldGoldData(String docNum) throws POSException {
		// DownloadOldGoldDataResponse response = POSServerCaller.getWebService().downloadOldGoldData(docNum);
		// return response;
		return null;
	}
}
