/*
 * @(#)RegUtil.java	1.0 2013-7-15
 *
 * 北京木联能软件技术有限公司.
 */
package com.zohar.herop.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * regEx: regular expression
 * s: the String will be checked
 * i: group index of the reg
 *  
 * @author Administrator
 * @version 1.0, 2013-7-15
 */
public class RegUtil {
	public static String regFindByGroup(String regEx, String s, int i){
		String[] groups = regFindByGroup(regEx, s);
		if (groups!=null){
			return groups[i]; 
		} else{
			return null;
		}
	}
	
	public static String[] regFindByGroup(String regEx, String s){
		Pattern pat = Pattern.compile(regEx);  
		Matcher mat = pat.matcher(s);  
		boolean rs = mat.find();
		if (rs && mat.groupCount()>0){
			String[] groups = new String[mat.groupCount()+1];
			for (int i=1;i<groups.length;i++){
				groups[i] = mat.group(i);
			}
			return groups;
		}
		return null;
	}
}
