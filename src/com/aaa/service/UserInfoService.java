package com.aaa.service;

import com.aaa.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/11/2 13:24
*/
@Service
public interface UserInfoService {
    //查询出此用户的个人信息
    public UserInfo getUserInfo(@Param("userid")String userid);
    //修改个人信息
    public boolean updateUserInfo(@Param("userInfo")UserInfo userInfo);
}
