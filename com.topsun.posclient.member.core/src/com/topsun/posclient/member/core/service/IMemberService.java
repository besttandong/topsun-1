package com.topsun.posclient.member.core.service;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.datamodel.Member;

/**
 * @author Dong
 *
 */
public interface IMemberService extends IBaseService {

	/**
	 * 获取会员基本信息
	 * @param cardNo
	 * @return
	 * @throws POSException
	 */
	public Member getMember(String cardNo) throws POSException;
}
