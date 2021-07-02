package com.hallbooking.customer.iclass;

public class ErrorInfo {
	private String msg;
	private String errorMsg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public ErrorInfo(String msg, String errorMsg) {
		super();
		this.msg = msg;
		this.errorMsg = errorMsg;
	}
	public ErrorInfo() {
		
	}
	
}
