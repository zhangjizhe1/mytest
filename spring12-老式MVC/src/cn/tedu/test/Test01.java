package cn.tedu.test;

import cn.tedu.web.UserServlet;
import org.junit.Test;

public class Test01 {
    @Test
    public void test01(){
        UserServlet userServlet = new UserServlet();
        userServlet.addUser();
    }
}
