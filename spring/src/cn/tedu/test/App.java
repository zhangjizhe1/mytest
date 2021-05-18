package cn.tedu.test;

import cn.tedu.domain.Animal;
import cn.tedu.domain.Person;
import cn.tedu.domain.Second;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    @Test
    public void spring08(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContest.xml");

        context.close();
    }
    @Test
    public void spring07(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContest.xml");
        Person p=(Person)context.getBean(Person.class);
        p.eat();
        context.close();
    }
    @Test
    public void spring06(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContest.xml");
        Second s=context.getBean(Second.class);
        s.run();
        context.close();
    }
    @Test
    public void spring5(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContest.xml");
        Animal a1=(Animal) context.getBean("animal");
        Animal a2=(Animal) context.getBean("animal1");
        System.out.println(a1==a2);
        context.close();
    }
    @Test
    public void spring04(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContest.xml");
        Animal a1=(Animal) context.getBean("animal");
        Animal a2=(Animal) context.getBean("animal");
        System.out.println(a1);
        System.out.println(a2);
        context.close();
    }
    @Test
    public void spring03(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContest.xml");
        Animal animal=(Animal) context.getBean("animal");
        animal.sleep();
        context.close();
    }
    @Test
    public void spring02(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContest.xml");
        Person p=(Person)context.getBean("person");
        System.out.println(p);
        p.eat();
        context.close();
    }
    @Test
    public void spring01(){
        Person  p=new Person("张三",20);
        System.out.println(p);
    }

}
