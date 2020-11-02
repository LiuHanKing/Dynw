package com.aaa.model;

import org.springframework.stereotype.Component;

/*
@author lzw
@create 2020/11/1 20:57
*/
@Component
public class Area {
    private int codeid;
    private int parentid;
    private String cityName;

    public Area() {
    }

    public Area(int codeid, int parentid, String cityName) {
        this.codeid = codeid;
        this.parentid = parentid;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Area{" +
                "codeid=" + codeid +
                ", parentid=" + parentid +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public int getCodeid() {
        return codeid;
    }

    public void setCodeid(int codeid) {
        this.codeid = codeid;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
