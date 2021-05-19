package cn.tedu.test;

import cn.tedu.domain.Person;
import cn.tedu.domain.Person2;
import cn.tedu.domain.Person3;
import cn.tedu.domain.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    /**
     * @Controller
     * @Service
     * @Repository
     * @Component 以上四个注解功能是一模一样的，都是用来将类注册为Spring管理的bean的注解
     */
    @Test
    public void test04() {
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        Person3 p = (Person3) context.getBean("person3");
        System.out.println(p);
        //3.关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }

    /**
     * @PostConstruct 初始化方法
     * @PreDestory 销毁方法
     */
    @Test
    public void test03() {
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.insert();
        userDao.delete();
        //3.关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }

    /**
     * @Lazy 懒加载
     */
    @Test
    public void test02() {
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        Person2 p1 = (Person2) context.getBean("person2");
        System.out.println(p1);
        Person2 p2 = (Person2) context.getBean("person2");
        System.out.println(p2);
        //3.关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }

    /**
     * @Scope 单例多例
     */
    @Test
    public void test01() {
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        Person p1 = (Person) context.getBean("person");
        System.out.println(p1);
        Person p2 = (Person) context.getBean("person");
        System.out.println(p2);
        //3.关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }
}
