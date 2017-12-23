package com.eternal.design.service.impl;

import com.eternal.design.entity.User;
import com.eternal.design.entity.UserExample;
import com.eternal.design.mapper.UserMapper;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult<User> findByPage(UserExample example) {
        return PageUtil.queryByPage(() -> userMapper.countByExample(example), () -> userMapper.selectByExample(example));
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User insertOrUpdate(User user) {
        if(user.getId() == null) {
            userMapper.insertSelective(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findByUsername(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);

        return userMapper.selectByExample(example).stream()
                .findFirst()
                .orElse(null);
    }
}
