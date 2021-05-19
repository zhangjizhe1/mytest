package cn.tedu.web;

import cn.tedu.domain.User;
import cn.tedu.service.ProdService;
import cn.tedu.service.UserService;
import cn.tedu.service.aaa.bbb.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {
    @Autowired

    private UserService userService = null;
    @Autowired
    private ProdService prodService = null;
    @Autowired
    private OrderService orderService = null;

    public void test01(){
        userService.addUser(new User());
        userService.delUser(3);
        System.out.println(userService.queryUser("zs",18));

        prodService.addProd();
        prodService.delProd();

        orderService.addOrder();
        orderService.queryOrder();
    }
}
