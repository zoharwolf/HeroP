/*
 * @(#)Main.java	1.0 2013-6-27
 *
 */
package com.zohar.herop;

import java.util.Locale;

import com.zohar.herop.common.Constant;
import com.zohar.herop.common.RegUtil;

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
		System.out.println(RegUtil.regFindByGroup("sf\\.allName=\\[(.*)\\];$", "sf.allName=[\"ql\", \"lo\"];", 1));
	}

}
