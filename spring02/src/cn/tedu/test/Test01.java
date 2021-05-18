package cn.tedu.test;

import cn.tedu.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     * 多例bean的生命周期:
     *      容器初始化时 发现多例的bean 不会创建对象 只是保存了类的信息
     *      之后每次获取该bean  都重新创建并返回新的对象
     *      这些对象也不会被保留在容器内部Map中
     *      什么时候销毁 完全取决于用户
     */
    @Test
    public void test02(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //2.获取bean
        Person p1 = (Person) context.getBean("person");
        System.out.println(p1);
        Person p2 = (Person) context.getBean("person");
        System.out.println(p2);
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * 单例bean生命周期:
     *      在容器初始化的过程中创建对象
     *      创建出来的对象被保存在容器内部的Map中
     *      之后每次获取得到的都是这个对象
     *      直到容器被关闭时 随着容器的销毁 容器内部保存的对象被移除
     */
    @Test
    public void test01(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        Person p1 = (Person) context.getBean("person");
        System.out.println(p1);
        Person p2 = (Person) context.getBean("person");
        System.out.println(p2);
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
