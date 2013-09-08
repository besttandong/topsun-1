package com.topsun.posclient.promotion.core.service;

import java.util.List;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.Promotion;

/**
 * @author LiLei
 *
 */
public interface IPromotionService {
	
	/**
	 * 单品促销(根据单品本身允许的促销折扣进行打折)
	 * @param items 单品集合
	 * @return 根据折扣更新价格之后的单品列表
	 * @throws POSException
	 */
	public List<Item> applyPromotion(List<Item> items) throws POSException;

	/**
	 * 第N件打M折
	 * @param items 促销之前的单品集合 （必须是促销范围内的单品）
	 * @param promotion 促销方案
	 * @return 应用第N件打M折促销之后的商品集合，主要是价格的修改
	 * @throws POSException
	 */
	public List<Item> applyNM(List<Item> items, Promotion promotion)throws POSException;
	
	/**
	 * 整单满N减M
	 * @param items 促销之前的单品集合（必须是促销范围内的单品）
	 * @param promotion 促销方案
	 * @return 应用整单满N减M促销之后的商品集合，主要是按权重进行分摊。
	 * 举例：满1000减300，满500减100。如果  客户买了1800元算法为，只要满足最后一个促销条件即可即返回300元
	 * @throws POSException
	 */
	public List<Item> applyAllNM(List<Item> items, Promotion promotion)throws POSException;
	
}
