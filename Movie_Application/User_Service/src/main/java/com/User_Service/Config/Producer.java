package com.User_Service.Config;


import com.User_Service.RabbitMQ_Domain.UserDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;

    public void sendMessageToRabbitMq(UserDTO userDTO){
        rabbitTemplate.convertAndSend(directExchange.getName(),"user_routing",userDTO);
    }


}

