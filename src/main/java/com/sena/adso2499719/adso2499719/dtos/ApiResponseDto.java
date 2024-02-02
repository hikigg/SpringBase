package com.sena.adso2499719.adso2499719.dtos;

public class ApiResponseDto<T> {

	
	private String message;
	private boolean status;
	private T data;
	
	public ApiResponseDto() {
		
	}
	
	public ApiResponseDto(String message, boolean status, T data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}

	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
