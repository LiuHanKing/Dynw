package com.aaa.util;

import com.aaa.handler.UserHandler;
import com.aaa.model.EmailTemp;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/*
@author lzw
@create 2020/9/24 22:04
*/
public class SendEmail {
    public static String  SendEmail(String toEmailAddress,String yzm){
        //EmailTemp emailTemp =UserHandler.getEmailTempById();

        // 发件人电子邮箱
        String fromEmail = "dynw@liuhanking.xyz";
        //String fromEmail =emailTemp.getFromEmail();
        //发件人邮箱密码
        String fromEmailPassword="dynw";
        //String fromEmailPassword=emailTemp.getFromEmailPassword();
        // 指定发送邮件的主机为 liuhanking.xyz
        String host = "39.105.200.254";  //邮件服务器
        //String host=emailTemp.getEmailHost();
        Properties props=new Properties();
        //开启账号验证
        props.setProperty("mail.smtp.auth", "true");
        //协议
        props.setProperty("mail.transport.protocol", "smtp");
        //邮箱服务器地址
        props.setProperty("mail.host", host);
        Session session=Session.getInstance(props,
                new Authenticator() {
                    //验证信息返回器
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, fromEmailPassword);
                    }
                }
        );
        String context="验证码是："+yzm+" 。有效期为5分钟 ,此邮件无需回复！！！";
        //String context=emailTemp.getEmailContext1()+yzm+emailTemp.getEmailContext2();
        //打开调试
        session.setDebug(true);
        try {
            Message msg=new MimeMessage(session);
            InternetAddress sendaddress=new InternetAddress(fromEmail);
            //发件人
            msg.setFrom(sendaddress);

            //主题
            String emailSubject="Dynw验证码邮件";
            //String emailSubject=emailTemp.getEmailSubject();
            msg.setSubject(emailSubject);

            //收件人
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
            //正文

            msg.setText(context);
            //发送邮件
            Transport.send(msg);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return context;
    }


}
