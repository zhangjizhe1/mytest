package cn.tedu.test;

import org.junit.Test;

class Person{
    @Deprecated
    public void eat(){
        System.out.println("吃..");
    }

    public void eat2(){
        System.out.println("洗手..吃..");
    }

    public void say(){
        System.out.println("说..");
    }
}

class Teacher extends Person{
    @Override
    public void say(){
        System.out.println("一本正经的说..");
    }
}

public class Test02 {
    @Test
    public void test01(){
        Teacher t = new Teacher();
        t.eat();
        t.say();
        t.eat2();
    }
}
