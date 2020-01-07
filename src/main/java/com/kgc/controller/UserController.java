package com.kgc.controller;

import com.kgc.pojo.User;
import com.kgc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
   private UserService userService;

    @RequestMapping("getUserList")
    public Object getUserList(){
       List<User> user =  userService.getUserList();
       return user;
    }
    @RequestMapping("user")
    public Object getList(){
        List<User> user = userService.getList();
        return user;
    }
}
