package com.topsun.posclient.datamodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 零售信息
 * 
 * @author Dong
 *
 */
public class PartSales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int shopId; //店铺名称
	
	private String no;//单据编号
	
	private int balloter;//收银员
	
	private String ballotNo;//收银票号
	
	private String remark;// 备注
	
	private Date salesDate;//销售日期
	
	private Date checkDate; //审核日期
	
	private int userId; //会员
	
	private String cardNo;// 会员卡号
	
	private String enableBalance; //可用余额

	private String enablePoint; //可用积分
	
	private int applyUser;//制单人
	
	private int checker;//审核人
	
	private List<Item> itemList; //零售明细，商品列表
	
	private List<PartSalesCashier> psCashierList;//零售结算
	
	
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getEnablePoint() {
		return enablePoint;
	}

	public void setEnablePoint(String enablePoint) {
		this.enablePoint = enablePoint;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBallotNo() {
		return ballotNo;
	}

	public void setBallotNo(String ballotNo) {
		this.ballotNo = ballotNo;
	}

	public String getEnableBalance() {
		return enableBalance;
	}

	public void setEnableBalance(String enableBalance) {
		this.enableBalance = enableBalance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<PartSalesCashier> getPsCashierList() {
		return psCashierList;
	}

	public void setPsCashierList(List<PartSalesCashier> psCashierList) {
		this.psCashierList = psCashierList;
	}

	public final int getShopId() {
		return shopId;
	}

	public final void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public final int getBalloter() {
		return balloter;
	}

	public final void setBalloter(int balloter) {
		this.balloter = balloter;
	}

	public final int getUserId() {
		return userId;
	}

	public final void setUserId(int userId) {
		this.userId = userId;
	}

	public final int getApplyUser() {
		return applyUser;
	}

	public final void setApplyUser(int applyUser) {
		this.applyUser = applyUser;
	}

	public final int getChecker() {
		return checker;
	}

	public final void setChecker(int checker) {
		this.checker = checker;
	}
}
