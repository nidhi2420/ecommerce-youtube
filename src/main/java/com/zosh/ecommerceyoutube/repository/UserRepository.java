package com.zosh.ecommerceyoutube.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zosh.ecommerceyoutube.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   
	public User findByEmail(String email);
   
	
}
