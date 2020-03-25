package com.easymall.service;

import com.easymall.domain.User;

public interface UserService {
    public boolean hasUserName(String username);

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录用户
     */
    User loginUser(String username, String password);
}
