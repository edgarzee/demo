package com.example.demo.user.controller;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User userObj){
        userService.saveUser(userObj);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getUsers", "/{userId}"})
    public List<User> getUser(@PathVariable(required = false) Long userId){
        return userService.getUserDetails(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
