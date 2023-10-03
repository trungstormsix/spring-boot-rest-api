package com.ocoder.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ocoder.restapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

}