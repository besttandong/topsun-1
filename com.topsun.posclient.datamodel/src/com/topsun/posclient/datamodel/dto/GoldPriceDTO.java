package com.topsun.posclient.datamodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.topsun.posclient.datamodel.GoldPrice;
import com.topsun.posclient.datamodel.Item;

/**
 * 实时金价
 * @author LiLei
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="data")
@XmlType(name = "GoldPriceDTO", propOrder = {
    "goldPriceList"
},namespace="http://com.topsun.posclient/GoldPriceDTO")
public class GoldPriceDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<GoldPrice> goldPriceList;

//	@XmlElements({
//        @XmlElement(name = "goldPriceList", type = GoldPrice.class)
//    })
    @XmlElementWrapper(name="goldPriceList")
    @XmlElement(name="GoldPrice")
	public final List<GoldPrice> getGoldPriceList() {
		return goldPriceList;
	}

	public final void setGoldPriceList(List<GoldPrice> goldPriceList) {
		this.goldPriceList = goldPriceList;
	}
}
