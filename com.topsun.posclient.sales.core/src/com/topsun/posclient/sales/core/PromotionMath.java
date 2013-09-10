package com.topsun.posclient.sales.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.datamodel.Promotion;
import com.topsun.posclient.datamodel.PromotionM;
import com.topsun.posclient.datamodel.RetailM;

/**
 * 促销方案算法
 * 
 * @author Dong
 *
 */
public class PromotionMath {
	
	/**
	 * 设置零售明细促销方案ID和标题
	 * @param retailM 零售明细
	 * @param promotion 促销方案
	 */
	private void setRetailM(RetailM retailM, Promotion promotion){
		retailM.setPromotionID(retailM.getPromotionID()+promotion.getID()+",");
		retailM.setPromotionName(retailM.getPromotionName()+promotion.getTitle()+",");
	}
	
	
	/**
	 * 单品促销
	 * @param retailMs 零售明细集合
	 * @param promotion 促销方案
	 * @return 促销之后的单品集合
	 * @throws POSException
	 */
	public List<RetailM> applySingle(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		for(RetailM retailM : retailMs){
			setRetailM(retailM, promotion);
			//全场
			if(promotion.getIsAll() == 1){
				retailM.setFactAmount(retailM.getSalesAmount().multiply(promotion.getRate()));
			}else{
				List<PromotionM> promotionMList = promotion.getPromotionMList();
				for(PromotionM pm : promotionMList){
					// 根据单品ID获取单品信息，从单品信息获取物料编号
					// pm.getMATNR()和单品的物料编号比较，是否包含，不包含return false包含则根据物料编码进行排除算法
				}
			}
			ret.add(retailM);
		}
		return ret;
	}
	
	/**
	 * 单件金额满N减M
	 * @param retailMs
	 * @param promotion
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applySingleNM(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		for(RetailM retailM : retailMs){
			setRetailM(retailM, promotion);
			//零售明细的实售金额大于促销方案设定值1，满足单件满N减M的条件
			if(retailM.getSalesAmount().compareTo(promotion.getSet1()) == 1){
				retailM.setFactAmount(retailM.getSalesAmount().subtract(promotion.getSet2()));
			}
			ret.add(retailM);
		}
		return ret;
	}
	
	/**
	 * 数量满减
	 * @param retailMs
	 * @param promotion
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applyNumNm(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		return ret;
	}
	
	/**
	 * 单品满送赠品
	 * @param retailMs
	 * @param promotion
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applySingleNG(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		return ret;
	}
	
	/**
	 * 买指定商品可选购指定商品（折扣）
	 * @param retailMs
	 * @param promotion
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applyAppoint(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		return ret;
	}
	
	/**
	 * 工费打折
	 * @param retailMs
	 * @param promotion
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applyFee(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		return ret;
	}
	
	/**
	 * 工费扣减
	 * @param retailMs
	 * @param promotion
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applyFeeD(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		return ret;
	}
	
	/**
	 * 第N件打M折
	 * @param items
	 * @param promotion
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applyNM(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> retailMList = new ArrayList<RetailM>();
		int num = promotion.getSet1().intValue();//第N件
		BigDecimal points = promotion.getSet2();//打M折
		for(RetailM retailM : retailMs){
			setRetailM(retailM, promotion);
			if(retailMs.size() >= num){
				retailM.setFactAmount(retailM.getFactAmount().multiply(points));
			}
			retailMList.add(retailM);
		}
		return retailMList;
	}

	/**
	 * 整单满减
	 * @param retailMs 单品集合
	 * @param promotion 促销方案
	 * @return 促销之后的单品集合
	 * @throws POSException
	 */
	public List<RetailM> applyAllNM(List<RetailM> retailMs, Promotion promotion)
			throws POSException {
		BigDecimal countPrices = new BigDecimal(0);
		for(RetailM retailM : retailMs){
			countPrices = countPrices.add(retailM.getSalesAmount());//累加门店零售标签价为总价
		}
		if(countPrices.compareTo(promotion.getSet1()) == 1){//整单满N元，符合减M元条件
			//按权重将减少的M元分摊到每件商品
			if(null == retailMs || retailMs.size() <= 0){
				return retailMs;
			}
			List<RetailM> itemList = new ArrayList<RetailM>();
			BigDecimal afterCountPrices = new BigDecimal(0);//单品折后价累加
			BigDecimal afterNMCountPrices = countPrices.subtract(promotion.getSet2());//折后总价
			
			for(int i=0; i<retailMs.size(); i++){
				RetailM rm = retailMs.get(i);
				setRetailM(rm, promotion);
				BigDecimal itemCountPrices = rm.getSalesAmount();//门店零售标签价
				BigDecimal pricesPoint = itemCountPrices.divide(countPrices, 2, BigDecimal.ROUND_HALF_DOWN);
				BigDecimal afterNMPrices = itemCountPrices.subtract(promotion.getSet2().multiply(pricesPoint));//单品折后价
				
				//如果是最后一件
				if((i+1) == retailMs.size()){
					rm.setSalesAmount(afterNMCountPrices.subtract(afterCountPrices));//最后一件的折后价=折后总价-单品折后价累加
				}else{
					afterCountPrices = afterCountPrices.add(afterNMPrices);//折后总价=单品折后价累加（不包括最后一件）
					rm.setSalesAmount(itemCountPrices.subtract(promotion.getSet2().multiply(pricesPoint)));
				}
				itemList.add(rm);
			}
			return itemList;
		}else{
			return retailMs;
		}
	}
}
