package com.topsun.posclient.datamodel;

import java.util.Date;

/**
 * 物料
 * 
 * @author LiLei
 *
 */
public class Material {
	
	private int id;
	private String mtart;//物料类型
	private String matnr;//物料号
	private String maktx;//物料描述
	private String meins;//基本计量单位
	private String matkl;//物料组
	private String prdha;//产品层次
	private String spart;//产品组
	private String extwg;//成本对象
	private String xchpf;//批次管理
	private String classe;//产成品特性类
	private String vkorg;//销售组织
	private String vtweg;//分销渠道
	private String taxkm;//税分类	确定税类别"0" 免税；"1" 17%	
	private String kondm;//物料定价组	即品牌（根据品牌进行加价）素金类为必填	
	private int delFlg;//删除标识（默认为0）		
	private int creater;//创建者		
	private Date createdTime;//创建时间		
	private int updater;//最后修改者		
	private Date lastUpdatedTime;//最后修改时间		
	private String revision;//版本戳		
	
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final String getMtart() {
		return mtart;
	}
	public final void setMtart(String mtart) {
		this.mtart = mtart;
	}
	public final String getMatnr() {
		return matnr;
	}
	public final void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public final String getMaktx() {
		return maktx;
	}
	public final void setMaktx(String maktx) {
		this.maktx = maktx;
	}
	public final String getMeins() {
		return meins;
	}
	public final void setMeins(String meins) {
		this.meins = meins;
	}
	public final String getMatkl() {
		return matkl;
	}
	public final void setMatkl(String matkl) {
		this.matkl = matkl;
	}
	public final String getPrdha() {
		return prdha;
	}
	public final void setPrdha(String prdha) {
		this.prdha = prdha;
	}
	public final String getSpart() {
		return spart;
	}
	public final void setSpart(String spart) {
		this.spart = spart;
	}
	public final String getExtwg() {
		return extwg;
	}
	public final void setExtwg(String extwg) {
		this.extwg = extwg;
	}
	public final String getXchpf() {
		return xchpf;
	}
	public final void setXchpf(String xchpf) {
		this.xchpf = xchpf;
	}
	public final String getClasse() {
		return classe;
	}
	public final void setClasse(String classe) {
		this.classe = classe;
	}
	public final String getVkorg() {
		return vkorg;
	}
	public final void setVkorg(String vkorg) {
		this.vkorg = vkorg;
	}
	public final String getVtweg() {
		return vtweg;
	}
	public final void setVtweg(String vtweg) {
		this.vtweg = vtweg;
	}
	public final String getTaxkm() {
		return taxkm;
	}
	public final void setTaxkm(String taxkm) {
		this.taxkm = taxkm;
	}
	public final String getKondm() {
		return kondm;
	}
	public final void setKondm(String kondm) {
		this.kondm = kondm;
	}
	public final int getDelFlg() {
		return delFlg;
	}
	public final void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}
	public final int getCreater() {
		return creater;
	}
	public final void setCreater(int creater) {
		this.creater = creater;
	}
	public final Date getCreatedTime() {
		return createdTime;
	}
	public final void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public final int getUpdater() {
		return updater;
	}
	public final void setUpdater(int updater) {
		this.updater = updater;
	}
	public final Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public final void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	public final String getRevision() {
		return revision;
	}
	public final void setRevision(String revision) {
		this.revision = revision;
	}
}
