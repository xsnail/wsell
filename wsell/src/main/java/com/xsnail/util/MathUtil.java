package com.xsnail.util;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public class MathUtil {
    private static final Double MONEY_RANGE = 0.01;
    public static boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1-d2);
        if(result < 0.01){
            return true;
        }else{
            return false;
        }
    }
}
