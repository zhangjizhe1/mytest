package cn.tedu.test;

import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test01(){
        //1.创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        UserServlet userServlet = context.getBean(UserServlet.class);
        userServlet.test01();
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
