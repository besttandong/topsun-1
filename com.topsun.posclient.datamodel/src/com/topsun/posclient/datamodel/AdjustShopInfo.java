package com.topsun.posclient.datamodel;

import java.util.Date;
import java.util.List;

/**
 * 调店信息
 * 
 * @author Dong
 *
 */
public class AdjustShopInfo {
	
	private String id; //标识
	
	private int outShop; //调出店铺
	
	private int intoShop;//调入店铺
	
	private String voucherNo; //单据编号
	
	private Date callDate; //调拨日期
	
	private int callType; // 调拨类型
	
	private Date checkDate;//审核日期
	
	private Date reCheckDate; //复核日期
	
	private String remark;//备注
	
	private int itemNum; //调货数量 取goosList的size
	
	private List<Item> itemList; // 商品列表
	
	private int applyUser;//制单人
	
	private int checker;//审核人
	
	private int reChecker;//复核人
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getReCheckDate() {
		return reCheckDate;
	}

	public void setReCheckDate(Date reCheckDate) {
		this.reCheckDate = reCheckDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCallDate() {
		return callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public final int getOutShop() {
		return outShop;
	}

	public final void setOutShop(int outShop) {
		this.outShop = outShop;
	}

	public final int getIntoShop() {
		return intoShop;
	}

	public final void setIntoShop(int intoShop) {
		this.intoShop = intoShop;
	}

	public final int getCallType() {
		return callType;
	}

	public final void setCallType(int callType) {
		this.callType = callType;
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

	public final int getReChecker() {
		return reChecker;
	}

	public final void setReChecker(int reChecker) {
		this.reChecker = reChecker;
	}
}
