package com.hallbooking.vendor.exception;

public class VendorTypeNotFoundException extends RuntimeException{
	public VendorTypeNotFoundException() {}
	public VendorTypeNotFoundException(String message) {
		super(message);
	}

}
