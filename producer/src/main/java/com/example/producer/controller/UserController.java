package com.example.producer.controller;

import com.example.producer.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "kafka-spring-producer";

    @GetMapping("/publish/{name}")
    public String PostMessage(@PathVariable final String name) {
        User user = new User();
        user.setId("blah-blah");
        user.setName(name);
        user.setEmail("kim@test.com");
        kafkaTemplate.send(TOPIC, user);
        return "Message Published Successfully";

    }


}