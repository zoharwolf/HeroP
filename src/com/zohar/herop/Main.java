/*
 * @(#)Main.java	1.0 2013-6-27
 *
 */
package com.zohar.herop;

import java.util.Locale;

import com.zohar.herop.common.Constant;

/**
 * 
 * 
 * @author zohar
 * @version 1.0, 2013-6-27
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.CHINA);
		System.out.println(Constant.getString("name")+" "+Constant.getString("age"));
	}

}
