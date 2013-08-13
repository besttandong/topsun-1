package com.topsun.posclient.sales.ui.menu;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;

import com.topsun.posclient.common.POSException;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.datamodel.Item;

public class SalesItemCellModify implements ICellModifier {
	
	IBaseService baseService  = new BaseServiceImpl();

	public TableViewer tableViewer;
	public SalesItemCellModify(TableViewer tableViewer){
		this.tableViewer = tableViewer;
	}
	@Override
	public boolean canModify(Object element, String property) {
		if("itemName".equals(property) || "num".equals(property)){
			return true;
		}
		return false;
	}

	@Override
	public Object getValue(Object element, String property) {
		if(element instanceof Item){
			Item item = (Item)element;
			if("itemName".equals(property)){
				return item.getItemName()!=null?"":"";
			}
			
			if("num".equals(property)){
				return String.valueOf(item.getNum());
			}
		}
		
		return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {
		if(element instanceof TableItem){
			TableItem item = (TableItem)element;
			Item saleItem = (Item)item.getData();
			if("itemName".equals(property)){
				try {
					if(value.toString().equals("")){
						saleItem.setItemName("");
					}
					Item queryItem = baseService.getItemByCode(value.toString());
					if(queryItem != null){
						saleItem.setItemName(queryItem.getItemName());
						saleItem.setItemCode(value.toString());
						saleItem.setNum(1);
						saleItem.setRetailPrice(queryItem.getRetailPrice());
						tableViewer.refresh();
					}else{
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "警告", "没有商品信息");
					}
				} catch (POSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if("num".equals(property)){
				if("".equals(value.toString().trim())){
					return;
				}
				if(value.toString().length() > 10){
					
				}else{
					saleItem.setNum(Integer.valueOf(value.toString()));
					tableViewer.refresh();
				}
				
			}
		}
	}

}
