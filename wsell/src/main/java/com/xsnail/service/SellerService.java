package com.xsnail.service;

import com.xsnail.dataobject.SellerInfo;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}
