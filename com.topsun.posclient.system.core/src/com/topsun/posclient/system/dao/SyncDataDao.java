package com.topsun.posclient.system.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;

import com.topsun.posclient.common.AppConstants;
import com.topsun.posclient.common.POSClientApp;
import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.dao.BaseDao;
import com.topsun.posclient.datamodel.AdjustRepositoryInfo;
import com.topsun.posclient.datamodel.AdjustShopInfo;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.PartSales;
import com.topsun.posclient.datamodel.dto.AdjustRepositoryDTO;
import com.topsun.posclient.datamodel.dto.AdjustShopDTO;
import com.topsun.posclient.datamodel.dto.ItemDTO;
import com.topsun.posclient.datamodel.dto.PartSalesDTO;
import com.topsun.posclient.datamodel.dto.UserDTO;
import com.topsun.posclient.system.MessageResources;
import com.topsun.posclient.system.SyncProgress;
import com.topsun.posclient.system.service.SyncDataListenerManager;
import com.topsun.posclient.webservice.POSServerCaller;
import com.topsun.posclient.webservice.dto.ArrayOfRetail;
import com.topsun.posclient.webservice.dto.ArrayOfbackWarehouse;
import com.topsun.posclient.webservice.dto.ArrayOfshopAllot;
import com.topsun.posclient.webservice.dto.ArrayOfsyncItemDataResultItem;
import com.topsun.posclient.webservice.dto.ArrayOfuser;
import com.topsun.posclient.webservice.dto.BackWarehouse;
import com.topsun.posclient.webservice.dto.GetUserInfo;
import com.topsun.posclient.webservice.dto.GetUserInfoReq;
import com.topsun.posclient.webservice.dto.GetUserInfoResponse;
import com.topsun.posclient.webservice.dto.GetUserInfoResult;
import com.topsun.posclient.webservice.dto.Retail;
import com.topsun.posclient.webservice.dto.SavePartSales;
import com.topsun.posclient.webservice.dto.SavePartSalesReq;
import com.topsun.posclient.webservice.dto.SavePartSalesResponse;
import com.topsun.posclient.webservice.dto.SaveReturnRepository;
import com.topsun.posclient.webservice.dto.SaveReturnRepositoryReq;
import com.topsun.posclient.webservice.dto.SaveReturnRepositoryResponse;
import com.topsun.posclient.webservice.dto.SaveShopAllot;
import com.topsun.posclient.webservice.dto.SaveShopAllotReq;
import com.topsun.posclient.webservice.dto.SaveShopAllotResponse;
import com.topsun.posclient.webservice.dto.ShopAllot;
import com.topsun.posclient.webservice.dto.SyncItemData;
import com.topsun.posclient.webservice.dto.SyncItemDataReq;
import com.topsun.posclient.webservice.dto.SyncItemDataReqCondition;
import com.topsun.posclient.webservice.dto.SyncItemDataResponse;
import com.topsun.posclient.webservice.dto.SyncItemDataResult;
import com.topsun.posclient.webservice.dto.SyncItemDataResultItem;
import com.topsun.posclient.webservice.dto.User;
import com.topsun.posclient.webservice.dto.UserCredential;

/**
 * 数据同步处理
 * 
 * @author Lilei
 *
 */
public class SyncDataDao extends BaseDao {
	
