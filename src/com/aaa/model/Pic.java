package com.aaa.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 19:26
*/
@Component
public class Pic {
    private int picId;
    private String picName;
    private String picPath;
    private Date picUploadTime;

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Date getPicUploadTime() {
        return picUploadTime;
    }

    public void setPicUploadTime(Date picUploadTime) {
        this.picUploadTime = picUploadTime;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "picId=" + picId +
                ", picName='" + picName + '\'' +
                ", picPath='" + picPath + '\'' +
                ", picUploadTime=" + picUploadTime +
                '}';
    }

    public Pic(int picId, String picName, String picPath, Date picUploadTime) {
        this.picId = picId;
        this.picName = picName;
        this.picPath = picPath;
        this.picUploadTime = picUploadTime;
    }

    public Pic() {
    }
}
