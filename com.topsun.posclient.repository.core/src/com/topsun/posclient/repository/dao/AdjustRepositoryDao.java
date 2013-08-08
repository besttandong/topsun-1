package com.topsun.posclient.repository.dao;

import java.util.ArrayList;
import java.util.List;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.datamodel.AdjustRepositoryInfo;
import com.topsun.posclient.datamodel.dto.AdjustRepositoryDTO;
import com.topsun.posclient.webservice.POSServerCaller;
import com.topsun.posclient.webservice.dto.ArrayOfbackWarehouse;
import com.topsun.posclient.webservice.dto.BackWarehouse;
import com.topsun.posclient.webservice.dto.QueryReturnRepository;
import com.topsun.posclient.webservice.dto.QueryReturnRepositoryReq;
import com.topsun.posclient.webservice.dto.QueryReturnRepositoryReqCondition;
import com.topsun.posclient.webservice.dto.QueryReturnRepositoryResponse;
import com.topsun.posclient.webservice.dto.QueryReturnRepositoryResult;
import com.topsun.posclient.webservice.dto.SaveReturnRepository;
import com.topsun.posclient.webservice.dto.SaveReturnRepositoryReq;
import com.topsun.posclient.webservice.dto.UserCredential;

/**
 * 回仓数据处理
 * 
 * @author Dong
 * 
 */
public class AdjustRepositoryDao extends BaseDao {

	/**
	 * 保存回仓信息
	 * @param adjustRepositoryDTO 回仓信息
	 * @throws Exception
	 */
	public void saveAdjustRepository(AdjustRepositoryInfo data) throws Exception {
		
		AdjustRepositoryDTO adjustRepositoryDTO = new AdjustRepositoryDTO();
		List<AdjustRepositoryInfo> list = new ArrayList<AdjustRepositoryInfo>();
		list.add(data);
		
		if (checkConnection()) {
			//保存本地备份数据
			this.getLocalProcessor().createXmlFileFromObject(adjustRepositoryDTO, "data_adjustRepository", AppConstants.DATA_ADJUSTREPOSITORY_PATH_BACK);

			BackWarehouse[] bws = new BackWarehouse[1];
			
			BackWarehouse bw = new BackWarehouse();
			bw.setBackWHID(data.getReceiveRepositoryId());
			bw.setConsignorID(data.getDeliver());
			bw.setDocNum(data.getOrderNo());
			bw.setDocNumPos("POS01");
			bw.setDocState("1");
			bw.setMakerID(data.getApplyUser());
			bw.setMemo(data.getRemark());
			bw.setShopID(data.getBackShopId());
			bw.setWarehouseID(data.getChecker());
			bws[0] = bw;
				
			UserCredential userCredential = POSServerCaller.getDefaultUserCredential();
			ArrayOfbackWarehouse aow = new ArrayOfbackWarehouse();
			aow.setBackWarehouse(bws);
			SaveReturnRepositoryReq req = new SaveReturnRepositoryReq();
			req.setUserCredential(userCredential);
			req.setBackWarehouses(aow);
			SaveReturnRepository saveReturnRepository = new SaveReturnRepository();
			saveReturnRepository.setSaveReturnRepositoryReq(req);
			POSServerCaller.getWebService().saveReturnRepository(saveReturnRepository);
			System.out.println("--------->>> Call webservice saveReturnRepository finished!");
			
		}else{
			this.getLocalProcessor().createXmlFileFromObject(adjustRepositoryDTO, "data_adjustRepository", AppConstants.DATA_ADJUSTREPOSITORY_PATH);
		}
	}
	
	/**
	 * 查询回仓信息
	 * @param adjustRepositoryInfo 回仓信息
	 * @return
	 * @throws Exception
	 */
	public List<AdjustRepositoryInfo> queryAdjustRepository(AdjustRepositoryInfo adjustRepositoryInfo) throws Exception {
		List<AdjustRepositoryInfo> resultList = null;
		try{
			//设置查询条件
			QueryReturnRepositoryReqCondition condition = new QueryReturnRepositoryReqCondition();
			
			QueryReturnRepositoryReq req = new QueryReturnRepositoryReq();
			req.setUserCredential(POSServerCaller.getDefaultUserCredential());
			req.setCondition(condition);
			
			QueryReturnRepository queryReturnRepository = new QueryReturnRepository();
			queryReturnRepository.setQueryReturnRepositoryReq(req);
			QueryReturnRepositoryResponse response = POSServerCaller.getWebService().queryReturnRepository(queryReturnRepository);
			System.out.println("--------->>> Call webservice queryReturnRepository finished!");
			// 处理查询结果
			QueryReturnRepositoryResult result = response.getQueryReturnRepositoryResult();
			if(result.getResult().getFlag().equals("0")){
				ArrayOfbackWarehouse aow = result.getBackWarehouses();
				BackWarehouse[] bws = aow.getBackWarehouse();
				
				resultList = new ArrayList<AdjustRepositoryInfo>();
				for(int i=0; i<bws.length; i++){
					BackWarehouse bw = bws[i];
					AdjustRepositoryInfo ari = new AdjustRepositoryInfo();
					ari.setApplyUser(bw.getMakerID());
					ari.setBackReason(String.valueOf(bw.getBackWHID()));
					ari.setBackShopId(bw.getShopID());
					ari.setRemark(bw.getMemo());
					ari.setReceiveRepositoryId(bw.getWarehouseID());
					ari.setOrderNo(bw.getDocNum());
					ari.setDeliver(bw.getConsignorID());
					resultList.add(ari);
				}
			}else{
				throw new Exception(result.getResult().getMsg());
			}
			return resultList;
		}catch(Exception e){
			throw new Exception("查询失败！");
		}
	}
}
