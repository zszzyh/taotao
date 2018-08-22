package com.cwb.controller;

import com.cwb.service.loginService.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cwb on 18/8/6.
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginServiceImpl;

    @RequestMapping("/dologin.do")
    @ResponseBody
    public Map doLogin(@RequestBody Map<String, String> map){
//        System.out.println(map);
//        if (loginServiceImpl.findByUsernameAndPassword(map.get("username"),map.get("password"))){
//            map.put("flag","true");
//        }else{
//            map.put("flag","false");
//        }
//        return map;

        // 生成用户名和密码token
        UsernamePasswordToken token = new UsernamePasswordToken(map.get("username"), map.get("password"));
        // 获取当前用户的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //传递token给shiro,调用doGetAuthenticationInfo这个方法(即:登录验证)
            currentUser.login(token);

        } catch (AuthenticationException e) {//登录失败
            map.put("flag","false");
            return map;
        }

        map.put("flag","true");
        return map;
    }

    List<String> getRoleList(){
        List<String> list = new ArrayList<>();
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println(currentUser.isPermitted("admin:del"));
        System.out.println(currentUser.isPermitted("admin:ADD"));
        if (currentUser.hasRole("oper")){
            list.add("oper");
        }
        return list;
    }

}
