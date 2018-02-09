package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2/6/2018.
 */

@RestController
public class LoginCongfoller {


    @PostMapping
    public ResponseEntity<User> processLogin(User reqUser) {
        Authentication authentication = null;
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(reqUser.getEmail(), reqUser);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        user.setPassword(null);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
