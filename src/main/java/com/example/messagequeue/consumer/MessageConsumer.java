package com.example.messagequeue.consumer;

import com.example.messagequeue.config.RabbitMQConfig;
import com.example.messagequeue.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(Message message) {
        System.out.println("Received message: " + message.getContent());
        // Process the message as needed
    }
}
