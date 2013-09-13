package com.topsun.posclient.repository.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.datamodel.AdjustShopInfo;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.dto.AdjustShopDTO;
import com.topsun.posclient.webservice.POSServerCaller;
import com.topsun.posclient.webservice.dto.ArrayOfitem;
import com.topsun.posclient.webservice.dto.ArrayOfshopAllot;
import com.topsun.posclient.webservice.dto.QueryShopAllot;
import com.topsun.posclient.webservice.dto.QueryShopAllotReq;
import com.topsun.posclient.webservice.dto.QueryShopAllotReqCondition;
import com.topsun.posclient.webservice.dto.QueryShopAllotResponse;
import com.topsun.posclient.webservice.dto.QueryShopAllotResult;
import com.topsun.posclient.webservice.dto.SaveShopAllot;
import com.topsun.posclient.webservice.dto.SaveShopAllotReq;
import com.topsun.posclient.webservice.dto.ShopAllot;

/**
 * 调店信息数据处理
 * 
 * @author Dong
 * 
 */
public class AdjustShopDao extends BaseDao {

	/**
	 * 保存调店信息
	 * 
	 * @param adjustStoreDTO 调店信息
	 * @throws Exception
	 */
	public void saveAdjustShop(AdjustShopDTO adjustStoreDTO) throws Exception {
		if (checkConnection()) {
			// 保存本地备份数据
			this.getLocalProcessor().createXmlFileFromObject(adjustStoreDTO,
					"data_adjustShop", AppConstants.DATA_ADJUSTSHOP_PATH_BACK);

			List<AdjustShopInfo> list = adjustStoreDTO.getAdjustShopList();

			ShopAllot[] shopAllots = new ShopAllot[list.size()];
			AdjustShopInfo info = list.get(0);
			ShopAllot sa = new ShopAllot();
			sa.setAllotDate(ProjectUtil.getCalendar(info.getCallDate()));
			sa.setAllotTypeId(info.getCallType());
			sa.setDocNum(info.getVoucherNo());
			sa.setDocNumPOS("POS09");
			sa.setInShpId(info.getIntoShop());
			sa.setOutShpId(info.getOutShop());
			sa.setMemo(info.getRemark());
			sa.setMakerID(info.getApplyUser());
			sa.setItems(POSServerCaller.getItemArray(info.getItemList()));
			
			shopAllots[0] = sa;
			
			ArrayOfshopAllot aoa = new ArrayOfshopAllot();
			aoa.setShopAllot(shopAllots);

			SaveShopAllotReq req = new SaveShopAllotReq();
			req.setUserCredential(POSServerCaller.getDefaultUserCredential());
			req.setShopAllots(aoa);

			SaveShopAllot saveShopAllot = new SaveShopAllot();
			saveShopAllot.setSaveShopAllotReq(req);
			POSServerCaller.getWebService().saveShopAllot(saveShopAllot);

			System.out
					.println("--------->>> Call webservice saveShopAllot finished!");

		} else {
			this.getLocalProcessor().createXmlFileFromObject(adjustStoreDTO,
					"data_adjustShop", AppConstants.DATA_ADJUSTSHOP_PATH);
		}
	}

	/**
	 * 查询调店信息
	 * 
	 * @return 调店信息集合
	 * @throws Exception
	 */
	public List<AdjustShopInfo> queryAdjustShopInfo(
			HashMap<String, Object> queryParams) throws Exception {
		// 设置查询条件
		QueryShopAllotReqCondition condition = new QueryShopAllotReqCondition();
		// condition.setInShpId(0);
		// condition.setMakerID(0);
		// condition.setOutShpId(0);
		// condition.setDocNum(null);
		// condition.setAllotTypeId(0);
		// condition.setAllotDateStart(null);
		// condition.setAllotDateFinish(null);

		// 设置查询请求报文
		QueryShopAllot queryShopAllot = new QueryShopAllot();

		QueryShopAllotReq req = new QueryShopAllotReq();
		req.setUserCredential(POSServerCaller.getDefaultUserCredential());
		req.setCondition(condition);

		queryShopAllot.setQueryShopAllotReq(req);

		// 处理返回值
		QueryShopAllotResponse response = POSServerCaller.getWebService()
				.queryShopAllot(queryShopAllot);
		QueryShopAllotResult result = response.getQueryShopAllotResult();

		List<AdjustShopInfo> resultList = new ArrayList<AdjustShopInfo>();

		if (result.getResult().getFlag().equals("0")) {
			ArrayOfshopAllot arrayOfshopAllot = result.getShopAllots();
			ShopAllot[] shopAllotArray = arrayOfshopAllot.getShopAllot();
			for (int i = 0; i < shopAllotArray.length; i++) {
				ShopAllot shopAllot = shopAllotArray[i];
				AdjustShopInfo adjustShop = new AdjustShopInfo();
				adjustShop.setVoucherNo(shopAllot.getDocNum());
				adjustShop.setApplyUser(shopAllot.getMakerID());
				adjustShop.setCallDate(shopAllot.getAllotDate().getTime());
				adjustShop.setCallType(shopAllot.getAllotTypeId());
				adjustShop.setIntoShop(shopAllot.getInShpId());
				adjustShop.setRemark(shopAllot.getMemo());
				adjustShop.setOutShop(shopAllot.getOutShpId());
				adjustShop.setItemList(getItemList(shopAllot.getItems()));
				adjustShop.setCheckDate(new Date());
				adjustShop.setChecker(shopAllot.getMakerID());
				adjustShop.setReCheckDate(new Date());
				adjustShop.setReChecker(shopAllot.getMakerID());
				adjustShop.setItemNum(shopAllotArray.length);
				resultList.add(adjustShop);
			}
		} else {
			throw new Exception(result.getResult().getMsg());
		}
		return resultList;
	}
	
//	private static ArrayOfitem getItemArray(List<Item> itemList){
//		ArrayOfitem arrayOfitem = new ArrayOfitem();
//		com.topsun.posclient.webservice.dto.Item[] itemArray = new com.topsun.posclient.webservice.dto.Item[itemList.size()];;
//		for(int i=0; i<itemList.size(); i++){
//			Item ee = itemList.get(i);
//			com.topsun.posclient.webservice.dto.Item iii = new com.topsun.posclient.webservice.dto.Item();
//			iii.setItemId(ee.getId());
//			iii.setLineNum(Integer.valueOf(ee.getItemCode()));
//			iii.setMemo(ee.getDescription());
//			iii.setQuantity(ee.getNum());
//			itemArray[i] = iii;
//		}
//		arrayOfitem.setItem(itemArray);
//		return arrayOfitem;
//	}

	private static List<Item> getItemList(ArrayOfitem itemArray) {
		List<Item> items = new ArrayList<Item>();
		com.topsun.posclient.webservice.dto.Item[] iArray = itemArray.getItem();
		if (null == iArray) {
			return null;
		}
		for (int i = 0; i < iArray.length; i++) {
			com.topsun.posclient.webservice.dto.Item im = iArray[i];
			Item iii = new Item();
			iii.setId(im.getItemId());
			iii.setItemCode(String.valueOf(im.getLineNum()));
			items.add(iii);
		}
		return items;
	}

}
