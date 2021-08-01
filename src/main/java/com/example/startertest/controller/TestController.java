package com.example.startertest.controller;


import com.example.startertest.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedisUtil redisUtil;


    @GetMapping("test")
    public String test() {
        redisUtil.setCacheObject("key","custom redis starter");
        return (String)redisUtil.getCacheObject("key");
    }
}
