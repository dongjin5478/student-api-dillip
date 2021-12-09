package com.student.response;

import java.time.LocalDateTime;

public class PersonProductResponse {
	private LocalDateTime timestamp= LocalDateTime.now();
	private String message;
	private Object data;
	public PersonProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonProductResponse(LocalDateTime timestamp, String message, Object data) {
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

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
