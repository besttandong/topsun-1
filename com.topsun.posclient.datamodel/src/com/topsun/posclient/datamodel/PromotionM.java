package com.topsun.posclient.datamodel;

import java.math.BigDecimal;

/**
 * 促销方案明细
 * 
 * @author Dong
 *
 */
public class PromotionM {
	
	private int ID; //ID编号
	private String DocNum; //方案编号
	private String Type; //类型[包含/排除/指定商品]
	private String MATNR; //物料编号
	private BigDecimal Rate; //折扣率
	private BigDecimal Sum; //扣减值
	
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
	public final String getType() {
		return Type;
	}
	public final void setType(String type) {
		Type = type;
	}
	public final String getMATNR() {
		return MATNR;
	}
	public final void setMATNR(String mATNR) {
		MATNR = mATNR;
	}
	public final BigDecimal getRate() {
		return Rate;
	}
	public final void setRate(BigDecimal rate) {
		Rate = rate;
	}
	public final BigDecimal getSum() {
		return Sum;
	}
	public final void setSum(BigDecimal sum) {
		Sum = sum;
	}
}
