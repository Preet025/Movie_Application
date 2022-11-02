package com.niit.UserAuthentication.Config;


import com.niit.UserAuthentication.RabbitMQ_Domain.UserDTO;
import com.niit.UserAuthentication.domain.User;
import com.niit.UserAuthentication.exception.UserAlreadyExistsException;
import com.niit.UserAuthentication.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private UserService userService;
    @RabbitListener(queues="user_queue")
    public void sendDataFromRabbitmq(UserDTO userDTO) throws UserAlreadyExistsException {
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userService.saveUser(user);

    }

}
