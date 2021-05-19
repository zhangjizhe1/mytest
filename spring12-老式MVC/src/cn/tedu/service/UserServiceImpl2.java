package cn.tedu.service;

import cn.tedu.dao.OracleUserDao;

public class UserServiceImpl2 {

    //private MySqlUserDao userDao = new MySqlUserDao();
    private OracleUserDao userDao = new OracleUserDao();

    public void addUser(){
        System.out.println("#UserService2..addUser..");
        userDao.addUser();
    }
}
