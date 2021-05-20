package cn.tedu.service;

import cn.tedu.anno.Trans;
import cn.tedu.dao.UserDao;
import cn.tedu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Trans
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Trans
    @Override
    public void delUser(int id) {
        userDao.delUser(id);
    }
}
