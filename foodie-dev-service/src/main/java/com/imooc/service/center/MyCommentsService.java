package com.imooc.service.center;

import com.imooc.pojo.OrderItems;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.center.CenterUserBO;

import java.util.List;

public interface MyCommentsService {

    /**
     * 根据订单ID查询关联的商品
     *
     * @param orderId
     * @return
     */
    public List<OrderItems> queryPendingComment(String orderId);

}
