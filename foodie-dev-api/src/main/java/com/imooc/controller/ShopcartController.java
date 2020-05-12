package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.RedisOperator;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static com.imooc.controller.BaseController.FOODIE_SHOPCART;

/**
 * 购物车控制类
 *
 * @author WuJunyi
 * @create 2019-11-14 9:52
 **/
@Api(value = "购物车接口controller", tags = "购物车接口相关的api")
@RequestMapping("shopcart")
@RestController
public class ShopcartController extends BaseController {

    @Autowired
    private RedisOperator redisOperator;

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult add(@RequestParam String userId,
                               @RequestBody ShopcartBO shopcartBO,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("");
        }

        System.out.println(shopcartBO.toString());

        // 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到Redis缓存
        // 需要额外判断当前购物车中包含已经存在的商品，如果存在则累加购买数量
        String shopcartJson = redisOperator.get(FOODIE_SHOPCART + ":" + userId);
        List<ShopcartBO> shopcartBOList = null;
        if (StringUtils.isNotBlank(shopcartJson)) {
            // 如果redis中已经有购物车了
            shopcartBOList = JsonUtils.jsonToList(shopcartJson, ShopcartBO.class);
            // 判断购物车中是否存在已有商品，如果有的话counts累加
            boolean isHaving = false;
            for (ShopcartBO sc : shopcartBOList) {
                String tempSpecId = sc.getSpecId();
                if (tempSpecId.equals(shopcartBO.getSpecId())) {
                    sc.setBuyCounts(sc.getBuyCounts() + shopcartBO.getBuyCounts());
                    isHaving = true;
                }
            }
            if (!isHaving) {
                shopcartBOList.add(shopcartBO);
            }
        } else {
            // 如果redis中没有购物车
            shopcartBOList = new ArrayList<>();
            // 直接添加到购物车中
            shopcartBOList.add(shopcartBO);
        }

        // 覆盖现有redis中的购物车
        redisOperator.set(FOODIE_SHOPCART + ":" + userId, JsonUtils.objectToJson(shopcartBOList));

        return IMOOCJSONResult.ok();

    }

    @ApiOperation(value = "从购物车中删除商品", notes = "从购物车中删除商品", httpMethod = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult del(@RequestParam String userId,
                               @RequestParam String itemSpecId,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId)) {
            return IMOOCJSONResult.errorMsg("参数不能为空");
        }

        // 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除redis购物车中的商品
        String shopcartJson = redisOperator.get(FOODIE_SHOPCART + ":" + userId);
        if (StringUtils.isNotBlank(shopcartJson)) {
            // redis中已经有购物车了
            List<ShopcartBO> shopcartBOList = JsonUtils.jsonToList(shopcartJson, ShopcartBO.class);
            // 判断购物车中是否存在已有商品，如果有则删除
            for (ShopcartBO sc : shopcartBOList) {
                String tmpSpecId = sc.getSpecId();
                if (tmpSpecId.equals(itemSpecId)) {
                    shopcartBOList.remove(sc);
                    break;
                }
            }
            // 覆盖现有的redis中的购物车
            redisOperator.set(FOODIE_SHOPCART + ":" + userId, JsonUtils.objectToJson(shopcartBOList));
        }

        return IMOOCJSONResult.ok();

    }
}
