package com.xsnail.service;

import com.xsnail.dto.OrderDTO;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public interface PushMessageService {
    void orderStatus(OrderDTO orderDTO);
}
