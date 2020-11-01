package com.aaa.service;

import com.aaa.model.Email;
import com.aaa.model.EmailTemp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/9/26 1:15
*/
@Service
public interface EmailService {
    public boolean addemailTo(Email email);

}
