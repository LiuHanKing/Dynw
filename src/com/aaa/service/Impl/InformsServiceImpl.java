package com.aaa.service.Impl;

import com.aaa.mapper.InformsMapper;
import com.aaa.model.Informs;
import com.aaa.service.InformsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@author lzw
@create 2020/11/10 11:11
*/
@Service
public class InformsServiceImpl implements InformsService {
    @Autowired
    private InformsMapper informsMapper;
    @Override
    public boolean addInforms(Informs informs) {
        return informsMapper.addInforms(informs);
    }

    @Override
    public List<Informs> getInformsPass() {
        return informsMapper.getInformsPass();
    }

    @Override
    public List<Informs> getInformsFail() {
        return informsMapper.getInformsFail();
    }

    @Override
    public List<Informs> getInformsUnApproval() {
        return informsMapper.getInformsUnApproval();
    }

    @Override
    public boolean updateApprovalStatus(Informs informs) {
        return informsMapper.updateApprovalStatus(informs);
    }

    @Override
    public Informs getInformsById(int id) {
        return informsMapper.getInformsById(id);
    }


}
