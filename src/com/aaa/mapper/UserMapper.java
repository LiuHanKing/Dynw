package com.aaa.mapper;

import com.aaa.model.LoginLog;
import com.aaa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/*
@author lzw
@create 2020/9/25 19:30
*/
@Component
public interface UserMapper {
    //注册账号
    public boolean addUser(@Param("user") User user);
    //查询用户编号是否注册
    public Integer selectYhbh(@Param("yhbh")String yhbh);
    //查询此邮箱是否已注册
    public Integer selectEmail(@Param("email")String email);
    //登陆账号查询
    public Integer getUser(@Param("username") String  username, @Param("password") String password);

    //插入登录日志
    public boolean addLoginLog(@Param("loginLog") LoginLog loginLog);

}
