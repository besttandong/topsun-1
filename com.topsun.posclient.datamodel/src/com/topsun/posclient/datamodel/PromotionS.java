package com.topsun.posclient.datamodel;

/**
 * 促销方案指定赠品
 * @author Dong
 *
 */
public class PromotionS {

	private int ID; //ID编号
	private String DocNum; //方案编号
	private String Giveaway; //赠品编号
	
	public final int getID() {
		return ID;
	}
	public final void setID(int iD) {
		ID = iD;
	}
	public final String getDocNum() {
		return DocNum;
	}
	public final void setDocNum(String docNum) {
		DocNum = docNum;
	}
	public final String getGiveaway() {
		return Giveaway;
	}
	public final void setGiveaway(String giveaway) {
		Giveaway = giveaway;
	}
}
