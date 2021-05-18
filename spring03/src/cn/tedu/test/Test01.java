package cn.tedu.test;

import cn.tedu.domain.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    /**
     * 懒加载：
     *      将创建的对象的时机延迟到第一次使用该对象时
     *      仅仅是延迟了创建时机，该是单例的 仍然是 单例的
     *      多例bean配置懒加载没有意义！
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
