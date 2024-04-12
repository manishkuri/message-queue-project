package com.example.messagequeue.controller;

import com.example.messagequeue.model.Message;
import com.example.messagequeue.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageQueueController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        messageProducer.sendMessage(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
