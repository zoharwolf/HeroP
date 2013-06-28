/*
 * @(#)Main.java	1.0 2013-6-27
 *
 */
package com.zohar.herop;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * 
 * @author Administrator
 * @version 1.0, 2013-6-27
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.CHINA);
		ResourceBundle bundle = ResourceBundle.getBundle("language/BaseInfo",Locale.getDefault());
		System.out.println(bundle.getString("name")+" "+bundle.getString("age"));
	}

}
