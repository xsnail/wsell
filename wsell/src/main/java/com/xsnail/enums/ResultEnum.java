package com.xsnail.enums;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public enum ResultEnum {

    PARAM_ERROR(1,"参数不正确"),
    CART_EMPTY(2,"购物车不能为空"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17,"支付状态不正确"),
    ORDER_OWNER_ERROR(18,"该订单不属于当前用户"),
    WECHAT_MP_ERROR(20,"微信公众账号方面错误"),
    WXPAY_NOTIFY_MONEY_ERROR(21,"微信异步通知金额校验失败")
    ;


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
