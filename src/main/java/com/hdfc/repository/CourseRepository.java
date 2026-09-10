package com.hdfc.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hdfc.entity.Course;

@Repository
public class CourseRepository {
	
	private final Map<Integer, Course> courses;
	private Integer idCount;
	
	
	public CourseRepository() {
		
		this.courses = new HashMap<>();
		this.idCount = 100;
	}

	public Course save(Course course) {
		
		idCount++;
		
		course.setCourseId(idCount);
		
		courses.put(idCount,course);
		
		return course;
	}
	
	public List<Course> findAll(){
		
		return new ArrayList<>(courses.values());
	}
	
	public Course findById(Integer id) {
		
		return courses.get(id);
	}
	
	public Course update(Integer id, Course course) {
		
		Course existingCourse = courses.get(id);
		
		if(existingCourse == null) {
			
			return null;
		}
		
		course.setCourseId(id);
		
		courses.put(id,course);
		
		return course;
	}
	
	public Course delete(Integer id) {
		
		Course deletedCourse = courses.get(id);
		
		if(deletedCourse == null) {
			
			return null;
		}
		
		courses.remove(id);
		
		return deletedCourse;
	}
}
