package cn.tedu.test;

import cn.tedu.domain.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     * 初始化/销毁方法 - Spring方式
     */
    @Test
    public void test02(){
        //1.初始化Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.insert();
        userDao.delete();
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }

    /**
     * 初始化/销毁方法 - 手动调用
     */
    @Test
    public void test01(){
        UserDao userDao = new UserDao();
        userDao.myInit();

        userDao.insert();
        userDao.delete();

        userDao.myDestory();
    }
}
