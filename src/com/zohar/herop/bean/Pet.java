/*
 * @(#)Pet.java	1.0 2013-6-28
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
public class Pet extends Biont {
	List<Equip> equips;
	private int exp;
	private int nextExp;
	public List<Equip> getEquips() {
		return equips;
	}
	public void setEquips(List<Equip> equips) {
		this.equips = equips;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getNextExp() {
		return nextExp;
	}
	public void setNextExp(int nextExp) {
		this.nextExp = nextExp;
	}
}
