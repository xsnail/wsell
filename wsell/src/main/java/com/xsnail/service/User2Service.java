package com.xsnail.service;

import com.xsnail.mapper.TestMapper;
import com.xsnail.mapper.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/9/29 0029.
 */
@Service
public class User2Service {
    @Autowired
    private User2Mapper user2Mapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequired(String username,String password){
        user2Mapper.insertUser(username,password);
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void addRequiredExcetion(String username,String password){
        user2Mapper.insertUser(username,password);
        throw new RuntimeException();
    }
}
