package com.imooc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * war包启动类
 * 打包war [4] 增加war的启动类
 *
 * @author WuJunyi
 * @create 2019-12-16 11:16
 **/
public class WarStarterApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        //指向Application这个springboot启动类
        return builder.sources(Application.class);
    }
}
