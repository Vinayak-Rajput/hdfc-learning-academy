package com.hdfc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.dto.CourseResponseDto;
import com.hdfc.service.AnalyticsService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	AnalyticsService analyticsService;
	
	public AnalyticsController(AnalyticsService analyticsService) {
		this.analyticsService = analyticsService;
	}
	
	@GetMapping("/course-count")
	public ResponseEntity<Integer> getCoursesCount(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(analyticsService.getCoursesCount());
	}
	
	@GetMapping("enrollment-count")
	public ResponseEntity<Integer> getEnrollmentsCount(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(analyticsService.getEnrollmentsCount());
	}
	
	@GetMapping("most-popular-course")
	public ResponseEntity<CourseResponseDto> getMostPopularCourse(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(analyticsService.getMostPopularCourse());
	}
}
