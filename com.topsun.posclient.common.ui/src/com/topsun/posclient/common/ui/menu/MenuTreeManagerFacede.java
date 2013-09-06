package com.topsun.posclient.common.ui.menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ViewSite;

import com.topsun.posclient.common.POSClientApp;
import com.topsun.posclient.common.service.IBaseService;
import com.topsun.posclient.common.service.impl.BaseServiceImpl;
import com.topsun.posclient.common.ui.model.TopSunMenuModel;
import com.topsun.posclient.common.ui.model.TopSunTreeModel;
import com.topsun.posclient.common.ui.utils.ImageUtils;
import com.topsun.posclient.common.ui.utils.TopSunMenuTreeComparator;
import com.topsun.posclient.datamodel.User;
import com.topsun.posclient.widget.pshelf.PShelf;
import com.topsun.posclient.widget.pshelf.PShelfItem;

/**
 * 
 * @author yujie3
 * 
 */
public class MenuTreeManagerFacede {

	private static MenuTreeManagerFacede facede = new MenuTreeManagerFacede();

	private static List<TopSunMenuModel> menuList = new ArrayList<TopSunMenuModel>();

	private static List<TopSunTreeModel> treeList = new ArrayList<TopSunTreeModel>();

	private MenuTreeManagerFacede() {

	}

	static IWorkbenchWindow window = PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow();
	static int instanceNum;

	private static void checkSecondaryId(String viewID) {
		IWorkbenchPage page = window.getActivePage();
		IViewReference vr = page.findViewReference(viewID,
				Integer.toString(instanceNum));
		if (vr != null) {
			instanceNum++;
			checkSecondaryId(viewID);
		} else {
			return;
		}

	}

	public static MenuTreeManagerFacede getInstance() {
		if (facede == null) {
			facede = new MenuTreeManagerFacede();
			return facede;
		}
		return facede;
	}

	private TopSunTreeModel findTree(String treeName) {
		for (TopSunTreeModel tree : treeList) {
			if (treeName.equals(tree.getTreeName())) {
				return tree;
			}
		}
		return null;
	}

	private TopSunMenuModel findMenu(String menuID) {
		for (TopSunMenuModel menu : menuList) {
			if (menuID.equals(menu.getMenuID())) {
				return menu;
			}
		}
		return null;
	};

