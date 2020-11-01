package com.aaa.service;

import com.aaa.model.EmailTemp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/9/27 0:20
*/
@Service
public interface EmailTempService {
    public EmailTemp getEmailTempById(@Param("id") Integer id);
}
