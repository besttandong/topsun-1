package com.topsun.posclient.sales.service;


import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.datamodel.dto.PartSalesDTO;
import com.topsun.posclient.datamodel.dto.RetailDTO;

/**
 * 零售接口
 * 
 * @author Dong
 *
 */
public interface IPartSaleService extends IBaseService {
	
	/**
	 * 保存销售数据
	 * 
	 * @param partSalesList
	 * @throws Exception
	 */
	@Deprecated
	public void saveSaleData(PartSalesDTO salesDTO) throws Exception;
	
	/**
	 * 保存零售数据
	 * @param retailDTO
	 * @throws Exception
	 */
	public void savePartSalesData(RetailDTO retailDTO) throws Exception;
	
}