	private void createTree(Composite composite, final TopSunMenuModel menu) {
		loadTreeExtension(menu);
		TreeViewer treeViewer = new TreeViewer(composite);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		treeViewer.setLabelProvider(new MenuTreeLabelProvider());
		treeViewer.setContentProvider(new MenuTreeContentProvider());
		TopSunMenuModel t_Menu = findMenu(menu.getMenuID());
		List<TopSunTreeModel> topSunTrees = t_Menu.getTrees();
		TopSunMenuTreeComparator comparator = new TopSunMenuTreeComparator();
		Collections.sort(topSunTrees, comparator);
		treeViewer.setInput(topSunTrees);

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateStatusline(event);

			}
		});

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				ISelection iSelection = event.getSelection();
				if (iSelection instanceof TreeSelection) {
					TreeSelection selection = (TreeSelection) iSelection;
					Object obj = selection.getFirstElement();
					if (obj instanceof TopSunTreeModel) {
						TopSunTreeModel selectionTree = (TopSunTreeModel) obj;

						TopSunTreeModel topsunTree = findTree(selectionTree
								.getTreeName());
						String viewId = topsunTree.getViewid();
						checkSecondaryId(viewId);
						if (window != null) {
							try {
								IViewPart part = window.getActivePage()
										.showView(viewId, Integer.toString(0),
												IWorkbenchPage.VIEW_ACTIVATE);
								instanceNum++;

							} catch (PartInitException e) {
								MessageDialog.openError(window.getShell(),
										"Error",
										"Error opening view:" + e.getMessage());
							}
						}

					}
				}
				IBaseService commonService  = new BaseServiceImpl();
				User loginUser = POSClientApp.get().getLoginUser();
				String deptName = loginUser.getDeptName();
				String userName = loginUser.getUserName();
				ViewSite viewSite = (ViewSite)window.getPartService().getActivePart().getSite();
				IStatusLineManager statusManager =  viewSite.getActionBars().getStatusLineManager();
				statusManager.setMessage("姓名：" + userName + "      部门:" + deptName +"       登录时间：" + Calendar.getInstance().getTime());
			}
			
			
		});

	}

	protected void updateStatusline(SelectionChangedEvent event) {
		
	}

	public void loadTreeExtension(TopSunMenuModel menu) {
		IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint("com.topsun.tree").getExtensions();
		for (IExtension iExtension : extensions) {
			IConfigurationElement[] configurationElement = iExtension
					.getConfigurationElements();
			for (IConfigurationElement iConfigurationElement : configurationElement) {
				String pluginId = iExtension.getNamespace();
				String menuId = iConfigurationElement.getAttribute("menuid");
				String treeName = iConfigurationElement.getAttribute("name");
				String treeid = iConfigurationElement.getAttribute("treeid");
				String viewid = iConfigurationElement.getAttribute("viewid");
				String index = iConfigurationElement.getAttribute("index");
				String icon = iConfigurationElement.getAttribute("icons");

				if (menu.getMenuID().equals(menuId)) {
					TopSunTreeModel sunTree = new TopSunTreeModel(menu);
					sunTree.setTreeId(treeid);
					sunTree.setTreeName(treeName);
					sunTree.setViewid(viewid);
					sunTree.setPluginId(pluginId);
					sunTree.setIcon(icon == null ? "" : icon);
					sunTree.setIndex(index == null ? "" : index);
					treeList.add(sunTree);
				}
			}
		}
	}
	
	
	

	public void initMenu(PShelf parent) {
		for (TopSunMenuModel menuModel : menuList) {
			PShelfItem item = new PShelfItem(parent, SWT.NONE);
			item.setText("  " + menuModel.getMenuName());

			Composite compsite = item.getBody();
			Color color = PlatformUI.getWorkbench().getDisplay()
					.getSystemColor(SWT.COLOR_WHITE);
			item.setImage(ImageUtils.createImage(menuModel.getPluginID(),
					menuModel.getIcon()));
			compsite.setBackground(color);
			
			GridLayout gridLayout = new GridLayout(1, false);
			gridLayout.marginBottom = 0;
			gridLayout.marginHeight = 0;
			gridLayout.marginLeft = 0;
			gridLayout.marginRight = 0 ;
			gridLayout.marginTop = 0;
			gridLayout.marginWidth = 0;
			compsite.setLayout(gridLayout);
			// Create Tree Viewer
			createTree(compsite, menuModel);
		}
	}

	public void loadMenuExtension() {
		IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint("com.topsun.menu").getExtensions();
		for (IExtension iExtension : extensions) {
			IConfigurationElement[] configurationElement = iExtension
					.getConfigurationElements();
			for (IConfigurationElement iConfigurationElement : configurationElement) {
				String meunName = iConfigurationElement.getAttribute("name");
				String index = iConfigurationElement.getAttribute("index");
				String menuid = iConfigurationElement.getAttribute("menuid");
				String icon = iConfigurationElement.getAttribute("icon");
				String pluginId = iExtension.getNamespace();
				TopSunMenuModel menu = new TopSunMenuModel();
				menu.setMenuID(menuid);
				menu.setMenuName(meunName);
				menu.setIcon(icon == null ? "" : icon);
				menu.setIndex(index == null ? "" : index);
				menu.setPluginID(pluginId);
				menuList.add(menu);
			}
		}
		TopSunMenuTreeComparator comparator = new TopSunMenuTreeComparator();
		Collections.sort(menuList, comparator);

	}
}
