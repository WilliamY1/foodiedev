package com.imooc.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * 地址相关的接口
 *
 * @author WuJunyi
 * @create 2019-11-19 17:05
 **/
@Api(value = "地址相关",tags = {"地址相关的api接口"})
@RestController
public class AddressController {

    /**
     * 用户在确认订单页面，可以针对收货地址做如下操作：
     * 1. 查询用户的所有收货地址列表
     * 2. 新增收货地址
     * 3. 删除收货地址
     * 4. 修改收货地址
     * 5. 设置默认地址
     */
}
