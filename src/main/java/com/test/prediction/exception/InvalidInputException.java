package com.test.prediction.exception;

public class InvalidInputException extends Exception{

	private static final long serialVersionUID = -5557649170716852753L;

	private final String errorMessage;

	public InvalidInputException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
