package com.xsnail.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Data
@Entity
public class SellerInfo
{
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
