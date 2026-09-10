package com.hdfc.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hdfc.dto.CourseResponseDto;
import com.hdfc.entity.Enrollment;
import com.hdfc.mapper.CourseMapper;
import com.hdfc.repository.CourseRepository;
import com.hdfc.repository.EnrollmentRepository;

@Service
public class AnalyticsServiceImpl implements AnalyticsService{
	
	private EnrollmentRepository enrollmentRepository;
	private CourseRepository courseRepository;
	private CourseMapper courseMapper;
	
	public AnalyticsServiceImpl(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository,
			CourseMapper courseMapper) {
		super();
		this.enrollmentRepository = enrollmentRepository;
		this.courseRepository = courseRepository;
		this.courseMapper = courseMapper;
	}

	@Override
	public Integer getCoursesCount() {

		return (int) courseRepository
				.findAll()
				.stream()
				.count();
	}

	@Override
	public Integer getEnrollmentsCount() {

		return (int) enrollmentRepository
				.findAll()
				.stream()
				.count();
	}

	@Override
	public CourseResponseDto getMostPopularCourse() {
	
		List<Enrollment> enrollments = enrollmentRepository.findAll();
		
		Optional<Integer> requiredCourse = enrollments.stream()
				.collect(Collectors.groupingBy(Enrollment::getCourseId, Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey);

		return courseMapper.toDto(courseRepository.findById(requiredCourse.get()));
	}

}
