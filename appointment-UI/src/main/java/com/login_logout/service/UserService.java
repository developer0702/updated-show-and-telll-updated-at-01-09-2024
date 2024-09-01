package com.login_logout.service;


import com.login_logout.entity.UserDtls;


public interface UserService {

	public UserDtls createUser(UserDtls user);

	public boolean checkEmail(String email);

}