package com.easymall.mapper;

import com.easymall.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 根据用户名查找用户
     */
    public User queryUserByUserName(@Param("username") String username);

    /**
     * 根据用户名 密码 查找用户
     * @return
     */
    User queryUserByUserNameAndPsw(@Param("username") String username, @Param("password") String password);

    /**
     * 新增用户
     */
    void addUser(User user);
}
