package com.app.cn.entity;

import java.util.Date;

public class TravelInfo {
	private Integer id;
	private String username;
	private String toWhere;
	private Date startTime;
	private Integer peopleNum;
	private Integer process;//0代表进行中的活动，1代表已经结束的活动
	private String descInfo;
	private Date releaseTime;
	
	public String getDescInfo() {
		return descInfo;
	}
	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Integer getProcess() {
		return process;
	}
	public void setProcess(Integer process) {
		this.process = process;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getToWhere() {
		return toWhere;
	}
	public void setToWhere(String toWhere) {
		this.toWhere = toWhere;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Integer getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}
}
