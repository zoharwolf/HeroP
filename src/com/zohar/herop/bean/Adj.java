/*
 * @(#)Adj.java	1.0 2013-6-28
 *
 */
package com.zohar.herop.bean;

import java.util.Map;

/**
 * 
 * 
 * @author zohar
 * @version 1.0, 2013-6-28
 */
public class Adj {
	public static final int TYPE_BIONT = 1;
	public static final int TYPE_ITEM = 2;
	
	private String name;
	private int type;
	private Map<String, Integer> fixAttr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getFixAttr() {
		return fixAttr;
	}
	public void setFixAttr(Map<String, Integer> fixAttr) {
		this.fixAttr = fixAttr;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
