package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/my03")
public class MyController03 {
    /**
     *  SpringMVC资源跳转 - 定时刷新 - 传统方式
     *  http://localhost/SpringMVCDay02_04_Details02_Redirect/my03/test01.action
     */
    @ResponseBody
    @RequestMapping(value = "/test01.action",produces = "text/html;charset=utf-8")
    public String test01(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Refresh","3;url="+request.getContextPath()+"/index.jsp");
        return "恭喜您注册成功！3秒后回到主页..";
    }
}
