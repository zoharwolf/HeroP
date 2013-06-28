/*
 * @(#)Constant.java	1.0 2013-6-28
 *
 */
package com.zohar.herop.common;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * 
 * @author zohar
 * @version 1.0, 2013-6-28
 */
public class Constant {
	
	private static ResourceBundle baseInfoBundle = ResourceBundle.getBundle("language/BaseInfo",Locale.getDefault());

	/**
	 * Get string from locale properties
	 * @return
	 */
	public static String getString(String key){
		try {
			return new String(baseInfoBundle.getString(key).getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
