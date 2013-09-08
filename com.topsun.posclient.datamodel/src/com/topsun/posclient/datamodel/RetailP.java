package com.topsun.posclient.datamodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LiLei
 *
 */
public class RetailP {
	
	private int ID; //ID编号
	private int MainID; //主表ID
	private String DocNum; //单据编号
	private int PayModeID; //结算方式ID
	private BigDecimal Poundage; //手续费比例
	private BigDecimal PoundageRate; //手续费
	private BigDecimal Sum; //结算金额
	private int DelFlg; //删除标识（默认为0）
	private int Creater; //创建者
	private Date CreatedTime; //创建时间
	private int Updater; //最后修改者
	private Date LastUpdatedTime; //最后修改时间
	private String Revision; //版本戳
	
	public final int getID() {
		return ID;
	}
	public final void setID(int iD) {
		ID = iD;
	}
	public final int getMainID() {
		return MainID;
	}
	public final void setMainID(int mainID) {
		MainID = mainID;
	}
	public final String getDocNum() {
		return DocNum;
	}
	public final void setDocNum(String docNum) {
		DocNum = docNum;
	}
	public final int getPayModeID() {
		return PayModeID;
	}
	public final void setPayModeID(int payModeID) {
		PayModeID = payModeID;
	}
	public final BigDecimal getPoundage() {
		return Poundage;
	}
	public final void setPoundage(BigDecimal poundage) {
		Poundage = poundage;
	}
	public final BigDecimal getPoundageRate() {
		return PoundageRate;
	}
	public final void setPoundageRate(BigDecimal poundageRate) {
		PoundageRate = poundageRate;
	}
	public final BigDecimal getSum() {
		return Sum;
	}
	public final void setSum(BigDecimal sum) {
		Sum = sum;
	}
	public final int getDelFlg() {
		return DelFlg;
	}
	public final void setDelFlg(int delFlg) {
		DelFlg = delFlg;
	}
	public final int getCreater() {
		return Creater;
	}
	public final void setCreater(int creater) {
		Creater = creater;
	}
	public final Date getCreatedTime() {
		return CreatedTime;
	}
	public final void setCreatedTime(Date createdTime) {
		CreatedTime = createdTime;
	}
	public final int getUpdater() {
		return Updater;
	}
	public final void setUpdater(int updater) {
		Updater = updater;
	}
	public final Date getLastUpdatedTime() {
		return LastUpdatedTime;
	}
	public final void setLastUpdatedTime(Date lastUpdatedTime) {
		LastUpdatedTime = lastUpdatedTime;
	}
	public final String getRevision() {
		return Revision;
	}
	public final void setRevision(String revision) {
		Revision = revision;
	}
}
