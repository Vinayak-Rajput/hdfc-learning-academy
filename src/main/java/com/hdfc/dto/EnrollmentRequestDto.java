package com.hdfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EnrollmentRequestDto {

	private Integer employeeId;
	private String employeeName;
	private Integer courseId;
	
}
