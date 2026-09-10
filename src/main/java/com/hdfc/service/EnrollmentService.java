package com.hdfc.service;

import java.util.List;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;

public interface EnrollmentService {
	
	EnrollmentResponseDto enrollEmployee(EnrollmentRequestDto dto);
	List<EnrollmentResponseDto> getAllEnrollments();
	EnrollmentResponseDto getEnrollmentById(Integer id);
	EnrollmentResponseDto cancelEnrollment(Integer id);
    EnrollmentResponseDto completeEnrollment(Integer id);
	List<EnrollmentResponseDto> getEnrollmentsByStatus(String status);
	List<EnrollmentResponseDto> getEnrollmentsByEmployeeId(Integer empId);
}
