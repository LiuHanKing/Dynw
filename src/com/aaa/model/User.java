package com.aaa.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/*
@author lzw
@create 2020/9/25 19:25
*/
@Component
public class User {
    public static final long serialVersionUID = 876876;
    private int yh_id;          //用户id
    private String yh_yhbh;     //用户编号
    private String yh_password; //用户密码
    private String yh_email;    //邮箱地址
    private String yh_status;   //账号状态
    private String yh_scbz;     //账号删除标志
    private String yh_yname;    //用户名
    private String yh_caste;    //账号等级
    private int yh_wrongTimes;  //登陆错误次数
    private Date yh_wrongDate;  //修改登陆状态时间

    public User() {
    }

    public User(int yh_id, String yh_yhbh, String yh_password, String yh_email, String yh_status, String yh_scbz, String yh_yname, String yh_caste, int yh_wrongTimes, Date yh_wrongDate) {
        this.yh_id = yh_id;
        this.yh_yhbh = yh_yhbh;
        this.yh_password = yh_password;
        this.yh_email = yh_email;
        this.yh_status = yh_status;
        this.yh_scbz = yh_scbz;
        this.yh_yname = yh_yname;
        this.yh_caste = yh_caste;
        this.yh_wrongTimes = yh_wrongTimes;
        this.yh_wrongDate = yh_wrongDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "yh_id=" + yh_id +
                ", yh_yhbh='" + yh_yhbh + '\'' +
                ", yh_password='" + yh_password + '\'' +
                ", yh_email='" + yh_email + '\'' +
                ", yh_status='" + yh_status + '\'' +
                ", yh_scbz='" + yh_scbz + '\'' +
                ", yh_yname='" + yh_yname + '\'' +
                ", yh_caste='" + yh_caste + '\'' +
                ", yh_wrongTimes=" + yh_wrongTimes +
                ", yh_wrongDate=" + yh_wrongDate +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getYh_password() {
        return yh_password;
    }

    public void setYh_password(String yh_password) {
        this.yh_password = yh_password;
    }

    public String getYh_email() {
        return yh_email;
    }

    public void setYh_email(String yh_email) {
        this.yh_email = yh_email;
    }

    public String getYh_status() {
        return yh_status;
    }

    public void setYh_status(String yh_status) {
        this.yh_status = yh_status;
    }

    public String getYh_scbz() {
        return yh_scbz;
    }

    public void setYh_scbz(String yh_scbz) {
        this.yh_scbz = yh_scbz;
    }

    public String getYh_yname() {
        return yh_yname;
    }

    public void setYh_yname(String yh_yname) {
        this.yh_yname = yh_yname;
    }

    public String getYh_caste() {
        return yh_caste;
    }

    public void setYh_caste(String yh_caste) {
        this.yh_caste = yh_caste;
    }

    public int getYh_wrongTimes() {
        return yh_wrongTimes;
    }

    public void setYh_wrongTimes(int yh_wrongTimes) {
        this.yh_wrongTimes = yh_wrongTimes;
    }

    public Date getYh_wrongDate() {
        return yh_wrongDate;
    }

    public void setYh_wrongDate(Date yh_wrongDate) {
        this.yh_wrongDate = yh_wrongDate;
    }
}
