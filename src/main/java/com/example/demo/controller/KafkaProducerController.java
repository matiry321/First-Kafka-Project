package com.example.demo.controller;

import com.example.demo.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

//    public KafkaProducerController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}