package com.aaa.service.Impl;

import com.aaa.mapper.UserMapper;
import com.aaa.model.LoginLog;
import com.aaa.model.User;
import com.aaa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/9/25 22:46
*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer selectYhbh(String yhbh) {

        return userMapper.selectYhbh(yhbh);
    }

    @Override
    public Integer selectEmail(String email) {
        return userMapper.selectEmail(email);
    }

    @Override
    public Integer getUser(String username, String password) {
        return userMapper.getUser(username,password);
    }

    @Override
    public boolean addLoginLog(LoginLog loginLog) {
        return userMapper.addLoginLog(loginLog);
    }
}