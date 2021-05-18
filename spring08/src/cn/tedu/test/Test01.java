package cn.tedu.test;

import cn.tedu.domain.NetConn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     * 注解方式实现工厂注册Bean
     */
    @Test
    public void test01(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        NetConn nc = (NetConn) context.getBean("nc");
        nc.sendData();
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
