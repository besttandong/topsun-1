package com.topsun.posclient.common.listener;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Listener;

/**
 * 监听管理sss
 * @author Administrator
 *
 */
public class KeyListenerManager {
	private static KeyListenerManager keyListenerManager;
	private KeyListenerManager(){};
	
	private List<IKeyListener> listeners = new ArrayList<IKeyListener>();
	
	public static  KeyListenerManager getInstance(){
		if(keyListenerManager == null){
			keyListenerManager = new KeyListenerManager();
			return keyListenerManager;
		}
		return keyListenerManager;
	}
	
	public void addKeyListener(IKeyListener listener){
		listeners.add(listener);
	}
	
	public void removeListener(IKeyListener iKeyListener){
		listeners.remove(iKeyListener);
	}
	
	public void fireChange(String operationType){
		for (IKeyListener keyListener : listeners) {
			keyListener.onChange(operationType);
		}
	}
	
}
