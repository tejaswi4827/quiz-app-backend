package com.tejaswi.quiz.payloads;

import lombok.Data;

@Data
public class JwtRequest {
	private String userName;
	private String password;
}
