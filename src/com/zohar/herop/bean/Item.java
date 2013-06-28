/*
 * @(#)Item.java	1.0 2013-6-28
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
public class Item {
	List<Adj> adjs;
	private int price;
	public List<Adj> getAdjs() {
		return adjs;
	}
	public void setAdjs(List<Adj> adjs) {
		this.adjs = adjs;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
