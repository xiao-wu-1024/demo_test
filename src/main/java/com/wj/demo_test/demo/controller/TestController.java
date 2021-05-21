package com.wj.demo_test.demo.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author xiao-_-wu
 * @date 2021/5/6 16:01
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/test")
    public String test(){
        redisTemplate.opsForValue().set("myKey", "myValue", 20, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("myKey"));
        return redisTemplate.opsForValue().get("myKey");
    }

}
