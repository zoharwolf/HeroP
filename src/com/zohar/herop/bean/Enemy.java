/*
 * @(#)Enemy.java	1.0 2013-6-28
 *
 */
package com.zohar.herop.bean;

import java.util.List;

/**
 * 
 * 
 * @author Administrator
 * @version 1.0, 2013-6-28
 */
public class Enemy extends Biont {
	List<Item> relic;

	public List<Item> getRelic() {
		return relic;
	}

	public void setRelic(List<Item> relic) {
		this.relic = relic;
	}
}
