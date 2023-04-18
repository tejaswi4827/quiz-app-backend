package com.tejaswi.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejaswi.quiz.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// Hibernate auto find user from db no need to write query because of method name
	public User findByUserName(String username);

}
