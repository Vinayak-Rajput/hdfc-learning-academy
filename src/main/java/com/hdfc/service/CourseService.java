package com.hdfc.service;

import java.util.List;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;

public interface CourseService {
	
	List<CourseResponseDto> getAllCourses();
	CourseResponseDto getCourseById(Integer id);
	CourseResponseDto createCourse(CourseRequestDto course);
	CourseResponseDto updateCourse(Integer id,CourseRequestDto course);
	CourseResponseDto deleteCourse(Integer id);
	List<CourseResponseDto> getCoursesByTrainer(String trainerName);
	List<CourseResponseDto> getCoursesByFeeLimit(Double fees);
}
