package com.aaa.handler;

import com.aaa.model.Photo;
import com.aaa.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.io.*;


/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/15 8:32
*/
@Controller
public class PhotoHandler<JSONArray> {
    @Autowired
    private PhotoService photoService;


    @RequestMapping(value = "/addPhoto", method = RequestMethod.POST)
    public String addPics(Model model, MultipartFile photo, HttpSession session) throws IOException {
        Photo photo1=new Photo();
        String photoname= photo.getOriginalFilename();
        String path=session.getServletContext().getRealPath("\\source\\img");
        String filename = path + photoname;
        if (filename.endsWith(".jpg") || filename.endsWith(".png")) {
            File file = new File(filename);
            photo.transferTo(file);
            try {
                InputStream in=new FileInputStream(filename);
                byte[] arr=new byte[in.available()];
                photo1.setName(photoname);
                photo1.setPic(arr);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        int ifChenge=photoService.addPhoto(photo1);
        if(ifChenge==0){
            model.addAttribute("info", "插入图片失败");
        }else if(ifChenge>0){
            model.addAttribute("info", "插入图片成功");
        }else{
            model.addAttribute("info", "未知情况");
        }

        return "info";
    }

    @RequestMapping(value = "showPho/{id}")
    @ResponseBody
    public String showPhotobyid(Model model, @PathVariable int id) throws IOException {
        Photo photo=photoService.getPhotoById(id);
        byte[] arr=photo.getPic();
      //  OutputStream outputStream="";
       model.addAttribute("info",photo);

            return "showPic";
    }




}
