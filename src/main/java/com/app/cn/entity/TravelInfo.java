package com.app.cn.entity;


public class TravelInfo {
	private Integer id;
	private String username;
	private String toWhere;
	private String startTime;
	private Integer peopleNum;
	private Integer process;//0代表进行中的活动，1代表已经结束的活动
	private String descInfo;
	private String releaseTime;
	private Integer usernameId;
	
	public Integer getUsernameId() {
		return usernameId;
	}
	public void setUsernameId(Integer usernameId) {
		this.usernameId = usernameId;
	}
	public String getDescInfo() {
		return descInfo;
	}
	public void setDescInfo(String descInfo) {
		this.descInfo = descInfo;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Integer getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}
	@Override
	public String toString() {
		return "TravelInfo [id=" + id + ", username=" + username + ", toWhere=" + toWhere + ", startTime=" + startTime
				+ ", peopleNum=" + peopleNum + ", process=" + process + ", descInfo=" + descInfo + ", releaseTime="
				+ startTime + ", usernameId=" + usernameId + "]";
	}
}
