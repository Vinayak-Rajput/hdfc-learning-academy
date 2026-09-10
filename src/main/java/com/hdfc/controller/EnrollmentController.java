package com.hdfc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;

import com.hdfc.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
	
	EnrollmentService enrollmentService;

	public EnrollmentController(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}

	@PostMapping
	public ResponseEntity<EnrollmentResponseDto> create(@RequestBody EnrollmentRequestDto enrollmentRequestDto){
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(enrollmentService.enrollEmployee(enrollmentRequestDto));
	}
	
	@GetMapping
	public ResponseEntity<List<EnrollmentResponseDto>> getAll(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getAllEnrollments());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EnrollmentResponseDto> getById(@PathVariable Integer id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getEnrollmentById(id));
	}
	
	@PutMapping("/{id}/cancel")
	public ResponseEntity<EnrollmentResponseDto> cancel(@PathVariable Integer id) {
		
		enrollmentService.cancelEnrollment(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}
	
	@PutMapping("/{id}/complete")
	public ResponseEntity<?> complete(@PathVariable Integer id) {
		
		enrollmentService.completeEnrollment(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<EnrollmentResponseDto>> getEnrollmentsByStatus(@PathVariable String status){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getEnrollmentsByStatus(status));
		
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<EnrollmentResponseDto>> getEnrollmentsByEmployeeId(@PathVariable Integer empId){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getEnrollmentsByEmployeeId(empId));
		
	}
}
