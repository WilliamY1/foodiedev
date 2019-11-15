package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类
 *
 * @author WuJunyi
 * @create 2019-11-15 15:57
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {

    // http://localhost:8088/swagger-ui.html        原路径
    // http://localhost:8088/doc.html        swagger-bootstrap-ui路径

    // 配置swagger2核心配置 docket
    @Bean
    public Docket createRestApi() {
        // 1.指定api类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                // 2.用于定义api文档汇总信息
                .apiInfo(apiInfo())
                // 3.指定controller包
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.imooc.controller"))
                // 4.所有controller
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 1.文档页标题
                .title("天天吃货 电商平台接口API")
                // 2.联系人信息
                .contact(new Contact("william",
                        "https://www.imooc.com",
                        "18758194783@163.com"))
                // 3.详细信息
                .description("专为天天吃货提供的api文档")
                // 4.文档版本号
                .version("1.0.1")
                // 5.网站地址
                .termsOfServiceUrl("https://www.imooc.com")
                .build();
    }

}
