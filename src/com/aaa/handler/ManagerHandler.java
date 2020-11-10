package com.aaa.handler;

import com.aaa.model.Informs;
import com.aaa.service.InformsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
@author lzw
@create 2020/11/10 11:13
*/
@Controller
public class ManagerHandler {
    @Autowired
    private InformsServer informsServer;
    @RequestMapping(value = "addInforms",method = RequestMethod.POST)
    public @ResponseBody boolean addInforms(String title,String content, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Informs informs=new Informs();
        informs.setInf_author(username);
        informs.setInf_title(title);
        informs.setInf_content(content);
        boolean ifAddInforms=informsServer.addInforms(informs);
        return ifAddInforms;
    }
}
