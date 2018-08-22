package com.cwb.service.loginService;

import com.cwb.bean.TbAdmin;

/**
 * Created by cwb on 18/8/6.
 */
public interface LoginService {
    // 根据账号密码判断是否登录成功
    Boolean findByUsernameAndPassword(String username, String password);

    // 根据用户名查找
    TbAdmin findByUsername(String username);
}
