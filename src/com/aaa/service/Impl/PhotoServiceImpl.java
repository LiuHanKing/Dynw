package com.aaa.service.Impl;

import com.aaa.mapper.PhotoMapper;
import com.aaa.model.Photo;
import com.aaa.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 23:23
*/
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;
    @Override
    public int addPhoto(Photo photo) {

        return  photoMapper.addPhoto(photo);
    }

    @Override
    public List<Photo> getPhotos() {
        return photoMapper.getPhotos();
    }

    @Override
    public Photo getPhotoById(int id) {
        return photoMapper.getPhotoById(id);
    }
}
