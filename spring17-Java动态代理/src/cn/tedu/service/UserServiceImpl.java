package cn.tedu.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("addUser..");
    }

    @Override
    public void delUser() {
        System.out.println("delUser..");
    }

    @Override
    public void queryUser() {
        System.out.println("queryUser..");
    }

    public void aaa(){
        System.out.println("aaa..");
    }
}
