package com.example.demo.service;

import com.example.demo.domain.User;

public interface EmailService {

	public void sendConfirmationEmail(User user);
	
}
