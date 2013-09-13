package com.topsun.posclient.datamodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Dong
 *
 */
public class Member {
	
	private int id;

	private String name;
	
	private int gender;
	
	private int ageReg;
	
	private Date birthday;
	
	private String phone1;
	
	private String phone2;
	
	private String email;
	
	private Date regDate;
	
	private int createShopId;
	
	private int cardSender1;
	
	private int cardSender2;
	
	private String remark;
	
	private int monthCount;
	
	private int yearCount;
	
	private int buyCount;
	
	private int firstCount;
	
	private int endCount;
	
	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final int getGender() {
		return gender;
	}

	public final void setGender(int gender) {
		this.gender = gender;
	}

	public final int getAgeReg() {
		return ageReg;
	}

	public final void setAgeReg(int ageReg) {
		this.ageReg = ageReg;
	}

	public final Date getBirthday() {
		return birthday;
	}

	public final void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public final String getPhone1() {
		return phone1;
	}

	public final void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public final String getPhone2() {
		return phone2;
	}

	public final void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final Date getRegDate() {
		return regDate;
	}

	public final void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public final int getCreateShopId() {
		return createShopId;
	}

	public final void setCreateShopId(int createShopId) {
		this.createShopId = createShopId;
	}

	public final int getCardSender1() {
		return cardSender1;
	}

	public final void setCardSender1(int cardSender1) {
		this.cardSender1 = cardSender1;
	}

	public final int getCardSender2() {
		return cardSender2;
	}

	public final void setCardSender2(int cardSender2) {
		this.cardSender2 = cardSender2;
	}

	public final String getRemark() {
		return remark;
	}

	public final void setRemark(String remark) {
		this.remark = remark;
	}

	public final int getMonthCount() {
		return monthCount;
	}

	public final void setMonthCount(int monthCount) {
		this.monthCount = monthCount;
	}

	public final int getYearCount() {
		return yearCount;
	}

	public final void setYearCount(int yearCount) {
		this.yearCount = yearCount;
	}

	public final int getBuyCount() {
		return buyCount;
	}

	public final void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	public final int getFirstCount() {
		return firstCount;
	}

	public final void setFirstCount(int firstCount) {
		this.firstCount = firstCount;
	}

	public final int getEndCount() {
		return endCount;
	}

	public final void setEndCount(int endCount) {
		this.endCount = endCount;
	}
}
