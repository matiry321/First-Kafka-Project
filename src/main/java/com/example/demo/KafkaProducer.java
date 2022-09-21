package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    String kafkaTopic = "java_in_use_topic";

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message received -> %s", message));

        kafkaTemplate.send(kafkaTopic, message);
    }
}