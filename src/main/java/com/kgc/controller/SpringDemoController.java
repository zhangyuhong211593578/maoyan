package com.kgc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SpringDemoController {

    @RequestMapping("hello")
    public Object hello(){
        return "hello";
    }
    @RequestMapping("view/hello")
    public Object view(){
        return "hello view";
    }
    @RequestMapping("show1")
    public Object show1(HttpSession session){
        System.out.println(session.getId());
        return session.getId();

    }

    @RequestMapping("login")
    public Object login (HttpServletResponse response) throws UnsupportedEncodingException {
        String username = "哈哈哈";
        username = URLEncoder.encode(username,"UTF-8");
        System.out.println(username);
        Cookie cookie = new Cookie("username",username);
        cookie.setPath("/");
        cookie.setMaxAge(60*5);
        response.addCookie(cookie);
        return true;
    }

    @RequestMapping("getUserName")
    public Object getUserName(HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String,Object> map = new HashMap<String, Object>();
        //Cookie的获取
        Cookie[] cookies = request.getCookies();
        String username = "";
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.equals("username")) {
                String value = cookie.getValue();
                username = URLDecoder.decode(value, "UTF-8");
            }
        }
        map.put("result",username);
        return map;
    }
}
