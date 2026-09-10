package com.hdfc.exception;

@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException{
	
	public CourseNotFoundException(String message) {
		super(message);
	}

}
