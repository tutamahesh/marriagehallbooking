package com.hallbooking.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> exceptionHandler(IDNotFoundException idn)
	{
		CustomErrorResponse resp=new CustomErrorResponse("ID Not Found",idn.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
	}
}
