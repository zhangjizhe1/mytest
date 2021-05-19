package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Map;

/**
 * 控制器方法可以接收的参数
 */
@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 控制器方法可以接收的参数3 - 模型对象
     *  Model
     *  Map
     *  ModelMap
     *  http://localhost/SpringMVCDay01_03_ParamType/my01/test03_4.action
     *  http://localhost/SpringMVCDay01_03_ParamType/my01/test03_3.action
     *  http://localhost/SpringMVCDay01_03_ParamType/my01/test03_2.action
     *  http://localhost/SpringMVCDay01_03_ParamType/my01/test03_1.action
     */
    @RequestMapping("/test03_4.action")
    public String test03_4(ModelMap mm){
        mm.addAttribute("k1","v1");
        mm.put("k2","v2");
        return "my01test03_4";
    }
    @RequestMapping("/test03_3.action")
    public String test03_3(Map map){
        map.put("k1","v1");
        map.put("k2","v2");
        return "my01test03_3";
    }
    @RequestMapping("/test03_2.action")
    public String test03_2(Model model){
        model.addAttribute("k1","v1");
        model.addAttribute("k2","v2");
        return "my01test03_2";
    }
    @RequestMapping("/test03_1.action")
    public ModelAndView test03_1(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("k1","v1");
        mav.addObject("k2","v2");
        mav.setViewName("my01test03_1");
        return mav;
    }

    /**
     * 控制器方法可以接收的参数2 - web开发相关的流对象
     *  InputStream - request.getInputStream()
     *  OutputStream - response.getOutputStream()
     *  Reader - request.getReader()
     *  Writer - response.getWrtier()
     *  http://localhost/SpringMVCDay01_03_ParamType/my01/test02.action
     */
    @RequestMapping("/test02.action")
    public void test02(Writer writer) throws IOException {
        writer.write("abc");
    }

    /**
     * 控制器方法可以接收的参数1 - web开发相关的对象
     *  HttpServletRequest
     *  HttpServletResponse
     *  HttpSession
     *  WebRequest - requset对象和session对象的合体
     *  http://localhost/SpringMVCDay01_03_ParamType/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletRequest request, HttpServletResponse response, HttpSession session, WebRequest wreq) throws IOException {
        String ip = request.getRemoteAddr();
        System.out.println(ip);

        response.getWriter().write("hello mvc!");

        String id = session.getId();
        System.out.println(id);
    }
}
