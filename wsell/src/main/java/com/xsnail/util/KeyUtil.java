package com.xsnail.util;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式:时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer a = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(a);
    }
}
