package com.app.cn.entity;

public class DiscussionBeforeTravel {
	private Integer id;
	private Integer userId;
	private String username;
	private Integer activityId;
	private String words;//用户的文字评论
	private String filePath;//文件相对路径
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "DiscussionBeforeTravel [id=" + id + ", userId=" + userId + ", username=" + username + ", activityId="
				+ activityId + ", words=" + words + ", filePath=" + filePath + "]";
	}
	
}
