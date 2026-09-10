package com.hdfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseResponseDto {

	private Integer courseId;
	private String courseName;
	private String trainerName;
	private Integer durationInDays;
	private Integer maxCapacity;
	private Double fees;
}
