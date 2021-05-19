package cn.tedu.test;

import cn.tedu.web.UserServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Cglib动态代理 实现面向切面编程
 *      解决了代码混杂的问题
 *      解决了代码重复的问题
 *      基于继承实现，对于非接口方法同样可以实现代理
 *      第三方实现方案，必须导入相关开发包
 *      理论上性能比java动态代理要低一些
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
