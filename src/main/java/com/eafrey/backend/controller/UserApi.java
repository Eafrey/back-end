package com.eafrey.backend.controller;

import com.eafrey.backend.model.User;
import com.eafrey.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseEntity createUser(@RequestBody User user) {
        System.out.println("user"+user.toString());
        userService.save(user);
        return ResponseEntity.ok("ok");
    }
}
