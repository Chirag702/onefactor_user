package com.onefactor.user.service.impl;

import com.onefactor.user.entity.User;
import com.onefactor.user.repository.UserRepository;
import com.onefactor.user.service.UserService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public User updateUser(String email, User user) {
	    User existingUser = userRepository.findByEmail(email);
	    
	    if (existingUser == null) {
	        throw new EntityNotFoundException("User with email " + email + " not found.");
	    }

	    // Update only the fields that are needed
	    if (user.getIsEmailVerified() != null && user.getIsEmailVerified()) {
	        existingUser.setIsEmailVerified(true);
	    }

	    
	    if (user.getFname() != null && user.getFname()!="") {
	        existingUser.setFname(user.getFname());
	    }
	    
	    if (user.getLname() != null && user.getLname()!="") {
	        existingUser.setLname(user.getLname());
	    }
	    
	    if (user.getGender() != null && user.getGender()!="") {
	        existingUser.setGender(user.getGender());
	    }
	    
	    
	    return userRepository.save(existingUser);
	}


	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
}
