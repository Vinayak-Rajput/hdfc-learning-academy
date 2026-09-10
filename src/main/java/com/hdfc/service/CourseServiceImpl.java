package com.hdfc.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.entity.Course;
import com.hdfc.exception.CourseNotFoundException;
import com.hdfc.mapper.CourseMapper;
import com.hdfc.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	private final CourseRepository courseRepository;
	private final CourseMapper courseMapper;

	public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {

		this.courseRepository = courseRepository;
		this.courseMapper = courseMapper;
	}
	
	@Override
	public CourseResponseDto createCourse(CourseRequestDto course) {

		return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(course)));
	}

	@Override
	public List<CourseResponseDto> getAllCourses() {
		
		return courseRepository.findAll().stream()
				.map(courseMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public CourseResponseDto getCourseById(Integer id) {
		
		Course course = courseRepository.findById(id);
		
		if(course == null) {
			
			throw new CourseNotFoundException("Course with ID " + id + " not found.");
		}

		return courseMapper.toDto(course);
	}

	@Override
	public CourseResponseDto updateCourse(Integer id, CourseRequestDto courseDto) {
	
		Course course = courseRepository.update(id, courseMapper.toEntity(courseDto));
		
		if(course == null) {
			
			throw new CourseNotFoundException("Course with ID " + id + " not found.");
		}
		
		return courseMapper.toDto(course);
	}

	@Override
	public CourseResponseDto deleteCourse(Integer id) {
		
		Course course = courseRepository.delete(id);
		
		if(course == null) {
			
			throw new CourseNotFoundException("Course with ID " + id + " not found.");
		}

		return courseMapper.toDto(course);
	}

	@Override
	public List<CourseResponseDto> getCoursesByTrainer(String trainerName) {
		
		return courseRepository.findAll().stream()
				.filter(course -> course.getTrainerName().equals(trainerName))
				.map(courseMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<CourseResponseDto> getCoursesByFeeLimit(Double fees) {
		
		return courseRepository.findAll().stream()
				.filter(course -> course.getFees() < fees)
				.map(courseMapper::toDto)
				.collect(Collectors.toList());
	}
	
	

}
