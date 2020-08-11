package com.lightnet.controller;

import com.lightnet.entity.User;
import com.lightnet.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public List<User> list() {

        User user = new User();
        user.setId(5);
        user.setName("haha");

        userMapper.insert(user);

        return userMapper.selectList(null);
    }
}
