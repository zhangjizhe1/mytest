package cn.tedu.service;

import cn.tedu.dao.OracleUserDao;

public class UserServiceImpl {

    //private MySqlUserDao userDao = new MySqlUserDao();
    private OracleUserDao userDao = new OracleUserDao();

    public void addUser(){
        System.out.println("#UserService..addUser..");
        userDao.addUser();
    }
}
