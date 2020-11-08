package com.aaa.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
@author lzw
@create 2020/11/8 19:58
*/
public class OnlineListener implements HttpSessionListener {
    private static int OnlineNumberCount = 0;//初始化数量

    public static int getOnlineNumberCount() {
        return OnlineNumberCount;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //把数据放到整个应用中公共区域ServletContext中
        OnlineNumberCount++;
        //判断obj是否有值
        System.out.println("session创建");
        System.out.println("当前访问人数：" + OnlineNumberCount);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //每销毁一次就-1
        OnlineNumberCount--;
        System.out.println("session销毁");
        System.out.println("当前访问人数" + OnlineNumberCount--);


    }
}
