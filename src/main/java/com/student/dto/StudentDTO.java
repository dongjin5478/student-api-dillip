package com.student.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.student.entity.Student;

import lombok.Data;

//@Data
public class StudentDTO {
	private LocalDateTime timestamp = LocalDateTime.now();
	private String message;
	private List<Student> data;
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(LocalDateTime timestamp, String message, List<Student> data) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.data = data;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Student> getData() {
		return data;
	}
	public void setData(List<Student> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "StudentDTO [timestamp=" + timestamp + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
