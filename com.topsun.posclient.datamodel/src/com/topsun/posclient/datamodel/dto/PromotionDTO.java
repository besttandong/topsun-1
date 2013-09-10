package com.topsun.posclient.datamodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.topsun.posclient.datamodel.Promotion;

/**
 * @author LiLei
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="data")
@XmlType(name = "PromotionDTO", propOrder = {
    "promotionList"
},namespace="http://com.topsun.posclient/PromotionDTO")
public class PromotionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Promotion> promotionList;

	@XmlElementWrapper(name="promotionList")
    @XmlElement(name="Promotion")
	public final List<Promotion> getPromotionList() {
		return promotionList;
	}

	public final void setPromotionList(List<Promotion> promotionList) {
		this.promotionList = promotionList;
	}
}
