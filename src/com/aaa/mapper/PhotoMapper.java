package com.aaa.mapper;

import com.aaa.model.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 23:20
*/
@Component
public interface PhotoMapper {
    @Insert("insert into photo (name,pic) values(#{name},#{pic})")
    public int addPhoto(Photo photo);

    @Select("select * from photo")
    public List<Photo> getPhotos();
    @Select("select * from photo where id=#{id}")
    public Photo getPhotoById(int id);
}
