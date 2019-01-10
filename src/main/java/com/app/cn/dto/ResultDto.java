package com.app.cn.dto;

public class ResultDto<T> {
	//success=ok表示操作成功，success=no表示操作失败
	private String success;
	private String errMsg;
	
	private T result;
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
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
}
