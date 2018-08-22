package com.cwb.dao;

import com.cwb.bean.TbOrderItem;
import com.cwb.bean.TbOrderItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderItemMapper {
    long countByExample(TbOrderItemCriteria example);

    int deleteByExample(TbOrderItemCriteria example);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    List<TbOrderItem> selectByExample(TbOrderItemCriteria example);

    int updateByExampleSelective(@Param("record") TbOrderItem record, @Param("example") TbOrderItemCriteria example);

    int updateByExample(@Param("record") TbOrderItem record, @Param("example") TbOrderItemCriteria example);
}