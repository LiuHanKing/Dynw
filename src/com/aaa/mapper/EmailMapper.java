package com.aaa.mapper;

import com.aaa.model.Email;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/*
@author lzw
@create 2020/9/26 1:05
*/
@Component
public interface EmailMapper {
    //插入邮件记录
    public boolean addemailTo(@Param("email") Email email);
}
