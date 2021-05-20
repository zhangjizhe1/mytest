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

public class Test02 {
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
     * #{} 和 ${} 的选择
     * 通常都用#{} 有预编译机制 可以防止sql注入 效率高 字符串日期类型数据不用手动拼单引号
     * 但 如果传递的是 sql语句中的 表名 列名 关键字 则应使用${} 防止自动拼接单引号改变sql的语义
     */
    @Test
    public void test03(){
        Map<String,Object> map = new HashMap<>();
        map.put("cname","age");
        List<User> list = session.selectList("cn.tedu.mapper.UserMapper2.selc03", map);
        System.out.println(list);
    }

    /**
     * 值传递 - ${}
     * 没有采用预编译机制 直接将参数拼接到了sql中
     * 不能防止sql注入
     * 没有性能提升
     * 对于字符串类型、日期类型的数据 需要手动拼接单引号
     */
    @Test
    public void test02(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","ccc");
        List<User> list = session.selectList("cn.tedu.mapper.UserMapper2.selc02", map);
        System.out.println(list);
    }

    /**
     * 值传递 - #{}
     *  使用了预编译机制 sql语句的主干 和 参数 是分开传递的
     *  可以防止sql注入攻击
     *  提高执行的效率
     *  对于 字符串类型、日期类型的数据 不需要手动拼接单引号
     */
    @Test
    public void test01(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","ccc");
        List<User> list = session.selectList("cn.tedu.mapper.UserMapper2.selc01", map);
        System.out.println(list);
    }
}
