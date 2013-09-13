package com.topsun.posclient.sales.ui.table;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.topsun.posclient.datamodel.Item;

public class SalesTableLableProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		Image image = new Image(Display.getDefault(), 1, 30); 
		return image;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof Item) {
			Item item = (Item) element;
			String productName = item.getItemName();
			String type = item.getItemCode();
			//int number = item.getNum();
		//	double retailPrice = item.getRetailPrice();
			double total = 0;

			switch (columnIndex) {
			case 0:
				return productName;
			case 1:
				return type;
			case 2:
				return String.valueOf(0);
			case 3:
				if(0 == 0){
					return "";
				}
				return String.valueOf(0);
			case 4:
				if(total == 0){
					return "";
				}
				return String.valueOf(total);

			default:
				return "";
			}
		}

		return element.toString();

	}

}
