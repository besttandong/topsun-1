package com.topsun.posclient.datamodel;

import java.util.Date;
import java.util.List;

/**
 * 调仓信息
 * 
 * @author Dong
 *
 */
public class AdjustRepositoryInfo {
	
	private String id; //标识
	
	private int backShopId; //回仓店铺
	
	private String orderNo; //单据编号
	
	private int deliver; //发货人
	
	private Date backDate; //调仓日期
	
	private int receiveRepositoryId; // 收获仓库
	
	private Date checkDate;//审核日期
	
	private String backReason;//回仓原因
	
	private Date reCheckDate; //复核日期
	
	private String remark;//备注
	
	private int num;//备注
	
	private List<Item> itemList; // 商品列表
	
	private int applyUser;//制单人
	
	private int checker;//审核人
	
	private int reChecker;//复核人
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getBackReason() {
		return backReason;
	}

	public void setBackReason(String backReason) {
		this.backReason = backReason;
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

	public final int getBackShopId() {
		return backShopId;
	}

	public final void setBackShopId(int backShopId) {
		this.backShopId = backShopId;
	}

	public final int getDeliver() {
		return deliver;
	}

	public final void setDeliver(int deliver) {
		this.deliver = deliver;
	}

	public final int getReceiveRepositoryId() {
		return receiveRepositoryId;
	}

	public final void setReceiveRepositoryId(int receiveRepositoryId) {
		this.receiveRepositoryId = receiveRepositoryId;
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
