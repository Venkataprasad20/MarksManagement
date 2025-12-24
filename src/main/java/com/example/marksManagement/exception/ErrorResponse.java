package com.example.marksManagement.exception;

import java.time.LocalDateTime;
public class ErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timestamp;
	
	ErrorResponse(int status,String message,LocalDateTime timestamp){
		this.status=status;
		this.message=message;
		this.timestamp=timestamp;
	}
	
	//getters and Setters
	public void setStatus(int status) {
		this.status=status;
	}
	public int getStatus() {
		return status;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp=timestamp;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
