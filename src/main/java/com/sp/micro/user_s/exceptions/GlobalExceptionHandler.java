package com.sp.micro.user_s.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sp.micro.user_s.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundExc.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundExc ex){
		
		String message=ex.getMessage();
		ApiResponse response=ApiResponse.builder().msg(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
