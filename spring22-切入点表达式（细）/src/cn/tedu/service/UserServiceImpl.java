package cn.tedu.service;

import cn.tedu.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        System.out.println("新增用户..");
    }

    @Override
    public void delUser(int id) {
        System.out.println("删除用户..");
    }

    @Override
    public void updateUser() {
        System.out.println("修改用户..");
    }

    @Override
    public User queryUser(String name, int age) {
        System.out.println("查询用户");
        return new User();
    }
}
