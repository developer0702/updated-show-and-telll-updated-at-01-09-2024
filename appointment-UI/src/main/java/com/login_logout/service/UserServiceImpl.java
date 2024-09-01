package com.login_logout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login_logout.entity.UserDtls;
import com.login_logout.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public UserDtls createUser(UserDtls user) {

		user.setPassword(passwordEncode.encode(user.getPassword()));

		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}


}