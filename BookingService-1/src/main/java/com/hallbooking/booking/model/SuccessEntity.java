package com.hallbooking.booking.model;

public class SuccessEntity {
	private String message;
	private String result;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public SuccessEntity(String message, String result) {
		this.message = message;
		this.result = result;
	}
	public SuccessEntity() {
		
	}
	
}
