package com.aaa.model;

import org.springframework.stereotype.Component;

/*
@author lzw
@create 2020/9/25 19:25
*/
@Component
public class User {
    public static final long serialVersionUID=876876;
    private int yh_id;
    private String yh_yhbh;
    private String yh_password;
    private String yh_email;
    private String yh_status;
    private String yh_scbz;
    private String yh_yname;
    private String yh_caste;
    private int yh_wrongTimes;
    public User() {
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
                '}';
    }

    public User(int yh_id, String yh_yhbh, String yh_password, String yh_email, String yh_status, String yh_scbz, String yh_yname, String yh_caste, int yh_wrongTimes) {
        this.yh_id = yh_id;
        this.yh_yhbh = yh_yhbh;
        this.yh_password = yh_password;
        this.yh_email = yh_email;
        this.yh_status = yh_status;
        this.yh_scbz = yh_scbz;
        this.yh_yname = yh_yname;
        this.yh_caste = yh_caste;
        this.yh_wrongTimes = yh_wrongTimes;
    }
}
