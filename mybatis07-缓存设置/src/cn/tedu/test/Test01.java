package cn.tedu.test;

import cn.tedu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test01 {

    /**
     *  二级缓存
     *  全局生效 默认关闭 需要手动开启
     */
    @Test
    public void test02() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session1 = factory.openSession();
        User user = session1.selectOne("cn.tedu.mapper.UserMapper.selc01",3);
        System.out.println(user);
        session1.close();

        SqlSession session2 = factory.openSession();
        User user2 = session2.selectOne("cn.tedu.mapper.UserMapper.selc01",3);
        System.out.println(user2);
        session2.close();
    }

    /**
     *  一级缓存
     *  在一个事务内生效 默认开启 无法关闭
     */
    @Test
    public void test01() throws IOException {
        //1.创建SqlSessionFactory
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //2.创建session
        SqlSession session = factory.openSession();

        //3.执行sql
        User user = session.selectOne("cn.tedu.mapper.UserMapper.selc01",3);
        System.out.println(user);
        User user2 = session.selectOne("cn.tedu.mapper.UserMapper.selc01",3);
        System.out.println(user);

        //4关闭session
        session.close();
    }

}
