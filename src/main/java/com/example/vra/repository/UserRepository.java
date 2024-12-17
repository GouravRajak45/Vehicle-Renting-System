package com.example.vra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vra.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u.profilePicture.imageId FROM User u Where u.userId= :userId")
	Integer getProfilePictureByUserId(int userId);
	
	User findByEmail(String userName);
}
