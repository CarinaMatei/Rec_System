package com.springboot.project.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.project.model.Role;
import com.springboot.project.model.User;
import com.springboot.project.repository.UserRepository;
import com.springboot.project.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Lazy
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(@Lazy UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), 
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public List<User> getUserByKeyword(String keyword) {
		return userRepository.findByKeyword(keyword);
	}
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public List<User> getUsersByIds(List<Long> ids) {
        return userRepository.findAllById(ids);
    }
	
}
