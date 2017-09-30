package com.xsnail.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Data
public class OrderVO implements Serializable {

    private static final long serialVersionUID = -5701064898991035669L;
    private String name;
    private String phone;
    private String address;
    private String openid;
    private List<OrderProduct> items;

    public static class OrderProduct{
        String productId;
        Integer productQuantity;
    }

}
