package com.example.jpalesson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test/{value}")
    public String test(@PathVariable(name = "value") String value,
            @RequestParam(name = "email") String email) {
        return value + email;
    }


}
