package cn.tedu.test;

import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态代理者 实现切面
 *      解决了代码混杂的问题
 *      没有解决代码重复的问题
 */
public class Test01 {
    @Test
    public void test01(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        UserServlet userServlet = context.getBean(UserServlet.class);
        userServlet.test();
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
