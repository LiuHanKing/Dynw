package com.aaa.service;

import com.aaa.mapper.PicMapper;
import com.aaa.model.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 19:37
*/
@Service
public interface PicSercvice {
    public boolean addPic(Pic pic);
    public List<Pic> getAll();
}
