package cn.tedu.web;

import cn.tedu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 控制器方法可以返回的返回值类型5 - 其他
     * 如果返回值类型是除以上情况外的其他情况，则无论返回什么，返回值会被存入模型中，作为模型数据来使用，值为当前置，键为当前值类型名首字母转小写
     * 并使用默认视图名作为视图名称来使用
     * 所谓默认视图名 = 当前控制器方法访问路径去除前后缀
     *  /my01/test07.action --> my01/test07
     *  http://localhost/SpringMVCDay02_02_ReturnType/my01/test07.action
     */
    @RequestMapping("/test07.action")
    public User test07(){
        return new User(9,"zzz",Arrays.asList("sz","gz"));
    }

    /**
     * 控制器方法可以返回的返回值类型4 - 被@ResponseBody修饰的方法
     * 如果控制器方法被@ResponseBody修饰，则无论返回值是什么，都会作为相应发送给浏览器
     *  如果是基本数据类型、String类型，则直接发送给浏览器
     *  如果是对象类型，则转换为json格式字符串发送给浏览器
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test06_1.action
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test06_2.action
     */
    @ResponseBody
    @RequestMapping("/test06_2.action")
    public User test06_2(){
        return new User(3,"xxx", Arrays.asList("bj","sh","gz"));
    }
    @ResponseBody
    @RequestMapping("/test06_1.action")
    public String test06_1(){
        return "abc";
    }

    /**
     * 控制器方法可以返回的返回值类型3 - void
     * 如果控制器方法返回值类型为void，将使用默认视图名作为视图名称来使用
     * 所谓默认视图名 = 当前控制器方法访问路径去除前后缀
     *  /my01/test05.action  -->  my01/test05
     *  http://localhost/SpringMVCDay02_02_ReturnType/my01/test05.action
     */
    @RequestMapping("/test05.action")
    public void test05(Model model){
        model.addAttribute("k1","v1");
        model.addAttribute("k2","v2");
    }

    /**
     * 控制器方法可以返回的返回值类型2 - redirect:开头的字符串
     * 返回redirect:开头的字符串可以实现请求重定向
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test04_2.action
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test04_1.action
     */
    @RequestMapping("/test04_2.action")
    public String test04_2(){
        return "redirect:/index.jsp";
    }
    @RequestMapping("/test04_1.action")
    public void test04_1(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    /**
     * 控制器方法可以返回的返回值类型2 - forward:开头的字符串
     * 返回forward:开头的字符串可以实现请求转发
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test03_2.action
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test03_1.action
     */
    @RequestMapping("/test03_2.action")
    public String test03_2() {
        return "forward:/index.jsp";
    }
    @RequestMapping("/test03_1.action")
    public void test03_1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    /**
     * 控制器方法可以返回的返回值类型2 - 普通字符串
     * 返回的普通字符串会作为视图名称来使用
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test02.action
     */
    @RequestMapping("/test02.action")
    public String test02(Model model){
        model.addAttribute("k1","v1");
        model.addAttribute("k2","v2");
        return "my01test02";
    }

    /**
     * 控制器方法可以返回的返回值1 - ModelAndView
     * http://localhost/SpringMVCDay02_02_ReturnType/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public ModelAndView test01(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("k1","v1");
        mav.addObject("k2","v2");
        mav.setViewName("my01test01");
        return mav;
    }
}
