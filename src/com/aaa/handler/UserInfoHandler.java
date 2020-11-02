package com.aaa.handler;

import com.aaa.model.Area;
import com.aaa.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
@author lzw
@create 2020/11/1 21:32
*/
@Controller
public class UserInfoHandler {
    @Autowired
    private AreaService areaService;
    //查询省份
    @RequestMapping(value = "getProvince",method = RequestMethod.GET)
    public String getProvince(Model model) {
        List<Area> provinceList=areaService.getProvince();
        model.addAttribute("provinceList",provinceList);
        return "user/user_info";
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
}
