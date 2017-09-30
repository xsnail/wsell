package com.xsnail.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -7165867627225440080L;
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> categoryProductList;


}
