package com.aaa.handler;

import com.aaa.model.Photo;
import com.aaa.model.Pic;
import com.aaa.service.PhotoService;
import com.aaa.service.PicSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/9/14 19:42
*/
@Controller
public class PicHanndler {
    @Autowired
    private PicSercvice picSercvice;
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPic(Model model, MultipartFile photo) throws IOException {
        Pic pic = new Pic();
        if (!photo.isEmpty()) {
            String path = "C:\\file\\";
            String befrorePrefix = "pic" + (int) (Math.random() * 90000) + 10000;
            System.out.println(befrorePrefix);
            String filename = befrorePrefix + photo.getOriginalFilename();
            if (filename.endsWith(".jpg") || filename.endsWith(".png")) {
                File file = new File(path, filename);
                String paths = path + filename;
                System.out.println(paths + "-----------------------------------------------------");
                // 文件上传
                photo.transferTo(file);
                pic.setPicName(filename);
                pic.setPicPath(paths);

                boolean ifAdd = picSercvice.addPic(pic);
                if (ifAdd) {
                    model.addAttribute("fileInfo", "插入成功");
                } else {
                    model.addAttribute("fileInfo", "插入失败");
                }
            }

        }

        return "info";
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public String addPic(Model model) throws IOException {
        List<Pic> list = picSercvice.getAll();
        model.addAttribute("info", list);
        for (Pic pic : list) {

        File file = new File( pic.getPicPath());
        FileInputStream is = new FileInputStream(file);
        byte[] data = new byte[is.available()];
        is.read(data);
        is.close();
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Img = encoder.encode(data);
        pic.setPicPath(base64Img);
        model.addAttribute("info",pic);
        }
        return "showPic";

    }




}
