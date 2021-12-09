package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.student.dto.StudentDTO;
import com.student.entity.Student;
import com.student.exception.StudentException;
import com.student.request.StudentRequest;
import com.student.response.StudentResponse;
import com.student.service.StudentService;

import ch.qos.logback.core.status.Status;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@Operation(summary = "saveStudentDetails")
	@RequestMapping(path = "/student",consumes = "application/json",produces = "application/json",method = RequestMethod.POST)
	public ResponseEntity<?> addStudent(@RequestBody StudentRequest studentRequest)
	{	
		
		final String message = "Student Record Added Successfully !!";
		HttpStatus status = HttpStatus.CREATED;
		StudentResponse response = new StudentResponse();
		try {
			response.setMessage(message);
			service.addStudent(studentRequest);
			return new ResponseEntity<StudentResponse>(response,status);
			
		}catch (StudentException e) {
			StudentException se = new StudentException(e.getErrorCode(),e.getErrorMessage(), e.getDescription());
			return new ResponseEntity<StudentException>(se,HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			String errorMessage = e.toString();
			status = HttpStatus.BAD_REQUEST;
			response.setMessage(errorMessage);
			return new ResponseEntity<StudentResponse>(response,status);
		}
		
	}
	
	@Operation(summary = "getAllStudentsDetails")
	@RequestMapping(path = "/students",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> findAll()
	{
		String message = "Student Details Found";
		HttpStatus status = null;
		
		List<Student> list = service.findAll();
		StudentDTO dto = new StudentDTO();
		
		try {
			if (list.size() == 0) {
				status = HttpStatus.NOT_FOUND;
				message = "No Record Found";
				dto.setMessage(message);
			}else {
				status = HttpStatus.OK;
				dto.setMessage(message);
				dto.setData(list);
			}
			return new ResponseEntity<StudentDTO>(dto,status);
		} catch (Exception e) {
			// TODO: handle exception
			String errorMessage = e.toString();
			dto.setMessage(errorMessage);
			status = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<StudentDTO>(dto,status);
		}
	}
	
	@Operation(summary = "getStudentDetailsByRollNo")
	@RequestMapping(path = "/student/{roll_no}",produces = "application/json",method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> findById(@PathVariable(name = "roll_no") int rollNo)
	{
		HttpStatus status = null;
		StudentDTO dto = new StudentDTO();
		String message = null;
		List<Student> list = service.findById(rollNo);
		
		try {
			if (list.size() == 0) {
				status = HttpStatus.NOT_FOUND;
				message = "No Student Present in DB with the Roll Number => "+rollNo;
				dto.setMessage(message);
			}else {
				message = "Student Record Found with Roll Number => "+rollNo;
				status = HttpStatus.OK;
				dto.setMessage(message);
				dto.setData(list);
			}
			return new ResponseEntity<StudentDTO>(dto,status);
		} catch (Exception e) {
			// TODO: handle exception
			String errorMessage = e.toString();
			dto.setMessage(errorMessage);
			status = HttpStatus.BAD_REQUEST;
			return new ResponseEntity<StudentDTO>(dto,status);
		}
	}
	
	@Operation(summary = "updateStudentDetailsByRollNo")
	@RequestMapping(path = "/student/{roll_no}",consumes = "application/json",produces = "application/json",method = RequestMethod.PUT)
	public ResponseEntity<StudentResponse> updateById(@PathVariable(name = "roll_no") int rollNo,@RequestBody StudentRequest request)
	{
		HttpStatus status = HttpStatus.OK;
		StudentResponse response = service.updateStudentById(rollNo,request);
		return new ResponseEntity<StudentResponse>(response,status);
	}
	
	@Operation(summary = "deleteStudentDetailsByRollNo")
	@RequestMapping(path = "/student/{roll_no}",consumes = "text/plain",produces = "application/json",method = RequestMethod.DELETE)
	public ResponseEntity<StudentResponse> deleteById(@PathVariable(name = "roll_no") int rollNo)
	{
		StudentResponse response = service.deleteStudentById(rollNo);
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<StudentResponse>(response,status);
	}
}
