package com.hexapixel.widgets.ribbon;

import org.eclipse.swt.widgets.Display;

import com.hexapixel.widgets.generic.ImageCache;
import com.hexapixel.widgets.generic.Utils;

public class CarrodTest {
	public static void main(String[] args) {
		Display display = new Display();
		final RibbonShell shell = new RibbonShell(display);
		shell.setButtonImage(ImageCache.getImage("selection_recycle_24.png"));
		shell.setText("Top Sun Pos-Client");
		shell.setSize(800, 600);
		Utils.centerDialogOnScreen(shell.getShell());
		shell.open();
//			
		RibbonTabFolder tabfolder = shell.getRibbonTabFolder();
		
		RibbonTab saleTab = new RibbonTab(tabfolder, "菜单");
		RibbonGroup tbGroup = new RibbonGroup(saleTab,  "");
		RibbonToolbar toolbar = new RibbonToolbar(tbGroup, RibbonToolbar.STYLE_NO_BORDER, 2);
		RibbonToolbarGrouping rtg = new RibbonToolbarGrouping(toolbar, 1);		
		RibbonToolbarGrouping rtg2 = new RibbonToolbarGrouping(toolbar, 2);		
		
		
		{
			RibbonButton button = new RibbonButton(rtg, ImageCache.getImage("selection_recycle_24.png"), null,  RibbonButton.STYLE_NO_DEPRESS);
		}
		
		{
			RibbonButton button = new RibbonButton(rtg2, ImageCache.getImage("selection_recycle_24.png"), null,  RibbonButton.STYLE_NO_DEPRESS);
		}
		
//		{
//			RibbonTab saleTab = new RibbonTab(tabfolder, "财务管理");
//			RibbonGroup tbGroup = new RibbonGroup(saleTab,  "店铺缴款");
//			RibbonGroup tbGroup1 = new RibbonGroup(saleTab, "付款 ");
//			RibbonGroup tbGroup2 = new RibbonGroup(saleTab, "收款");
//		}
//		
//		{
//			RibbonTab saleTab = new RibbonTab(tabfolder, "库存");
//			RibbonGroup tbGroup = new RibbonGroup(saleTab,  "回仓   ");
//			RibbonGroup tbGroup1 = new RibbonGroup(saleTab, "店调店 ");
//			RibbonGroup tbGroup2 = new RibbonGroup(saleTab, "库存盘点 ");
//		}
//		
//		{
//			RibbonTab saleTab = new RibbonTab(tabfolder, "系统设置");
//			RibbonGroup tbGroup = new RibbonGroup(saleTab,  "设置");
//			RibbonGroup tbGroup1 = new RibbonGroup(saleTab, "同步数据");
//		}
	
//		RibbonToolbar toolbar = new RibbonToolbar(tbGroup, RibbonToolbar.STYLE_BORDERED, 2);
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
