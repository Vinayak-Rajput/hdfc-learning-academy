package com.hdfc.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Enrollment {
	
	private Integer enrollmentId;
	private Integer employeeId;
	private String employeeName;
	private Integer courseId;
	private LocalDate enrollmentDate;
	private String status; //ENROLLED COMPLETED CANCELLED
}
