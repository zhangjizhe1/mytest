package cn.tedu.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("addUser..");
        int i = 1/0;
    }

    @Override
    public void delUser() {
        System.out.println("deUser..");
    }
}
