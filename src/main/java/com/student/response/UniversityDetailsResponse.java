package com.student.response;

import java.time.LocalDateTime;
import java.util.List;

public class UniversityDetailsResponse {
	private LocalDateTime timestamp = LocalDateTime.now();
	private String message = "This API is Designed and Deveoped By Dillip Kumar";
	private List<UniversityDetailsDTO> data;
	
	
	
	public UniversityDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UniversityDetailsResponse(LocalDateTime timestamp, String message, List<UniversityDetailsDTO> data) {
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


	public List<UniversityDetailsDTO> getData() {
		return data;
	}
	public void setData(List<UniversityDetailsDTO> data) {
		this.data = data;
	}
	
	
}
