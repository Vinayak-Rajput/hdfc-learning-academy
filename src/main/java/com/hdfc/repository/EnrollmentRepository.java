package com.hdfc.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hdfc.entity.Enrollment;

@Repository
public class EnrollmentRepository {
	
	private final Map<Integer, Enrollment> enrollments;
	private Integer idCount;
	
	
	public EnrollmentRepository() {
		
		this.enrollments = new HashMap<>();
		this.idCount = 100;
	}

	public Enrollment save(Enrollment enrollment) { 
		
		idCount++;
		
		enrollment.setEnrollmentId(idCount);
		
		enrollment.setEnrollmentDate(LocalDate.now());
		
		enrollment.setStatus("ENROLLED");
		
		enrollments.put(idCount,enrollment);
		
		return enrollment;
	}
	
	public List<Enrollment> findAll(){
		
		return new ArrayList<>(enrollments.values());
	}
	
	public Enrollment findById(Integer id) {
		
		return enrollments.get(id);
	}
	
	public Enrollment updateStatusCancel(Integer id) {
		
		Enrollment enrollment = enrollments.get(id);
		
		if(enrollment == null) {
			
			return null;
		}
		
		enrollment.setStatus("CANCELLED");
		
		return enrollment;
	}
	
	public Enrollment updateStatusCompleted(Integer id) {
		
		Enrollment enrollment = enrollments.get(id);
		
		if(enrollment == null) {
			
			return null;
		}
		
		enrollment.setStatus("COMPLETED");
		
		return enrollment;	
		
	}
}
