package com.bs23.assignment.kafkalistener;

import com.bs23.assignment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @KafkaListener(topics = "user-events", groupId = "groupId")
    void listeners(String data) {
        logger.info("Kafka listener: " + data);
    }

}
