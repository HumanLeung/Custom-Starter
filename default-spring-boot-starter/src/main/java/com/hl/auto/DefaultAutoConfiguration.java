package com.hl.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ConditionalOnClass(RedisAccessor.class)
@EnableConfigurationProperties(DefaultProperties.class)
public class DefaultAutoConfiguration {

    @Autowired
    DefaultProperties properties;

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(){
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
        JedisConnectionFactory factory = new JedisConnectionFactory(new RedisStandaloneConfiguration(properties.getHost()));
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
}
