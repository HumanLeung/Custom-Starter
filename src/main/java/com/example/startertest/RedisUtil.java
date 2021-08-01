package com.example.startertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


@Component
public class RedisUtil<T> {

    @Autowired
    public RedisTemplate redisTemplate;

    public RedisTemplate getRedisTemplate(){
        return redisTemplate;
    }
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T>ValueOperations<String,T> setCacheObject(String key, T value) {
        ValueOperations<String, T> operations = redisTemplate.opsForValue();
        operations.set(key,value);
        return operations;
    }
    public Object getCacheObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
