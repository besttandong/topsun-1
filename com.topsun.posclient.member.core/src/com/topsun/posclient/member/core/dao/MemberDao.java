package com.topsun.posclient.member.core.dao;

import java.io.File;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.datamodel.Member;
import com.topsun.posclient.datamodel.dto.MemberDTO;

/**
 * 会员管理数据访问
 * 
 * @author LiLei
 */
public class MemberDao extends BaseDao{
	
	/**
	 * 获取所有会员信息
	 * @return 会员信息DTO
	 * @throws Exception
	 */
	public MemberDTO getAllMember() throws Exception{
		File file = new File(ProjectUtil.getRuntimeClassPath()
				+ AppConstants.DATA_MEMBER_FILENAME);
		MemberDTO memberDTO = (MemberDTO) getLocalProcessor()
				.getObjectFromXml(getLocalProcessor().getDataFileContent(file),MemberDTO.class);
		return memberDTO;
	}
}
