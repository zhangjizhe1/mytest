package cn.tedu.web;

import cn.tedu.enums.Role;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {
    //当前用户角色
    public static Role role = Role.ADMIN;

    @Autowired
    private UserService userService = null;

    public void test01(){
        //userService.addUser();
        //userService.queryUser();
        //userService.updateUser();
        userService.delUser();
    }
}
