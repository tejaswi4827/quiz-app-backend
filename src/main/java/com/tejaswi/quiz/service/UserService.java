package com.tejaswi.quiz.service;

import java.util.Set;

import com.tejaswi.quiz.entity.User;
import com.tejaswi.quiz.entity.UserRole;

public interface UserService {

	// creating user
	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	User getUser(String username);

	void deleteUser(Long username);
}
