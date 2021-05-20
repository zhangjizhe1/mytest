package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * SpringMVC作用域 - request域
 */
@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * SpringMVC作用域 - request域 - SpringMVC方式
     * 向模型中写入的数据 本质上就是将数据写入了request域
     * http://localhost/SpringMVCDay02_03_Details01_Scope/my01/test03.action
     */
    @RequestMapping("/test04.action")
    public void test04(@RequestAttribute("k1") String k1,@RequestAttribute("k2") String k2){
        System.out.println(k1);
        System.out.println(k2);
    }
    @RequestMapping("/test03.action")
    public String test03(Model model){
        model.addAttribute("k1","v1");
        model.addAttribute("k2","v2");
        return "forward:/my01/test04.action";
    }

    /**
     * SpringMVC作用域 - request域 - 传统方式
     * http://localhost/SpringMVCDay02_03_Details01_Scope/my01/test01.action
     */
    @RequestMapping("/test02.action")
    public void test02(HttpServletRequest request){
        String k1 = (String) request.getAttribute("k1");
        String k2 = (String) request.getAttribute("k2");
        System.out.println(k1);
        System.out.println(k2);
    }
    @RequestMapping("/test01.action")
    public String test01(HttpServletRequest request){
        request.setAttribute("k1","v1");
        request.setAttribute("k2","v2");
        return "forward:/my01/test02.action";
    }
}
