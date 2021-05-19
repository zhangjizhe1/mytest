package cn.tedu.dao;

import cn.tedu.domain.User;
import cn.tedu.utils.JDBCUtils;
import cn.tedu.utils.TransactionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    @Override
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = TransactionManager.getConn();
            ps = conn.prepareStatement("insert into user values (null,?,?,?)");
            ps.setString(1,user.getName());
            ps.setInt(2,user.getAge());
            ps.setString(3,user.getAddr());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null,ps,null);
        }
    }

    @Override
    public void delUser(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = TransactionManager.getConn();
            ps = conn.prepareStatement("delete from user where id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null,ps,null);
        }
    }
}
