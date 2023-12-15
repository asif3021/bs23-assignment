package com.bs23.assignment.controller;

import com.bs23.assignment.entity.User;
import com.bs23.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findByUserId(@PathVariable Long id) {
        return service.findByUserId(id).get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return service.addUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        service.deleteUserById(id);
        return "User deleted!!!";
    }


}
