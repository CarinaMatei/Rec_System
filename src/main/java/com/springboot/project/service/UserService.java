package com.springboot.project.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.project.model.User;
import com.springboot.project.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);
	
	List<User> getAllUsers();
	
	User getUserById(Long id);

	List<User> getUserByKeyword(String keyword);

	void saveUser(User user);
	
	User findByEmail(String email);
	
	List<User> getUsersByIds(List<Long> ids);
}
