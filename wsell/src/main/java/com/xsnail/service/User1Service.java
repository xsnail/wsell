package com.xsnail.service;

import com.xsnail.dataobject.User;
import com.xsnail.mapper.TestMapper;
import com.xsnail.mapper.User1Mapper;
import com.xsnail.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/9/29 0029.
 */
@Service
public class User1Service {

    @Autowired
    private User1Mapper user1Mapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequired(String username,String password){
        user1Mapper.insertUser(username,password);
    }
}
