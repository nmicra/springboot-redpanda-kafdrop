package com.example.redpanddemo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListiner {


    @KafkaListener(topics = "myTopic", groupId = "grp-1")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println(">>>> " + record.value());
    }
}
