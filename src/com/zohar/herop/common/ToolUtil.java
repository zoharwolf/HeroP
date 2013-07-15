package com.zohar.herop.common;

import java.util.Collection;

public class ToolUtil {
	public static <T> boolean isNullOrEmpty(Collection<T> col){
		if (col==null || col.size()==0){
			return true;
		} else{
			return false;
		}
	}
}
