package cn.tedu.test;

import cn.tedu.domain.PErson2;
import cn.tedu.domain.Person;
import cn.tedu.domain.Teacher;
import cn.tedu.domain.pErson3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     *  注解方式注册bean
     *  id推断规则：
     *      如果手动指定了id，则采用指定的id
     *      如果没有指定id，则自动推断id
     *      自动推断id的规则为：
     *          看类名的第二个字母，
     *          如果第二个字母是小写，则类名首字母转小写为id
     *          如果类名第二个字母是大写，则首字母保持不变作为id
     */
    @Test
    public void test01(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        Person p = (Person) context.getBean("person");
        System.out.println(p);
        Teacher t = (Teacher) context.getBean("ter");
        System.out.println(t);
        PErson2 p2 = (PErson2) context.getBean("PErson2");
        System.out.println(p2);
        pErson3 p3 = (pErson3) context.getBean("pErson3");
        System.out.println(p3);
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
