package cn.tedu.test;

import cn.tedu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    private SqlSessionFactory factory  = null;
    private SqlSession session = null;

    @Before
    public void before(){
        try {
            //1.创建SqlSessionFactory
            InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
            //2.创建session
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        //4.关闭session
        session.close();
    }

    /**
     * sql复用
     */
    @Test
    public void test02(){
        User user = session.selectOne("cn.tedu.mapper.UserMapper2.selc01", 3);
        System.out.println(user);
    }

    /**
     * 别名标签
     */
    @Test
    public void test01(){
        List<User> list = session.selectList("cn.tedu.mapper.UserMapper.selc01");
        System.out.println(list);
    }

}
