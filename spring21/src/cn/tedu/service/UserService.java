package cn.tedu.service;

import cn.tedu.domain.User;

public interface UserService {
    public void addUser(User user);
    public void delUser(int id);
    public void updateUser();
    public User queryUser(String name,int age);
}
