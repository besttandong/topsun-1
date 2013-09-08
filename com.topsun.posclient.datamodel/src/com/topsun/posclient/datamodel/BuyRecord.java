package com.topsun.posclient.datamodel;

import java.util.Date;

/**
 * @author Dong
 *
 */
public class BuyRecord {
	
	private int id;
	
	private int memberId;
	
	private Date salesDate;
	
	private int shopId;
	
	private String itemCode;
	
	private String itemName;
	
	private int itemNum;
	
	private double retailPrice;
	
	private double salesPoint;
	
	private double salesPointAmount;
	
	private double sellAmount;
	
	private double amount;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final int getMemberId() {
		return memberId;
	}

	public final void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public final Date getSalesDate() {
		return salesDate;
	}

	public final void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public final int getShopId() {
		return shopId;
	}

	public final void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public final String getItemCode() {
		return itemCode;
	}

	public final void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public final String getItemName() {
		return itemName;
	}

	public final void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public final int getItemNum() {
		return itemNum;
	}

	public final void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public final double getRetailPrice() {
		return retailPrice;
	}

	public final void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public final double getSalesPoint() {
		return salesPoint;
	}

	public final void setSalesPoint(double salesPoint) {
		this.salesPoint = salesPoint;
	}

	public final double getSalesPointAmount() {
		return salesPointAmount;
	}

	public final void setSalesPointAmount(double salesPointAmount) {
		this.salesPointAmount = salesPointAmount;
	}

	public final double getSellAmount() {
		return sellAmount;
	}

	public final void setSellAmount(double sellAmount) {
		this.sellAmount = sellAmount;
	}

	public final double getAmount() {
		return amount;
	}

	public final void setAmount(double amount) {
		this.amount = amount;
	}
}
