package com.topsun.posclient.common.ui.style;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ViewSite;

import com.hexapixel.widgets.generic.ImageCache;
import com.hexapixel.widgets.generic.Utils;
import com.hexapixel.widgets.ribbon.ButtonSelectGroup;
import com.hexapixel.widgets.ribbon.RibbonButton;
import com.hexapixel.widgets.ribbon.RibbonGroup;
import com.hexapixel.widgets.ribbon.RibbonShell;
import com.hexapixel.widgets.ribbon.RibbonTab;
import com.hexapixel.widgets.ribbon.RibbonTabFolder;
import com.hexapixel.widgets.ribbon.RibbonTooltip;
import com.topsun.posclient.common.POSClientApp;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.common.ui.menu.TouchModeFacade;
import com.topsun.posclient.common.ui.model.TopSunTreeModel;
import com.topsun.posclient.common.ui.utils.TouchModeManager;
import com.topsun.posclient.datamodel.User;

public class TouchModeApplication {
	
	public static RibbonShell createShell(Display display) {
		final RibbonShell shell = new RibbonShell(display);
		shell.setButtonImage(ImageCache.getImage("selection_recycle_24.png"));
		shell.setText("Top Sun Pos-Client");
		shell.setSize(1024, 768);
		

		List<TopSunTreeModel> list = TouchModeFacade.getInstance().loadAllTreeItems();
		Composite composite = new Composite(shell.getShell(), SWT.NONE);
		TouchModeManager.getInstance().setComposite(composite);
		Menu shellMenu = shell.getBigButtonMenu();
		MenuItem btest = new MenuItem(shellMenu, SWT.POP_UP);
		btest.setText("Testing a menu");
		
		shell.addBigButtonListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				System.err.println("Clicked big button");
				shell.showBigButtonMenu();
			}
			
		});
		
		
		RibbonTabFolder ftf = shell.getRibbonTabFolder();
//		GridLayout gridLayout = new GridLayout();
//		gridLayout.marginLeft =  1;
//		gridLayout.marginWidth = 10;
//		ftf.setLayout(gridLayout);
		ftf.setHelpImage(ImageCache.getImage("questionmark.gif"));
		ftf.getHelpButton().setToolTip(new RibbonTooltip("Title", "Get Help Using Whatever This Is"));
		
		RibbonTab ft1 = new RibbonTab(ftf, "菜单");
		
		for (TopSunTreeModel topSunTreeModel : list) {
			RibbonGroup ftg2 = new RibbonGroup(ft1, "                  ");
//			GridLayout gridLayout1 = new GridLayout(1,false);
//			gridLayout1.marginLeft =  100;
//			gridLayout1.marginWidth = 100;
//			ftg2.setLayout(gridLayout1);
			RibbonButton rb1 = new RibbonButton(ftg2, ImageCache.getImage("olb_picture2.gif"),topSunTreeModel.getTreeName(), RibbonButton.STYLE_NO_DEPRESS);
			ButtonSelectGroup group = new ButtonSelectGroup();
			rb1.setButtonSelectGroup(group);
			rb1.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					
//					try {
//						IViewPart part = window.getActivePage()
//						.showView("", Integer.toString(0),
//								IWorkbenchPage.VIEW_ACTIVATE);
//					} catch (PartInitException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					ISelection iSelection = e.getSelection();
//					if (iSelection instanceof TreeSelection) {
//						TreeSelection selection = (TreeSelection) iSelection;
//						Object obj = selection.getFirstElement();
//						if (obj instanceof TopSunTreeModel) {
//							TopSunTreeModel selectionTree = (TopSunTreeModel) obj;
//
//							TopSunTreeModel topsunTree = findTree(selectionTree
//									.getTreeName());
//							String viewId = topsunTree.getViewid();
//
//						}
//					}
//					IBaseService commonService  = new BaseServiceImpl();
//					User loginUser = POSClientApp.get().getLoginUser();
//					String deptName = loginUser.getDeptName();
//					String userName = loginUser.getUserName();
//					ViewSite viewSite = (ViewSite)window.getPartService().getActivePart().getSite();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

		}
		
		Utils.centerDialogOnScreen(shell.getShell());
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		System.exit(0);
		return shell;
	}
}
