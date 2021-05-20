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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {
    private SqlSessionFactory factory = null;
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
     * 值传递3 - 单值传递
     */
    @Test
    public void test03(){
        User user = session.selectOne("cn.tedu.mapper.UserMapper.selc02", 3);
        System.out.println(user);
    }

    /**
     * 值传递2 - bean传递
     */
    @Test
    public void test02(){
        User user = new User();
        user.setId(9);
        user.setName("xx");
        user.setAge(99);
        session.insert("cn.tedu.mapper.UserMapper.insert01",user);
        session.commit();
    }

    /**
     * 值传递1 - Map传递
     */
    @Test
    public void test01() throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("min",20);
        map.put("max",30);
        List<User> list = session.selectList("cn.tedu.mapper.UserMapper.selc01",map);
        System.out.println(list);
    }
}
