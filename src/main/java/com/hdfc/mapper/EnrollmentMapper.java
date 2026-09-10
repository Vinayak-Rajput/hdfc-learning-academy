package com.hdfc.mapper;

import com.hdfc.dto.EnrollmentRequestDto;
import com.hdfc.dto.EnrollmentResponseDto;
import com.hdfc.entity.Enrollment;

public interface EnrollmentMapper {
    EnrollmentResponseDto toDto(Enrollment enrollment);
    Enrollment toEntity(EnrollmentRequestDto dto);
}
