package com.hdfc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/courses")
@Tag(name = "Courses APIs", description = "Operations for Course Management System")
public class CourseController {
	
	private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping
	@Operation(
			summary = "Create Course", 
			description = "Create a new course resource.",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Payload to create Course resource", 
					required = true, 
					content = @Content(
							schema = @Schema(implementation = CourseRequestDto.class)
							)
					)
			)
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "201",
					description = "Successfully created a new copurse resource",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
					)
			}
	)
	public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto course){
		
		return  ResponseEntity
				.status(HttpStatus.CREATED)
				.body(courseService.createCourse(course));
	}
	
	@GetMapping
	@Operation( summary = "Get All Courses", description = "Get all course resources.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched all Course details.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
				)
	public ResponseEntity<List<CourseResponseDto>> getAllCourses(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getAllCourses());
		
	}
	
	@GetMapping("/{id}")
	@Operation( summary = "Get Course By ID", description = "Get an course resource by ID reference.")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Fetched the required Course details.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
					),
			
			@ApiResponse(
					responseCode = "404",
					description = "Course Not Found",
					content = @Content
					)
			}
	)
	public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Integer id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getCourseById(id));
	}
	
	@PutMapping("/{id}")
	@Operation( summary = "Update Course", description = "Update Course Details.")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Updated Successfully.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
					),
			
			@ApiResponse(
					responseCode = "404",
					description = "Course Not Found",
					content = @Content
					)
			}
	)
	public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Integer id,@RequestBody CourseRequestDto dto){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.updateCourse(id, dto));
	}
	
	@DeleteMapping("{id}")
	@Operation( summary = "Delete Course", description = "Delete Course Details.")
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200",
					description = "Deleted Successfully.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
					),
			
			@ApiResponse(
					responseCode = "404",
					description = "Course Not Found",
					content = @Content
					)
			}
	)
	public ResponseEntity<CourseResponseDto> deleteCourse(@PathVariable Integer id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.deleteCourse(id));
	}
	
	@GetMapping("/trainer/{trainerName}")
	@Operation( summary = "Get Courses By Trainer Name", description = "Get all course resources for given trainer.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched the required Courses.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
				)
	public ResponseEntity<List<CourseResponseDto>> getCoursesByTrainer(@PathVariable String trainerName){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getCoursesByTrainer(trainerName));		
	}
	
	@GetMapping("/fees/{fees}")
	@Operation( summary = "Get Courses By Fees Less Than", description = "Get all course resources for fees less than given fee amount.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched the required Courses.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
				)
	public ResponseEntity<List<CourseResponseDto>> getCoursesByFeeLimit(@PathVariable Double fees){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getCoursesByFeeLimit(fees));
	}
}
