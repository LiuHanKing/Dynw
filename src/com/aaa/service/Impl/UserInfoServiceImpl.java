package com.aaa.service.Impl;

import com.aaa.mapper.UserInfoMapper;
import com.aaa.model.UserInfo;
import com.aaa.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/11/2 13:24
*/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(String userid) {
        return userInfoMapper.getUserInfo(userid);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }
}
