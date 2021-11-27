package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.request.StudentRequest;
import com.student.response.StudentResponse;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> re_student = repository.findAll();
		return re_student;
	}

	@Override
	public StudentResponse deleteStudentById(int rollNo) {
		// TODO Auto-generated method stub
		StudentResponse response = new StudentResponse();
		
		List<Student> list = repository.findByRollNo(rollNo);
		
		if(list.size() == 0)
		{
			response.setMessage("Student Record is not present with this Roll Number "+rollNo);
		}
		else {
			repository.deleteById(rollNo);
			response.setMessage("Student Record deleted successfully having the Roll Number "+rollNo);
		}
		return response;
	}

	@Override
	public StudentResponse updateStudentById(int rollNo,StudentRequest student) {
		// TODO Auto-generated method stub
		StudentResponse response = new StudentResponse();
		List<Student> list = repository.findByRollNo(rollNo);
		Student re_student = new Student();
		if(list.size()==0)
		{
			response.setMessage("No Student is Present in DB with this Roll Number");
		}
		else {
			repository.deleteById(rollNo);
			re_student.setStudentName(student.getName());
			re_student.setAge(student.getAge());
			re_student.setGender(student.getGender());
			re_student.setMobileNumber(student.getMobileNumber());
			re_student.setRollNo(rollNo);
			repository.save(re_student);
			response.setMessage("Student Record Updated Successfully with Roll Number => "+rollNo);
		}
		return response;
	}

	@Override
	public List<Student> findById(int rollNo) {
		// TODO Auto-generated method stub
		List<Student> re_student = repository.findByRollNo(rollNo);
		return re_student;
	}

	@Override
	public Student addStudent(StudentRequest student) {
		// TODO Auto-generated method stub
		
		Student re_student = new Student();
		
		re_student.setStudentName(student.getName());
		re_student.setAge(student.getAge());
		re_student.setGender(student.getGender());
		re_student.setMobileNumber(student.getMobileNumber());
		System.out.println(re_student);
		
		return repository.save(re_student);
		
	}
	
	

}
