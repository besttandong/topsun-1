package com.topsun.posclient.datamodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 旧金
 * 
 * @author Dong
 *
 */
public class OldGold {

	private int ID; //ID编号
	private int mainID; //ID单据ID
	private String DocNum; //ID单据编号
	private String IdfCode; //ID鉴定单编号
	private String ItemCode; //ID单品编号
	private String MtartCode; //ID物料编号
	private BigDecimal Weight_G; //ID金重
	private BigDecimal Neatness; //ID纯色%
	private BigDecimal Loss; //ID耗损率
	private BigDecimal Weight; //ID纯重
	private BigDecimal Weight_R; //ID回收净重
	private BigDecimal Refine; //ID提炼费
	private BigDecimal Service; //ID服务费
	private BigDecimal Weight_F; //ID实际重量
	private BigDecimal Price_G; //ID回收金价
	private BigDecimal Sum; //ID回收金额
	private String Type; //ID类型[经销/代销]
	private int Suppliser; //ID所属供应商
	private int DelFlg; //ID删除标识（默认为0）
	private int Creater; //ID创建者
	private Date CreatedTime; //ID创建时间
	private int Updater; //ID最后修改者
	private Date LastUpdatedTime; //ID最后修改时间
	private String Revision; //ID版本戳
	public final int getID() {
		return ID;
	}
	public final void setID(int iD) {
		ID = iD;
	}
	public final int getMainID() {
		return mainID;
	}
	public final void setMainID(int mainID) {
		this.mainID = mainID;
	}
	public final String getDocNum() {
		return DocNum;
	}
	public final void setDocNum(String docNum) {
		DocNum = docNum;
	}
	public final String getIdfCode() {
		return IdfCode;
	}
	public final void setIdfCode(String idfCode) {
		IdfCode = idfCode;
	}
	public final String getItemCode() {
		return ItemCode;
	}
	public final void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public final String getMtartCode() {
		return MtartCode;
	}
	public final void setMtartCode(String mtartCode) {
		MtartCode = mtartCode;
	}
	public final BigDecimal getWeight_G() {
		return Weight_G;
	}
	public final void setWeight_G(BigDecimal weight_G) {
		Weight_G = weight_G;
	}
	public final BigDecimal getNeatness() {
		return Neatness;
	}
	public final void setNeatness(BigDecimal neatness) {
		Neatness = neatness;
	}
	public final BigDecimal getLoss() {
		return Loss;
	}
	public final void setLoss(BigDecimal loss) {
		Loss = loss;
	}
	public final BigDecimal getWeight() {
		return Weight;
	}
	public final void setWeight(BigDecimal weight) {
		Weight = weight;
	}
	public final BigDecimal getWeight_R() {
		return Weight_R;
	}
	public final void setWeight_R(BigDecimal weight_R) {
		Weight_R = weight_R;
	}
	public final BigDecimal getRefine() {
		return Refine;
	}
	public final void setRefine(BigDecimal refine) {
		Refine = refine;
	}
	public final BigDecimal getService() {
		return Service;
	}
	public final void setService(BigDecimal service) {
		Service = service;
	}
	public final BigDecimal getWeight_F() {
		return Weight_F;
	}
	public final void setWeight_F(BigDecimal weight_F) {
		Weight_F = weight_F;
	}
	public final BigDecimal getPrice_G() {
		return Price_G;
	}
	public final void setPrice_G(BigDecimal price_G) {
		Price_G = price_G;
	}
	public final BigDecimal getSum() {
		return Sum;
	}
	public final void setSum(BigDecimal sum) {
		Sum = sum;
	}
	public final String getType() {
		return Type;
	}
	public final void setType(String type) {
		Type = type;
	}
	public final int getSuppliser() {
		return Suppliser;
	}
	public final void setSuppliser(int suppliser) {
		Suppliser = suppliser;
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
