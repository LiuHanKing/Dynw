package com.aaa.mapper;

import com.aaa.model.Area;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/*
@author lzw
@create 2020/11/1 20:59
*/
@Component
public interface AreaMapper {
    //查询出省份
    public List<Area> getProvince();
    //查询出地市
    public List<Area> getcity(@Param("code")int code);
    //查询出县区
    public List<Area> getCounties(@Param("code")int code);
}
