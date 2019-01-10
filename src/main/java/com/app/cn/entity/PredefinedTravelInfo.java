package com.app.cn.entity;

public class PredefinedTravelInfo {
	private Integer id;
	private String username;//发起人
	private String activityName;//活动名称
	private String area;
	private String specificLocation;
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
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSpecificLocation() {
		return specificLocation;
	}
	public void setSpecificLocation(String specificLocation) {
		this.specificLocation = specificLocation;
	}
}
