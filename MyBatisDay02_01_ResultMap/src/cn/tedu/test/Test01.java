package cn.tedu.test;

import cn.tedu.domain.User;
import cn.tedu.domain.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    /**
     * 手动映射结果集
     *  查询结果列名 和 要封装的bean的属性名不一致 此时可以手动映射结果集 结果
     */
    @Test
    public void test01() throws IOException {
        //1.创建SqlSessionFactory
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //2.创建SqlSession
        SqlSession session = factory.openSession();
        //3.调用sql
        List<User2> list = session.selectList("cn.tedu.mapper.UserMapper.selc02",3);
        System.out.println(list);
        //4.关闭sessoin
        session.close();
    }
}
