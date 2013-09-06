package com.topsun.posclient.common.service.impl;

import java.util.List;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.datamodel.AllotStyle;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.Material;
import com.topsun.posclient.datamodel.Shop;
import com.topsun.posclient.datamodel.User;
import com.topsun.posclient.datamodel.dto.AllotStyleDTO;
import com.topsun.posclient.datamodel.dto.CashierModeDTO;
import com.topsun.posclient.datamodel.dto.ItemDTO;
import com.topsun.posclient.datamodel.dto.ShopDTO;
import com.topsun.posclient.datamodel.dto.UserDTO;

public class BaseServiceImpl implements IBaseService {
	
	BaseDao baseDao = new BaseDao();

	public UserDTO getUserData() throws Exception {
		return baseDao.getUserData();
	}

	/**
	 * 根据ID获取用户信息
	 * @return
	 * @throws Exception
	 */
	public UserDTO getUserById(int userId) throws Exception {
		return baseDao.getUserById(userId);
	}
	
	/**
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public String getEmployeeNameById(int userId) throws Exception {
		return baseDao.getEmployeeNameById(userId);
	}

	/**
	 * 获取所有结算方式
	 * @return
	 * @throws POSException 
	 * @throws Exception
	 */
	public CashierModeDTO getAllCashierMode() throws POSException {
		try {
			return baseDao.getAllCashierMode();
		} catch (Exception e) {
			e.printStackTrace();
			throw new POSException("查询结算方式出错!"+e.getStackTrace());
		}
	}
	
	
	/**
	 * 获取所有商品信息
	 * @return
	 * @throws Exception
	 */
	public ItemDTO getAllItem() throws Exception {
		return baseDao.getAllItem();
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ShopDTO getAllShop() throws Exception {
		return baseDao.getAllShop();
	}
	
	public String getShopNameById(int shopId) throws Exception {
		return baseDao.getShopNameById(shopId);
	}
	
	public String getItemNameById(int itemId) throws Exception {
		return baseDao.getItemNameById(itemId);
	}
	
	public String getShopNameByUserId(int userId) throws POSException {
		UserDTO userDto = null;
		try {
			userDto = baseDao.getUserById(userId);
		} catch (Exception e) {
			throw new POSException("查询店铺名称出错！");
		}
		List<User> userList = userDto.getUserList();
		if (null == userList) {
			return "";
		}
		User user = userList.get(0);
		if (null == user) {
			return "";
		}
		return user.getDeptName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.topsun.posclient.common.service.ICommonService#getItemByCode(java
	 * .lang.String)
	 */
	public Item getItemByCode(String code) throws POSException {
		Item returnItem = null;
		ItemDTO itemDto = null;
		try {
			itemDto = baseDao.getAllItem();

			if (null != itemDto) {
				List<Item> itemList = itemDto.getItemList();
				if (null == itemList || itemList.size() <= 0) {
					return null;
				}
				for (Item item : itemList) {
					if (item.getItemCode().equals(code)) {
						returnItem = item;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new POSException("查询商品信息出错！");
		}
		return returnItem;
	}

	public List<AllotStyle> getAllotStyle() throws POSException {
		AllotStyleDTO allotStyleDTO = null;
		
		List<AllotStyle> allotStyleList = null;
		try {
			allotStyleDTO = baseDao.getAllAllotStyle();
			if (null != allotStyleDTO) {
				allotStyleList = allotStyleDTO.getAllotStyleList();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new POSException("获取调拨类型信息失败");
		}
		return allotStyleList;
	}

	public String createNo() throws POSException {
		return String.valueOf(System.currentTimeMillis());
	}

	public Shop getShopById(int shopId) throws Exception {
		return baseDao.getShopById(shopId);
	}

	/* (non-Javadoc)
	 * @see com.topsun.posclient.common.service.IBaseService#calculatePoints(com.topsun.posclient.datamodel.Material)
	 */
	public int calculatePoints(Material material) throws POSException {
		return 0;
	}

}
