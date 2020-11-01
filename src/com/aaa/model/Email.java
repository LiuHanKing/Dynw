package com.aaa.model;

import org.springframework.stereotype.Component;

/*
@author lzw
@create 2020/9/26 0:47
*/
@Component
public class Email {
    private String  toEmail ;
    private String  checkCode;
    @Override
    public String toString() {
        return "Email{" +
                "toEmail='" + toEmail + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }

    public Email() {
    }

    public Email(String toEmail, String checkCode) {
        this.toEmail = toEmail;
        this.checkCode = checkCode;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
