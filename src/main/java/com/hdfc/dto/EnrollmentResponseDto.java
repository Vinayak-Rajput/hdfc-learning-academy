package com.hdfc.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EnrollmentResponseDto {

	private Integer enrollmentId;
	private Integer employeeId;
	private String employeeName;
	private Integer courseId;
	private LocalDate enrollmentDate;
	private String status;
}
