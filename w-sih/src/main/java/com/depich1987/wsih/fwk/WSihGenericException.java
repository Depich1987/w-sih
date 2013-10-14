package com.depich1987.wsih.fwk;

public class WSihGenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2481445236843219301L;
	
	public WSihGenericException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param message
	 */
	public WSihGenericException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public WSihGenericException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WSihGenericException(String message, Throwable cause) {
		super(message, cause);
	}

}
