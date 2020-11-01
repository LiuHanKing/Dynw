package com.aaa.service.Impl;

import com.aaa.mapper.EmailTempMapper;
import com.aaa.model.EmailTemp;
import com.aaa.service.EmailTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/9/27 0:21
*/
@Service
public class EmailTempServiceImpl implements EmailTempService {
    @Autowired
    private EmailTempMapper emailTempMapper;
    @Override
    public EmailTemp getEmailTempById(Integer id) {
        if(id==null){
            id=1;
        }
        EmailTemp emailTemp=emailTempMapper.getEmailTempById(id);
        return emailTemp;
    }

}
