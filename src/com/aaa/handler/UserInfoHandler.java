package com.aaa.handler;

import com.aaa.model.Area;
import com.aaa.model.UserInfo;
import com.aaa.service.AreaService;
import com.aaa.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@author lzw
@create 2020/11/1 21:32
*/
@Controller
public class UserInfoHandler {
    @Autowired
    private AreaService areaService;
    @Autowired
    private UserInfoService userInfoService;

    //查询省份并且查询个人信息
    @RequestMapping(value = "getInfo",method = RequestMethod.GET)
    public String getInfo(Model model,@RequestParam("userid")String userid) {
        UserInfo userInfo1=userInfoService.getUserInfo(userid);
        System.out.println(userInfo1+"----------------------------------------------------");
        model.addAttribute("userInfo",userInfo1);
        List<Area> provinceList=areaService.getProvince();
        model.addAttribute("provinceList",provinceList);
        return "user/user_info";
    }
    //查询省份
    @RequestMapping(value = "getProvince",method = RequestMethod.GET)
    public String getProvince(Model model) {
        List<Area> provinceList=areaService.getProvince();
        model.addAttribute("provinceList",provinceList);
        return "user/area";
    }
    //查询地市
    @RequestMapping(value = "getCity",method = RequestMethod.GET)
    public @ResponseBody List<Area> getCitys(Model model,int code) {
        List<Area> cityList=areaService.getcity(code);
        //model.addAttribute("cityList",cityList);
        return cityList;
    }
    //查询县区
    @RequestMapping(value = "getCounties",method = RequestMethod.GET)
    public @ResponseBody List<Area>  getCounties(Model model,int code) {
        List<Area> countiesList=areaService.getCounties(code);
        //model.addAttribute("countiesList",countiesList);
        return countiesList;
    }

    //修改用户的个人信息
    @RequestMapping(value = "updateInfo",method = RequestMethod.POST)
    public @ResponseBody boolean updateInfo(Model model, UserInfo userInfo) {
        System.out.println(userInfo+"+++++++++查询个人信息++++++++++++");
       boolean change=userInfoService.updateUserInfo(userInfo);
        return change;
    }

}
