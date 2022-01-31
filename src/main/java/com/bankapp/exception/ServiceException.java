package com.bankapp.exception;

public class ServiceException extends Exception{

	public ServiceException(String message, Throwable t) {
		super(message,t);
	}
	
	public ServiceException( Throwable t) {
		super(t);
	}
}
