package com.xsnail.dto;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
@Data
public class CartDTO {
    //商品id
    private String productId;

    //商品数量
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
