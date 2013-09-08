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
import com.topsun.posclient.datamodel.Member;

/**
 * 
 * @author LiLei
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name="data")
@XmlType(name = "MemberDTO", propOrder = {
    "goldPriceList"
},namespace="http://com.topsun.posclient/MemberDTO")
public class MemberDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Member> memberList;

	@XmlElements({
        @XmlElement(name = "memberList", type = Item.class)
    })
	public final List<Member> getMemberList() {
		return memberList;
	}

	public final void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

}
