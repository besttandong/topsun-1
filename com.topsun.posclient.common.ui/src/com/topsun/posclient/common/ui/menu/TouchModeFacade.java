package com.topsun.posclient.common.ui.menu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

import com.topsun.posclient.common.ui.model.TopSunTreeModel;

public class TouchModeFacade {
	private static List<TopSunTreeModel> treeList = new ArrayList<TopSunTreeModel>();
	public static TouchModeFacade facede;
	private TouchModeFacade() {

	}
	public static TouchModeFacade getInstance() {
		if (facede == null) {
			facede = new TouchModeFacade();
			return facede;
		}
		return facede;
	}
	public List<TopSunTreeModel> loadAllTreeItems(){
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

				TopSunTreeModel sunTree = new TopSunTreeModel();
				sunTree.setTreeId(treeid);
				sunTree.setTreeName(treeName);
				sunTree.setViewid(viewid);
				sunTree.setPluginId(pluginId);
				sunTree.setIcon(icon == null ? "" : icon);
				sunTree.setIndex(index == null ? "" : index);
				treeList.add(sunTree);
			}
		}
		return this.treeList;
	}
}
