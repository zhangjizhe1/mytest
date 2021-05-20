package cn.tedu.service;

import cn.tedu.dao.UserDao;
import cn.tedu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    @Transactional
    @Override
    public User queryUser(int id) {
        return userDao.queryUser(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void delUser(int id) {
        userDao.delUser(id);
    }
}
