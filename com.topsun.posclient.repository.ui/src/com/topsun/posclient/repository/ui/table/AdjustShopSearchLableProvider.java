package com.topsun.posclient.repository.ui.table;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.datamodel.AdjustShopInfo;

public class AdjustShopSearchLableProvider implements ITableLabelProvider {

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
		if (element instanceof AdjustShopInfo) {
			AdjustShopInfo adjustShopInfo = (AdjustShopInfo) element;
			String callDate = ProjectUtil.getDateString(adjustShopInfo.getCallDate());
			int outShopName = adjustShopInfo.getOutShop();
			int intoShopName = adjustShopInfo.getIntoShop();
			String orderNumber = adjustShopInfo.getVoucherNo();
			int callType = adjustShopInfo.getCallType();
			int callNum = adjustShopInfo.getItemNum();
			String remark = adjustShopInfo.getRemark();
			String checkDate = ProjectUtil.getDateString(adjustShopInfo.getCheckDate());
			String recheckDate = ProjectUtil.getDateString(adjustShopInfo.getReCheckDate());
			switch (columnIndex) {
			case 0:
				return callDate;
			case 1:
				return orderNumber;
			case 2:
				return String.valueOf(outShopName);
			case 3:
				return String.valueOf(intoShopName);
			case 4:
				return String.valueOf(callType);
			case 5:
				return String.valueOf(callNum);
			case 6:
				return String.valueOf(intoShopName);
			case 7:
				return String.valueOf(intoShopName);
			case 8:
				return checkDate;
			case 9:
				return remark;
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
