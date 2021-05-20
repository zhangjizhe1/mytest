package cn.tedu.web;

import cn.tedu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 发送json格式数据
     * http://localhost/SpringMVCDay02_07_Details05_Json/my01/test01.action
     */
    @ResponseBody
    @RequestMapping("/test01.action")
    public User test01(){
        User user = new User(3,"zs", Arrays.asList("bj","sh","gz"));
        return user;
    }

    /**
     * 接收json格式数据
     * http://localhost/SpringMVCDay02_07_Details05_Json/test02.jsp
     */
    @RequestMapping("/test02.action")
    public void test02(@RequestBody User user){
        System.out.println(user);
    }
}
