package com.eternal.design.service;


import com.eternal.design.entity.User;
import com.eternal.design.entity.UserExample;
import com.eternal.design.page.PageResult;

public interface UserService {
    PageResult<User> findByPage(UserExample example);

    User findById(Integer id);

    User insertOrUpdate(User user);

    int deleteById(Integer id);
}
