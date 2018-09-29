package com.xsnail.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/9/29 0029.
 */
public interface User1Mapper {

    @Insert("insert into user1(username,password) values(#{username},#{password})")
    int insertUser(@Param("username") String username, @Param("password") String password);
}
