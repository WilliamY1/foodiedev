package com.imooc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 基础控制类
 *
 * @author WuJunyi
 * @create 2019-11-14 9:52
 **/
@Controller
public class BaseController {

    public static final Integer COMMENT_PAGE_SIZE = 10;
}
