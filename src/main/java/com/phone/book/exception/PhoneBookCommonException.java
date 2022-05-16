package com.phone.book.exception;

/**
 * @author vivek
 *
 */
public class PhoneBookCommonException extends Exception {

	private int statusCode = 500;
	private String errorCode;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PhoneBookCommonException(String message) {
		super(message);
	}

	public PhoneBookCommonException(String message, Throwable cause) {
		super(message, cause);

	}

	public PhoneBookCommonException(String message, int statusCode, String errorCode, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
		this.errorCode = errorCode;

	}
	
	public PhoneBookCommonException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;

	}

	public PhoneBookCommonException(Throwable cause) {
		super(cause);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}