package com.bs23.assignment.service;

import com.bs23.assignment.entity.User;
import com.bs23.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User addUser(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findByUserId(Long id) {
        return repository.findById(id);
    }

    public void deleteUserById(Long id) {
        Optional<User> user = repository.findById(id);
        repository.delete(user.get());
    }



}
