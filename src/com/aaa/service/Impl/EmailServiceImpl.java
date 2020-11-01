package com.aaa.service.Impl;

import com.aaa.mapper.EmailMapper;
import com.aaa.mapper.EmailTempMapper;
import com.aaa.model.Email;
import com.aaa.model.EmailTemp;
import com.aaa.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/9/26 1:15
*/
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailMapper emailMapper;
    @Override
    public boolean addemailTo(Email email) {
        return emailMapper.addemailTo(email);
    }

}
