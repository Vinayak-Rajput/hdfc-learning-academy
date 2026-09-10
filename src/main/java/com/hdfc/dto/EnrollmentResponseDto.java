package com.hdfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EnrollmentResponseDto {

	private Integer courseId;
	private String status;
}
