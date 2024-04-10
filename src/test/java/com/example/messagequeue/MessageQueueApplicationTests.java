package com.example.messagequeue;

import com.example.messagequeue.model.Message;
import com.example.messagequeue.producer.MessageProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageQueueApplicationTests {

    @Autowired
    private MessageProducer messageProducer;

    @Test
    void testMessageProduction() {
        Message message = new Message();
        message.setId("1");
        message.setContent("Hello, message queue!");
        messageProducer.sendMessage(message);
    }
}