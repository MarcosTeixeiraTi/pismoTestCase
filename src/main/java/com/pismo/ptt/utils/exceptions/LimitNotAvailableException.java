package com.pismo.ptt.utils.exceptions;

public class LimitNotAvailableException extends Exception {
	
	private static final long serialVersionUID = -1L;
	
	public LimitNotAvailableException() {
		super();
	}
	
	public LimitNotAvailableException(String msg) {
		super(msg);
	}
}