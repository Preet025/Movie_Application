package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.InvalidCredentialsException;
import com.niit.UserAuthentication.exception.UserAlreadyExistsException;
import com.niit.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws InvalidCredentialsException {
        System.out.println("email"+email);
        System.out.println("password"+password);
        User loggedInUser = userRepository.findByEmailAndPassword(email,password);
        System.out.println(loggedInUser);
        if(loggedInUser == null)
        {
            throw new InvalidCredentialsException();
        }
        return loggedInUser;
    }

}
