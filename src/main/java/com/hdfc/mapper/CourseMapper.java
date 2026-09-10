package com.hdfc.mapper;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.entity.Course;

public interface CourseMapper {
    CourseResponseDto toDto(Course employee);
    Course toEntity(CourseRequestDto dto);
}
