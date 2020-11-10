package com.aaa.service;

import com.aaa.model.Informs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/*
@author lzw
@create 2020/11/10 11:10
*/
@Service
public interface InformsServer {
    //添加通知
    public boolean addInforms(@Param("informs") Informs informs);
}
