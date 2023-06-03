package com.wht.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/27 13:36
 */
@Service
public class ChatService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public void addUser(String username) {
        redisTemplate.opsForValue().set("user",username);
    }
}
