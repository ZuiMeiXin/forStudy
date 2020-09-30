package com.hisoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void setObj(String key, Object obj, long Timeout) {
        redisTemplate.opsForValue().set(key, obj, Timeout);
    }

    @Override
    public Object getObj(String key) {

        return redisTemplate.opsForValue().get(key);
    }
}
