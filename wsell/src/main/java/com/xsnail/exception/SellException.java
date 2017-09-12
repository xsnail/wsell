package com.xsnail.exception;

import com.xsnail.enums.ResultEnum;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
