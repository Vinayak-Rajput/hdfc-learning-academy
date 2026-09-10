package com.hdfc.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hdfc.entity.Course;

@Repository
public class CourseRepository {
	
	private Map<Integer, Course> courses;
	private Integer idCount;
	
	
	public CourseRepository() {
		super();
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
		
		if(!courses.containsKey(id)) {
			return null;
		}
		
		return courses.get(id);
	}
	
	public Course update(Integer id, Course course) {
		
		if(!courses.containsKey(id)) {
			return null;
		}
		
		courses.put(id,course);
		
		return course;
	}
	
	public Course delete(Integer id) {
		
		if(!courses.containsKey(id)) {
			return null;
		}
		
		Course deleted = findById(id);
		courses.remove(id);
		
		return deleted;
	}
}
