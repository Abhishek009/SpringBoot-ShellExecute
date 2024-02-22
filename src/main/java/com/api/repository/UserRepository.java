
 package com.api.repository;
 


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.api.model.User;

@Repository
 public interface UserRepository extends JpaRepository<User, Long> {
	
 
 }


