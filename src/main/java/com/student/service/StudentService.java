package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Student;
import com.student.request.StudentRequest;
import com.student.response.StudentResponse;

public interface StudentService {
	
	public Student addStudent(StudentRequest student);
	
	public StudentResponse deleteStudentById(int rollNo);
	
	public StudentResponse updateStudentById(int rollNo,StudentRequest student);
	
	public List<Student> findAll();
	
	public List<Student> findById(int rollNo);
}
