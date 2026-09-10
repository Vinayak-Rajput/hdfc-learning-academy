package com.hdfc.entity;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
	
	private Integer courseId;
	private String courseName;
	private String trainerName;
	
	@Positive
	private Integer durationInDays;
	private Integer maxCapacity;
	
	@Positive
	private Double fees;
}
