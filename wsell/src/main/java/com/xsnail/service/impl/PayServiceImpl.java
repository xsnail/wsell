package com.xsnail.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.xsnail.dto.OrderDTO;
import com.xsnail.enums.ResultEnum;
import com.xsnail.exception.SellException;
import com.xsnail.service.OrderService;
import com.xsnail.service.PayService;
import com.xsnail.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private BestPayService bestPayService;
    @Autowired
    private OrderService orderService;

    private static final String ORDER_NAME = "微信点餐订单";

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        PayResponse payResponse = bestPayService.pay(payRequest);
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
        //1.验证签名
        //2.支付状态
        //3.支付金额
        //4.支付人(下单人 == 支付人)
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);

        //修改订单支付状态
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if(!MathUtil.equals(orderDTO.getOrderAmount().doubleValue(),payResponse.getOrderAmount())){
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_ERROR);
        }
        orderService.paid(orderDTO);

        return payResponse;
    }


    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        return bestPayService.refund(refundRequest);
    }
}
