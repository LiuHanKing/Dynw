package com.aaa.service;

import com.aaa.model.LoginLog;
import com.aaa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/9/25 22:45
*/
@Service
public interface UserService {
    //注册账号
    public boolean addUser(User user);
    //查询用户编号是否注册
    public Integer selectYhbh(String yhbh);
    //查询此邮箱是否已注册
    public Integer selectEmail(String email);
    //登陆账号查询
    public User getUser(@Param("username") String  username, @Param("password") String password);
    //插入登录日志
    public boolean addLoginLog(LoginLog loginLog);
    //修改用户密码
    public boolean updateUser(String username,String password);
    //根据邮箱地址修改用户密码
    public boolean updateUserByEmail(String email,String password);
}
