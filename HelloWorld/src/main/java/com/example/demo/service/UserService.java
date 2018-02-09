package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
	
	User save(User user);

	User doesUserExist(String email);
}
