package com.topsun.posclient.sales.core.service;


import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.datamodel.Retail;
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
	public void saveSaleData(PartSalesDTO salesDTO) throws POSException;
	
	/**
	 * 保存零售数据
	 * @param retailDTO
	 * @param docNum 单据编号
	 * @throws POSException
	 */
	public void saveRetail(RetailDTO retailDTO, String docNum) throws POSException;
	
	
	/**
	 * 应用促销方案
	 * @param retailMs 零售数据
	 * @return 促销计算折扣之后的零售数据
	 * @throws POSException 
	 */
	public Retail applyPromotion(Retail retail) throws POSException;
	
}
