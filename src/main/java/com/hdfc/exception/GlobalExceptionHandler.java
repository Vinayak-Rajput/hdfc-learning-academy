package com.hdfc.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private Map<String, Object> createErrorBody(HttpStatus status, String message) {
		
		Map<String, Object> body = new HashMap<>();
		
		body.put("Status", status.value());
		body.put("Message", message);
		body.put("Timestamp", LocalDateTime.now().toString());
		
		return body;
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleCourseNotFound(CourseNotFoundException exception) {
        return ResponseEntity
        		.status(HttpStatus.NOT_FOUND)
        		.body(createErrorBody(HttpStatus.NOT_FOUND, exception.getMessage()));
	}
	
	@ExceptionHandler(EnrollmentNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleEnrollmentNotFound(CourseNotFoundException exception) {
        return ResponseEntity
        		.status(HttpStatus.NOT_FOUND)
        		.body(createErrorBody(HttpStatus.NOT_FOUND, exception.getMessage()));
	}
	
	@ExceptionHandler(DuplicateEnrollmentException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateEnrollment(DuplicateEnrollmentException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(createErrorBody(HttpStatus.CONFLICT, ex.getMessage()));
    }

	@ExceptionHandler(CourseCapacityFullException.class)
    public ResponseEntity<Map<String, Object>> handleCourseCapacityFull(CourseCapacityFullException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(createErrorBody(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
}
