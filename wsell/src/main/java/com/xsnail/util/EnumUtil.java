package com.xsnail.util;

import com.xsnail.enums.CodeEnum;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public class EnumUtil {
    public static <T extends CodeEnum<Integer>> T getByCode(Integer code, Class<T> enumClass){
        for(T each : enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