	/**
	 * 下载用户数据
	 * @param progress
	 * @param count
	 * @throws Exception
	 */
	public void downloadUserData(final SyncProgress progress,final int count) throws Exception  {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsyncuser);
					try {
						UserCredential userCredential = new UserCredential();
						userCredential.setPassWord(POSClientApp.get().getLoginUser().getPassWord());
						userCredential.setUserName(POSClientApp.get().getLoginUser().getUserName());
						GetUserInfoReq req = new GetUserInfoReq();
						req.setUserCode(POSClientApp.get().getLoginUser().getUserCode());
						req.setUserCredential(userCredential);
						
						GetUserInfo getUserInfo = new GetUserInfo();
						getUserInfo.setGetUserInfoReq(req);
						GetUserInfoResponse response = POSServerCaller.getWebService().getUserInfo(getUserInfo);
						GetUserInfoResult result = response.getGetUserInfoResult();
						String flag = result.getResult().getFlag();
						if(null == flag || flag.equals("false")){
							return;
						}
						ArrayOfuser userArray = result.getUsers();
						User[] users = userArray.getUser();
						List<com.topsun.posclient.datamodel.User> userList = new ArrayList<com.topsun.posclient.datamodel.User>(); 
						UserDTO userDTO = new UserDTO();
						for(int i=0; i<users.length; i++){
							User user = users[i];
							com.topsun.posclient.datamodel.User uu = new com.topsun.posclient.datamodel.User();
							uu.setUserCode(user.getUserCode());
							uu.setDeptId(user.getDeptId());
							uu.setDeptName(user.getDeptName());
							uu.setEmployeeId(user.getEmployeeId());
							uu.setEmployeeName(user.getEmployeeName());
							uu.setId(user.getUserId());
							userList.add(uu);
						}
						userDTO.setUserList(userList);
						
						// 更新本地数据文件
						getLocalProcessor().updateLocalDataFile(userDTO, AppConstants.DATA_USER_FILENAME_BACK, AppConstants.DATA_USER_FILENAME);
						
					} catch (Exception e) {
						SyncDataListenerManager.getInstance().fireChange("下载用户数据失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsyncuser,count);
				}
			});
	}
	
	/**
	 * 下载店铺数据
	 * 
	 * @param progress
	 * @param count
	 * @throws Exception
	 */
	public void downloadShopData(SyncProgress progress,final int count) throws Exception{
		
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsyncshop);
					try {
//						GetUserInfo getUserInfo = getServerCaller().buildGetUserInfo();
//						String userInfoReqStr = getLocalProcessor().getStringFromObject(getUserInfo);
//						IPosWebService webservice = getServerCaller().getWebService();
//						String returnVal = webservice.downloadShopData(userInfoReqStr);
//						
//						saveLocalFile(AppConstants.DATA_SHOP_FILENAME, returnVal);
					} catch (Exception e) {
						SyncDataListenerManager.getInstance().fireChange("下载店铺数据失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsyncshop,count);
				}
			});
	}
	
	public void downloadItemData(SyncProgress progress,final int count) throws Exception{
		
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsyncitem);
					try {
						SyncItemDataReqCondition condition = new SyncItemDataReqCondition();
						
						SyncItemDataReq req = new SyncItemDataReq();
						req.setUserCredential(POSServerCaller.getDefaultUserCredential());
						req.setCondition(condition);
						
						SyncItemData syncItemData0 = new SyncItemData();
						syncItemData0.setSyncItemDataReq(req);
						SyncItemDataResponse response = POSServerCaller.getWebService().syncItemData(syncItemData0);
						
						SyncItemDataResult result = response.getSyncItemDataResult();
						String flag = result.getResult().getFlag();
						if(null == flag || flag.equals("false")){
							return;
						}
						
						List<Item> itemList = new ArrayList<Item>(); 
						ItemDTO itemDTO = new ItemDTO();
						ArrayOfsyncItemDataResultItem responseData = result.getItems();
						SyncItemDataResultItem[] itemArray = responseData.getSyncItemDataResultItem();
						for(int i=0; i<itemArray.length; i++){
							Item item = new Item();
//							SyncItemDataResultItem sd = itemArray[i];
//							item.setId(sd.getId());
//							item.setArea(sd.getAreaId());
////							item.setAreaName(sidri.getAreaId());
//							item.setBrandId(sd.getBrandId());
//							item.setChannelPrice(sd.getChannelPrice().doubleValue());
//							item.setClassId(sd.getClassId());
//							item.setDivisionId(sd.getDivisionId());
//							item.setDescription(sd.getDescription());
//							item.setGuidePrice(sd.getGuidePrice().doubleValue());
//							item.setItemCode(sd.getItemCode());
//							item.setItemName(sd.getItemName());
//							item.setNum(sd.getUnitId());
//							item.setPurchasePrice(sd.getPurchasePrice().doubleValue());
//							item.setRetailPrice(sd.getRetailPrice().doubleValue());
//							item.setSectionId(sd.getSectionId());
//							item.setStdId(sd.getStdId());
//							item.setSupplierId(sd.getSupplierId());
//							item.setUnitId(sd.getUnitId());
//							item.setWholesalePrice(sd.getWholesalePrice().doubleValue());
							itemList.add(item);
						}
						itemDTO.setItemList(itemList);
						
						// 更新本地数据文件
						getLocalProcessor().updateLocalDataFile(itemDTO, AppConstants.DATA_ITEM_FILENAME_BACK, AppConstants.DATA_ITEM_FILENAME);
						
					} catch (Exception e) {
						e.printStackTrace();
						SyncDataListenerManager.getInstance().fireChange("下载商品主数据失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsyncitem,count);
				}
			});
	}
	
	public void downloadCashierModeData(SyncProgress progress,final int count) throws Exception{
		
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsynccashiermode);
					try {
//						GetUserInfo getUserInfo = getServerCaller().buildGetUserInfo();
//						String userInfoReqStr = getLocalProcessor().getStringFromObject(getUserInfo);
//						IPosWebService webservice = getServerCaller().getWebService();
//						String returnVal = webservice.downloadCashierModeData(userInfoReqStr);
//						
//						saveLocalFile(AppConstants.DATA_CASHIERMODE_FILENAME, returnVal);
					} catch (Exception e) {
						SyncDataListenerManager.getInstance().fireChange("下载结算方式数据失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsynccashiermode,count);
				}
			});
	}
	
	public void uploadPartSalesData(SyncProgress progress,final int count) throws Exception{
		
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsyncsales);
					try {
						File file = new File(ProjectUtil.getRuntimeClassPath()+AppConstants.DATA_PARTSALES_PATH);
						File[] dataFiles = file.listFiles();
						for(int i=0; i<dataFiles.length; i++){
							File dataFile = dataFiles[i];
							if(!dataFile.isFile()){
								SyncDataListenerManager.getInstance().fireChange("本地没有需要上传的零售数据文件。");
								return;
							}
							PartSalesDTO dto = (PartSalesDTO)getLocalProcessor().getObjectFromXml(getLocalProcessor().getDataFileContent(dataFile), PartSalesDTO.class) ;
							List<PartSales> list = dto.getPartSalesList();
							if(null == list || list.size() <= 0){
								return;
							}
							Retail[] retailArray = new Retail[list.size()];
							for(int j = 0; j<list.size(); j++){
								PartSales asi = list.get(j);
								Retail sa = new Retail();
								sa.setAddPoint(10);
								sa.setAuditDate(ProjectUtil.getCalendar(asi.getCheckDate()));
								sa.setAuditID(asi.getChecker());
								sa.setBillNo(asi.getBallotNo());
								sa.setSalesDate(ProjectUtil.getCalendar(asi.getSalesDate()));
								sa.setShopID(asi.getShopId());
								sa.setCashierID(asi.getUserId());
								sa.setDocNum(asi.getNo());
								sa.setEmployeeID(asi.getUserId());
								sa.setMemo(asi.getRemark());
								sa.setDiscount(new BigDecimal(1));
								sa.setIsReturn(0);
								sa.setEnablePoint(Integer.valueOf(asi.getEnablePoint()));
								sa.setEnableBalance(new BigDecimal(asi.getEnableBalance()));
								sa.setRetail_Ms(POSServerCaller.getArrayOfRetail_M(asi.getItemList()));
								sa.setRetail_Ps(POSServerCaller.getArrayOfRetail_P(asi.getPsCashierList()));
								retailArray[i] = sa;
							}
							
							ArrayOfRetail arrayOfRetail = new ArrayOfRetail();
							arrayOfRetail.setRetail(retailArray);
							
							SavePartSalesReq req = new SavePartSalesReq();
							req.setUserCredential(POSServerCaller.getDefaultUserCredential());
							req.setRetails(arrayOfRetail);
							
							SavePartSales savePartSales12 = new SavePartSales();
							savePartSales12.setSavePartSalesReq(req);
							SavePartSalesResponse response = POSServerCaller.getWebService().savePartSales(savePartSales12);
							String flag = response.getSavePartSalesResult().getResult().getFlag();
							System.out.println("----------->> Call webservice savePartSales finished!&Flag = "+flag);
						}
					} catch (Exception e) {
						e.printStackTrace();
						SyncDataListenerManager.getInstance().fireChange("零售数据上传失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsyncsales,count);
				}
			});
	}
	
	public void uploadPayRecordData(SyncProgress progress,final int count) throws Exception{
		
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsyncpayment);
					try {
						File file = new File(ProjectUtil.getRuntimeClassPath()+AppConstants.DATA_SHOPPAY_PATH);
						File[] dataFiles = file.listFiles();
						for(int i=0; i<dataFiles.length; i++){
//							File dataFile = dataFiles[i];
//							if(!dataFile.isFile()){
//								return;
//							}
//							AdjustShopDTO dto = (AdjustShopDTO)getLocalProcessor().getObjectFromXml(getLocalProcessor().getDataFileContent(dataFile), AdjustShopDTO.class) ;
//							List<AdjustShopInfo> list = dto.getAdjustShopList();
//							if(null == list || list.size() <= 0){
//								return;
//							}
//							ShopAllot[] shopAllotArray = new ShopAllot[list.size()];
//							for(int j = 0; j<list.size(); j++){
//								AdjustShopInfo asi = list.get(j);
//								ShopAllot sa = new ShopAllot();
//								sa.setAllotDate(ProjectUtil.getCalendar(asi.getCallDate()));
//								sa.setAllotTypeId(sa.getAllotTypeId());
//								sa.setDocNum(asi.getVoucherNo());
//								sa.setDocNumPOS("POS09");
//								sa.setInShpId(asi.getIntoShop());
//								sa.setOutShpId(asi.getOutShop());
//								sa.setMakerID(asi.getApplyUser());
//								sa.setMemo(asi.getRemark());
//								sa.setItems(POSServerCaller.getItemArray(asi.getItemList()));
//								shopAllotArray[i] = sa;
//							}
//							ArrayOfshopAllot arrayOfshopAllot = new ArrayOfshopAllot();
//							arrayOfshopAllot.setShopAllot(shopAllotArray);
//							SaveShopAllotReq req = new SaveShopAllotReq();
//							req.setUserCredential(POSServerCaller.getDefaultUserCredential());
//							req.setShopAllots(arrayOfshopAllot);
//							SaveShopAllot saveShopAllot6 = new SaveShopAllot();
//							saveShopAllot6.setSaveShopAllotReq(req);
//							POSServerCaller.getWebService().sa(saveShopAllot6);
//							
//							System.out.println("----------->> Call webservice saveShopAllot finished!");
						}
					} catch (Exception e) {
						SyncDataListenerManager.getInstance().fireChange("缴款数据上传失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsyncpayment,count);
				}
			});
	}
	
	public void uploadAdjustShopData(SyncProgress progress,final int count) throws Exception{
	
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsyncadjustshop);
					try {
						File file = new File(ProjectUtil.getRuntimeClassPath()+AppConstants.DATA_ADJUSTSHOP_PATH);
						File[] dataFiles = file.listFiles();
						for(int i=0; i<dataFiles.length; i++){
							File dataFile = dataFiles[i];
							if(!dataFile.isFile()){
								SyncDataListenerManager.getInstance().fireChange("本地没有需要上传的调店数据文件。");
								return;
							}
							AdjustShopDTO dto = (AdjustShopDTO)getLocalProcessor().getObjectFromXml(getLocalProcessor().getDataFileContent(dataFile), AdjustShopDTO.class) ;
							List<AdjustShopInfo> list = dto.getAdjustShopList();
							if(null == list || list.size() <= 0){
								return;
							}
							ShopAllot[] shopAllotArray = new ShopAllot[list.size()];
							for(int j = 0; j<list.size(); j++){
								AdjustShopInfo asi = list.get(j);
								ShopAllot sa = new ShopAllot();
								sa.setAllotDate(ProjectUtil.getCalendar(asi.getCallDate()));
								sa.setAllotTypeId(sa.getAllotTypeId());
								sa.setDocNum(asi.getVoucherNo());
								sa.setDocNumPOS("POS09");
								sa.setInShpId(asi.getIntoShop());
								sa.setOutShpId(asi.getOutShop());
								sa.setMakerID(asi.getApplyUser());
								sa.setMemo(asi.getRemark());
								sa.setItems(POSServerCaller.getItemArray(asi.getItemList()));
								shopAllotArray[i] = sa;
							}
							ArrayOfshopAllot arrayOfshopAllot = new ArrayOfshopAllot();
							arrayOfshopAllot.setShopAllot(shopAllotArray);
							SaveShopAllotReq req = new SaveShopAllotReq();
							req.setUserCredential(POSServerCaller.getDefaultUserCredential());
							req.setShopAllots(arrayOfshopAllot);
							SaveShopAllot saveShopAllot6 = new SaveShopAllot();
							saveShopAllot6.setSaveShopAllotReq(req);
							SaveShopAllotResponse response = POSServerCaller.getWebService().saveShopAllot(saveShopAllot6);
							String flag = response.getSaveShopAllotResult().getResult().getFlag();
							System.out.println("----------->> Call webservice saveShopAllot finished!&Flag = "+flag);
						}
					} catch (Exception e) {
						e.printStackTrace();
						SyncDataListenerManager.getInstance().fireChange("调店数据上传失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsyncadjustshop,count);
				}
			});
	}
	
	public void uploadAdjustRepositoryData(SyncProgress progress,final int count) throws Exception{
		
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_startsyncadjustrepository);
					try {
						File file = new File(ProjectUtil.getRuntimeClassPath()+AppConstants.DATA_ADJUSTREPOSITORY_PATH);
						File[] dataFiles = file.listFiles();
						for(int i=0; i<dataFiles.length; i++){
							File dataFile = dataFiles[i];
							if(!dataFile.isFile()){
								SyncDataListenerManager.getInstance().fireChange("本地没有需要上传的回仓数据文件。");
								return;
							}
							AdjustRepositoryDTO dto = (AdjustRepositoryDTO)getLocalProcessor().getObjectFromXml(getLocalProcessor().getDataFileContent(dataFile), AdjustRepositoryDTO.class) ;
							List<AdjustRepositoryInfo> list = dto.getAdjustRepositoryInfos();
							if(null == list || list.size() <= 0){
								return;
							}
							BackWarehouse[] backWarehouseArray = new BackWarehouse[list.size()];
							for(int j = 0; j<list.size(); j++){
								AdjustRepositoryInfo asi = list.get(j);
								BackWarehouse bw = new BackWarehouse();
								bw.setBackWarehouseItems(POSServerCaller.getBackWarehouseItemArray(asi.getItemList()));
								backWarehouseArray[i] = bw;
							}
							
							ArrayOfbackWarehouse arrayOfbackWarehouse = new ArrayOfbackWarehouse();
							arrayOfbackWarehouse.setBackWarehouse(backWarehouseArray);
							
							SaveReturnRepositoryReq req = new SaveReturnRepositoryReq();
							req.setUserCredential(POSServerCaller.getDefaultUserCredential());
							req.setBackWarehouses(arrayOfbackWarehouse);
							
							SaveReturnRepository saveReturnRepository14 = new SaveReturnRepository();
							saveReturnRepository14.setSaveReturnRepositoryReq(req);
							SaveReturnRepositoryResponse response = POSServerCaller.getWebService().saveReturnRepository(saveReturnRepository14);
							String flag = response.getSaveReturnRepositoryResult().getResult().getFlag();
							System.out.println("----------->> Call webservice saveReturnRepository finished!&Flag = "+flag);
						}
					} catch (Exception e) {
						e.printStackTrace();
						SyncDataListenerManager.getInstance().fireChange("回仓数据上传失败");
						return;
					}
					SyncDataListenerManager.getInstance().fireChange("---------------> "+MessageResources.message_tips_endsyncadjustrepository,count);
				}
			});
		
	}
	
	public void saveLocalFile(String filepath, String fileContent) throws Exception{
		File file = new File(ProjectUtil.getRuntimeClassPath()+filepath);
    	file.deleteOnExit();
    	BufferedWriter output = null;
    	try {
			file.createNewFile();
			
			output = new BufferedWriter(new FileWriter(file));
		    output.write(fileContent);
		    
		} catch (Exception e) {
			throw new Exception(MessageResources.message_tips_sync_failer);
		}finally{
			if(null != output){
				output.close();
			}
		}
	}
	
	public void createDisplayThread(final Text infoText,final String text){
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				{
					String str  = infoText.getText() + "\r\n";
					infoText.setText(str + text);
				}
				
			}
		});
	}
	
	public void setProgress(final ProgressBar bar ,final int worked){
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				{
					bar.setSelection(worked);
				}

			}
		});
	}

}
