package cn.tedu.dao;

import cn.tedu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
    create database sdb;
    use sdb;
    create table user (id int primary key auto_increment,name varchar(20),age int,addr varchar(30));
    insert into user values (null,'aaa',18,'bj');
    insert into user values (null,'bbb',28,'sh');
    insert into user values (null,'ccc',19,'gz');
    insert into user values (null,'ddd',23,'bj');
    insert into user values (null,'eee',32,'sz');

 */

@Repository
public class MySqlUserDao implements UserDao {
    @Autowired
    private JdbcTemplate jdbctemplate =null;
    @Override
    public void addUser(User user) {
        jdbctemplate.update("insert into user values (null,?,?,?)",user.getName(),user.getAge(),user.getAddr());
    }

    @Override
    public void delUser(int id) {
        jdbctemplate.update("delete from user where id = ?",id);
    }

    @Override
    public User queryUser(int id) {
        User user=jdbctemplate.queryForObject("select * from user where id =?", new BeanPropertyRowMapper<User>(User.class) ,id);
        return user;
    }
}
