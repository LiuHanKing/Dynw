package com.aaa.mapper;

import com.aaa.model.Informs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/*
@author lzw
@create 2020/11/10 9:48
*/
@Component
public interface InformsMapper {
    //添加通知
    public boolean addInforms(@Param("informs") Informs informs);
}
