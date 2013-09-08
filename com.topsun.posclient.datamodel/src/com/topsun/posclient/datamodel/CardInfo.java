package com.topsun.posclient.datamodel;


/**
 * 卡信息
 * 
 * @author LiLei
 *
 */
public class CardInfo {
	
	private int memberId;
	
	private String cardNo;
	
	public String cardType;
	
	public String validDate;
	
	public String invalidDate;
	
	public String status;

	public final int getMemberId() {
		return memberId;
	}

	public final void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public final String getCardNo() {
		return cardNo;
	}

	public final void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public final String getCardType() {
		return cardType;
	}

	public final void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public final String getValidDate() {
		return validDate;
	}

	public final void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public final String getInvalidDate() {
		return invalidDate;
	}

	public final void setInvalidDate(String invalidDate) {
		this.invalidDate = invalidDate;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(String status) {
		this.status = status;
	}
}
