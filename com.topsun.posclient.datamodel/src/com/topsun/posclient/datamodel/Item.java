package com.topsun.posclient.datamodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * 
 * @author Dong
 *
 */
public class Item {

	private int id;//ID编号	Primary Key
	private String itemCode;//货号
	private String itemName;//商品名称	
	private String MATNR;//物料号 
	private BigDecimal ZDPZL;//单品重量
	private String ZSJCS;//素金成色
	private int ZoneID;//所属柜位
	private String ZSSMD;//所属门店 
	private String ZSSGS;//所属公司 
	private BigDecimal ZZZZZ;//主钻总重
	private BigDecimal ZFZZZL;//副钻总重量 
	private BigDecimal ZJGF;//加工费 
	private String ZYTM;//原条码 
	private String ZJSHJFS;//结算核价方式
	private BigDecimal ZMDLSBQJ;//门店零售标签价 
	private BigDecimal ZMDDXJSJ;//门店代销结算价 
	private BigDecimal DISCOUNT1;//下游倒扣扣率(乘)
	private BigDecimal DISCOUNT2;//下游倒扣扣率(除)
	private String ZCSBJ; //印记
	private String Matkl; //物料组编号

	public final String getMATNR() {
		return MATNR;
	}

	public final void setMATNR(String mATNR) {
		MATNR = mATNR;
	}

	public final BigDecimal getZDPZL() {
		return ZDPZL;
	}

	public final void setZDPZL(BigDecimal zDPZL) {
		ZDPZL = zDPZL;
	}

	public final String getZSJCS() {
		return ZSJCS;
	}

	public final void setZSJCS(String zSJCS) {
		ZSJCS = zSJCS;
	}

	public final String getZCSBJ() {
		return ZCSBJ;
	}

	public final void setZCSBJ(String zCSBJ) {
		ZCSBJ = zCSBJ;
	}

	public final int getZoneID() {
		return ZoneID;
	}

	public final void setZoneID(int zoneID) {
		ZoneID = zoneID;
	}

	public final String getZSSMD() {
		return ZSSMD;
	}

	public final void setZSSMD(String zSSMD) {
		ZSSMD = zSSMD;
	}

	public final String getZSSGS() {
		return ZSSGS;
	}

	public final void setZSSGS(String zSSGS) {
		ZSSGS = zSSGS;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getItemCode() {
		return itemCode;
	}

	public final void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public final String getItemName() {
		return itemName;
	}

	public final void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public final BigDecimal getZZZZZ() {
		return ZZZZZ;
	}

	public final void setZZZZZ(BigDecimal zZZZZ) {
		ZZZZZ = zZZZZ;
	}

	public final BigDecimal getZFZZZL() {
		return ZFZZZL;
	}

	public final void setZFZZZL(BigDecimal zFZZZL) {
		ZFZZZL = zFZZZL;
	}

	public final BigDecimal getZJGF() {
		return ZJGF;
	}

	public final void setZJGF(BigDecimal zJGF) {
		ZJGF = zJGF;
	}

	public final String getZYTM() {
		return ZYTM;
	}

	public final void setZYTM(String zYTM) {
		ZYTM = zYTM;
	}

	public final String getZJSHJFS() {
		return ZJSHJFS;
	}

	public final void setZJSHJFS(String zJSHJFS) {
		ZJSHJFS = zJSHJFS;
	}

	public final BigDecimal getZMDLSBQJ() {
		return ZMDLSBQJ;
	}

	public final void setZMDLSBQJ(BigDecimal zMDLSBQJ) {
		ZMDLSBQJ = zMDLSBQJ;
	}

	public final BigDecimal getZMDDXJSJ() {
		return ZMDDXJSJ;
	}

	public final void setZMDDXJSJ(BigDecimal zMDDXJSJ) {
		ZMDDXJSJ = zMDDXJSJ;
	}

	public final BigDecimal getDISCOUNT1() {
		return DISCOUNT1;
	}

	public final void setDISCOUNT1(BigDecimal dISCOUNT1) {
		DISCOUNT1 = dISCOUNT1;
	}

	public final BigDecimal getDISCOUNT2() {
		return DISCOUNT2;
	}

	public final void setDISCOUNT2(BigDecimal dISCOUNT2) {
		DISCOUNT2 = dISCOUNT2;
	}

	public final String getMatkl() {
		return Matkl;
	}

	public final void setMatkl(String matkl) {
		Matkl = matkl;
	}
}