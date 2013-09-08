package com.topsun.posclient.datamodel;

import java.math.BigDecimal;

/**
 * 全场促销
 * @author Dong
 *
 */
public class PromotionA {
	
	private int ID; //ID编号
	private String DocNum; //方案编号
	private BigDecimal Set1; //设定值1
	private BigDecimal Set2; //设定值2
	
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
	public final BigDecimal getSet1() {
		return Set1;
	}
	public final void setSet1(BigDecimal set1) {
		Set1 = set1;
	}
	public final BigDecimal getSet2() {
		return Set2;
	}
	public final void setSet2(BigDecimal set2) {
		Set2 = set2;
	}
}
