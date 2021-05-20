package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * SpringMVC作用域 - ServletContext域
 */
@Controller
@RequestMapping("/my03")
public class MyController03 {
    /**
     * SpringMVC作用域 - ServletContext域 - 传统方式
     * http://localhost/SpringMVCDay02_03_Details01_Scope/my03/test02.action
     * http://localhost/SpringMVCDay02_03_Details01_Scope/my03/test01.action
     */
    @RequestMapping("/test02.action")
    public void test02(HttpServletRequest request){
        ServletContext sc = request.getServletContext();
        String sck1 = (String) sc.getAttribute("sck1");
        String sck2 = (String) sc.getAttribute("sck2");
        System.out.println(sck1);
        System.out.println(sck2);
    }
    @RequestMapping("/test01.action")
    public void test01(HttpServletRequest request){
        ServletContext sc = request.getServletContext();
        sc.setAttribute("sck1","scv1");
        sc.setAttribute("sck2","scv2");
    }
}
