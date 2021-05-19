package cn.tedu.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class MySqlUserDao implements UserDao {
    public void addUser(){
        System.out.println("#MySql..addUser..");
    }
}
