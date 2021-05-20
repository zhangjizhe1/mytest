package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my02")
public class MyController02 {
    @RequestMapping("/test01.action")
    public void test01(){
        int i = 1/0;
    }
    @RequestMapping("/test02.action")
    public void test02(){
        throw new NullPointerException();
    }
}
