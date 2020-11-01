package com.aaa.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 23:18
*/
@Component
public class Photo {
    private int id;
    private String name;
    private byte[] pic;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic=" + Arrays.toString(pic) +
                ", time=" + time +
                '}';
    }

    public Photo(int id, String name, byte[] pic, Date time) {
        this.id = id;
        this.name = name;
        this.pic = pic;
        this.time = time;
    }

    public Photo() {
    }
}
