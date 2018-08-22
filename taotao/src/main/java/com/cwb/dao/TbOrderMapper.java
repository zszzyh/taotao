package com.cwb.dao;

import com.cwb.bean.TbOrder;
import com.cwb.bean.TbOrderCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderMapper {
    long countByExample(TbOrderCriteria example);

    int deleteByExample(TbOrderCriteria example);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    List<TbOrder> selectByExample(TbOrderCriteria example);

    int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderCriteria example);

    int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderCriteria example);
}