package com.topsun.posclient.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.datamodel.AllotStyle;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.Material;
import com.topsun.posclient.datamodel.Shop;
import com.topsun.posclient.datamodel.dto.CashierModeDTO;
import com.topsun.posclient.datamodel.dto.ItemDTO;
import com.topsun.posclient.datamodel.dto.ShopDTO;
import com.topsun.posclient.datamodel.dto.UserDTO;

/**
 * 基础服务接口
 * @author Dong
 *
 */
public interface IBaseService {
	
	/**
	 * 获取用户数据
	 * @return
	 * @throws Exception
	 */
	public UserDTO getUserData() throws Exception;

	/**
	 * 根据ID获取用户数据
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserDTO getUserById(int userId) throws Exception;
	
	public String getEmployeeNameById(int userId) throws Exception;

	public CashierModeDTO getAllCashierMode() throws POSException;
	
	public ItemDTO getAllItem() throws Exception;
	
	public ShopDTO getAllShop() throws Exception;
	
	public String getShopNameById(int shopId) throws Exception;
	
	public Shop getShopById(int shopId) throws Exception;
	
	public String getItemNameById(int itemId) throws Exception;
	
	
	/**
	 * 根据用户ID获取店铺名称
	 * 
	 * @throws Exception
	 */
	public String getShopNameByUserId(int userId) throws POSException;
	
	
	/**
	 * 根据款号（条形码）获取商品信息
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
	
	
	
	
	
	
	
	
	/**
	 * 生成单据编号
	 * @return
	 * @throws POSException
	 */
	public String createNo() throws POSException;
	
	/**
	 * 计算积分	
	 * 按物料类别进行判断，对应每个物料类别都有一个积分系数，
	 * 如普通会员黄金类别积分系数为0.5，即购买10000元黄金，
	 * 积分为5000分。金牌会员对应铂金类别积分系数为0.75，
	 * 即购买10000元铂金，积分为7500分。
	 * @param material 物料
	 * @return 积分值
	 * @throws POSException
	 */
	public int calculatePoints(Material material)throws POSException;
	
	/**
	 * 根据物料编号，获取实时金价
	 * @param mtartCode 物料编号
	 * @return 实时金价
	 * @throws POSException
	 */
	public BigDecimal getGoldPriceByMtartCode(String mtartCode) throws POSException;
	
	/**
	 * 根据物料编码修改实时金价
	 * @param mtartCode 物料编码
	 * @param gprice 金价
	 * @return 成功/失败标识
	 * @throws POSException
	 */
	public boolean updateGoldPriceByMtartCode(String mtartCode, BigDecimal gprice) throws POSException;
	
}
