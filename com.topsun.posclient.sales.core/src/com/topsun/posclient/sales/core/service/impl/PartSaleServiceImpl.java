package com.topsun.posclient.sales.core.service.impl;

import java.util.List;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.LoggerUtil;
import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.datamodel.Promotion;
import com.topsun.posclient.datamodel.Retail;
import com.topsun.posclient.datamodel.dto.PartSalesDTO;
import com.topsun.posclient.datamodel.dto.PromotionDTO;
import com.topsun.posclient.datamodel.dto.RetailDTO;
import com.topsun.posclient.sales.core.PromotionMath;
import com.topsun.posclient.sales.core.SalesCoreActivator;
import com.topsun.posclient.sales.core.dao.PartSaleDao;
import com.topsun.posclient.sales.core.service.IPartSaleService;

/**
 * 零售服务实现
 * @author Dong
 *
 */
public class PartSaleServiceImpl extends BaseServiceImpl implements IPartSaleService {
	
	/**
	 * 零售数据访问
	 */
	private PartSaleDao partSaleDao = new PartSaleDao();
	
	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.service.IPartSaleService#saveSaleData(com.topsun.posclient.sales.entity.PartSales)
	 */
	public void saveSaleData(PartSalesDTO salesDTO) throws POSException {
		try {
			partSaleDao.saveSalesData(salesDTO);
		} catch (Exception e) {
			LoggerUtil.logError(SalesCoreActivator.PLUGIN_ID, e);
			throw new POSException("上传零售数据失败,数据已保存在本地");
		}
	}

	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.service.IPartSaleService#savePartSalesData(com.topsun.posclient.datamodel.dto.RetailDTO)
	 */
	public void saveRetail(RetailDTO retailDTO, String docNum) throws POSException {
		try {
			partSaleDao.saveRetail(retailDTO);
			ProjectUtil.setValue(AppConstants.DOCNUM, docNum);
		} catch (Exception e) {
			LoggerUtil.logError(SalesCoreActivator.PLUGIN_ID, e);
			throw new POSException("保存零售数据失败");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.core.service.IPartSaleService#applyPromotion(com.topsun.posclient.datamodel.Retail)
	 */
	public Retail applyPromotion(Retail retail) throws POSException{
		
		PromotionMath promotionMath = new PromotionMath();
		
		Retail ret = retail;
		PromotionDTO promotionDTO = null;
		try {
			promotionDTO = partSaleDao.getValidTimePromotion();
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.logError(SalesCoreActivator.PLUGIN_ID, e);
			throw new POSException("促销方案查询出错");
		}
		List<Promotion> promotions = promotionDTO.getPromotionList();
		for(int i=0; i<promotions.size(); i++){
			Promotion prmi = promotions.get(i);
			int type = Integer.valueOf(prmi.getType());
			switch(type){
				case 0:
					retail.setRetailMList(promotionMath.applySingle(retail.getRetailMList(), prmi));//单品促销
					ret = retail;
					break;
				case 1:
					retail.setRetailMList(promotionMath.applyAllNM(retail.getRetailMList(), prmi));//整单满减
					ret = retail;
					break;
				case 2:
					retail.setRetailMList(promotionMath.applySingleNM(retail.getRetailMList(), prmi));//单件金额满减
					ret = retail;
					break;
				case 3:
					retail.setRetailMList(promotionMath.applyNumNm(retail.getRetailMList(), prmi));//数量满减
					return retail;
				case 4:
					retail.setRetailMList(promotionMath.applySingleNG(retail.getRetailMList(), prmi));//单品满送赠品
					ret = retail;
					break;
				case 5:
					retail.setRetailMList(promotionMath.applyAppoint(retail.getRetailMList(), prmi));//买指定商品可选购指定商品（折扣）
					ret = retail;
					break;
				case 6:
					retail.setRetailMList(promotionMath.applyNM(retail.getRetailMList(), prmi));//第N件打M折
					ret = retail;
					break;
				case 7:
					//TODO 捆绑销售
					return retail;
				case 8:
					retail.setRetailMList(promotionMath.applyFee(retail.getRetailMList(), prmi));//工费打折
					ret = retail;
					break;
				case 9:
					retail.setRetailMList(promotionMath.applyFeeD(retail.getRetailMList(), prmi));//工费扣减
					ret = retail;
					break;
				default:
					ret = retail;
					break;
			}
		}
		return ret;
	}
}
