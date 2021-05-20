package cn.tedu.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 */
//@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ExceptionHandler
    public String myGExceptionHandler(Exception e){
        System.out.println("#全局异常处理..记录日志.."+e);
        return "mgerr";
    }
}
