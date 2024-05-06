package com.example.redpanddemo.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaPublisher {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Transactional
    public void sendMessage(String topicName, String msg) {
        kafkaTemplate.send(topicName, msg);
    }
}