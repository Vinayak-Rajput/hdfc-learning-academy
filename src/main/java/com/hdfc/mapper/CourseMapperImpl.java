package com.hdfc.mapper;

import org.springframework.stereotype.Component;

import com.hdfc.dto.CourseRequestDto;
import com.hdfc.dto.CourseResponseDto;
import com.hdfc.entity.Course;

@Component
public class CourseMapperImpl implements CourseMapper {

	@Override
	public CourseResponseDto toDto(Course course) {
		
		CourseResponseDto courseResponseDto = new CourseResponseDto();
		
		courseResponseDto.setCourseId(course.getCourseId());
		courseResponseDto.setCourseName(course.getCourseName());
		courseResponseDto.setDurationInDays(course.getDurationInDays());
		courseResponseDto.setFees(course.getFees());
		courseResponseDto.setMaxCapacity(course.getMaxCapacity());
		courseResponseDto.setTrainerName(course.getTrainerName());
		
		return courseResponseDto;
	}

	@Override
	public Course toEntity(CourseRequestDto dto) {
		
		Course course = new Course();
		
		course.setCourseName(dto.getCourseName());
		course.setDurationInDays(dto.getDurationInDays());
		course.setFees(dto.getFees());
		course.setMaxCapacity(dto.getMaxCapacity());
		course.setTrainerName(dto.getTrainerName());
		
		return course;
	}

}
