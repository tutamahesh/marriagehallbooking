package com.hallbooking.customer.iclass;

public class SuccessInfo {
	private String message;
	private String successMsg;

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SuccessInfo() {
	
	}

	public SuccessInfo(String message, String successMsg) {
		
		this.message = message;
		this.successMsg = successMsg;
	}
	
	
}
