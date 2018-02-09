package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.User;

public interface UserDAO {
	
	public List<User> findByEmail(String email);
	
	public List<User> findByEmailAndPassword(String email, String password);
	
	public User save(User user);
	
	public void update(User user);

}
