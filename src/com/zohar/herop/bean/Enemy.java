/*
 * @(#)Enemy.java	1.0 2013-6-28
 *
 */
package com.zohar.herop.bean;

import java.util.List;

/**
 * 
 * 
 * @author zohar
 * @version 1.0, 2013-6-28
 */
public class Enemy extends Biont {
	List<Item> relic;
	int exp;
	int gold;

	public List<Item> getRelic() {
		return relic;
	}

	public void setRelic(List<Item> relic) {
		this.relic = relic;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	
}
