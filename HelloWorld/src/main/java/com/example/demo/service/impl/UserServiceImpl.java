package com.example.demo.service.impl;


import org.omg.SendingContext.RunTimeOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDAO;
import com.example.demo.domain.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	EmailService emailService;
	
	@Autowired
	UserDAO userDao;
	
	@Override
	public User save(User user) {
	User thisUser = userDao.save(user);
	this.emailService.sendConfirmationEmail(thisUser);
	return thisUser;
	}


	@Override
	public User doesUserExist(String email) {
		List<User> users = userDao.findByEmail(email);

		if(users.size() == 0) {
			throw new RuntimeException("User does not exist in database");
		}

		return users.get(0);
	}

}
