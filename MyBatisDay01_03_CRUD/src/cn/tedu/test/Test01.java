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
import java.util.Arrays;
import java.util.List;

public class Test01 {

    private SqlSessionFactory factory = null;
    private SqlSession session = null;

    @Before
    public void before(){
        try {
            InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        session.close();
    }

    /**
     * 删除
     */
    @Test
    public void delete2(){
        List list = Arrays.asList(2,3,5);
        session.delete("cn.tedu.mapper.UserMapper.del02",list);
        session.commit();
    }
    @Test
    public void delete(){
        User user = new User(0,null,0);
        session.delete("cn.tedu.mapper.UserMapper.del01",user);
        session.commit();
    }

    /**
     * 新增
     */
    @Test
    public void insert(){
        User user = new User(0,null,0);
        session.insert("cn.tedu.mapper.UserMapper.insert01",user);
        session.commit();
    }

    /**
     * 查询
     */
    @Test
    public void select(){
        User user = new User(0,null,0);
        List<User> list = session.selectList("cn.tedu.mapper.UserMapper.selc01", user);
        System.out.println(list);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        User user = new User(9,"tt",0);
        session.update("cn.tedu.mapper.UserMapper.update01",user);
        session.commit();
    }
}
