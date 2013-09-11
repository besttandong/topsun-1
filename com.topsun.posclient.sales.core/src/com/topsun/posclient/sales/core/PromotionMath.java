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
	 * 单品促销
	 * @param retailMs 零售明细集合
	 * @param promotion 促销方案
	 * @return 促销之后的单品集合
	 * @throws POSException
	 */
	public List<RetailM> applySingle(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		for(RetailM retailM : retailMs){
			if(promotion.getIsAll() == 1){//全场
				System.out.println(retailM.getItemCode()+"["+retailM.getMATNR()+"]全场打折，折扣为："+promotion.getRate());
				retailM.setFactAmount(retailM.getFactAmount().multiply(promotion.getRate()));
			}else{
				doIncludAndExclude(retailM, promotion); //包含&排除算法
			}
			setRetailM(retailM, promotion);
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
			//零售明细的实售金额大于促销方案设定值1，满足单件满N减M的条件
			if(retailM.getSalesAmount().compareTo(promotion.getSet1()) == 1){
				retailM.setFactAmount(retailM.getFactAmount().subtract(promotion.getSet2()));
			}
			setRetailM(retailM, promotion);
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
	 * @param retailMs 零售明细列表
	 * @param promotion 促销方案
	 * @return
	 * @throws POSException
	 */
	public List<RetailM> applySingleNG(List<RetailM> retailMs, Promotion promotion) throws POSException {
		List<RetailM> ret = new ArrayList<RetailM>();
		for(RetailM retailM : retailMs){
			if(retailM.getFactAmount().intValue() > promotion.getSet1().intValue()){
				List<String> appointList = getAppointListFromPromi(promotion);
				if(appointList.contains(retailM.getMATNR())){//零售明细编号在促销方案指定物料编号列表中
					retailM.setItemName(retailM.getItemName()+"(有赠品)");
				}
			}
			setRetailM(retailM, promotion);
			ret.add(retailM);
		}
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
		for(RetailM retailM : retailMs){
			if(promotion.getIsAll() == 1){//全场
				retailM.setProcessFee_S(retailM.getProcessFee().multiply(promotion.getSet1()));
			}else{
				doIncludAndExclude(retailM, promotion); //包含&排除算法
			}
			setRetailM(retailM, promotion);
			ret.add(retailM);
		}
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
		for(RetailM retailM : retailMs){
			if(promotion.getIsAll() == 1){//全场
				retailM.setProcessFee_S(retailM.getProcessFee().subtract(retailM.getSalesWeight().multiply(promotion.getSet1())));
			}else{
				doIncludAndExclude(retailM, promotion); //包含&排除算法
			}
			setRetailM(retailM, promotion);
			ret.add(retailM);
		}
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
			if(retailMs.size() >= num){
				retailM.setFactAmount(retailM.getFactAmount().multiply(points));
			}
			retailMList.add(retailM);
			setRetailM(retailM, promotion);
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
				BigDecimal itemCountPrices = rm.getSalesAmount();//门店零售标签价
				BigDecimal pricesPoint = itemCountPrices.divide(countPrices, 2, BigDecimal.ROUND_HALF_UP);
				BigDecimal afterNMPrices = itemCountPrices.subtract(promotion.getSet2().multiply(pricesPoint));//单品折后价
				
				//如果是最后一件
				if((i+1) == retailMs.size()){
					rm.setFactAmount(afterNMCountPrices.subtract(afterCountPrices));//最后一件的折后价=折后总价-单品折后价累加
				}else{
					afterCountPrices = afterCountPrices.add(afterNMPrices);//折后总价=单品折后价累加（不包括最后一件）
					rm.setFactAmount(itemCountPrices.subtract(promotion.getSet2().multiply(pricesPoint)));
				}
				itemList.add(rm);
				setRetailM(rm, promotion);
			}
			return itemList;
		}else{
			return retailMs;
		}
	}
	
	/*****************************************************************************************/
	
	
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
	 * 获取某个促销方案，根据物料号排除列表
	 * @param promotion 促销方案
	 * @return
	 */
	private List<String> getExcludeListFromPromi(Promotion promotion){
		StringBuffer buffer = new StringBuffer("[");
		List<PromotionM> promotionMList = promotion.getPromotionMList();
		List<String> unincludList = new ArrayList<String>();//排除列表
		for(PromotionM pm : promotionMList){
			if(pm.getType().equals("2")){
				buffer.append(pm.getMATNR());
				unincludList.add(pm.getMATNR());
			}
		}
		buffer.append("]");
		System.out.println("排除列表："+buffer.toString());
		return unincludList;
	}
	
	/**
	 * 获取某个促销方案指定物料编号列表
	 * @param promotion 促销方案
	 * @return
	 */
	private List<String> getAppointListFromPromi(Promotion promotion){
		List<String> appointList = new ArrayList<String>();//指定物料编号列表
		List<PromotionM> promotionMList = promotion.getPromotionMList();
		for(PromotionM pm : promotionMList){
			if(pm.getType().equals("3")){
				appointList.add(pm.getMATNR());
			}
		}
		return appointList;
	}
	
	/**
	 * 包含&排除算法
	 * @param retailM 零售明细
	 * @param promotion 促销方案
	 */
	private void doIncludAndExclude(RetailM retailM, Promotion promotion){
		System.out.println(retailM.getItemCode()+"["+retailM.getMATNR()+"]非全场打折（包含排除算法），折扣为："+promotion.getRate());
		List<PromotionM> promotionMList = promotion.getPromotionMList();
		List<String> excludeList = getExcludeListFromPromi(promotion);
		for(PromotionM pm : promotionMList){
			if(!pm.getType().equals("3")){
				//包含并不在排除列表则打折
				if(retailM.getMATNR().startsWith(pm.getMATNR()) && !excludeList.contains(retailM.getMATNR())){
					retailM.setFactAmount(retailM.getFactAmount().multiply(pm.getRate()));
				}
			}
		}
	}
}
