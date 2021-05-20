package cn.tedu.test;

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
     * 多对多查询，以Stu为视角
     */
    @Test
    public void test06(){
        List<Stu> list = session.selectList("cn.tedu.mapper.m2mMapper.m2m02");
        System.out.println(list);
    }

    /**
     * 多对多查询，以Teacher为视角
     */
    @Test
    public void test05(){
        List<Teacher> list = session.selectList("cn.tedu.mapper.m2mMapper.m2m01");
        System.out.println(list);
    }

    /**
     * 一对多查询，以Emp为视角
     */
    @Test
    public void test04(){
        List<Emp> list = session.selectList("cn.tedu.mapper.o2mMapper.o2m02");
        System.out.println(list);
    }

    /**
     * 一对多查询，以Dept为视角
     */
    @Test
    public void test03(){
        List<Dept> list = session.selectList("cn.tedu.mapper.o2mMapper.o2m01");
        System.out.println(list);
    }

    /**
     * 一对一查询，以Room为视角
     */
    @Test
    public void test02() throws IOException {
        List<Room> list = session.selectList("cn.tedu.mapper.o2oMapper.o2o02");
        System.out.println(list);
    }
    /**
     * 一对一查询，以Grade为视角
     */
    @Test
    public void test01() throws IOException {
        List<Grade> list = session.selectList("cn.tedu.mapper.o2oMapper.o2o01");
        System.out.println(list);
    }
}
