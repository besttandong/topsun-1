package com.topsun.posclient.datamodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 促销方案
 * 
 * @author LiLei
 *
 */
public class Promotion {
	
	/*******************************************************************/
	private int ID; //ID编号
	private String DocNum; //方案编号
	private String Title; //方案名称
	private Date StartDate; //起始时间
	private Date EndDate; //终止时间
	private int Mon; //星期一
	private int Tur; //星期二
	private int Wen; //星期三
	private int Thu; //星期四
	private int Fri; //星期五
	private int Sat; //星期六
	private int Sun; //星期天
	private String StartTime; //开始小时
	private String EndTime; //结束小时
	private String Type; //方案类型
	private int Level; //方案优先级
	private int IsAll; //是否全场
	private int IsExc; //是否排除
	private BigDecimal Rate; //统一折扣率
	private BigDecimal Set1; //设定值1
	private BigDecimal Set2; //设定值2
	
	private List<PromotionM> promotionMList;//
	
	private List<PromotionA> promotionAList;
	
	private List<PromotionS> promotionSList;
	
	@XmlElementWrapper(name="promotionMList")
    @XmlElement(name="PromotionM")
	public final List<PromotionM> getPromotionMList() {
		return promotionMList;
	}

	public final void setPromotionMList(List<PromotionM> promotionMList) {
		this.promotionMList = promotionMList;
	}

	@XmlElementWrapper(name="promotionAList")
    @XmlElement(name="PromotionA")
	public final List<PromotionA> getPromotionAList() {
		return promotionAList;
	}

	public final void setPromotionAList(List<PromotionA> promotionAList) {
		this.promotionAList = promotionAList;
	}

	@XmlElementWrapper(name="promotionSList")
    @XmlElement(name="PromotionS")
	public final List<PromotionS> getPromotionSList() {
		return promotionSList;
	}

	public final void setPromotionSList(List<PromotionS> promotionSList) {
		this.promotionSList = promotionSList;
	}

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

	public final String getTitle() {
		return Title;
	}

	public final void setTitle(String title) {
		Title = title;
	}

	public final Date getStartDate() {
		return StartDate;
	}

	public final void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public final Date getEndDate() {
		return EndDate;
	}

	public final void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public final int getMon() {
		return Mon;
	}

	public final void setMon(int mon) {
		Mon = mon;
	}

	public final int getTur() {
		return Tur;
	}

	public final void setTur(int tur) {
		Tur = tur;
	}

	public final int getWen() {
		return Wen;
	}

	public final void setWen(int wen) {
		Wen = wen;
	}

	public final int getThu() {
		return Thu;
	}

	public final void setThu(int thu) {
		Thu = thu;
	}

	public final int getFri() {
		return Fri;
	}

	public final void setFri(int fri) {
		Fri = fri;
	}

	public final int getSat() {
		return Sat;
	}

	public final void setSat(int sat) {
		Sat = sat;
	}

	public final int getSun() {
		return Sun;
	}

	public final void setSun(int sun) {
		Sun = sun;
	}

	public final String getStartTime() {
		return StartTime;
	}

	public final void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public final String getEndTime() {
		return EndTime;
	}

	public final void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public final String getType() {
		return Type;
	}

	public final void setType(String type) {
		Type = type;
	}

	public final int getLevel() {
		return Level;
	}

	public final void setLevel(int level) {
		Level = level;
	}

	public final int getIsAll() {
		return IsAll;
	}

	public final void setIsAll(int isAll) {
		IsAll = isAll;
	}

	public final int getIsExc() {
		return IsExc;
	}

	public final void setIsExc(int isExc) {
		IsExc = isExc;
	}

	public final BigDecimal getRate() {
		return Rate;
	}

	public final void setRate(BigDecimal rate) {
		Rate = rate;
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
