package com.eafrey.backend.Controller;

import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {

    @GetMapping("/api/test")
    public String getTest() {
        return "test-eafrey-cn";
    }
}
