package com.example.vra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vra.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
