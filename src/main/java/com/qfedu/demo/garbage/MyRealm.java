package com.qfedu.demo.garbage;

import com.qfedu.demo.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

import java.util.HashMap;

/**
 * realm是shiro的认证器
 */
public class MyRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.提取出用户登录时输入的用户名
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        //2.根据用户名去数据库中查询用户
        User userFromDB = getUerFromDBByUserName(username);
        if (userFromDB == null) {
//    用户名不对
            throw new UnknownAccountException("账户不存在");
        }
//        3.查到了，返回数据库中查询到的用户信息
//        返回的是数据库保存的信息
        return new SimpleAuthenticationInfo(username,userFromDB.getPassword(),getName());
    }

    private User getUerFromDBByUserName(String username) {
        HashMap<String, User> map = new HashMap<>();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        map.put("zhangsan", user);
        User user2 = new User();
        user2.setUsername("lisi");
        user2.setPassword("123456");
        map.put("lisi", user2);
        return map.get(username);
    }
}
