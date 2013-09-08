package com.topsun.posclient.datamodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.OldGold;

/**
 * 旧金
 * 
 * @author Dong
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="data")
@XmlType(name = "OldGoldDTO", propOrder = {
    "oldGoldList"
},namespace="http://com.topsun.posclient/OldGoldDTO")
public class OldGoldDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<OldGold> oldGoldList;

	@XmlElements({
        @XmlElement(name = "oldGoldList", type = Item.class)
    })
	public final List<OldGold> getOldGoldList() {
		return oldGoldList;
	}

	public final void setOldGoldList(List<OldGold> oldGoldList) {
		this.oldGoldList = oldGoldList;
	}

}
