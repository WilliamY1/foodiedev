package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Springboot运行类
 *
 * @author WuJunyi
 * @create 2019-11-14 9:51
 **/
@SpringBootApplication
// 扫描mybatis通用Mapper所在的包
@MapperScan(basePackages = "com.imooc.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
