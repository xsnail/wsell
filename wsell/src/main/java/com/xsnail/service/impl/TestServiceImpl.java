package com.xsnail.service.impl;

import com.xsnail.mapper.TestMapper;
import com.xsnail.service.TestService;
import com.xsnail.service.TransService;
import org.omg.IOP.ExceptionDetailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/9/29 0029.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TransService transService;

    @Override
    public void testTrans() {
        trans();
    }

    @Override
    public void testTrans2() {
        try {
            transService.trans();
        }catch (Exception e){

        }
    }

    @Override
    @Transactional
    public void trans() {
        int i = testMapper.insertUser("ggg","123456");
        System.out.println(1/0);
    }
}
