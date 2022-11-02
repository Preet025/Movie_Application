package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.InvalidCredentialsException;
import com.niit.UserAuthentication.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user) throws UserAlreadyExistsException;
    User findByEmailAndPassword(String email, String password) throws InvalidCredentialsException;
}
