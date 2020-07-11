package com.oracle.challenge.fibonacci.exception;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 3620980532720315841L;
	private final int errorCode;

	private final String message;

	public InvalidInputException(int errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public int getErrorCode() {
		return errorCode;
	}
}
