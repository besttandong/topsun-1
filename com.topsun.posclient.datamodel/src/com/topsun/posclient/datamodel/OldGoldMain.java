package com.topsun.posclient.datamodel;

import java.util.Date;

/**
 * 旧金鉴定单
 * @author LiLei
 *
 */
public class OldGoldMain {

	private int ID; //ID编号
	private String DocNum; //鉴定单编号
	private int EmployeeID; //鉴定人员ID
	private String EmployeeName; //鉴定人员名称
	private String Status; //类型[已贴换/未贴换]
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
	public final String getDocNum() {
		return DocNum;
	}
	public final void setDocNum(String docNum) {
		DocNum = docNum;
	}
	public final int getEmployeeID() {
		return EmployeeID;
	}
	public final void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public final String getEmployeeName() {
		return EmployeeName;
	}
	public final void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public final String getStatus() {
		return Status;
	}
	public final void setStatus(String status) {
		Status = status;
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
