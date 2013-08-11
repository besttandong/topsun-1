package com.topsun.posclient.repository.ui.view;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.datamodel.AdjustRepositoryInfo;

public class AdjustRepositoryTableLableProvider implements ITableLabelProvider {

	IBaseService baseService = new BaseServiceImpl();
	
	public void addListener(ILabelProviderListener listener) {

	}

	public void dispose() {

	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {

	}

	public Image getColumnImage(Object element, int columnIndex) {
		Image image = new Image(Display.getDefault(), 1, 30); 
		return image;
	}

	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof AdjustRepositoryInfo) {
			AdjustRepositoryInfo ari = (AdjustRepositoryInfo) element;
			String backDate = ProjectUtil.getDateString(ari.getBackDate());
			String orderNo = ari.getOrderNo();
			String shopName = "";
			String receiveRepository = "";
			String backReason = "";
			String applyUser = "";
			String checker = "";
			String reChecker = "";
			String remark = "";
			String checkDate = "";
			String recheckDate = "";
			int num = 0;
			try {
				shopName = baseService.getShopNameById(ari.getBackShopId());
				receiveRepository = baseService.getShopNameById(ari.getReceiveRepositoryId());
				num = ari.getNum();
				backReason = ari.getBackReason();
				applyUser = baseService.getEmployeeNameById(ari.getApplyUser());
				checker = baseService.getEmployeeNameById(ari.getChecker());
				reChecker = baseService.getEmployeeNameById(ari.getReChecker());
				remark = ari.getRemark();
				checkDate = ProjectUtil.getDateString(ari.getCheckDate());
				recheckDate = ProjectUtil.getDateString(ari.getReCheckDate());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			switch (columnIndex) {
			case 0:
				return backDate;
			case 1:
				return orderNo;
			case 2:
				return shopName;
			case 3:
				return receiveRepository;
			case 4:
				return String.valueOf(num);
			case 5:
				return backReason;
			case 6:
				return applyUser;
			case 7:
				return checker;
			case 8:
				return checkDate;
			case 9:
				return reChecker;
			case 10:
				return recheckDate;
			case 11:
				return remark;
			default:
				return "";
			}
		}

		return element.toString();

	}
}