package com.topsun.posclient.datamodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 零售数据
 * 
 * @author LiLei
 *
 */
public class Retail {
	
	private int ID; //ID编号
	private String DocNum; //单据编号
	private Date AccountData; //结算日期
	private String SalesType; //销售类型
	private BigDecimal TotalSales; //销售总金额
	private int DiscountAccount; //打折授权账号
	private BigDecimal DiscountRate; //授权折扣率
	private BigDecimal DiscountAmount; //授权折扣额
	private BigDecimal DiscountToZero; //授权抹零金额
	private BigDecimal InvoceAmount; //开票金额
	private int IsMember; //是否会员销售
	private BigDecimal MemberDiscount; //会员折扣率
	private BigDecimal DiscountAmount_M; //会员折扣金额
	private int CashierID; //收银员工ID
	private String CardNo; //会员卡卡号
	private int EnablePoint; //可用积分
	private int UsePoint; //本次使用积分
	private int AddPoint; //本次累加积分
	private int ShopID; //店铺ID
	private Date SalesDate; //销售日期
	private BigDecimal Receivable; //应收总金额
	private BigDecimal Discount; //优惠金额
	private BigDecimal Totals; //实收金额
	private int IsReturn; //是否有过退货
	private int IsReplace; //是否旧金贴换
	private int IsUpload; //是否上传SAP
	
	private List<RetailM> retailMList; //零售明细 
	private List<RetailP> retailPList;//零售结算  整单结算金额分配
	private List<RetailMP> retailMPList;//零售结算 拆分到每个商品的结算金额
	
	@XmlElementWrapper(name="retailPList")
    @XmlElement(name="RetailP")
	public final List<RetailP> getRetailPList() {
		return retailPList;
	}
	public final void setRetailPList(List<RetailP> retailPList) {
		this.retailPList = retailPList;
	}
	
	@XmlElementWrapper(name="retailMList")
    @XmlElement(name="RetailM")
	public final List<RetailM> getRetailMList() {
		return retailMList;
	}
	public final void setRetailMList(List<RetailM> retailMList) {
		this.retailMList = retailMList;
	}
	
	@XmlElementWrapper(name="retailMPList")
    @XmlElement(name="RetailMP")
	public final List<RetailMP> getRetailMPList() {
		return retailMPList;
	}
	public final void setRetailMPList(List<RetailMP> retailMPList) {
		this.retailMPList = retailMPList;
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
	public final Date getAccountData() {
		return AccountData;
	}
	public final void setAccountData(Date accountData) {
		AccountData = accountData;
	}
	public final String getSalesType() {
		return SalesType;
	}
	public final void setSalesType(String salesType) {
		SalesType = salesType;
	}
	public final BigDecimal getTotalSales() {
		return TotalSales;
	}
	public final void setTotalSales(BigDecimal totalSales) {
		TotalSales = totalSales;
	}
	public final int getDiscountAccount() {
		return DiscountAccount;
	}
	public final void setDiscountAccount(int discountAccount) {
		DiscountAccount = discountAccount;
	}
	public final BigDecimal getDiscountRate() {
		return DiscountRate;
	}
	public final void setDiscountRate(BigDecimal discountRate) {
		DiscountRate = discountRate;
	}
	public final BigDecimal getDiscountAmount() {
		return DiscountAmount;
	}
	public final void setDiscountAmount(BigDecimal discountAmount) {
		DiscountAmount = discountAmount;
	}
	public final BigDecimal getDiscountToZero() {
		return DiscountToZero;
	}
	public final void setDiscountToZero(BigDecimal discountToZero) {
		DiscountToZero = discountToZero;
	}
	public final BigDecimal getInvoceAmount() {
		return InvoceAmount;
	}
	public final void setInvoceAmount(BigDecimal invoceAmount) {
		InvoceAmount = invoceAmount;
	}
	public final int getIsMember() {
		return IsMember;
	}
	public final void setIsMember(int isMember) {
		IsMember = isMember;
	}
	public final BigDecimal getMemberDiscount() {
		return MemberDiscount;
	}
	public final void setMemberDiscount(BigDecimal memberDiscount) {
		MemberDiscount = memberDiscount;
	}
	public final BigDecimal getDiscountAmount_M() {
		return DiscountAmount_M;
	}
	public final void setDiscountAmount_M(BigDecimal discountAmount_M) {
		DiscountAmount_M = discountAmount_M;
	}
	public final int getCashierID() {
		return CashierID;
	}
	public final void setCashierID(int cashierID) {
		CashierID = cashierID;
	}
	public final String getCardNo() {
		return CardNo;
	}
	public final void setCardNo(String cardNo) {
		CardNo = cardNo;
	}
	public final int getEnablePoint() {
		return EnablePoint;
	}
	public final void setEnablePoint(int enablePoint) {
		EnablePoint = enablePoint;
	}
	public final int getUsePoint() {
		return UsePoint;
	}
	public final void setUsePoint(int usePoint) {
		UsePoint = usePoint;
	}
	public final int getAddPoint() {
		return AddPoint;
	}
	public final void setAddPoint(int addPoint) {
		AddPoint = addPoint;
	}
	public final int getShopID() {
		return ShopID;
	}
	public final void setShopID(int shopID) {
		ShopID = shopID;
	}
	public final Date getSalesDate() {
		return SalesDate;
	}
	public final void setSalesDate(Date salesDate) {
		SalesDate = salesDate;
	}
	public final BigDecimal getReceivable() {
		return Receivable;
	}
	public final void setReceivable(BigDecimal receivable) {
		Receivable = receivable;
	}
	public final BigDecimal getDiscount() {
		return Discount;
	}
	public final void setDiscount(BigDecimal discount) {
		Discount = discount;
	}
	public final BigDecimal getTotals() {
		return Totals;
	}
	public final void setTotals(BigDecimal totals) {
		Totals = totals;
	}
	public final int getIsReturn() {
		return IsReturn;
	}
	public final void setIsReturn(int isReturn) {
		IsReturn = isReturn;
	}
	public final int getIsReplace() {
		return IsReplace;
	}
	public final void setIsReplace(int isReplace) {
		IsReplace = isReplace;
	}
	public final int getIsUpload() {
		return IsUpload;
	}
	public final void setIsUpload(int isUpload) {
		IsUpload = isUpload;
	}
}
