package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 异常处理器
     * 当前控制器类内的任意控制器方法抛出异常时 都会自动转由当前这个异常处理器进行处理
     */
    @ExceptionHandler
    public String myExcpetionHandler(Exception e){
        System.out.println("#异常处理..记录日志.."+e);
        return "err01";
    }

    @RequestMapping("/test01.action")
    public void test01(){
        int i = 1/0;
    }
}
