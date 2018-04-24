package com.eternal.design.service;

import com.eternal.design.entity.Menu;
import com.eternal.design.entity.User;

import java.util.List;

public interface MenuService {
    List<Menu> selectByUser(User user);

}
