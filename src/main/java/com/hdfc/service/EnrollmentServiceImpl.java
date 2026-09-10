package com.hdfc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;
import com.hdfc.entity.Enrollment;
import com.hdfc.exception.CourseCapacityFullException;
import com.hdfc.exception.CourseNotFoundException;
import com.hdfc.exception.DuplicateEnrollmentException;
import com.hdfc.exception.EnrollmentNotFoundException;
import com.hdfc.mapper.EnrollmentMapper;
import com.hdfc.repository.CourseRepository;
import com.hdfc.repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	
	private EnrollmentRepository enrollmentRepository;
	private CourseRepository courseRepository;
	private EnrollmentMapper enrollmentMapper;

	public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository,
			EnrollmentMapper enrollmentMapper) {
		super();
		this.enrollmentRepository = enrollmentRepository;
		this.courseRepository = courseRepository;
		this.enrollmentMapper = enrollmentMapper;
	}

	@Override
	public EnrollmentResponseDto enrollEmployee(EnrollmentRequestDto dto) {
		
		if(courseRepository.findById(dto.getCourseId()) == null) {
				
			throw new CourseNotFoundException("Course with Course ID " + dto.getCourseId() + " doesn't exist.");
		}
		
		if(isCourseAlreadyEnrolled(enrollmentMapper.toEntity(dto))) {
			
			throw new DuplicateEnrollmentException("Already Enrolled in Course with Course ID " + dto.getCourseId());
		}
		
		if(courseRepository.findById(dto.getCourseId()).getMaxCapacity() <= currentCapacityCounter(dto.getCourseId())) {
			
			throw new CourseCapacityFullException("Capacity for CourseId " + dto.getCourseId() + " exceeded.");
		} 		
		
		return enrollmentMapper.toDto(enrollmentRepository.save(enrollmentMapper.toEntity(dto)));
	}
	
	public List<EnrollmentResponseDto> getAllEnrollments() {
		
		return enrollmentRepository.findAll().stream()
				.map(enrollmentMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public EnrollmentResponseDto getEnrollmentById(Integer id) { 
		
		Enrollment enrollment = enrollmentRepository.findById(id);
		
		if(enrollment == null) {
			
			throw new EnrollmentNotFoundException("Enrollment with ID " + id + " doesn't exist.");
		}
		
		return enrollmentMapper.toDto(enrollment);
	}
	
	public EnrollmentResponseDto cancelEnrollment(Integer id) {
		
		Enrollment enrollment = enrollmentRepository.findById(id);
		
		if(enrollment == null) {
			
			throw new EnrollmentNotFoundException("Enrollment with ID " + id + " doesn't exist.");
		}
		
		enrollmentRepository.updateStatusCancel(id);
		
		return enrollmentMapper.toDto(enrollment);
	}
	
	public EnrollmentResponseDto completeEnrollment(Integer id) {
		
		Enrollment enrollment = enrollmentRepository.findById(id);
		
		if(enrollment == null) {
			
			throw new EnrollmentNotFoundException("Enrollment with ID " + id + " doesn't exist.");
		}
		
		enrollmentRepository.updateStatusCompleted(id);
		
		return enrollmentMapper.toDto(enrollment);
	}

	@Override
	public List<EnrollmentResponseDto> getEnrollmentsByStatus(String status) {
		
		return enrollmentRepository.findAll().stream()
				.filter(enrollment -> enrollment.getStatus().equalsIgnoreCase(status))
				.map(enrollmentMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EnrollmentResponseDto> getEnrollmentsByEmployeeId(Integer empId) {
		
		return enrollmentRepository.findAll().stream()
				.filter(enrollment -> enrollment.getEmployeeId().equals(empId))
				.map(enrollmentMapper::toDto)
				.collect(Collectors.toList());
	}
	
	public Integer currentCapacityCounter(Integer courseId) {
		
		Integer count = 0;
		
		for(Enrollment enrollment: enrollmentRepository.findAll()) {
			
			if(enrollment.getCourseId() == courseId) {
			
				count++;
			}
		}
		
		return count;
	}
	
	public boolean isCourseAlreadyEnrolled(Enrollment enrollment) {
		
		for(Enrollment en : enrollmentRepository.findAll()) { 
		
			if(en.getEmployeeId() == enrollment.getEmployeeId() && en.getCourseId() == enrollment.getCourseId())
				return true;
		}
		
		return false;
	}

}
