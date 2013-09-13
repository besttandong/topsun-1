package com.topsun.posclient.webservice;

import java.math.BigDecimal;
import java.util.List;

import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.PartSalesCashier;
import com.topsun.posclient.webservice.dto.ArrayOfRetail_M;
import com.topsun.posclient.webservice.dto.ArrayOfRetail_P;
import com.topsun.posclient.webservice.dto.ArrayOfbackWarehouseItem;
import com.topsun.posclient.webservice.dto.ArrayOfitem;
import com.topsun.posclient.webservice.dto.Retail_M;
import com.topsun.posclient.webservice.dto.Retail_P;
import com.topsun.posclient.webservice.dto.UserCredential;


/**
 * 
 * @author LiLei
 *
 */
public class POSServerCaller {
	
	public static Services getWebService() throws Exception {
		ServicesStub service = new ServicesStub();
		return service;
	}
	
	public static UserCredential getDefaultUserCredential(){
		UserCredential userCredential = new UserCredential();
		userCredential.setUserName("admin");
		userCredential.setPassWord("000000");
		return userCredential;
	}
	
	public static ArrayOfitem getItemArray(List<Item> itemList){
		ArrayOfitem arrayOfitem = new ArrayOfitem();
		com.topsun.posclient.webservice.dto.Item[] itemArray = new com.topsun.posclient.webservice.dto.Item[itemList.size()];;
		for(int i=0; i<itemList.size(); i++){
			Item ee = itemList.get(i);
			com.topsun.posclient.webservice.dto.Item iii = new com.topsun.posclient.webservice.dto.Item();
			iii.setItemId(ee.getId());
			iii.setLineNum(Integer.valueOf(ee.getItemCode()));
			itemArray[i] = iii;
		}
		arrayOfitem.setItem(itemArray);
		return arrayOfitem;
	}
	
	public static ArrayOfbackWarehouseItem getBackWarehouseItemArray(List<Item> itemList){
		ArrayOfbackWarehouseItem arrayOfitem = new ArrayOfbackWarehouseItem();
		com.topsun.posclient.webservice.dto.BackWarehouseItem[] itemArray = new com.topsun.posclient.webservice.dto.BackWarehouseItem[itemList.size()];;
		for(int i=0; i<itemList.size(); i++){
			Item ee = itemList.get(i);
			com.topsun.posclient.webservice.dto.BackWarehouseItem iii = new com.topsun.posclient.webservice.dto.BackWarehouseItem();
			iii.setItemID(ee.getId());
			iii.setLineNum(Integer.valueOf(ee.getItemCode()));
			iii.setSum(ee.getZMDLSBQJ());
			iii.setPrice(ee.getZMDLSBQJ());
			itemArray[i] = iii;
		}
		arrayOfitem.setBackWarehouseItem(itemArray);
		return arrayOfitem;
	}
	
	/**
	 * 零售数据结算方式（零售结算方式）数据转换
	 * 转换成调用WebService时需要的参数数据类型
	 * @param pscList
	 * @return ArrayOfRetail_P
	 */
	public static ArrayOfRetail_P getArrayOfRetail_P(List<PartSalesCashier> pscList){
		if(null == pscList || pscList.size() <= 0){
			return null;
		}
		Retail_P[] rps = new Retail_P[pscList.size()];
		for(int i=0; i<pscList.size(); i++){
			PartSalesCashier psc = pscList.get(i);
			Retail_P rp = new Retail_P();
			rp.setPayModeID(psc.getPayModelId());
			rp.setSum(new BigDecimal(psc.getSum()));
			rps[i] = rp;
		}
 
		ArrayOfRetail_P aop = new ArrayOfRetail_P();
		aop.setRetail_P(rps);
		return aop;
	}
	
	/**
	 * 零售数据明细（商品列表）数据转换
	 * 转换成调用WebService时需要的参数数据类型
	 * @param itemList
	 * @return ArrayOfRetail_M
	 */
	public static ArrayOfRetail_M getArrayOfRetail_M(List<Item> itemList){
		if(null == itemList || itemList.size() <= 0){
			return null;
		}
		Retail_M[] rms = new Retail_M[itemList.size()];
		for(int i=0; i<itemList.size(); i++){
			Item item = itemList.get(i);
			Retail_M rm = new Retail_M();
			rm.setItemId(item.getId());
			rm.setLineNum(Integer.valueOf(item.getItemCode()));
			rm.setPrice(item.getZMDLSBQJ());
			rm.setSum(item.getZMDLSBQJ());
			rms[i] = rm;
		}
		ArrayOfRetail_M aom = new ArrayOfRetail_M();
		aom.setRetail_M(rms);
		return aom;
	}
}

