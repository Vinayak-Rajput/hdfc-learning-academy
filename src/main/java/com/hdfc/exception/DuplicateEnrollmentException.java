package com.hdfc.exception;

@SuppressWarnings("serial")
public class DuplicateEnrollmentException extends RuntimeException {
	
	public DuplicateEnrollmentException(String message) {
	
		super(message);
	}
}
