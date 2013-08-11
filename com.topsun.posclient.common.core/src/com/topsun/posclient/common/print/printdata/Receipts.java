package com.topsun.posclient.common.print.printdata;

import java.util.Date;
import java.util.List;

import com.topsun.posclient.datamodel.Item;

/**
 * 小票打印对象
 * @author Dong
 *
 */
public class Receipts {
	
	private String title;
	
	private String telephone;
	
	private String address;
	
	private String date;
	
	private String machineNo;
	
	private String cashier;
	
	private String titleBr;//标题换行符
	
	private List<Item> items;
	
	private String bootBr;
	
	private String bootString;
	
	private String netAddress;

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final String getTelephone() {
		return telephone;
	}

	public final void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public final String getMachineNo() {
		return machineNo;
	}

	public final void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public final String getCashier() {
		return cashier;
	}

	public final void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public final String getTitleBr() {
		return titleBr;
	}

	public final void setTitleBr(String titleBr) {
		this.titleBr = titleBr;
	}

	public final List<Item> getItems() {
		return items;
	}

	public final void setItems(List<Item> items) {
		this.items = items;
	}

	public final String getBootBr() {
		return bootBr;
	}

	public final void setBootBr(String bootBr) {
		this.bootBr = bootBr;
	}

	public final String getBootString() {
		return bootString;
	}

	public final void setBootString(String bootString) {
		this.bootString = bootString;
	}

	public final String getNetAddress() {
		return netAddress;
	}

	public final void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}
}
