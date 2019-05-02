package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.UserMapper;
import com.zking.ssm.model.User;
import com.zking.ssm.service.IUserBiz;
import com.zking.ssm.shiro.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userBiz")
public class UserBizImpl implements IUserBiz {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int doRegister(User user) {
        //md5+盐

        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(user.getPassword(), salt);

        user.setSalt(salt);
        user.setPassword(credentials);
        return userMapper.insert(user);
    }

    @Override
    public User loadByUsername(User user) {
        return userMapper.selectByUsername(user.getUsername());
    }

    @Override
    public String doLogin(User user) {
        String message = null;
        User u = userMapper.selectByUsername(user.getUsername());
        if (null == u || !PasswordHelper.checkCredentials(user.getPassword(), u.getSalt(), u.getPassword())) {
            message = "帐号或密码错误";
        } else if (new Integer(1).equals(u.getLocked())) {
            message = "帐号已锁定，请与管理员联系";
        }
        return message;
    }

    @Override
    public Set<String> listPermissionsByUserName(User user) {
        return new HashSet<String>(userMapper.listPermissionsByUserName(user));
    }

    @Override
    public Set<String> listRolesByUserName(User user) {
        return new HashSet<String>(userMapper.listRolesByUserName(user));
    }

    @Override
    public int updatePassword(User user) {
        //md5+盐
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(user.getPassword(), salt);


        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(credentials);
        u.setSalt(salt);

        return userMapper.updateByPrimaryKeySelective(u);
    }

    @Override
    public int doResetPassword(User user) {
        //md5+盐
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(User.DEFAULT_PASSWORD, salt);


        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(credentials);
        u.setSalt(salt);

        return userMapper.updateByPrimaryKeySelective(u);
    }
}
