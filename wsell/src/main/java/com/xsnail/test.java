package com.xsnail;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
public class test {
    public static void main(String[] args) {
        PayModel payModel = new PayModel("4003000005","400300000520170907145987",
                "400300000520170907150134","3","xxxcode","1","342","1","3.5","4003000005",
                "20170907150134","3","20170907150134",null,"1",null,"1");

        System.out.println(new Gson().toJson(payModel));
    }
}
