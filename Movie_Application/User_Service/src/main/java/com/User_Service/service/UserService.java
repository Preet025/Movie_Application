package com.User_Service.service;

import com.User_Service.domain.User;
import com.User_Service.exception.UserAlreadyExistsException;
import com.User_Service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User registerUser(User user) throws UserAlreadyExistsException;
    Optional<User> getUserByEmail(String email) throws UserNotFoundException;
}
