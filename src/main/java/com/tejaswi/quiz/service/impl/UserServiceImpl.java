package com.tejaswi.quiz.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejaswi.quiz.entity.User;
import com.tejaswi.quiz.entity.UserRole;
import com.tejaswi.quiz.repo.RoleRepository;
import com.tejaswi.quiz.repo.UserRepository;
import com.tejaswi.quiz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	// creating users
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub

		User userFoundInDatabase = this.userRepository.findByUserName(user.getUsername());
		if (userFoundInDatabase != null) {
			System.out.println("user is already present in Database !!");
			throw new Exception("User is already present in Database !!!");
		} else {
			// create user in DB
			for (UserRole userRole : userRoles) {
				roleRepository.save(userRole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			userFoundInDatabase = this.userRepository.save(user);

		}
		return userFoundInDatabase;

	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserName(username);
	}

	@Override
	public void deleteUser(Long username) {
		this.userRepository.deleteById(username.intValue());
		// TODO Auto-generated method stub
		
	}

}
