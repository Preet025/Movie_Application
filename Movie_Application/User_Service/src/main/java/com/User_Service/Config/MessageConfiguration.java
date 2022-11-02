package com.User_Service.Config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

     @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("user_exchange");
    }

    @Bean
    public Queue registerQueue(){
        return new Queue("user_queue");
    }

    @Bean
    public Binding userbinding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("user_routing");
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemp=new RabbitTemplate(connectionFactory);
        rabbitTemp.setMessageConverter(producerJackson2JsonMessageConverter());
        return  rabbitTemp;

    }
}
