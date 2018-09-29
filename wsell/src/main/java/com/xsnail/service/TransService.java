package com.xsnail.service;

import com.xsnail.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/9/29 0029.
 */
@Service
public class TransService {

    @Autowired
    private TestMapper testMapper;

    @Transactional
    public void trans(){

            int i = testMapper.insertUser("ggg", "123456");
            System.out.println(1 / 0);

    }
}
