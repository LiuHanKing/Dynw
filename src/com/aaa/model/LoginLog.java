package com.aaa.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/*
@author lzw
@create 2020/9/26 16:51
*/
@Component
public class LoginLog {
    private int id;
    private String  login_user;
    private String login_action;
    private Date login_time;
    private String login_status;
    private String login_address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public String getLogin_action() {
        return login_action;
    }

    public void setLogin_action(String login_action) {
        this.login_action = login_action;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public String getLogin_status() {
        return login_status;
    }

    public void setLogin_status(String login_status) {
        this.login_status = login_status;
    }

    public String getLogin_address() {
        return login_address;
    }

    public void setLogin_address(String login_address) {
        this.login_address = login_address;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", login_user='" + login_user + '\'' +
                ", login_action='" + login_action + '\'' +
                ", login_time=" + login_time +
                ", login_status='" + login_status + '\'' +
                ", login_address='" + login_address + '\'' +
                '}';
    }

    public LoginLog() {
    }

    public LoginLog(int id, String login_user, String login_action, Date login_time, String login_status, String login_address) {
        this.id = id;
        this.login_user = login_user;
        this.login_action = login_action;
        this.login_time = login_time;
        this.login_status = login_status;
        this.login_address = login_address;
    }
}
