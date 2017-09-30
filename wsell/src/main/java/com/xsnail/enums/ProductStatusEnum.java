package com.xsnail.enums;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public enum ProductStatusEnum implements CodeEnum<Integer>{

    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
}
