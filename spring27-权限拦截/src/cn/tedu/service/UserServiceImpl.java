package cn.tedu.service;

import cn.tedu.anno.PrivAnno;
import cn.tedu.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("新增用户");
    }

    @PrivAnno({Role.USER,Role.ADMIN})
    @Override
    public void queryUser() {
        System.out.println("查询用户");
    }

    @PrivAnno({Role.USER,Role.ADMIN})
    @Override
    public void updateUser() {
        System.out.println("修改用户");
    }

    @PrivAnno(Role.ADMIN)
    @Override
    public void delUser() {
        System.out.println("删除用户");
    }
}
