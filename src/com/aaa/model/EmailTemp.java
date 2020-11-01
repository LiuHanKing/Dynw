package com.aaa.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/*
@author lzw
@create 2020/9/26 23:19
*/
@Component
public class EmailTemp {
    private Integer id;
    private String  fromEmail;
    private String fromEmailPassword;
    private String emailHost ;
    private String emailSubject ;
    private String emailContext1 ;
    private String emailContext2 ;
    private Date createTime ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromEmailPassword() {
        return fromEmailPassword;
    }

    public void setFromEmailPassword(String fromEmailPassword) {
        this.fromEmailPassword = fromEmailPassword;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailContext1() {
        return emailContext1;
    }

    public void setEmailContext1(String emailContext1) {
        this.emailContext1 = emailContext1;
    }

    public String getEmailContext2() {
        return emailContext2;
    }

    public void setEmailContext2(String emailContext2) {
        this.emailContext2 = emailContext2;
    }

    public Date getcreateTime() {
        return createTime;
    }

    public void setcreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "EmailTemp{" +
                "id=" + id +
                ", fromEmail='" + fromEmail + '\'' +
                ", fromEmailPassword='" + fromEmailPassword + '\'' +
                ", emailHost='" + emailHost + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", emailContext1='" + emailContext1 + '\'' +
                ", emailContext2='" + emailContext2 + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public EmailTemp(Integer id, String fromEmail, String fromEmailPassword, String emailHost, String emailSubject, String emailContext1, String emailContext2, Date createTime) {
        this.id = id;
        this.fromEmail = fromEmail;
        this.fromEmailPassword = fromEmailPassword;
        this.emailHost = emailHost;
        this.emailSubject = emailSubject;
        this.emailContext1 = emailContext1;
        this.emailContext2 = emailContext2;
        this.createTime = createTime;
    }

    public EmailTemp() {
    }
}
