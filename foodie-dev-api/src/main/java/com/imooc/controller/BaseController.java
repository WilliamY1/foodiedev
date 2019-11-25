package com.imooc.controller;

import com.imooc.pojo.Orders;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.IMOOCJSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * 基础控制类
 *
 * @author WuJunyi
 * @create 2019-11-14 9:52
 **/
@Controller
public class BaseController {

    @Autowired
    public MyOrdersService myOrdersService;

    public static final String FOODIE_SHOPCART = "shopcart";

    public static final Integer COMMON_PAGE_SIZE = 10;

    public static final Integer PAGE_SIZE = 20;

    // 微信支付成功 -> 支付中心 -> 天天吃货平台
    //                         -> 回调通知的url
    String payReturnUrl = "http://localhost:8088/orders/notifyMerchantOrderPaid";

    String paymentUrl = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";

    //用户上传头像的位置
    //public static final String IMG_USER_FACE_LOCATION = "C:\\foodie-workspace\\foodie-shop\\face";
    public static final String IMG_USER_FACE_LOCATION = "C:" + File.separator +
            "foodie-workspace" + File.separator +
            "foodie-shop" + File.separator + "face";

    /**
     * 用于验证用户和订单是否有关联关系，避免非法用户调用
     *
     * @return
     */
    public IMOOCJSONResult checkUserOrder(String userId, String orderId) {

        Orders orders = myOrdersService.queryMyOrder(userId, orderId);
        if (null == orders) {
            return IMOOCJSONResult.errorMsg("订单不存在!");
        }
        return IMOOCJSONResult.ok(orders);
    }

}
