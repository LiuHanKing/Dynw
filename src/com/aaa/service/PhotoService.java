package com.aaa.service;

import com.aaa.model.Photo;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 23:23
*/
@Service
public interface PhotoService {
    public int addPhoto(Photo photo);
    public List<Photo> getPhotos();
    public Photo getPhotoById(int id);
}
