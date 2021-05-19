package cn.tedu.web;

import cn.tedu.service.UserServiceImpl2;

public class UserServlet {

    //private UserServiceImpl userService = new UserServiceImpl();
    private UserServiceImpl2 userService = new UserServiceImpl2();

    public void addUser(){
        userService.addUser();
    }
}
