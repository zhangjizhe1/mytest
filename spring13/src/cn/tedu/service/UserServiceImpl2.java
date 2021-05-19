package cn.tedu.service;

import cn.tedu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Override
    public void addUser() {
        System.out.println("#UserService2..addUser..");
        userDao.addUser();
    }
}
