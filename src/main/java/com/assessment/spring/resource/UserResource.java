package com.assessment.spring.resource;

import com.assessment.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "poc_kafka";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, name,new User(name, "Technology",12231l));

        return "Published successfully";
    }

    @GetMapping("/publishstring/{name}")
    public String postString(@PathVariable("name") final String name) {

        kafkaTemplate.send("Kafka_Example", name,new User(name, "Technology",12231l));

        return "Published successfully";
    }
}
