package cn.tedu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplStaticProxy implements UserService {

    @Autowired
    private UserServiceImpl userServiceImpl = null;

    @Override
    public void addUser() {
        try{
            System.out.println("#记录日志..");
            System.out.println("#控制权限..");
            System.out.println("#开启事务..");
            userServiceImpl.addUser();
            System.out.println("#提交事务..");
        }catch (Exception e){
            System.out.println("#回滚事务..");
            e.printStackTrace();
        }
    }

    @Override
    public void delUser() {
        try{
            System.out.println("#记录日志..");
            System.out.println("#控制权限..");
            System.out.println("#开启事务..");
            userServiceImpl.delUser();
            System.out.println("#提交事务..");
        }catch (Exception e){
            System.out.println("#回滚事务..");
            e.printStackTrace();
        }
    }

    @Override
    public void queryUser() {
        try{
            System.out.println("#记录日志..");
            System.out.println("#控制权限..");
            System.out.println("#开启事务..");
            userServiceImpl.queryUser();
            System.out.println("#提交事务..");
        }catch (Exception e){
            System.out.println("#回滚事务..");
            e.printStackTrace();
        }
    }
}
