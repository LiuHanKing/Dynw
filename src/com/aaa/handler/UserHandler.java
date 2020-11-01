package com.aaa.handler;


import com.aaa.model.Email;
import com.aaa.model.EmailTemp;
import com.aaa.model.LoginLog;
import com.aaa.model.User;
import com.aaa.service.EmailService;
import com.aaa.service.EmailTempService;
import com.aaa.service.UserService;
import com.aaa.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


/*
@author lzw
@create 2020/9/25 20:01
*/
@Controller
public class UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private static EmailTempService emailTempService;

    //查询用户编号是否已被占用
    @RequestMapping(value = "selectyhbh",method = RequestMethod.POST)
    public @ResponseBody Integer selectyhbh(Model model, String yhbh) {
        System.out.println("-------确认用户编号是否可使用------");
        System.out.println(yhbh);
        if(yhbh!=null){
            Integer i= userService.selectYhbh(yhbh);
            System.out.println(i+"--------------------++++++++++++++++++");
            if (i != null) {
                //此用户编号已被使用
                return 1;
            }
            //此用户编号可以注册
            System.out.println("-------确认用户编号是否可使用------");
            return 0;
        }
        //此用户编号可以注册
        return 2;
    }

    //查询邮箱地址是否已被占用
    @RequestMapping(value = "selectemail",method = RequestMethod.POST)
    public @ResponseBody Integer selectemail(Model model, String email) {
        System.out.println("-------确认邮箱是否可使用------");
        System.out.println(email);
        if(email!=null){
            Integer i= userService.selectEmail(email);
            System.out.println(i+"____________________________");
            if (i != null) {
                model.addAttribute("messg", "此邮箱已注册");
                return 1;
            }
            model.addAttribute("messg", "此邮箱可以使用");
            return 0;
        }

        System.out.println("-------确认邮箱是否可使用------");
        return 2;
    }

    //添加用户
    @RequestMapping(value = "/adduser")
    public String adduser(Model model, User user) {
        System.out.println("-------添加用户------");
        boolean i = userService.addUser(user);
        if (i == true) {
            model.addAttribute("messg", "用户添加成功");
        }
        model.addAttribute("messg", "用户添加失败");
        System.out.println("-------添加用户------");
        return "info";
    }

    //发送验证码，并记录发送邮件记录
    @RequestMapping(value = "sendemail", method = RequestMethod.POST)
    public @ResponseBody  Integer sendEmail(Model model, String email, HttpServletRequest request) {

        System.out.println("----------发送邮件----------------");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60*5);
        String yzm = String.valueOf(Math.round(Math.random() * 1000000));
        session.setAttribute("yzm", yzm);
        System.out.println(yzm);
        Email email1s=new Email();
        if(email!=null){
            String to = request.getParameter("email");
            System.out.println(to);
            email1s.setToEmail(email);
            String context=SendEmail.SendEmail(to, yzm);
            email1s.setCheckCode(context);
            emailService.addemailTo(email1s);
        }
        System.out.println("-------已经发送邮件------");
        return 1;
    }

    //校验邮件验证码
    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    public String checkEmaiCode(Model model, String email,String yhbh, String password,HttpServletRequest request) {
        System.out.println("-------确认邮件验证码------");
        System.out.println(email);
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("yzm");
        System.out.println(code);
        String yzm = request.getParameter("yzm");
        System.out.println(yzm);
        User user=new User();
        if (yzm.equals(code)) {
            model.addAttribute("messg", "验证码正确");
            //验证码使用之后，把session存储的验证码移出
            session.removeAttribute("yzm");
            user.setYh_yhbh(yhbh);
            user.setYh_email(email);
            user.setYh_password(password);
            userService.addUser(user);
            System.out.println(yzm);
            return "login";
        }
        session.removeAttribute("yzm");
        model.addAttribute("messg", "验证码不正确");
        System.out.println("-------确认邮件验证码------");
        return "register";
    }

    //用户登陆,并记录登陆日志
    @RequestMapping(value = "/login")
    public String selectyhbh(Model model, String  username,String password,String ipAddress,String GoogleCode,HttpServletRequest request) {
        System.out.println("-------验证用户登陆------");
        // 获取 Session 中的谷歌验证码
        String token = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // 删除 Session 中的谷歌验证码
        request.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String loginstatu;
        System.out.println(token+"--------------"+GoogleCode+"----------------"+username);
        if (token != null && token.equalsIgnoreCase(GoogleCode)) {
            System.out.println("验证码正确----------------");
            System.out.println("ip地址+++++++++++++"+ipAddress);
            HttpSession session = request.getSession();
            Integer i=userService.getUser(username,password);
            String loginAction="login";
            System.out.println(ipAddress);
            LoginLog loginLog=new LoginLog();
            loginLog.setLogin_user(username);
            loginLog.setLogin_action(loginAction);
            loginLog.setLogin_address(ipAddress);
            if(i!=null){
                loginstatu="0";
                session.setAttribute("username",username);
                System.out.println(loginstatu);
                loginLog.setLogin_status(loginstatu);
                boolean b=userService.addLoginLog(loginLog);
                System.out.println(b);
                return "info";
            }else{
                loginstatu="1";
            }
            System.out.println(loginstatu);
            loginLog.setLogin_status(loginstatu);
            boolean b=userService.addLoginLog(loginLog);
            System.out.println(b);
        } else {
            System.out.println("验证码错误");

        }
        System.out.println("-------验证用户登陆------");
        return "login";
    }

    //用户注销登录
    @RequestMapping(value = "logout/{ip}")
    public String selectyhbh(Model model, @PathVariable("ip") String ipAddress, HttpServletRequest request) throws IOException {
        System.out.println("-------注销登陆-----------");
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("username");
        String loginAction="logout";
        LoginLog loginLog=new LoginLog();
        loginLog.setLogin_user(username);
        loginLog.setLogin_action(loginAction);
        loginLog.setLogin_status("0");
        BASE64Decoder decoder = new BASE64Decoder();
        String base64AfterIP=new String(decoder.decodeBuffer(ipAddress),"UTF-8");
        System.out.println(base64AfterIP);
        loginLog.setLogin_address(base64AfterIP);
        userService.addLoginLog(loginLog);
        session.invalidate();
        System.out.println("-------注销登陆-----------");
        return "register";
    }

    @RequestMapping(value = "getEmailTemp")
    public EmailTemp getEmailTemp(){
        Integer id=1;
        EmailTemp emailTemp=emailTempService.getEmailTempById(id);
        System.out.println(emailTemp);
        return emailTemp;
    };




}
