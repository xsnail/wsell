package com.xsnail.vo;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Data
public class ResultVO<T> {
    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //返回的具体内容
    private T data;


}
