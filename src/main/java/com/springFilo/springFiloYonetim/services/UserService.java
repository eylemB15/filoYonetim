package com.springFilo.springFiloYonetim.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springFilo.springFiloYonetim.models.User;
import com.springFilo.springFiloYonetim.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	//get all user
	public List<User> getUsers() {
		
		return userRepository.findAll();
		
	}
	
	//add user
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	//get by id
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
	
	
	//delete user
	public void delete(int id) {
		userRepository.deleteById(id);
	}

}
