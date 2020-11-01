package com.aaa.service.Impl;

import com.aaa.mapper.PicMapper;
import com.aaa.model.Pic;
import com.aaa.service.PicSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 19:40
*/
@Service
public class PicServiceImpl implements PicSercvice {
    @Autowired
    private PicMapper picMapper;
    @Override
    public boolean addPic(Pic pic) {

       return picMapper.addPic(pic);
    }

    @Override
    public List<Pic> getAll() {
        return picMapper.getAll();
    }
}
