package com.cwb.dao;

import com.cwb.bean.TbAdmin;
import com.cwb.bean.TbAdminCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbAdminMapper {
    long countByExample(TbAdminCriteria example);

    int deleteByExample(TbAdminCriteria example);

    int insert(TbAdmin record);

    int insertSelective(TbAdmin record);

    List<TbAdmin> selectByExample(TbAdminCriteria example);

    int updateByExampleSelective(@Param("record") TbAdmin record, @Param("example") TbAdminCriteria example);

    int updateByExample(@Param("record") TbAdmin record, @Param("example") TbAdminCriteria example);
}