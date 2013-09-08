package com.topsun.posclient.promotion.core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.topsun.posclient.common.MockDataFactory;
import com.topsun.posclient.common.POSException;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.Promotion;
import com.topsun.posclient.promotion.core.service.IPromotionService;

/**
 * 
 * @author LiLei
 *
 */
public class PromotionServiceImpl implements IPromotionService {
	
	/* (non-Javadoc)
	 * @see com.topsun.posclient.promote.core.service.IPromoteService#applyPromotion(java.util.List)
	 */
	public List<Item> applyPromotion(List<Item> items) throws POSException {
		if(null == items || items.size() <= 0){
			return items;
		}
		List<Item> itemList = new ArrayList<Item>();
		for(Item item : items){
			//TODO 根据折扣修改Item价格
			itemList.add(item);
		}
		return itemList;
	}
	
	/* (non-Javadoc)
	 * @see com.topsun.posclient.promote.core.service.IPromoteService#applyNM(java.util.List, com.topsun.posclient.datamodel.Promotion)
	 */
	public List<Item> applyNM(List<Item> items, Promotion promotion) throws POSException {
		List<Item> itemList = new ArrayList<Item>();
		int num = promotion.getNum();//第N件
		double points = promotion.getPoints();//打M折
		for(Item item : items){
			if(item.getNum() >= num){
				item.setRetailPrice(item.getRetailPrice()*points);
			}
			itemList.add(item);
		}
		return itemList;
	}

	/* (non-Javadoc)
	 * @see com.topsun.posclient.promote.core.service.IPromoteService#applyAllNM(java.util.List, com.topsun.posclient.datamodel.Promotion)
	 */
	public List<Item> applyAllNM(List<Item> items, Promotion promotion)
			throws POSException {
		BigDecimal countPrices = new BigDecimal(0);
		for(Item item : items){
			countPrices = countPrices.add(item.getZMDLSBQJ().multiply(item.getZZJ()));//累加门店零售标签价为总价
		}
		if(countPrices.compareTo(promotion.getPointPrices()) == 1){//整单满N元，符合减M元条件
			return doAllNM(items, countPrices, promotion.getSalesPrices());//按权重将减少的M元分摊到每件商品
		}else{
			return items;
		}
	}
	
	/**
	 * 按权重将减少的M元分摊到每件商品
	 * @param items
	 * @param countPrices 整单总价
	 * @param salesPrices 减M元
	 * @return
	 */
	private List<Item> doAllNM(List<Item> items, BigDecimal countPrices, BigDecimal salesPrices){
		if(null == items || items.size() <= 0){
			return items;
		}
		List<Item> itemList = new ArrayList<Item>();
		BigDecimal afterCountPrices = new BigDecimal(0);//单品折后价累加
		BigDecimal afterNMCountPrices = countPrices.subtract(salesPrices);//折后总价
		
		for(int i=0; i<items.size(); i++){
			Item item = items.get(i);
			BigDecimal itemCountPrices = item.getZMDLSBQJ().multiply(item.getZZJ());//门店零售标签价×件数
			BigDecimal pricesPoint = itemCountPrices.divide(countPrices, 2, BigDecimal .ROUND_HALF_DOWN);
			BigDecimal afterNMPrices = itemCountPrices.subtract(salesPrices.multiply(pricesPoint));//单品折后价
			
			//如果是最后一件
			if((i+1) == items.size()){
				item.setZMDLSBQJ(afterNMCountPrices.subtract(afterCountPrices));//最后一件的折后价=折后总价-单品折后价累加
			}else{
				afterCountPrices = afterCountPrices.add(afterNMPrices);//折后总价=单品折后价累加（不包括最后一件）
				item.setZMDLSBQJ(itemCountPrices.subtract(salesPrices.multiply(pricesPoint)));
			}
			itemList.add(item);
		}
		return itemList;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		Promotion promotion = new Promotion();
		promotion.setPointPrices(new BigDecimal(1000));
		promotion.setSalesPrices(new BigDecimal(300));
		List<Item> items = MockDataFactory.createItemList();
		System.out.println("促销之前");
		for(Item item : items){
			System.out.println(item.getItemName()+" ---- 价格×数量    "+item.getZMDLSBQJ().multiply(item.getZZJ()));
		}
		try {
			List<Item> newItems = new PromotionServiceImpl().applyAllNM(items, promotion);
			System.out.println("促销之后");
			for(Item item : newItems){
				System.out.println(item.getItemName()+" ---- 价格×数量     "+item.getZMDLSBQJ().multiply(item.getZZJ()));
			}
		} catch (POSException e) {
			e.printStackTrace();
		}
	}

}
