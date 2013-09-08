package com.topsun.posclient.datamodel;

import java.math.BigDecimal;

/**
 * 促销方案
 * 
 * @author LiLei
 *
 */
public class Promotion {
	
	private String id; //标识
	
	private int num;//第N件
	private double points;//打M折
	
	private BigDecimal pointPrices; // 满N元
	private BigDecimal salesPrices;// 减M元
	
	public final BigDecimal getSalesPrices() {
		return salesPrices;
	}

	public final void setSalesPrices(BigDecimal salesPrices) {
		this.salesPrices = salesPrices;
	}

	public final BigDecimal getPointPrices() {
		return pointPrices;
	}

	public final void setPointPrices(BigDecimal pointPrices) {
		this.pointPrices = pointPrices;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final int getNum() {
		return num;
	}

	public final void setNum(int num) {
		this.num = num;
	}

	public final double getPoints() {
		return points;
	}

	public final void setPoints(double points) {
		this.points = points;
	}
	
}
