package com.aaa.handler;

import com.aaa.model.Informs;
import com.aaa.service.InformsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
@author lzw
@create 2020/11/10 11:13
*/
@Controller
public class ManagerHandler {
    @Autowired
    private InformsService informsService;

    //添加通知
    @RequestMapping(value = "addInforms", method = RequestMethod.POST)
    public @ResponseBody
    boolean addInforms(String title, String content, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Informs informs = new Informs();
        informs.setInf_author(username);
        informs.setInf_title(title);
        informs.setInf_content(content);
        boolean ifAddInforms = informsService.addInforms(informs);
        return ifAddInforms;
    }

    //获取所有已审批通过的通知
    @RequestMapping(value = "getInformsPass", method = RequestMethod.GET)
    @ResponseBody
    public List<Informs> getInformsPass(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Informs> list = informsService.getInformsPass();
        session.setAttribute("informs", list);
        System.out.println(list);
        return list;
    }
    //弹窗广告中通过通知id来找到对应的通知
    @RequestMapping(value = "getInformsById", method = RequestMethod.GET)
    public String getInformsById(Model model, int id) {
        System.out.println("--------通过通知id来找到对应的通知--------");
        Informs informs= informsService.getInformsById(id);
        if(informs!=null){
            model.addAttribute("infor",informs);
            return "user/user_in/show";
        }
        return "user/user_in/main";
    }
    //审批未审批的数据，通过通知id来找到对应的通知
    @RequestMapping(value = "getInformsById_un", method = RequestMethod.GET)
    public String getInformsById_un(Model model, int id) {
        System.out.println("--------通过通知id来找到对应的通知--------");
        Informs informs= informsService.getInformsById(id);
        if(informs!=null){
            model.addAttribute("infor",informs);
            return "manager/unApprovalInform";
        }
        return "manager/approvalInform";
    }
    //获取所有没有审批的通知
    @RequestMapping(value = "getInformsUnApproval",method = RequestMethod.POST)
    @ResponseBody
    public List<Informs> getInformsUnApproval() {
        System.out.println("----------获取所有没有审批的通知------------");
        List<Informs> informsList = informsService.getInformsUnApproval();
        return informsList;
    }
    //获取所有审批不通过的通知
    @RequestMapping(value = "getInformsFail",method = RequestMethod.POST)
    @ResponseBody
    public List<Informs> getInformsFail() {
        System.out.println("----------获取所有审批不通过的通知------------");
        List<Informs> informsList = informsService.getInformsFail();
        return informsList;
    }

    //通知审批更新状态
    @RequestMapping(value = "informApproval",method = RequestMethod.POST)
    @ResponseBody
    public boolean informApproval(Model model,Integer id,Integer status,String remark){
        System.out.println("----------通知审批更新状态------------");
        System.out.println(status+"------------"+id+"---------------"+remark);
        Informs informs=new Informs();
        informs.setInf_id(id);
        informs.setInf_deleteStatus("0");
        informs.setInf_approvalStatus(status);
        informs.setInf_remark(remark);
        informs.setInf_approvalTime(new Date());// 获取当前系统时间
        boolean ifUp=informsService.updateApprovalStatus(informs);
        return ifUp;
    }
}
