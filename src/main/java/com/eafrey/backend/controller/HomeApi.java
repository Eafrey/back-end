package com.eafrey.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {

    @GetMapping("/test")
    public String getTest() {
        return "test-eafrey-cn";
    }
}
