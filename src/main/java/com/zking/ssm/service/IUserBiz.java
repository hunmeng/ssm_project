package com.zking.ssm.service;

import com.zking.ssm.model.User;

import java.util.Set;

public interface IUserBiz {
    int doRegister(User user);//用户注册

    String doLogin(User user);//用户登陆

    int updatePassword(User user);//所有人都可以修改自己的密码

    int doResetPassword(User user);//管理员可以重置所有人的密码，密码默认值为888888

    //权限关键接口
    User loadByUsername(User user);//根据用户名查询用户
    Set<String> listPermissionsByUserName(User user);//查询指定用户拥有的权限
    Set<String> listRolesByUserName(User user);//查询指定用户拥有的角色
}
