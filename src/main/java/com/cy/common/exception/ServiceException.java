package com.cy.common.exception;

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1805709249498414780L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
	}

}
