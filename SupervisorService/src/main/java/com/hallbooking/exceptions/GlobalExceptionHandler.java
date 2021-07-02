package com.hallbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> exceptionHandler(IdNotFoundException idn)
	{
		CustomErrorResponse resp=new CustomErrorResponse("ID Not Found",idn.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
	}
	
}