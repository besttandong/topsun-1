package com.topsun.posclient.sales.dao;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.datamodel.dto.OldGoldDTO;

/**
 * 旧金数据访问
 * @author Dong
 *
 */
public class OldGoldDao extends BaseDao {

	/**
	 * 保存旧金数据，在线则上传到服务端
	 * @param oldGoldDTO 旧金数据
	 * @throws Exception
	 */
	public void saveOldGoldData(OldGoldDTO oldGoldDTO) throws Exception {
		
		if(checkConnection()){
			this.getLocalProcessor().createXmlFileFromObject(oldGoldDTO, "data_oldGold", AppConstants.DATA_OLDGOLD_PATH_BACK);
			//TODO 调用webservice上传
		}else{
			this.getLocalProcessor().createXmlFileFromObject(oldGoldDTO, "data_oldGold", AppConstants.DATA_OLDGOLD_PATH);
		}
	}
}
