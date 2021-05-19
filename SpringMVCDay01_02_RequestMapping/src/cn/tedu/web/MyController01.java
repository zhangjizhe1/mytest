package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/my01")
public class MyController01 {
    /**
     *  String[] headers() default {};
     *  限定对请求头的要求，只有请求头符合要求的请求才可以进来
     *       格式1:只指定名称，要求必须具有该名称的请求头
     *      格式2:以"!名称"的方式指定必须不包含指定名称的请求头
     *      格式3:以"名称=值"或"名称!=值"的方式指定必须具有某个请求头，且值必须等于或不等于给定值
     */
    @RequestMapping(value="/test05.action",headers = {"Host=localhost"})
    public void test05(){
        System.out.println("my01..test05..");
    }

    /**
     * String[] params()
     *  限定对请求参数的要求,只有请求参数符合要求的请求才可以进来
     *      格式1:只指定名称，要求必须具有该名称的请求参数
     *      格式2:以"!名称"的方式指定必须不包含指定名称的请求参数
     *      格式3:以"名称=值"或"名称!=值"的方式指定必须具有某个请求参数，且值必须等于或不等于给定值
     *  http://localhost/SpringMVCDay01_02_RequestMapping/my01/test04.action?uname=zs&ucity=bj&ugedner=female
     *  http://localhost/SpringMVCDay01_02_RequestMapping/my01/test04.action?uname=zs&uage=18&ucity=bj&ugedner=female
     *  http://localhost/SpringMVCDay01_02_RequestMapping/my01/test04.action?uname=zs&ucity=sh&ugedner=female
     *  http://localhost/SpringMVCDay01_02_RequestMapping/my01/test04.action?uname=zs&ucity=bj&ugender=male
     */
    @RequestMapping(value="/test04.action",params = {"uname","!uage","ucity=bj","ugender!=male"})
    public void test04(){
        System.out.println("my01..test04..");
    }

    /**
     * RequestMethod[] method() 属性
     *  用来限定当前控制器方法可以接收哪些请求方式的请求
     *  如果不配置，则接收任意请求方式的请求
     *  如果配置，则只接收指定请求方式的请求
     *  http://localhost/SpringMVCDay01_02_RequestMapping/my01/test03.action
     */
    @RequestMapping(value="/test03.action",method = {RequestMethod.GET})
    public void test03(){
        System.out.println("my01..test03..");
    }

    /**
     * String[] value() 属性
     *  指定访问路径
     *  可以使用*号通配符 通配路径
     *  http://localhost/SpringMVCDay01_02_RequestMapping/my01/test02.action
     *  http://localhost/SpringMVCDay01_02_RequestMapping/my01/test02xyz.action
     */
    @RequestMapping({"/test02.action","/test02*.action"})
    public void test02(){
        System.out.println("my01..test02..");
    }

    /**
     * @RequestMaping 的基本使用
     * http://localhost/SpringMVCDay01_02_RequestMapping/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(){
        System.out.println("my01..test01..");
    }
}
