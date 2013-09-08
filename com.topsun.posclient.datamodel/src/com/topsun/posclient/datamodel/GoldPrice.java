package com.topsun.posclient.datamodel;

/**
 * 实时金价
 * @author LiLei
 *
 */
public class GoldPrice {
	
	private int ID;//ID编号	Primary Key
	private String MtartCode;//物料编号	
	private String Price;//实时金价	
	
	public final int getID() {
		return ID;
	}
	public final void setID(int iD) {
		ID = iD;
	}
	public final String getMtartCode() {
		return MtartCode;
	}
	public final void setMtartCode(String mtartCode) {
		MtartCode = mtartCode;
	}
	public final String getPrice() {
		return Price;
	}
	public final void setPrice(String price) {
		Price = price;
	}
}
