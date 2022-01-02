package org.example.SpringBootDemo.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/redis")
public class redisController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/add")
    public String add(@RequestBody String req) {
        Gson gson = new Gson();
        RedisModel redis = gson.fromJson(req, RedisModel.class);
        try {
            redisTemplate.opsForValue().set(redis.key,redis.value);
            return "success!";
        }catch (Exception e) {
            return "failed";
        }

    }

}

class RedisModel {
    String key;
    String value;
}
