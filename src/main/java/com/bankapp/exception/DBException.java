package com.bankapp.exception;

public class DBException  extends Exception{

	public DBException(String message, Throwable t) {
		super(message,t);
	}
}
