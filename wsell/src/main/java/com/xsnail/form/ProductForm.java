package com.xsnail.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
@Data
public class ProductForm {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

}
