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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/enrollments")
@Tag(name = "Enrollment APIs", description = "Operations for Enrollment System")
public class EnrollmentController {
	
	EnrollmentService enrollmentService;

	public EnrollmentController(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}

	@PostMapping
	@Operation(
			summary = "Create Enrollment", 
			description = "Create a new enrollment resource.",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Payload to create Enrollment resource", 
					required = true, 
					content = @Content(
							schema = @Schema(implementation = EnrollmentRequestDto.class)
							)
					)
			)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "201",
					description = "Successfully created a new employee resource",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EnrollmentResponseDto.class)
						)	
					),
			
			@ApiResponse(
					responseCode = "404",
					description = "Course Not Found",
					content = @Content
					),
			
			@ApiResponse(
					responseCode = "400",
					description = "Course Capacity Full",
					content = @Content
					),
			
			@ApiResponse(
					responseCode = "409",
					description = "Already Enrolled",
					content = @Content
					)
				}
	)
	public ResponseEntity<EnrollmentResponseDto> create(@RequestBody EnrollmentRequestDto enrollmentRequestDto){
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(enrollmentService.enrollEmployee(enrollmentRequestDto));
	}
	
	@GetMapping
	@Operation( summary = "Get All Enrollments", description = "Get all enrollment resources.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched all Enrollments details.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EnrollmentResponseDto.class)
						)	
				)
	public ResponseEntity<List<EnrollmentResponseDto>> getAll(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getAllEnrollments());
	}
	
	@GetMapping("/{id}")
	@Operation( summary = "Get Enrollment By ID", description = "Get an enrollment resource by ID reference.")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Fetched the required Enrollment details.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EnrollmentResponseDto.class)
						)	
					),
			
			@ApiResponse(
					responseCode = "404",
					description = "Enrollment Not Found",
					content = @Content
					)
			}
	)
	public ResponseEntity<EnrollmentResponseDto> getById(@PathVariable Integer id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getEnrollmentById(id));
	}
	
	@PutMapping("/{id}/cancel")
	@Operation( summary = "Cancel Enrollment", description = "Set status for enrollment as \'CANCELLED\'.")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Cancelled Successfully.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EnrollmentResponseDto.class)
						)	
					),
			
			@ApiResponse(
					responseCode = "404",
					description = "Enrollment Not Found",
					content = @Content
					)
			}
	)
	public ResponseEntity<EnrollmentResponseDto> cancel(@PathVariable Integer id) {
		
		enrollmentService.cancelEnrollment(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}
	
	@PutMapping("/{id}/complete")
	@Operation( summary = "Complete Course", description = "Set status for course as \'COMPLETED\'.")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Completed Successfully.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EnrollmentResponseDto.class)
						)	
					),
			
			@ApiResponse(
					responseCode = "404",
					description = "Enrollment For Update Not Found",
					content = @Content
					)
			}
	)
	public ResponseEntity<EnrollmentResponseDto> complete(@PathVariable Integer id) {
		
		enrollmentService.completeEnrollment(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(null);
	}
	
	@GetMapping("/status/{status}")
	@Operation( summary = "Get Enrollments By Status", description = "Get all enrollment resources for status.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched the required Enrollments.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EnrollmentResponseDto.class)
						)	
				)
	public ResponseEntity<List<EnrollmentResponseDto>> getEnrollmentsByStatus(@PathVariable String status){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getEnrollmentsByStatus(status));
		
	}
	
	@GetMapping("/employee/{employeeId}")
	@Operation( summary = "Get Enrollments By Employee ID", description = "Get all enrollment resources for employee ID.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched the required Enrollments.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = EnrollmentResponseDto.class)
						)	
				)
	public ResponseEntity<List<EnrollmentResponseDto>> getEnrollmentsByEmployeeId(@PathVariable Integer empId){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(enrollmentService.getEnrollmentsByEmployeeId(empId));
		
	}
}
