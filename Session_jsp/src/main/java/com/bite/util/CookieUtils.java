package com.bite.util;

import javax.servlet.http.Cookie;

/**
 * 获取指定名称的cookie的工具类
 */
public class CookieUtils {

    public static  Cookie getCookieByName(String name, Cookie[] cookies) {
        //判断cookie数组是否ng
        if(cookies!=null){
            //遍历cookie数组
            for(Cookie cookie:cookies){
                //判断
                if(name.equals(cookie.getName())){
                    return cookie ;
                }
            }
        }
        return null ;
    }
}
