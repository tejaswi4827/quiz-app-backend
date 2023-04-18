package com.tejaswi.quiz.payloads;

import lombok.Data;

@Data
public class ApiResponse {

	private String status;
	
	public ApiResponse(String s){
	
		this.status=s;
	}
}
