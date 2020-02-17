package com.toec.execption;

public class ServiceExeception extends RuntimeException {
	
	private static final long serialVersionUID = 4033463470530855170L;
	public ServiceExeception() {
		super();
	}
	public ServiceExeception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ServiceExeception(String message, Throwable cause) {
		super(message, cause);
	}
	public ServiceExeception(String message) {
		super(message);
	}
	public ServiceExeception(Throwable cause) {
		super(cause);
	}
}
