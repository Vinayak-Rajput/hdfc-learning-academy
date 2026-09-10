package com.hdfc.mapper;

import org.springframework.stereotype.Component;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;
import com.hdfc.entity.Enrollment;

@Component
public class EnrollmentMapperImpl implements EnrollmentMapper {

	@Override
	public EnrollmentResponseDto toDto(Enrollment enrollment) {
		
		EnrollmentResponseDto enrollmentResponseDto = new EnrollmentResponseDto();
		
		enrollmentResponseDto.setCourseId(enrollment.getCourseId());
		enrollmentResponseDto.setStatus(enrollment.getStatus());
		
		return enrollmentResponseDto;
	}

	@Override
	public Enrollment toEntity(EnrollmentRequestDto dto) {
		
		Enrollment enrollment = new Enrollment();
		
		enrollment.setCourseId(dto.getCourseId());
		enrollment.setEmployeeId(dto.getEmployeeId());
		enrollment.setEmployeeName(dto.getEmployeeName());

		return enrollment;
	}

}
