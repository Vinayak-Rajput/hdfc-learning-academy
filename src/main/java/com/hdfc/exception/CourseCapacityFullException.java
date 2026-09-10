package com.hdfc.exception;

@SuppressWarnings("serial")
public class CourseCapacityFullException extends RuntimeException {

	public CourseCapacityFullException(String message) {
		super(message);
	}
}
