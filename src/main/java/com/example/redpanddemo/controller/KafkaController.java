package com.example.redpanddemo.controller;

import com.example.redpanddemo.constants.Constants;
import com.example.redpanddemo.kafka.KafkaPublisher;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
public class KafkaController {

    Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaPublisher kafkaPublisher;

    @PostMapping("publish")
    public ResponseEntity<String> publishMessage(@RequestParam String message){
        try {
            kafkaPublisher.sendMessage(Constants.TOPIC, message);
            return ResponseEntity.ok(null);

        } catch (Exception e ){
            logger.error("failed to send message", e);
            return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
        }
    }

}