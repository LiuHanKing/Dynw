package com.aaa.model;

import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Chromaticity;
import java.io.Serializable;
import java.util.Date;

/*
@author lzw
@create 2020/11/1 20:51
*/
@Component
public class UserInfo implements Serializable {
    public static final long serialVersionUID=87687;
    private int yh_id;
    private String yhbh;
    private int gender;
    private Date brithday;
    private String province;
    private String city;
    private String counties;
    private String phoneNumber;
    private String email;
    private String homeAddres;
    private String hobby;

    public UserInfo() {
    }

    public UserInfo(int yh_id, String yhbh, int gender, Date brithday, String province, String city, String counties, String phoneNumber, String email, String homeAddres, String hobby) {
        this.yh_id = yh_id;
        this.yhbh = yhbh;
        this.gender = gender;
        this.brithday = brithday;
        this.province = province;
        this.city = city;
        this.counties = counties;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.homeAddres = homeAddres;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "yh_id=" + yh_id +
                ", yhbh='" + yhbh + '\'' +
                ", gender=" + gender +
                ", brithday=" + brithday +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", counties='" + counties + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
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

    public String getyhbh() {
        return yhbh;
    }

    public void setyhbh(String yhbh) {
        this.yhbh = yhbh;
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

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
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
