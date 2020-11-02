package com.aaa.service;

import com.aaa.model.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@author lzw
@create 2020/11/1 21:24
*/
@Service
public interface AreaService {
    //查询出省份
    public List<Area> getProvince();
    //查询出地市
    public  List<Area>  getcity(@Param("code")int code);
    //查询出县区
    public  List<Area>  getCounties(@Param("code")int code);
}
