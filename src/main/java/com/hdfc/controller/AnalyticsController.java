package com.hdfc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.CourseResponseDto;
import com.hdfc.service.AnalyticsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/analytics")
@Tag(name = "Analytics APIs", description = "Operations for Analytics System")
public class AnalyticsController {

	AnalyticsService analyticsService;
	
	public AnalyticsController(AnalyticsService analyticsService) {
		this.analyticsService = analyticsService;
	}
	
	@GetMapping("/course-count")
	@Operation( summary = "Get Courses Count", description = "Get total count of courses.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched the courses count.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = Integer.class)
						)	
				)
	public ResponseEntity<Integer> getCoursesCount(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(analyticsService.getCoursesCount());
	}
	
	@GetMapping("/enrollment-count")
	@Operation( summary = "Get Enrollments Count", description = "Get total count of enrollments.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched the enrollments count.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = Integer.class)
						)	
				)
	public ResponseEntity<Integer> getEnrollmentsCount(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(analyticsService.getEnrollmentsCount());
	}
	
	@GetMapping("/most-popular-course")
	@Operation( summary = "Get Most Popular Course", description = "Get course with most enrollments.")
	@ApiResponse(
					responseCode = "200",
					description = "Fetched the most popular course.",
					content = @Content(
							mediaType = "application/json",
							schema = @Schema(implementation = CourseResponseDto.class)
						)	
				)
	public ResponseEntity<CourseResponseDto> getMostPopularCourse(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(analyticsService.getMostPopularCourse());
	}
}
