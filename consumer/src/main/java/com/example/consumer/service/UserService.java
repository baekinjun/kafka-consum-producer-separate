package com.example.consumer.service;

import com.example.consumer.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @KafkaListener(topics = "kafka-spring-producer", containerFactory = "userKafkaListenerFactory")
    public void listenHeaders(@Payload User user,
                              @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message :" + user + partition);
    }


}
