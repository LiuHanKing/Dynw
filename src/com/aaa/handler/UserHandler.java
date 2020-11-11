package com.aaa.handler;


import com.aaa.model.*;
import com.aaa.service.EmailService;
import com.aaa.service.UserService;
import com.aaa.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
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

    //查询用户编号是否已被占用
    @RequestMapping(value = "selectyhbh", method = RequestMethod.POST)
    public @ResponseBody
    Integer selectyhbh(Model model, String yhbh) {
        System.out.println("-------确认用户编号是否可使用------");
        if (yhbh != null) {
            Integer i = userService.selectYhbh(yhbh);
            if (i != null) {
                //此用户编号已被使用
                return 1;
            }
            //此用户编号可以注册
            return 0;
        }
        System.out.println("-------确认用户编号是否可使用------");
        //此用户编号不可以注册
        return 2;
    };

    //查询邮箱地址是否已被占用
    @RequestMapping(value = "selectemail", method = RequestMethod.POST)
    public @ResponseBody
    Integer selectemail(Model model, String email) {
        System.out.println("-------确认邮箱是否可使用------");
        if (email != null) {
            Integer i = userService.selectEmail(email);
            if (i != null) {
                model.addAttribute("messg", "此邮箱已注册");
                return 1;
            }
            model.addAttribute("messg", "此邮箱可以使用");
            return 0;
        }
        System.out.println("-------确认邮箱是否可使用------");
        return 2;
    };

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
        return "main";
    };

    //发送验证码，并记录发送邮件记录
    @RequestMapping(value = "sendemail", method = RequestMethod.POST)
    public @ResponseBody
    Integer sendEmail(Model model, String email, HttpServletRequest request) {
        System.out.println("----------发送邮件----------------");
        HttpSession session = request.getSession();
        //设置session最大时间为5分钟
        session.setMaxInactiveInterval(60 * 5);
        //生成验证码
        String yzm = String.valueOf(Math.round(Math.random() * 1000000));
        //session添加验证码
        session.setAttribute("yzm", yzm);
        Email email1s = new Email();
        if (email != null) {
            //传递过来的邮箱地址
            String to = request.getParameter("email");
            //发送邮件
            email1s.setToEmail(email);
            String context = SendEmail.SendEmail(to, yzm);
            email1s.setCheckCode(context);
            //添加发送邮件记录
            emailService.addemailTo(email1s);
        }
        System.out.println("-------已经发送邮件------");
        return 1;
    };

    //校验邮件验证码并注册账号
    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    @ResponseBody
    public Map checkEmaiCode(String email, String password, HttpServletRequest request) {
        System.out.println("-------确认邮件验证码------");
        Map map = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        //session中添加验证码
        String code = (String) session.getAttribute("yzm");
        //传参过来的验证码
        String yzm = (request.getParameter("yzm")).trim();
        //查询邮箱是否已经注册账号
        Integer e = userService.selectEmail(email);
        //生成用户名称
        String StringName = System.currentTimeMillis() + "" + "YH_name";
        BASE64Encoder encoder = new BASE64Encoder();
        String base64BeforeStrName = encoder.encode(StringName.getBytes());
        //生成用户编号
        String yhbh = (base64BeforeStrName.substring(1, 4) + (System.currentTimeMillis() + "").substring(9, 13)).substring(1,10);
        //判断用户编号是否可用
        if (e == null) {
            User user = new User();
            if (yzm.equals(code)) {
                map.put("messg", "注册成功!  您的用户编号为" + yhbh);
                //验证码使用之后，把session存储的验证码移出
                session.removeAttribute("yzm");
                user.setYh_yhbh(yhbh);
                user.setYh_email(email);
                user.setYh_password(password);
                user.setYh_yname(base64BeforeStrName);
                //添加新注册的用户信息
                userService.addUser(user);
                return map;
            } else {
                //移出验证码
                session.removeAttribute("yzm");
                map.put("messg", "验证码不正确");
                return map;
            }
        }
        //移出验证码
        session.removeAttribute("yzm");
        map.put("messg", "用户编号或邮箱地址不可用");
        System.out.println("-------确认邮件验证码------");
        return map;
    };

    //用户登陆,并记录登陆日志
    @RequestMapping(value = "/login")
    public String selectyhbh(Model model, String username, String password, String ipAddress, String GoogleCode, HttpServletRequest request) {
        System.out.println("-------验证用户登陆------");
        //登陆状态
        String loginstatu = null;
        //登陆日志
        LoginLog loginLog = null;
        try {
            //查询账号状态
            User user1 = userService.getUserStatus(username);
            //账号错误次数
            int UserLoginErrorTimes = user1.getYh_wrongTimes();
            // 获取 Session 中的谷歌验证码
            String token = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
            // 删除 Session 中的谷歌验证码
            request.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
            loginstatu = null;
            //System.out.println(token + "--------------" + GoogleCode + "----------------" + username);
            String loginAction = "login";
            loginLog = new LoginLog();
            loginLog.setLogin_user(username);
            loginLog.setLogin_action(loginAction);
            loginLog.setLogin_address(ipAddress);
            //判断验证码是否一致
            if (token.equalsIgnoreCase(GoogleCode)) {
                System.out.println("验证码正确----------------");
                HttpSession session = request.getSession();
                //查询账号密码是否一致
                User user = userService.getUser(username, password);
                //根据输入的账号密码查询出的结果进行判断，存在账号的情况
                if (user != null) {
                    //账号状态和删除标志不同的各种情况，返回对应的提示信息
                    if (user.getYh_status().equals("0") && user.getYh_scbz().equals("0")) {
                        loginstatu = "0";
                        session.setAttribute("username", user.getYh_yname());
                        session.setAttribute("userid", user.getYh_id());
                        session.setAttribute("yhcaste", user.getYh_caste());
                        //添加登陆日志
                        loginLog.setLogin_status(loginstatu);
                        //重置错误次数
                        userService.updateUserWrongTimes(0, username);
                        return "user/user_in/main";
                    } else if (user.getYh_status().equals("1") && user.getYh_scbz().equals("0")) {
                        model.addAttribute("messg", "您的账号已被冻结！！！请到帮助进行处理");
                        loginstatu = "1";
                        loginLog.setLogin_status(loginstatu);
                        boolean b = userService.addLoginLog(loginLog);
                        return "login";
                    } else if (user.getYh_status().equals("2") && user.getYh_scbz().equals("0")) {
                        model.addAttribute("messg", "您的账号封停有效！！！请到帮助进行处理");
                        loginstatu = "1";
                        loginLog.setLogin_status(loginstatu);
                        boolean b = userService.addLoginLog(loginLog);
                        return "login";
                    } else if (user.getYh_status().equals("3") || user.getYh_scbz().equals("1")) {
                        model.addAttribute("messg", "您的账号无效！！！请到帮助进行处理");
                        loginstatu = "1";
                        loginLog.setLogin_status(loginstatu);
                        boolean b = userService.addLoginLog(loginLog);
                        return "login";
                    } else {
                        loginstatu = "1";
                        loginLog.setLogin_status(loginstatu);
                        model.addAttribute("messg", "请到帮助解决登陆问题");
                        boolean b = userService.addLoginLog(loginLog);
                        return "login";
                    }
                }

            } else {
                //验证码错误的情况
                if (UserLoginErrorTimes <= 2) {
                    boolean ifUp = userService.updateUserWrongTimes(UserLoginErrorTimes+1, username);
                    if (ifUp) {
                        model.addAttribute("messg", "当前错误次数：" + (UserLoginErrorTimes + 1) + "。当错误次数达到三次，账号会被冻结！！！");
                    }
                } else if (UserLoginErrorTimes == 3) {
                    boolean ifBe = userService.updateUserBeFreeze(username);
                    if (ifBe) {
                        model.addAttribute("messg", "当前错误次数已达到3次，账号已冻结。请到帮助解除冻结！！！");
                    }
                }
                loginstatu = "1";
                loginLog.setLogin_status(loginstatu);
                System.out.println("验证码错误");
                model.addAttribute("messg", "验证码错误");
                boolean b = userService.addLoginLog(loginLog);
                System.out.println("-------验证码错误------");
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginstatu = "1";
        loginLog.setLogin_status(loginstatu);
        model.addAttribute("messg", "请到帮助");
        boolean b = userService.addLoginLog(loginLog);
        System.out.println("-------请到帮助------");
        return "login";
    };

    //用户注销登录
    @RequestMapping(value = "logout")
    @ResponseBody
    public boolean selectyhbh(Model model,String ipAddress, HttpServletRequest request) throws IOException {
        System.out.println("-------注销登陆-----------");
        HttpSession session = request.getSession();
        String loginAction = "logout";
        LoginLog loginLog = new LoginLog();
        String username= (String) session.getAttribute("username");
        loginLog.setLogin_user(username);
        loginLog.setLogin_action(loginAction);
        loginLog.setLogin_status("0");
        BASE64Decoder decoder = new BASE64Decoder();
        //把传过来的ip解码
        String base64AfterIP = new String(decoder.decodeBuffer(ipAddress), "UTF-8");
        loginLog.setLogin_address(base64AfterIP);
        userService.addLoginLog(loginLog);
        session.invalidate();
        System.out.println("-------注销登陆-----------");
        return true;
    };

    //检查用户的旧密码是否正确
    @RequestMapping(value = "checkoldpass", method = RequestMethod.POST)
    public @ResponseBody
    boolean checkoldpass(Model model, String username, String password) {
        System.out.println("++++++++++校验旧密码+++++++++++");
        User user = userService.getUser(username, password);
        if (user != null) {
            return true;
        }
        return false;
    };

    //修改用户密码
    @RequestMapping(value = "changepass", method = RequestMethod.POST)
    public @ResponseBody
    boolean changepass(Model model, String username, String password) {
        System.out.println("++++++++++修改密码+++++++++++");
        boolean ifchange = userService.updateUserPass(username, password);
        return ifchange;
    }

    //重置用户密码
    @RequestMapping(value = "resetpass", method = RequestMethod.POST)
    public @ResponseBody
    boolean resetpass(Model model, String yzm, String email, String password, HttpServletRequest request) {
        System.out.println("++++++++++重置密码+++++++++++");
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("yzm");
        String yzmcode = yzm.trim();
        boolean ifchange = false;
        if (code.equals(yzmcode)) {
            ifchange = userService.updateUserPassByEmail(email, password);
            System.out.println(ifchange + "----------------------");
        }
        return ifchange;
    }

    //查询账号状态account
    @RequestMapping(value = "getUserStatus", method = RequestMethod.POST)
    public @ResponseBody
    Map getUserStatus(String account) {
        System.out.println(account + "---------------account----------------");
        Map map = new HashMap<String, Object>();
        if (account != null) {
            User user = null;
            try {
                user = userService.getUserStatus(account);
                map.put("userid", user.getYh_id());
                System.out.println(user + "++++++++++++++++++++++++++++++++++");
                if (user != null) {
                    if (user.getYh_scbz().equals("0") && user.getYh_status().equals("0")) {
                        map.put("account", account);
                        map.put("status", "账号正常");
                        map.put("cz", "1");
                        return map;
                    } else if (user.getYh_scbz().equals("0") && user.getYh_status().equals("1")) {
                        map.put("account", account);
                        map.put("status", "账号已冻结");
                        map.put("cz", "2");
                        return map;
                    } else if (user.getYh_scbz().equals("0") && user.getYh_status().equals("2")) {
                        map.put("account", account);
                        map.put("status", "账号已封停");
                        map.put("cz", "3");
                        return map;
                    } else if (user.getYh_scbz().equals("1") || user.getYh_status().equals("3")) {
                        map.put("account", account);
                        map.put("status", "账号已注销");
                        map.put("cz", "4");
                        return map;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                map.put("account", account);
                map.put("status", "账号不存在");
                map.put("cz", "5");
                return map;
            }

        }
        map.put("account", account);
        map.put("status", "账号不能为空");
        map.put("cz", "6");
        return map;
    }

    //解除账号冻结
    @RequestMapping(value = "updateAccountFreeze", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateAccountFreeze(String email, String yzm, HttpServletRequest request) {
        System.out.println("-----------解除账号冻结-------");
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("yzm");
        String yzmcode = yzm.trim();
        boolean isUnfreeze = false;
        if (yzmcode.equals(yzmcode)) {
            isUnfreeze = userService.updateUserFreeze(email);
            if (isUnfreeze) {
                userService.updateUserWrongTimes(0, email);
            }
        }
        return isUnfreeze;
    }

}

