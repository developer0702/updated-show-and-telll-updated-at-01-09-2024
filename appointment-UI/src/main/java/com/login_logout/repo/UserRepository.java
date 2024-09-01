package com.login_logout.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.login_logout.entity.UserDtls;


public interface UserRepository extends JpaRepository<UserDtls, Integer> {

	public boolean existsByEmail(String email);

	public UserDtls findByEmail(String email);

}