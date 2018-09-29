package com.xsnail.mapper;

import com.xsnail.dataobject.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public interface OrderDetailMapper {

    @Select("select *from order_detail where orderId = #{orderId]")
    List<OrderDetail> findByOrderId(String orderId);
}
