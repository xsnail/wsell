package com.xsnail.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Data
public class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = -8066070402546393954L;
    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //返回的具体内容
    private T data;


}
