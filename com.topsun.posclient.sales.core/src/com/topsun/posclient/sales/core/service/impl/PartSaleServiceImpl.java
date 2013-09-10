package com.topsun.posclient.sales.core.service.impl;

import java.util.List;

import com.topsun.posclient.common.LoggerUtil;
import com.topsun.posclient.common.POSException;
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
	
	/**
	 * 促销方案计算器
	 */
	private PromotionMath promotionMath = new PromotionMath();

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
	public void saveRetail(RetailDTO retailDTO) throws POSException {
		try {
			partSaleDao.saveRetail(retailDTO);
		} catch (Exception e) {
			LoggerUtil.logError(SalesCoreActivator.PLUGIN_ID, e);
			throw new POSException("保存零售数据失败");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.topsun.posclient.sales.core.service.IPartSaleService#applyPromotion(com.topsun.posclient.datamodel.Retail)
	 */
	public Retail applyPromotion(Retail retail) throws POSException{
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
				case 1:
					retail.setRetailMList(promotionMath.applyAllNM(retail.getRetailMList(), prmi));//整单满减
				case 2:
					retail.setRetailMList(promotionMath.applySingleNM(retail.getRetailMList(), prmi));//单件金额满减
				case 3:
					retail.setRetailMList(promotionMath.applyNumNm(retail.getRetailMList(), prmi));//数量满减
				case 4:
					retail.setRetailMList(promotionMath.applySingleNG(retail.getRetailMList(), prmi));//单品满送赠品
				case 5:
					retail.setRetailMList(promotionMath.applyAppoint(retail.getRetailMList(), prmi));//买指定商品可选购指定商品（折扣）
				case 6:
					retail.setRetailMList(promotionMath.applyNM(retail.getRetailMList(), prmi));//整单满N减M
				case 7:
					//TODO 捆绑销售
				case 8:
					retail.setRetailMList(promotionMath.applyFee(retail.getRetailMList(), prmi));//工费打折
				case 9:
					retail.setRetailMList(promotionMath.applyFeeD(retail.getRetailMList(), prmi));//工费扣减
				default:
						
			}
		}
		return retail;
	}
}
