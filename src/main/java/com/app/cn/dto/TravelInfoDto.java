package com.app.cn.dto;

import com.app.cn.entity.TravelInfo;

public class TravelInfoDto {
	//no:此次操作失败;ok:此次操作成功
	private String success;
	
	private String errMsg;
	private TravelInfo data;
	
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
	public TravelInfo getData() {
		return data;
	}
	public void setData(TravelInfo data) {
		this.data = data;
	}
	
}
