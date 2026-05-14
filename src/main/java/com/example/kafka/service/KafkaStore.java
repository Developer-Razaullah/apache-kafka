package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaStore {

    private String lastReceivedMessage = "No message yet";

    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void listen(String message) {
        this.lastReceivedMessage = message; // Update when real message arrives
    }

    public String getLastMessage() {
        return lastReceivedMessage;
    }
}
