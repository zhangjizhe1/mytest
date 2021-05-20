package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/my02")
public class MyController02 {

    /**
     *  SpringMVC资源跳转 - 请求重定向 - SpringMVC方式
     *  返回redirect:开头的字符串实现请求重定向
     *  http://localhost/SpringMVCDay02_04_Details02_Redirect/my02/test02.action
     */
    @RequestMapping("/test02.action")
    public String test02(){
        return "redirect:/index.jsp";
    }

    /**
     * SpringMVC资源跳转 - 请求重定向 - 传统方式
     * http://localhost/SpringMVCDay02_04_Details02_Redirect/my02/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
