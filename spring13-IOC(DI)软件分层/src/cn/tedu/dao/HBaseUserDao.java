package cn.tedu.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HBaseUserDao implements UserDao {
    @Override
    public void addUser() {
        System.out.println("#HBase..addUser..");
    }
}
