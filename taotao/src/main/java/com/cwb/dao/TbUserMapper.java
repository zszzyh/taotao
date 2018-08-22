package com.cwb.dao;

import com.cwb.bean.TbUser;
import com.cwb.bean.TbUserCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserMapper {
    int countByExample(TbUserCriteria example);

    int deleteByExample(TbUserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserCriteria example);

    TbUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserCriteria example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserCriteria example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}