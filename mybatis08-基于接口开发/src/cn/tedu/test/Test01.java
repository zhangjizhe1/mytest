package cn.tedu.test;

import cn.tedu.domain.User;
import cn.tedu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test01 {

    /**
     * MyBatis基于接口开发
     */
    @Test
    public void test01() throws IOException {
        //1.创建SqlSessionFactory
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //2.创建SqlSession
        SqlSession session = factory.openSession();
        //3.获取Mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        //4.调用方法
        //mapper.insertUser(new User(0,"zzz",999));
        //session.commit();

        //List<User> list = mapper.selectBetweenAge(20,30);
        //System.out.println(list);

        User user = mapper.selectById(3);
        System.out.println(user);

        //5.关闭session
        session.close();
    }
}
