package com.qfedu.demo.service;

import com.qfedu.demo.entity.User;
import com.qfedu.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User loadUser(String username, String password) {
        User user = userMapper.loadUser(username);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    public Integer insert(User user) {
        //先去判断用户名是否已经存在
        User u = userMapper.getUserByUsername(user.getUsername());
        if (u != null) {
            //用户名重复，注册失败
            return -1;
        }
        //没有重名用户，正常注册
        Date date = new Date();
        user.setHiredate(date);
        user.setType(2);
        user.setAvailable(true);
        return userMapper.insert(user);
    }

    public User queryByLoginName(String loginName) {
        return userMapper.queryByLoginName(loginName);
    }

    public Boolean update(User user) {
        return userMapper.update(user);
    }
}
