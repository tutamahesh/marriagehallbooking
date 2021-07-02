package com.hallbooking.vendor.exception;

public class VendorNotFoundException extends RuntimeException{
	
	public VendorNotFoundException() {}
	public VendorNotFoundException(String message) {
		super(message);
	}
}
