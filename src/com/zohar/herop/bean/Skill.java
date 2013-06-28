/*
 * @(#)Skill.java	1.0 2013-6-28
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
public class Skill {
	String name;
	Map<String, Integer> consumeMap; // key-consume attr name, value-consume value
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Integer> getConsumeMap() {
		return consumeMap;
	}
	public void setConsumeMap(Map<String, Integer> consumeMap) {
		this.consumeMap = consumeMap;
	}
}
