package cn.tedu.test;

import cn.tedu.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Test01 {
    private ApplicationContext context = null;
    private JdbcTemplate template = null;
    @Before
    public void before(){
        //1.初始化Spring容器
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取bean
        template = (JdbcTemplate) context.getBean("jdbcTemplate");
    }
    @After
    public void after(){
        //3.关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void query4(){
        List<User> list = template.query("select * from user where id <=?", new BeanPropertyRowMapper<User>(User.class), 3);
        System.out.println(list);
    }
    @Test
    public void query3(){
        User user = template.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<User>(User.class), 3);
        System.out.println(user);
    }
    @Test
    public void query2(){
        List<Map<String, Object>> list = template.queryForList("select * from user where id <= ?", 3);
        System.out.println(list);
    }
    @Test
    public void query1(){
        Map<String, Object> map = template.queryForMap("select * from user where id = ?", 3);
        System.out.println(map);
    }
    @Test
    public void delete(){
        template.update("delete from user where id = ?",13);
    }
    @Test
    public void update(){
        template.update("update user set age=? where id = ?",88,13);
    }
    @Test
    public void insert(){
        template.update("insert into user values (null,?,?,?)","zzz",99,"xx");
    }
}
