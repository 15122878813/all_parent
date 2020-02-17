package com.toec.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
    public static String getCookieName(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String user_name = null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user_name")){
                user_name = cookie.getValue();
            }
        }
        return user_name;
    }
}
