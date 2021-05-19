package cn.tedu.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        try{
            System.out.println("#记录日志..");
            System.out.println("#权限控制..");
            System.out.println("#开启事务..");
            System.out.println("addUser..");
            System.out.println("#提交事务..");
        }catch (Exception e){
            System.out.println("#回滚事务..");
        }
    }

    @Override
    public void delUser() {
        try{
            System.out.println("#记录日志..");
            System.out.println("#权限控制..");
            System.out.println("#开启事务..");
            System.out.println("delUser..");
            System.out.println("#提交事务..");
        }catch (Exception e){
            System.out.println("#回滚事务..");
        }
    }

    @Override
    public void queryUser() {
        try{
            System.out.println("#记录日志..");
            System.out.println("#权限控制..");
            System.out.println("#开启事务..");
            System.out.println("queryUser..");
            System.out.println("#提交事务..");
        }catch (Exception e){
            System.out.println("#回滚事务..");
        }
    }
}
