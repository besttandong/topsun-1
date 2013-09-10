package com.topsun.posclient.datamodel;

import java.math.BigDecimal;

/**
 * 零售明细
 * 
 * @author LiLei
 *
 */
public class RetailM {
	
	private int ID; //ID编号
	private int EmployeeID; //营业员ID
	private int IsReplace; //是否旧金贴换
	private String DocNum; //单据编号
	private int ItemId; //单品ID
	private String ItemCode; //单品编号
	private BigDecimal PalWeight; //损益重量
	private BigDecimal PalAmount; //损益金额
	private String SourceCode; //原单品编码
	private String ItemType; //单品状态
	private String AccountType; //核算方式
	private BigDecimal Weight; //原克重
	private BigDecimal SalesWeight; //销售克重
	private BigDecimal UnSalesWeight; //截断克重
	private BigDecimal ProcessFee; //工费
	private BigDecimal ProcessFee_S; //结算工费
	private BigDecimal Price_G; //零售金价;
	private BigDecimal SalesAmount; //应售价
	private BigDecimal FactAmount; //实售价 促销，店长打折后的价格
	private BigDecimal PayAmount; //实付款 实际支付金额 实付款=应售款-旧金抵扣金额-换货抵扣金额
	private BigDecimal PointAmount; //积分抵扣款
	private BigDecimal OldAmount; //旧金抵扣金额
	private BigDecimal ReplaceAmount; //换货抵扣金额
	private String InvoceCode; //发票号码
	private BigDecimal InvoiceAmount; //开票金额
	private String PromotionID; //促销方案ID,多次促销,逗号区分
	private String PromotionName; //促销方案Title
	
	public final int getID() {
		return ID;
	}
	public final void setID(int iD) {
		ID = iD;
	}
	public final int getEmployeeID() {
		return EmployeeID;
	}
	public final void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public final int getIsReplace() {
		return IsReplace;
	}
	public final void setIsReplace(int isReplace) {
		IsReplace = isReplace;
	}
	public final String getDocNum() {
		return DocNum;
	}
	public final void setDocNum(String docNum) {
		DocNum = docNum;
	}
	public final int getItemId() {
		return ItemId;
	}
	public final void setItemId(int itemId) {
		ItemId = itemId;
	}
	public final String getItemCode() {
		return ItemCode;
	}
	public final void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public final BigDecimal getPalWeight() {
		return PalWeight;
	}
	public final void setPalWeight(BigDecimal palWeight) {
		PalWeight = palWeight;
	}
	public final BigDecimal getPalAmount() {
		return PalAmount;
	}
	public final void setPalAmount(BigDecimal palAmount) {
		PalAmount = palAmount;
	}
	public final String getSourceCode() {
		return SourceCode;
	}
	public final void setSourceCode(String sourceCode) {
		SourceCode = sourceCode;
	}
	public final String getItemType() {
		return ItemType;
	}
	public final void setItemType(String itemType) {
		ItemType = itemType;
	}
	public final String getAccountType() {
		return AccountType;
	}
	public final void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public final BigDecimal getWeight() {
		return Weight;
	}
	public final void setWeight(BigDecimal weight) {
		Weight = weight;
	}
	public final BigDecimal getSalesWeight() {
		return SalesWeight;
	}
	public final void setSalesWeight(BigDecimal salesWeight) {
		SalesWeight = salesWeight;
	}
	public final BigDecimal getUnSalesWeight() {
		return UnSalesWeight;
	}
	public final void setUnSalesWeight(BigDecimal unSalesWeight) {
		UnSalesWeight = unSalesWeight;
	}
	public final BigDecimal getProcessFee() {
		return ProcessFee;
	}
	public final void setProcessFee(BigDecimal processFee) {
		ProcessFee = processFee;
	}
	public final BigDecimal getProcessFee_S() {
		return ProcessFee_S;
	}
	public final void setProcessFee_S(BigDecimal processFee_S) {
		ProcessFee_S = processFee_S;
	}
	public final BigDecimal getPrice_G() {
		return Price_G;
	}
	public final void setPrice_G(BigDecimal price_G) {
		Price_G = price_G;
	}
	public final BigDecimal getSalesAmount() {
		return SalesAmount;
	}
	public final void setSalesAmount(BigDecimal salesAmount) {
		SalesAmount = salesAmount;
	}
	public final BigDecimal getFactAmount() {
		return FactAmount;
	}
	public final void setFactAmount(BigDecimal factAmount) {
		FactAmount = factAmount;
	}
	public final BigDecimal getPayAmount() {
		return PayAmount;
	}
	public final void setPayAmount(BigDecimal payAmount) {
		PayAmount = payAmount;
	}
	public final BigDecimal getPointAmount() {
		return PointAmount;
	}
	public final void setPointAmount(BigDecimal pointAmount) {
		PointAmount = pointAmount;
	}
	public final BigDecimal getOldAmount() {
		return OldAmount;
	}
	public final void setOldAmount(BigDecimal oldAmount) {
		OldAmount = oldAmount;
	}
	public final BigDecimal getReplaceAmount() {
		return ReplaceAmount;
	}
	public final void setReplaceAmount(BigDecimal replaceAmount) {
		ReplaceAmount = replaceAmount;
	}
	public final String getInvoceCode() {
		return InvoceCode;
	}
	public final void setInvoceCode(String invoceCode) {
		InvoceCode = invoceCode;
	}
	public final BigDecimal getInvoiceAmount() {
		return InvoiceAmount;
	}
	public final void setInvoiceAmount(BigDecimal invoiceAmount) {
		InvoiceAmount = invoiceAmount;
	}
	public final String getPromotionID() {
		return PromotionID;
	}
	public final void setPromotionID(String promotionID) {
		PromotionID = promotionID;
	}
	public final String getPromotionName() {
		return PromotionName;
	}
	public final void setPromotionName(String promotionName) {
		PromotionName = promotionName;
	}
}
