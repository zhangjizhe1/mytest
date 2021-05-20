package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * SpringMVC作用域 - session域
 */
@Controller
@RequestMapping("/my02")
@SessionAttributes({"sk1","sk2"})
public class MyController02 {

    /**
     * SpringMVC作用域 - session域 - SpringMVC方式
     *  向模型中写入数据 同时在控制器类上通过@SessionAttributes注解标注此属性 则这个属性会被同时拷贝到session域中
     *  从而实现向session中写入数据
     *  http://localhost/SpringMVCDay02_03_Details01_Scope/my02/test04.action
     *  http://localhost/SpringMVCDay02_03_Details01_Scope/my02/test03.action
     */
    @RequestMapping("/test04.action")
    public void test04(@SessionAttribute("sk1") String sk1,@SessionAttribute("sk2") String sk2){
        System.out.println("sk1");
        System.out.println("sk2");
    }
    @RequestMapping("/test03.action")
    public void test03(Model model){
        model.addAttribute("sk1","sv1");
        model.addAttribute("sk2","sv2");
    }

    /**
     * SpringMVC作用域 - session域 - 传统方式
     * localhost/SpringMVCDay02_03_Details01_Scope/my02/test02.action
     * localhost/SpringMVCDay02_03_Details01_Scope/my02/test01.action
     */
    @RequestMapping("/test02.action")
    public void test02(HttpSession session){
        String sk1 = (String) session.getAttribute("sk1");
        String sk2 = (String) session.getAttribute("sk2");
        System.out.println(sk1);
        System.out.println(sk2);
    }
    @RequestMapping("/test01.action")
    public void test01(HttpSession session){
        session.setAttribute("sk1","sv1");
        session.setAttribute("sk2","sv2");
    }
}
