package com.tejaswi.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejaswi.quiz.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
