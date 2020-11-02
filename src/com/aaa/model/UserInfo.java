package com.aaa.model;

import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Chromaticity;
import java.util.Date;

/*
@author lzw
@create 2020/11/1 20:51
*/
@Component
public class UserInfo {
    private int yh_id;
    private String yh_yhbh;
    private int gender;
    private Date brithday;
    private String province;
    private String city;
    private String counties;
    private String phoneNumber;
    private String yh_email;
    private String homeAddres;
    private String hobby;

    public UserInfo() {
    }

    public UserInfo(int yh_id, String yh_yhbh, int gender, Date brithday, String province, String city, String counties, String phoneNumber, String yh_email, String homeAddres, String hobby) {
        this.yh_id = yh_id;
        this.yh_yhbh = yh_yhbh;
        this.gender = gender;
        this.brithday = brithday;
        this.province = province;
        this.city = city;
        this.counties = counties;
        this.phoneNumber = phoneNumber;
        this.yh_email = yh_email;
        this.homeAddres = homeAddres;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "yh_id=" + yh_id +
                ", yh_yhbh='" + yh_yhbh + '\'' +
                ", gender=" + gender +
                ", brithday=" + brithday +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", counties='" + counties + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", yh_email='" + yh_email + '\'' +
                ", homeAddres='" + homeAddres + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public int getYh_id() {
        return yh_id;
    }

    public void setYh_id(int yh_id) {
        this.yh_id = yh_id;
    }

    public String getYh_yhbh() {
        return yh_yhbh;
    }

    public void setYh_yhbh(String yh_yhbh) {
        this.yh_yhbh = yh_yhbh;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounties() {
        return counties;
    }

    public void setCounties(String counties) {
        this.counties = counties;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getYh_email() {
        return yh_email;
    }

    public void setYh_email(String yh_email) {
        this.yh_email = yh_email;
    }

    public String getHomeAddres() {
        return homeAddres;
    }

    public void setHomeAddres(String homeAddres) {
        this.homeAddres = homeAddres;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
