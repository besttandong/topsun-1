package com.topsun.posclient.common.ui.style;

import java.util.List;

import org.eclipse.core.internal.registry.BundleHelper;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.internal.util.BundleUtility;
import org.osgi.framework.Bundle;

import com.hexapixel.widgets.generic.ImageCache;
import com.hexapixel.widgets.generic.Utils;
import com.hexapixel.widgets.ribbon.RibbonButton;
import com.hexapixel.widgets.ribbon.RibbonGroup;
import com.hexapixel.widgets.ribbon.RibbonShell;
import com.hexapixel.widgets.ribbon.RibbonTab;
import com.hexapixel.widgets.ribbon.RibbonTabFolder;
import com.hexapixel.widgets.ribbon.RibbonToolbar;
import com.hexapixel.widgets.ribbon.RibbonToolbarGrouping;
import com.topsun.posclient.common.ui.menu.TouchModeFacade;
import com.topsun.posclient.common.ui.model.TopSunTreeModel;

public class TouchModeApplication {
	public static RibbonShell createShell(Display display) {
		final RibbonShell shell = new RibbonShell(display);
		shell.setButtonImage(ImageCache.getImage("selection_recycle_24.png"));
		shell.setText("Top Sun Pos-Client");
		shell.setSize(800, 600);
		Utils.centerDialogOnScreen(shell.getShell());


		List<TopSunTreeModel> list = TouchModeFacade.getInstance().loadAllTreeItems();
		shell.open();
		//


		RibbonTabFolder tabfolder = shell.getRibbonTabFolder();

		RibbonTab saleTab = new RibbonTab(tabfolder, "菜单");
		

		for (TopSunTreeModel topSunTreeModel : list) {
			RibbonGroup tbGroup = new RibbonGroup(saleTab, topSunTreeModel.getTreeName());
			RibbonToolbar toolbar = new RibbonToolbar(tbGroup,
					RibbonToolbar.STYLE_NO_BORDER, 2);
			RibbonToolbarGrouping rtg = new RibbonToolbarGrouping(toolbar, 1);
			
			Bundle bundle = BundleHelper.getDefault().getBundle(topSunTreeModel.getPluginId());
			Image image = ImageDescriptor.createFromURL(BundleUtility.find(bundle,topSunTreeModel.getIcon())).createImage();
			
			RibbonButton button = new RibbonButton(rtg,image, null,RibbonButton.STYLE_NO_DEPRESS);
			button.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}


		// {
		// RibbonTab saleTab = new RibbonTab(tabfolder, "财务管理");
		// RibbonGroup tbGroup = new RibbonGroup(saleTab, "店铺缴款");
		// RibbonGroup tbGroup1 = new RibbonGroup(saleTab, "付款 ");
		// RibbonGroup tbGroup2 = new RibbonGroup(saleTab, "收款");
		// }
		//
		// {
		// RibbonTab saleTab = new RibbonTab(tabfolder, "库存");
		// RibbonGroup tbGroup = new RibbonGroup(saleTab, "回仓   ");
		// RibbonGroup tbGroup1 = new RibbonGroup(saleTab, "店调店 ");
		// RibbonGroup tbGroup2 = new RibbonGroup(saleTab, "库存盘点 ");
		// }
		//
		// {
		// RibbonTab saleTab = new RibbonTab(tabfolder, "系统设置");
		// RibbonGroup tbGroup = new RibbonGroup(saleTab, "设置");
		// RibbonGroup tbGroup1 = new RibbonGroup(saleTab, "同步数据");
		// }

		// RibbonToolbar toolbar = new RibbonToolbar(tbGroup,
		// RibbonToolbar.STYLE_BORDERED, 2);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		System.exit(0);
		return shell;
	}
}
