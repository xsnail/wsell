package com.xsnail.service;

import com.xsnail.dto.OrderDTO;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
