package com.aaa.service;

import com.aaa.model.Informs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@author lzw
@create 2020/11/10 11:10
*/
@Service
public interface InformsService {
    //添加通知
    public boolean addInforms(@Param("informs") Informs informs);
    //获取所有通知
    public List<Informs> getInformsPass();
    //获取所有审批不通过的通知
    public List<Informs> getInformsFail();
    //获取所有未审批的通知
    public List<Informs> getInformsUnApproval();
    //通知审批状态修改
    public boolean updateApprovalStatus(Informs informs);
    //根据通知来获取通知
    public Informs getInformsById(int id);
}
