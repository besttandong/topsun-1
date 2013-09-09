package com.topsun.posclient.datamodel.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.topsun.posclient.datamodel.Retail;
import com.topsun.posclient.datamodel.Shop;

/**
 * 零售数据
 * @author LiLei
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="data")
@XmlType(name = "RetailDTO", propOrder = {
    "retailList"
},namespace="http://com.topsun.posclient/RetailDTO")
public class RetailDTO {
	
	private List<Retail> retailList;

	@XmlElements({
        @XmlElement(name = "retailList", type = Shop.class)
    })
	public final List<Retail> getRetailList() {
		return retailList;
	}

	public final void setRetailList(List<Retail> retailList) {
		this.retailList = retailList;
	}

}
