package com.example.kafka.controller;


import com.example.kafka.service.KafkaConsumerService;
import com.example.kafka.service.KafkaProducerService;
import com.example.kafka.service.KafkaStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    @Autowired
    private KafkaStore kafkaStore;

    @Autowired
    private KafkaConsumerService consumerService;

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully!");
    }

    @GetMapping("/getMessage")
    public void getMessage(@RequestParam String message) {
        consumerService.consume(message);
    }

    @GetMapping("/getMessage")
    public String getMessage() {
        return "Latest message from Kafka: " + kafkaStore.getLastMessage();
    }

}
