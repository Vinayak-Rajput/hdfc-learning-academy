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

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping
	public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseRequestDto course){
		
		return  ResponseEntity
				.status(HttpStatus.CREATED)
				.body(courseService.createCourse(course));
	}
	
	@GetMapping
	public ResponseEntity<List<CourseResponseDto>> getAllCourses(){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getAllCourses());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Integer id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getCourseById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CourseResponseDto> updateCourse(@PathVariable Integer id,@RequestBody CourseRequestDto dto){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.updateCourse(id, dto));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<CourseResponseDto> deleteCourse(@PathVariable Integer id){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.deleteCourse(id));
	}
	
	@GetMapping("/trainer/{trainerName}")
	public ResponseEntity<List<CourseResponseDto>> getCoursesByTrainer(@PathVariable String trainerName){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getCoursesByTrainer(trainerName));		
	}
	
	@GetMapping("/fees/{amount}")
	public ResponseEntity<List<CourseResponseDto>> getCoursesByFeeLimit(@PathVariable Double fees){
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(courseService.getCoursesByFeeLimit(fees));
	}
}
