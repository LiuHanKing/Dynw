package com.aaa.service.Impl;

import com.aaa.mapper.AreaMapper;
import com.aaa.model.Area;
import com.aaa.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@author lzw
@create 2020/11/1 21:27
*/
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> getProvince() {
        return areaMapper.getProvince();
    }

    @Override
    public  List<Area> getcity(int code) {
        return areaMapper.getcity(code);
    }

    @Override
    public  List<Area> getCounties(int code) {
        return areaMapper.getCounties(code);
    }
}
