package com.xsnail.mapper;

import com.xsnail.dataobject.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2018/9/26 0026.
 */
public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    User getUser(@Param("username") String username,@Param("password") String password);
}
