package cn.tedu.text;

import cn.tedu.domain.NetConn;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

    /**
     * Spring工厂方式创建bean - spring工厂
     */
    @Test
    public void test03(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        //2.获取bean
        NetConn nc = (NetConn) context.getBean("nc");
        nc.sendData();
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * Spring工厂方式创建bean - 实例工厂
     */
    @Test
    public void test02(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //2.获取bean
        NetConn nc = (NetConn) context.getBean("nc");
        nc.sendData();
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
    /**
     * Spring工厂方式创建bean - 静态工厂
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
