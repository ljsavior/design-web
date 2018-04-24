package com.eternal.design.test;

import com.eternal.design.Application;
import com.eternal.design.entity.User;
import com.eternal.design.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSelectAll() {
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }

}
