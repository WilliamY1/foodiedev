package com.imooc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
@RestController
public class HelloController {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {

        logger.debug("debug: hello~");
        logger.warn("warn: hello~");
        logger.error("error: hello~");
        logger.info("info: hello~");

        return "Hello World!";
    }

    @GetMapping("/setSession")
    public Object setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        // 设置session属性
        session.setAttribute("userInfo","new user");
        // 设置session过期时间
        session.setMaxInactiveInterval(3600);
        // 获取session属性
        session.getAttribute("userInfo");
        // 手动移除session属性
        //session.removeAttribute("userInfo");
        return "ok";
    }
}
