package com.aaa.mapper;

import com.aaa.model.Pic;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

import java.util.List;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 19:34
*/
@Component
public interface PicMapper {
    @Insert("insert into pic (picName,picPath) values(#{picName},#{picPath})")
    public boolean addPic(Pic pic);

    public List<Pic> getAll();

}
