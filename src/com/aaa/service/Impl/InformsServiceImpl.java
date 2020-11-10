package com.aaa.service.Impl;

import com.aaa.mapper.InformsMapper;
import com.aaa.model.Informs;
import com.aaa.service.InformsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/11/10 11:11
*/
@Service
public class InformsServiceImpl implements InformsServer {
    @Autowired
    private InformsMapper informsMapper;
    @Override
    public boolean addInforms(Informs informs) {
        return informsMapper.addInforms(informs);
    }
}
