package cn.tedu.web;

import cn.tedu.domain.User;
import cn.tedu.domain.User2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器方法可以接收的参数
 */
@Controller
@RequestMapping("/my02")
public class MyController02 {

    /**
     * 控制器方法可以接收的参数5 - 请求参数 - 封装请求参数到bean
     * http://localhost/SpringMVCDay01_03_ParamType/my02/test04_3.action?uname=zs&uage=18&udog.dname=wc&udog.dage=3
     * http://localhost/SpringMVCDay01_03_ParamType/my02/test04_2.action?uname=zs&uage=18
     * http://localhost/SpringMVCDay01_03_ParamType/my02/test04_1.action?uname=zs&uage=18
     */
    @RequestMapping("/test04_3.action")
    public void test04_3(User2 user2){
        System.out.println(user2);
    }
    @RequestMapping("/test04_2.action")
    public void test04_2(User user){
        System.out.println(user);
    }
    @RequestMapping("/test04_1.action")
    public void test04_1(String uname,int uage){
        User user= new User();
        user.setUname(uname);
        user.setUage(uage);
        System.out.println(user);
    }

    /**
     * 控制器方法可以接收的参数4 - 请求参数 - 手动映射获取请求参数
     * http://localhost/SpringMVCDay01_03_ParamType/my02/test03.action?uname=zs&uage=18
     */
    @RequestMapping("/test03.action")
    public void test03(@RequestParam("uname") String username,@RequestParam("uage") int userage){
        System.out.println(username+"~"+userage);
    }

    /**
     * 控制器方法可以接收的参数4 - 请求参数 - 直接过去请求参数
     * http://localhost/SpringMVCDay01_03_ParamType/my02/test02.action?uname=zs&uage=18
     */
    @RequestMapping("/test02.action")
    public void test02(String uname,int uage){
        System.out.println(uname+"~"+uage);
    }

    /**
     * 控制器方法可以接收的参数4 - 请求参数 - 同求request获取请求参数
     * http://localhost/SpringMVCDay01_03_ParamType/my02/test01.action?uname=zs&uage=18
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletRequest request){
        String uname = request.getParameter("uname");
        int uage = Integer.parseInt(request.getParameter("uage"));
        System.out.println(uname+"~"+uage);
    }
}
