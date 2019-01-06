package com.app.cn.dto;

import com.app.cn.entity.User;

public class UserDto {
	//no:此次操作失败;ok:此次操作成功
	private String success;
	
	private String errMsg;
	private User user;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
