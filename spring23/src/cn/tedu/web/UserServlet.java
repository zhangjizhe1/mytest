package cn.tedu.web;

import cn.tedu.domain.User;
import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {
    @Autowired
    private UserService userService = null;

    public void test01(){
        //userService.addUser(new User());
        //userService.delUser(3);
        User user = userService.queryUser("zs",18);
        System.out.println(user);
        //userService.updateUser();
    }
}
