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
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;//ID编号	Primary Key
	
	private String itemCode;//货号
	
	private String itemName;//商品名称	
	
	private int classId;//大类ID编号
	
	private String className;//大类名称
	
	private int divisionId;//中类ID编号
	
	private String divisionName;//中类名称
	
	private int sectionId;//小类ID编号
	
	private String sectionName;//小类名称
	
	private int unitId;//单位ID编号
	
	private String unitName;//单位名称
	
	private int stdId;//规格型号ID编号	
	
	private int supplierId;//供应商ID编号
	
	private String supplierName; //供应商名称
	
	private int BrandId;//品牌ID编号	
	
	private String BrandName;//品牌名称
	
	private int area;//产地
	
	private String areaName;//产地名称
	
	private String description;//商品描述
	
	private double wholesalePrice;//批发价
	
	private double retailPrice;//零售价
	
	private double purchasePrice;//采购价
	
	private double channelPrice;//渠道价
	
	private double guidePrice;//指导价
	
	private int num; //数量
	
	
	
	/*****************新属性**********************/
	private Date ERSDA;//创建日期
	private String MATNR;//物料号 
	private String BUKRS;//公司代码
	private String CHARG;//批号
	private String ZTXM;//条形码 
	private String ZDPMC;//单品名称
	private String ZDPSX;//单品属性 
	private BigDecimal ZDPZL;//单品重量
	private String ZSJCS;//素金成色
	private String ZCSBJ;//厂商标记
	private int ZoneID;//所属柜位
	private String ZSSMD;//所属门店 
	private String ZSSGS;//所属公司 
	private BigDecimal ZLS;//粒数
	private String ZYS;//颜色
	private String ZJD;//净度 
	private String ZSD;//色度
	private String ZNBCJ;//内部厂家(供应商）
	private String ZQG;//切工
	private String ZPG;//抛光
	private String ZXZ;//形状
	private String ZDC;//对称
	private String ZYG;//荧光
	private String ZGG;//规格
	private BigDecimal ZZJ;//直径
	private String ZBS;//宝石
	private String ZJYFS;//经营方式
	private String ZSFLS;//是否历史
	private BigDecimal ZYLZZ;//原料总重
	private BigDecimal ZZZZZ;//主钻总重
	private BigDecimal ZZZZSL;//主钻总数量 
	private BigDecimal ZFZZSL;//辅钻总数量 
	private BigDecimal ZFZZZL;//副钻总重量 
	private String ZPJ;//配件
	private String ZPJZ;//配件重 
	private BigDecimal ZJQ;//配件金额
	private BigDecimal ZJS;//件数
	private BigDecimal ZPD;//票点
	private String ZSC;//手寸
	private String ZNBBH;//内部版号
	private String ZJSHJFS;//结算核价方式
	private BigDecimal ZMDLSBQJ;//门店零售标签价 
	private BigDecimal ZMDDXJSJ;//门店代销结算价 
	private String ZGIA;//GIA标记
	private String ERNAM;//创建对象的人员名称 
	private String ZSFTJ;//是否特价
	private BigDecimal ZJGF;//加工费 
	private BigDecimal ZBJJGF;//钯金加工费 
	private BigDecimal ZKJGFLS;//克加工费（零售）
	private BigDecimal ZJJGFLS;//件加工费（零售）
	private BigDecimal ZFUJIANFEI;//附件费 
	private String ZFJMC;//附件名称
	private BigDecimal ZFJJZ;//附件金重
	private BigDecimal ZKJFY;//扣减费用
	private String ZYTM;//原条码 
	private BigDecimal DISCOUNT1;//下游倒扣扣率(乘)
	private BigDecimal DISCOUNT2;//下游倒扣扣率(除)
	private int DelFlg;//删除标识（默认为0）
	private int Creater;//创建者
	private Date CreatedTime;//创建时间
	private int Updater;//最后修改者
	private Date LastUpdatedTime;//最后修改时间
	private String Revision;//版本戳
	
	public final Date getERSDA() {
		return ERSDA;
	}

	public final void setERSDA(Date eRSDA) {
		ERSDA = eRSDA;
	}

	public final String getMATNR() {
		return MATNR;
	}

	public final void setMATNR(String mATNR) {
		MATNR = mATNR;
	}

	public final String getBUKRS() {
		return BUKRS;
	}

	public final void setBUKRS(String bUKRS) {
		BUKRS = bUKRS;
	}

	public final String getCHARG() {
		return CHARG;
	}

	public final void setCHARG(String cHARG) {
		CHARG = cHARG;
	}

	public final String getZTXM() {
		return ZTXM;
	}

	public final void setZTXM(String zTXM) {
		ZTXM = zTXM;
	}

	public final String getZDPMC() {
		return ZDPMC;
	}

	public final void setZDPMC(String zDPMC) {
		ZDPMC = zDPMC;
	}

	public final String getZDPSX() {
		return ZDPSX;
	}

	public final void setZDPSX(String zDPSX) {
		ZDPSX = zDPSX;
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

	public final BigDecimal getZLS() {
		return ZLS;
	}

	public final void setZLS(BigDecimal zLS) {
		ZLS = zLS;
	}

	public final String getZYS() {
		return ZYS;
	}

	public final void setZYS(String zYS) {
		ZYS = zYS;
	}

	public final String getZJD() {
		return ZJD;
	}

	public final void setZJD(String zJD) {
		ZJD = zJD;
	}

	public final String getZSD() {
		return ZSD;
	}

	public final void setZSD(String zSD) {
		ZSD = zSD;
	}

	public final String getZNBCJ() {
		return ZNBCJ;
	}

	public final void setZNBCJ(String zNBCJ) {
		ZNBCJ = zNBCJ;
	}

	public final String getZQG() {
		return ZQG;
	}

	public final void setZQG(String zQG) {
		ZQG = zQG;
	}

	public final String getZPG() {
		return ZPG;
	}

	public final void setZPG(String zPG) {
		ZPG = zPG;
	}

	public final String getZXZ() {
		return ZXZ;
	}

	public final void setZXZ(String zXZ) {
		ZXZ = zXZ;
	}

	public final String getZDC() {
		return ZDC;
	}

	public final void setZDC(String zDC) {
		ZDC = zDC;
	}

	public final String getZYG() {
		return ZYG;
	}

	public final void setZYG(String zYG) {
		ZYG = zYG;
	}

	public final String getZGG() {
		return ZGG;
	}

	public final void setZGG(String zGG) {
		ZGG = zGG;
	}

	public final BigDecimal getZZJ() {
		return ZZJ;
	}

	public final void setZZJ(BigDecimal zZJ) {
		ZZJ = zZJ;
	}

	public final String getZBS() {
		return ZBS;
	}

	public final void setZBS(String zBS) {
		ZBS = zBS;
	}

	public final String getZJYFS() {
		return ZJYFS;
	}

	public final void setZJYFS(String zJYFS) {
		ZJYFS = zJYFS;
	}

	public final String getZSFLS() {
		return ZSFLS;
	}

	public final void setZSFLS(String zSFLS) {
		ZSFLS = zSFLS;
	}

	public final BigDecimal getZYLZZ() {
		return ZYLZZ;
	}

	public final void setZYLZZ(BigDecimal zYLZZ) {
		ZYLZZ = zYLZZ;
	}

	public final BigDecimal getZZZZZ() {
		return ZZZZZ;
	}

	public final void setZZZZZ(BigDecimal zZZZZ) {
		ZZZZZ = zZZZZ;
	}

	public final BigDecimal getZZZZSL() {
		return ZZZZSL;
	}

	public final void setZZZZSL(BigDecimal zZZZSL) {
		ZZZZSL = zZZZSL;
	}

	public final BigDecimal getZFZZSL() {
		return ZFZZSL;
	}

	public final void setZFZZSL(BigDecimal zFZZSL) {
		ZFZZSL = zFZZSL;
	}

	public final BigDecimal getZFZZZL() {
		return ZFZZZL;
	}

	public final void setZFZZZL(BigDecimal zFZZZL) {
		ZFZZZL = zFZZZL;
	}

	public final String getZPJ() {
		return ZPJ;
	}

	public final void setZPJ(String zPJ) {
		ZPJ = zPJ;
	}

	public final String getZPJZ() {
		return ZPJZ;
	}

	public final void setZPJZ(String zPJZ) {
		ZPJZ = zPJZ;
	}

	public final BigDecimal getZJQ() {
		return ZJQ;
	}

	public final void setZJQ(BigDecimal zJQ) {
		ZJQ = zJQ;
	}

	public final BigDecimal getZJS() {
		return ZJS;
	}

	public final void setZJS(BigDecimal zJS) {
		ZJS = zJS;
	}

	public final BigDecimal getZPD() {
		return ZPD;
	}

	public final void setZPD(BigDecimal zPD) {
		ZPD = zPD;
	}

	public final String getZSC() {
		return ZSC;
	}

	public final void setZSC(String zSC) {
		ZSC = zSC;
	}

	public final String getZNBBH() {
		return ZNBBH;
	}

	public final void setZNBBH(String zNBBH) {
		ZNBBH = zNBBH;
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

	public final String getZGIA() {
		return ZGIA;
	}

	public final void setZGIA(String zGIA) {
		ZGIA = zGIA;
	}

	public final String getERNAM() {
		return ERNAM;
	}

	public final void setERNAM(String eRNAM) {
		ERNAM = eRNAM;
	}

	public final String getZSFTJ() {
		return ZSFTJ;
	}

	public final void setZSFTJ(String zSFTJ) {
		ZSFTJ = zSFTJ;
	}

	public final BigDecimal getZJGF() {
		return ZJGF;
	}

	public final void setZJGF(BigDecimal zJGF) {
		ZJGF = zJGF;
	}

	public final BigDecimal getZBJJGF() {
		return ZBJJGF;
	}

	public final void setZBJJGF(BigDecimal zBJJGF) {
		ZBJJGF = zBJJGF;
	}

	public final BigDecimal getZKJGFLS() {
		return ZKJGFLS;
	}

	public final void setZKJGFLS(BigDecimal zKJGFLS) {
		ZKJGFLS = zKJGFLS;
	}

	public final BigDecimal getZJJGFLS() {
		return ZJJGFLS;
	}

	public final void setZJJGFLS(BigDecimal zJJGFLS) {
		ZJJGFLS = zJJGFLS;
	}

	public final BigDecimal getZFUJIANFEI() {
		return ZFUJIANFEI;
	}

	public final void setZFUJIANFEI(BigDecimal zFUJIANFEI) {
		ZFUJIANFEI = zFUJIANFEI;
	}

	public final String getZFJMC() {
		return ZFJMC;
	}

	public final void setZFJMC(String zFJMC) {
		ZFJMC = zFJMC;
	}

	public final BigDecimal getZFJJZ() {
		return ZFJJZ;
	}

	public final void setZFJJZ(BigDecimal zFJJZ) {
		ZFJJZ = zFJJZ;
	}

	public final BigDecimal getZKJFY() {
		return ZKJFY;
	}

	public final void setZKJFY(BigDecimal zKJFY) {
		ZKJFY = zKJFY;
	}

	public final String getZYTM() {
		return ZYTM;
	}

	public final void setZYTM(String zYTM) {
		ZYTM = zYTM;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getBrandId() {
		return BrandId;
	}

	public void setBrandId(int brandId) {
		BrandId = brandId;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getChannelPrice() {
		return channelPrice;
	}

	public void setChannelPrice(double channelPrice) {
		this.channelPrice = channelPrice;
	}

	public double getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(double guidePrice) {
		this.guidePrice = guidePrice;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}