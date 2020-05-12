package com.imooc.controller;

import com.imooc.utils.RedisOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 测试类
 *
 * @author WuJunyi
 * @create 2019-11-14 9:52
 **/
@ApiIgnore
@RestController()
@RequestMapping("redis")
public class RedisController {

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    @GetMapping("/set")
    public Object set(String key, String value) {

//        redisTemplate.opsForValue().set(key, value);
        redisOperator.set(key, value);

        return "Set OK";
    }

    @GetMapping("/get")
    public String get(String key) {
//        return (String) redisTemplate.opsForValue().get(key);
        return redisOperator.get(key);
    }

    @GetMapping("/delete")
    public String delete(String key) {
//        redisTemplate.delete(key);
        redisOperator.del(key);
        return "Delete OK";
    }


}
