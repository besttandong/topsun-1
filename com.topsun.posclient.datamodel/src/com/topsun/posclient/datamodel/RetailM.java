package com.topsun.posclient.datamodel;

import java.math.BigDecimal;
import java.util.Date;

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
	private BigDecimal PalAccount; //损益结算金额
	private String SourceCode; //原单品编码
	private String ItemType; //单品状态
	private String AccountType; //核算方式
	private BigDecimal Weight; //原克重
	private BigDecimal SalesWeight; //销售克重
	private BigDecimal UnSalesWeight; //截断克重
	private BigDecimal ProcessFee; //工费
	private BigDecimal ProcessFee_S; //结算工费
	private BigDecimal Price_G; //零售金价
	private BigDecimal SettlementPrice_G; //结算金价
	private BigDecimal SalesAmount; //应售价
	private BigDecimal FactAmount; //实售价
	private BigDecimal PayAmount; //实付款
	private BigDecimal PointAmount; //积分抵扣款
	private BigDecimal OldAmount; //旧金抵扣金额
	private BigDecimal ReplaceAmount; //换货抵扣金额
	private BigDecimal SettlementRate_Multi; //结算扣率（乘）
	private BigDecimal SettlementRate_Division; //结算扣率（除）
	private BigDecimal SettlementPrice; //结算价
	private String InvoceCode; //发票号码
	private BigDecimal InvoiceAmount; //开票金额
	private String PromotionID; //促销方案ID
	private String PromotionName; //促销方案Title
	private BigDecimal Rate_SP; //商超结算扣率
	private BigDecimal Account_SP; //商超结算价
	private int Suppliser_N; //外部供应商
	private int Suppliser_W; //内部供应商
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
	public final BigDecimal getPalAccount() {
		return PalAccount;
	}
	public final void setPalAccount(BigDecimal palAccount) {
		PalAccount = palAccount;
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
	public final BigDecimal getSettlementPrice_G() {
		return SettlementPrice_G;
	}
	public final void setSettlementPrice_G(BigDecimal settlementPrice_G) {
		SettlementPrice_G = settlementPrice_G;
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
	public final BigDecimal getSettlementRate_Multi() {
		return SettlementRate_Multi;
	}
	public final void setSettlementRate_Multi(BigDecimal settlementRate_Multi) {
		SettlementRate_Multi = settlementRate_Multi;
	}
	public final BigDecimal getSettlementRate_Division() {
		return SettlementRate_Division;
	}
	public final void setSettlementRate_Division(BigDecimal settlementRate_Division) {
		SettlementRate_Division = settlementRate_Division;
	}
	public final BigDecimal getSettlementPrice() {
		return SettlementPrice;
	}
	public final void setSettlementPrice(BigDecimal settlementPrice) {
		SettlementPrice = settlementPrice;
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
	public final BigDecimal getRate_SP() {
		return Rate_SP;
	}
	public final void setRate_SP(BigDecimal rate_SP) {
		Rate_SP = rate_SP;
	}
	public final BigDecimal getAccount_SP() {
		return Account_SP;
	}
	public final void setAccount_SP(BigDecimal account_SP) {
		Account_SP = account_SP;
	}
	public final int getSuppliser_N() {
		return Suppliser_N;
	}
	public final void setSuppliser_N(int suppliser_N) {
		Suppliser_N = suppliser_N;
	}
	public final int getSuppliser_W() {
		return Suppliser_W;
	}
	public final void setSuppliser_W(int suppliser_W) {
		Suppliser_W = suppliser_W;
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
