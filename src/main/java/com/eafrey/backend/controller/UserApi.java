package com.eafrey.backend.controller;

import com.eafrey.backend.model.User;
import com.eafrey.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserApi.class);

    @PostMapping("/api/user")
    public ResponseEntity createUser(@RequestBody User user) {
        logger.info("request add user {}", user);
        return ResponseEntity.ok(userService.save(user));
    }
}
