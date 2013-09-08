package com.topsun.posclient.promotion.core.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.datamodel.Promotion;

/**
 * 
 * 促销方案
 * 
 * @author LiLei
 *
 */
public class PromotionDao extends BaseDao {
	
	/**
	 * 本地查询促销方案
	 * 
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public List<Promotion> queryPromote(Map<String, Object> params) throws Exception{
		File file = new File(ProjectUtil.getRuntimeClassPath()+AppConstants.DATA_PROMOTE_FILENAME);
		List<Promotion> promoteList = new ArrayList<Promotion>();
		String data = getLocalProcessor().getDataFileContent(file);
		Promotion promote = (Promotion)getLocalProcessor().getObjectFromXml(data, Promotion.class);
		promoteList.add(promote);
		return promoteList;
	}
}
