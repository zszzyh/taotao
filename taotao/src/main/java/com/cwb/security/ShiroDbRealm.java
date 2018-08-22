package com.cwb.security;

import com.cwb.bean.TbAdmin;
import com.cwb.bean.TbUser;
import com.cwb.service.loginService.LoginService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

@Controller
public class ShiroDbRealm extends AuthorizingRealm {
    //@Autowired
    public LoginService loginService;

    /**
     * 获取授权信息
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //List roleList = userService.getRoles();

        info.addRole("oper");//oper,admin,manager
        info.addRole("admin");
        //List permissionList = userService.getPermissions();
        //info.addStringPermission("oper:add");
        //info.addStringPermission("oper:del");
        info.addStringPermission("oper:add");
        return info;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        //获得令牌——基于用户名和密码的令牌
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        //从令牌中可以取出用户名
        String accountName = token.getUsername();
        System.out.println(accountName+"    -----token username");
        TbAdmin userInDB = loginService.findByUsername(accountName);
        System.out.println(userInDB);
        if (userInDB != null){
            return new SimpleAuthenticationInfo(userInDB.getAdminName(),userInDB.getAdminPassword(),getName());
        }
        return null;
    }


    //一定要写getset方法
    public LoginService getUserService() {
        return loginService;
    }

    public void setLoginService(LoginService userService) {
        this.loginService = userService;
    }

}