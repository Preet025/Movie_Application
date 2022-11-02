package com.User_Service.service;


//import com.User_Service.Proxy.UserProxy;
import com.User_Service.Config.Producer;
import com.User_Service.RabbitMQ_Domain.UserDTO;
import com.User_Service.domain.User;
import com.User_Service.exception.UserAlreadyExistsException;
import com.User_Service.exception.UserNotFoundException;
import com.User_Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private Producer producer;
    private UserRepository userRepository;
   // private UserProxy userProxy;

//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, UserProxy userProxy) {
//        this.userRepository = userRepository;
//        this.userProxy = userProxy;
//    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        UserDTO userDTO=new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        //ResponseEntity responseEntity = userProxy.saveUser(user);
        //System.out.println(responseEntity.getBody());
        //return userRepository.save(user);
        else
        {
            userRepository.save(user);
            System.out.println("mongo data is saved and try to send the data to exchange");
            producer.sendMessageToRabbitMq(userDTO);
        }
        return user;
    }

    @Override
    public Optional<User> getUserByEmail(String email) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userRepository.findById(email);
    }


}

