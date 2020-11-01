package com.aaa.util;

import javax.servlet.http.Cookie;

/*
Created by IntelliJ IDEA 2019.3.4.
@author lzw
@create 2020/8/30 13:12
*/
public class CookieUntil {
    /*查找指定的名称的cookie对象
     * */

    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
