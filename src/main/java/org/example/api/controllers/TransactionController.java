package org.example.api.controllers;

import org.example.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final RedisService redisService;

    @Autowired
    public TransactionController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/")
    public String index() {
        return redisService.getValue("foo");
    }

    @PostMapping("/")
    public void createTransaction() {
    }
}
