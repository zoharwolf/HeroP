/*
 * @(#)Biont.java	1.0 2013-6-28
 *
 */
package com.zohar.herop.bean;

import java.util.List;

/**
 * 
 * @author zohar
 * @version 1.0, 2013-6-28
 */
public class Biont {
	private List<Adj> adj;
	private String name;
	private String desc;
	private int bodyPic;
	private int facePic;
	private int lv;
	private int hp;
	private int mhp;
	private int sp;
	private int msp;
	private int ap;
	private int map;
	private List<Status> statuses;
	private int atk;
	private int dfn;
	private int satk;
	private int sdfn;
	private int str;
	private int itg;
	private int spd;
	private int luk;
	private List<Skill> skills;
	
	public List<Adj> getAdj() {
		return adj;
	}
	public void setAdj(List<Adj> adj) {
		this.adj = adj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getBodyPic() {
		return bodyPic;
	}
	public void setBodyPic(int bodyPic) {
		this.bodyPic = bodyPic;
	}
	public int getFacePic() {
		return facePic;
	}
	public void setFacePic(int facePic) {
		this.facePic = facePic;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMhp() {
		return mhp;
	}
	public void setMhp(int mhp) {
		this.mhp = mhp;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getMsp() {
		return msp;
	}
	public void setMsp(int msp) {
		this.msp = msp;
	}
	public int getAp() {
		return ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}
	public int getMap() {
		return map;
	}
	public void setMap(int map) {
		this.map = map;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDfn() {
		return dfn;
	}
	public void setDfn(int dfn) {
		this.dfn = dfn;
	}
	public int getSatk() {
		return satk;
	}
	public void setSatk(int satk) {
		this.satk = satk;
	}
	public int getSdfn() {
		return sdfn;
	}
	public void setSdfn(int sdfn) {
		this.sdfn = sdfn;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getItg() {
		return itg;
	}
	public void setItg(int itg) {
		this.itg = itg;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public int getLuk() {
		return luk;
	}
	public void setLuk(int luk) {
		this.luk = luk;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public List<Status> getStatuses() {
		return statuses;
	}
	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}
}
