package com.topsun.posclient.common.service;

import java.util.List;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.datamodel.AllotStyle;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.dto.AllotStyleDTO;
import com.topsun.posclient.datamodel.dto.CashierModeDTO;
import com.topsun.posclient.datamodel.dto.ItemDTO;
import com.topsun.posclient.datamodel.dto.ShopDTO;
import com.topsun.posclient.datamodel.dto.UserDTO;

public interface IBaseService {
	
	public UserDTO getUserData() throws Exception;

	public UserDTO getUserById(int userId) throws Exception;
	
	public String getEmployeeNameById(int userId) throws Exception;

	public CashierModeDTO getAllCashierMode() throws POSException;
	
	public AllotStyleDTO getAllAllotStyle() throws Exception;
	
	public ItemDTO getAllItem() throws Exception;
	
	public ShopDTO getAllShop() throws Exception;
	
	public String getShopNameById(int shopId) throws Exception;
	
	public String getItemNameById(int itemId) throws Exception;
	
	
	/**
	 * 生成单据编号
	 * @return
	 * @throws POSException
	 */
	public String createNo() throws POSException;
	
	/**
	 * 根据用户ID获取店铺名称
	 * 
	 * @throws Exception
	 */
	public String getShopNameByUserId(int userId) throws POSException;
	
	
	/**
	 * 根据款号获取商品信息
	 * @return
	 * @throws POSException
	 */
	public Item getItemByCode(String code) throws POSException;
	
	
	/**
	 * 获取所有调拨类型
	 * @return
	 * @throws POSException
	 */
	public List<AllotStyle> getAllotStyle() throws POSException;

}
