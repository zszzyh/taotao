package com.cwb.service.loginService.impl;

import com.cwb.bean.TbAdmin;
import com.cwb.bean.TbAdminCriteria;
import com.cwb.dao.TbAdminMapper;
import com.cwb.service.loginService.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cwb on 18/8/6.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private TbAdminMapper tbAdminMapper;

    @Override
    public Boolean findByUsernameAndPassword(String username, String password) {
        TbAdminCriteria example = new TbAdminCriteria();
        TbAdminCriteria.Criteria criteria = example.createCriteria();
        criteria.andAdminAccountEqualTo(username);
        criteria.andAdminPasswordEqualTo(password);
        List<TbAdmin> list = tbAdminMapper.selectByExample(example);

        if (list.size()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public TbAdmin findByUsername(String username) {

        //先写假数据
        TbAdmin admin = new TbAdmin();
        admin.setAdminAccount("cwbcwb521");
        admin.setAdminPassword("521521cwb");
        admin.setAdminId(1);
        admin.setAdminName("cwb");
        admin.setAdminTelephone("15040551445");
        admin.setAdminEmail("cwbcwb521@hotmail.com");
        return admin;

//        TbAdminCriteria example = new TbAdminCriteria();
//        TbAdminCriteria.Criteria criteria = example.createCriteria();
//        criteria.andAdminAccountEqualTo(username);
//        System.out.println("12345");
//        try {
//            List<TbAdmin> list = tbAdminMapper.selectByExample(example);
//            System.out.println(list+"----------showList");
//            if (list.size()>0){
//                return list.get(0);
//            }else{
//                return null;
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;

    }
}
