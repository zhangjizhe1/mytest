package cn.tedu.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("新增用户..");
    }

    @Override
    public void delUser() {
        System.out.println("删除用户..");
    }
}
