package com.visitlog.visitlog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class RedisHelper {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void save(String key,String value){
        ValueOperations<String,String> values = stringRedisTemplate.opsForValue();
        values.set(key,value);
    }

    public void saveByExpiration(String key,String value,int duration){
        ValueOperations<String,String> values = stringRedisTemplate.opsForValue();
        values.set(key,value, Duration.ofSeconds(duration));
    }

    public String get(String key){
        ValueOperations<String,String> values = stringRedisTemplate.opsForValue();
        return values.get(key);
    }

}
