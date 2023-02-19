package com.sp.micro.user_s.exceptions;

public class ResourceNotFoundExc extends RuntimeException{
	public ResourceNotFoundExc() {
		super("Resource not found on server!!");
	}
	public ResourceNotFoundExc(String msg) {
		super(msg);
	}
}
