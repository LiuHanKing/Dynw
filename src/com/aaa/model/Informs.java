package com.aaa.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/*
@author lzw
@create 2020/11/10 9:43
*/
@Component
public class Informs {
    public static final long serialVersionUID = 123456;
    private int inf_id;                 //主键id
    private String inf_title;           //标题
    private String inf_author;          //作者
    private String inf_content;         //内容
    private Date inf_createTime;        //编辑时间
    private int inf_approvalStatus;     //审批状态
    private Date inf_approvalTime;      //审批时间
    private String inf_deleteStatus;    //删除标志

    public Informs() {
    }

    public Informs(int inf_id, String inf_title, String inf_author, String inf_content, Date inf_createTime, int inf_approvalStatus, Date inf_approvalTime, String inf_deleteStatus) {
        this.inf_id = inf_id;
        this.inf_title = inf_title;
        this.inf_author = inf_author;
        this.inf_content = inf_content;
        this.inf_createTime = inf_createTime;
        this.inf_approvalStatus = inf_approvalStatus;
        this.inf_approvalTime = inf_approvalTime;
        this.inf_deleteStatus = inf_deleteStatus;
    }

    @Override
    public String toString() {
        return "Informs{" +
                "inf_id=" + inf_id +
                ", inf_title='" + inf_title + '\'' +
                ", inf_author='" + inf_author + '\'' +
                ", inf_content='" + inf_content + '\'' +
                ", inf_createTime=" + inf_createTime +
                ", inf_approvalStatus=" + inf_approvalStatus +
                ", inf_approvalTime=" + inf_approvalTime +
                ", inf_deleteStatus='" + inf_deleteStatus + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getInf_id() {
        return inf_id;
    }

    public void setInf_id(int inf_id) {
        this.inf_id = inf_id;
    }

    public String getInf_title() {
        return inf_title;
    }

    public void setInf_title(String inf_title) {
        this.inf_title = inf_title;
    }

    public String getInf_author() {
        return inf_author;
    }

    public void setInf_author(String inf_author) {
        this.inf_author = inf_author;
    }

    public String getInf_content() {
        return inf_content;
    }

    public void setInf_content(String inf_content) {
        this.inf_content = inf_content;
    }

    public Date getInf_createTime() {
        return inf_createTime;
    }

    public void setInf_createTime(Date inf_createTime) {
        this.inf_createTime = inf_createTime;
    }

    public int getInf_approvalStatus() {
        return inf_approvalStatus;
    }

    public void setInf_approvalStatus(int inf_approvalStatus) {
        this.inf_approvalStatus = inf_approvalStatus;
    }

    public Date getInf_approvalTime() {
        return inf_approvalTime;
    }

    public void setInf_approvalTime(Date inf_approvalTime) {
        this.inf_approvalTime = inf_approvalTime;
    }

    public String getInf_deleteStatus() {
        return inf_deleteStatus;
    }

    public void setInf_deleteStatus(String inf_deleteStatus) {
        this.inf_deleteStatus = inf_deleteStatus;
    }
}
