package com.hdfc.service;

import com.hdfc.dto.CourseResponseDto;

public interface AnalyticsService {

	Integer getCoursesCount();
	Integer getEnrollmentsCount();
	CourseResponseDto getMostPopularCourse();
	
}
