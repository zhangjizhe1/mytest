package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController01 {
    @RequestMapping("/my01/test01.action")
    public ModelAndView test01(){
        System.out.println("my01test01..");

        ModelAndView mav = new ModelAndView();
        mav.addObject("k1","v1");
        mav.addObject("k2","v2");
        mav.setViewName("my01test01");

        return mav;
    }
}
