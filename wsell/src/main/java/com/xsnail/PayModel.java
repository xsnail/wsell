package com.xsnail;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by xsnail on 2017/6/2.
 */
@Data
public class PayModel implements Serializable {
    /**
     * 商品所对应的机器编号
     */
    public String PushMachineSn;
    // 订单编号
    public String OrderSn;
    // 创建时间
    public String CreateTime;
    // 订单状态   0：订单生成，1：订单支付成功（未出货），3：已出货
    public String OrderStatus;
    //商品编码
    public String GoodsCode;
    // 购买数量
    public String GoodsNum;
    // 商品ID
    public String GoodsId;
    // 商品类型 1：饮料机  2：格子柜
    public String GoodsBelong;
    // 商品价格
    public String GoodsPrice;
    // 主机的机器编码
    public String MachineSn;
    // 支付时间s
    public String PayTime;
    // 支付方式 0:现金支付;1:微信支付;2:支付宝支付
    public String PayType;
    // 出货时间
    public String DeliveryTime;
    // 流水号
    public String MachineTradeNo;
    /// 货道号
    public String MachineRoadNo;


    private String param;
    // 出货状态 0：出货中 1：出货成功 2：出货失败
    public String DeliveryStatus;


    public PayModel(String pushMachineSn, String orderSn, String createTime, String orderStatus, String goodsCode, String goodsNum, String goodsId, String goodsBelong, String goodsPrice, String machineSn, String payTime, String payType, String deliveryTime, String machineTradeNo, String machineRoadNo, String param, String deliveryStatus) {
        PushMachineSn = pushMachineSn;
        OrderSn = orderSn;
        CreateTime = createTime;
        OrderStatus = orderStatus;
        GoodsCode = goodsCode;
        GoodsNum = goodsNum;
        GoodsId = goodsId;
        GoodsBelong = goodsBelong;
        GoodsPrice = goodsPrice;
        MachineSn = machineSn;
        PayTime = payTime;
        PayType = payType;
        DeliveryTime = deliveryTime;
        MachineTradeNo = machineTradeNo;
        MachineRoadNo = machineRoadNo;
        this.param = param;
        DeliveryStatus = deliveryStatus;
    }
}
