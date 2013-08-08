package com.topsun.posclient.datamodel;

import java.io.UnsupportedEncodingException;

public class DataModel {
	
	public static String convert(String name){
		if(null == name){
			return name;
		}
		String newName = "";
		try {
			newName = new String(name.getBytes("GBK"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newName;
	}

}
