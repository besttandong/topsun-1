package com.topsun.posclient.common.ui.utils;

import org.eclipse.swt.widgets.Composite;

public class TouchModeManager {
	
	private static TouchModeManager manager;
	
	private Composite composite;
	
	
	public Composite getComposite() {
		return composite;
	}

	public void setComposite(Composite composite) {
		this.composite = composite;
	}

	private TouchModeManager(){
	}
	
	public static TouchModeManager getInstance(){
		if(manager == null){
			manager = new TouchModeManager();
		}
		return manager;
	}

	
}
