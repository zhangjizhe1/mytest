package com.easymall.service;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper = null;

    @Override
    public boolean hasUserName(String username) {
        return userMapper.queryUserByUserName(username) != null;
    }

    @Override
    public void registUser(User user) {
        //1.检查用户名是否已经存在
        if(userMapper.queryUserByUserName(user.getUsername())!=null){
            //2.存在就抛出异常
            throw new MsgException("用户名已存在");
        }else{
            //2.不存在就增加用户
            userMapper.addUser(user);
        }
    }

    @Override
    public User loginUser(String username, String password) {
        //1.根据用户名 密码 查找用户
        User user = userMapper.queryUserByUserNameAndPsw(username,password);
        //2.如果找不到抛出异常
        if(user==null) throw new MsgException("用户名密码不正确");
        //3.找到就返回对象
        return user;
    }
}
