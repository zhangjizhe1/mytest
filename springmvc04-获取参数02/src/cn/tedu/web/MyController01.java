package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 控制器方法可以接收的参数9 - 获取请求体内容
     * @RequestBody 直接获取请求体内容
     * http://localhost/SpringMVCDay02_01_ParamType/my01/test06.action
     */
    @RequestMapping("/test06.action")
    public void test06(@RequestBody String body){
        System.out.println(body);
    }

    /**
     * 控制器方法可以接收的参数8 - 路径参数
     * @PathVariable 路径参数获取
     * http://localhost/SpringMVCDay02_01_ParamType/my01/test05/zs/18.action
     * http://localhost/SpringMVCDay02_01_ParamType/my01/test05/ls/23.action
     */
    @RequestMapping("/test05/{uname}/{uage}.action")
    public void test05(@PathVariable("uname") String uname, @PathVariable("uage") String uage){
        System.out.println(uname);
        System.out.println(uage);
    }

    /**
     * 控制器方法可以接收的参数7 - 请求头的值
     * @RequestHeader 获取指定名称请求头的值
     * http://localhost/SpringMVCDay02_01_ParamType/my01/test04.action
     */
    @RequestMapping("/test04.action")
    public void test04(@RequestHeader("host") String host){
        System.out.println(host);
    }

    /**
     * 控制器方法可以接收的参数6 - cookie值
     * @CookieValue 获取指定名称cookie的值
     * http://localhost/SpringMVCDay02_01_ParamType/my01/test03.action
     */
    @RequestMapping("/test03.action")
    public void test03(@CookieValue("JSESSIONID") String JSESSIONID){
        System.out.println(JSESSIONID);
    }

    /**
     * 控制器方法可以接收的参数5 - 域属性
     * @RequestAttribute 从request域中获取数据
     * @SessionAttribute 从session域中获取数据
     * http://localhost/SpringMVCDay02_01_ParamType/my01/test02_1.action
     */
    @RequestMapping("/test02_2.action")
    public void test02_2(@RequestAttribute("k1") String k1, @RequestAttribute("k2") String k2, @SessionAttribute("k3") String k3,@SessionAttribute("k4") String k4){
        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
        System.out.println(k4);
    }
    @RequestMapping("/test02_1.action")
    public String test02_1(HttpServletRequest request, HttpSession session){
        request.setAttribute("k1","v1");
        request.setAttribute("k2","v2");
        session.setAttribute("k3","v3");
        session.setAttribute("k4","v4");
        return "forward:/my01/test02_2.action";
    }

    /**
     * 控制器方法可以接收的参数4 - 请求参数 - 中文乱码处理
     *  http://localhost/SpringMVCDay02_01_ParamType/my01test01.jsp
     */
    @RequestMapping("/test01.action")
    public void test01(String uname, String uaddr) throws UnsupportedEncodingException {
        System.out.println(uname + "~" + uaddr);
    }
}
