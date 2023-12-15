package com.bs23.assignment.service;

import com.bs23.assignment.entity.User;
import com.bs23.assignment.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @CachePut(value = "User", key = "#user.id")
    public User addUser(User user) {
        user = repository.save(user);
        logger.info("User added");
        kafkaTemplate.send("user-events", "User id " + user.getId() + " and first name is " + user.getFirstName() + " added successfully.");

        return user;
    }

    public List<User> findAll() {
        return repository.findAll();
    }


    @Cacheable(value = "User", key = "#id")
    public Optional<User> findByUserId(Long id) {

        // fetch data from Redis cache
        User redisUser = getFromCache(id);

        if (redisUser != null) {
            return Optional.of(redisUser);
        } else {
            // Fetch data from RDBMS if not present in Redis
            Optional<User> dbUser = repository.findById(id);

            // Save to Redis for future reads
            saveToCache(dbUser.get());

            return dbUser;
        }
    }

    @CacheEvict(value = "User", key = "#id")
    public void deleteUserById(Long id) {
        Optional<User> user = repository.findById(id);
        repository.delete(user.get());
        kafkaTemplate.send("user-events", "User id " + user.get().getId() + " and first name is " + user.get().getFirstName() + " deleted successfully.");

    }

    private User getFromCache(Long id) {

        return null;
    }

    public void saveToCache(User user) {

    }

}
