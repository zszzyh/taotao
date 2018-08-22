package com.cwb.dao;

import com.cwb.bean.TbOrderShipping;
import com.cwb.bean.TbOrderShippingCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrderShippingMapper {
    long countByExample(TbOrderShippingCriteria example);

    int deleteByExample(TbOrderShippingCriteria example);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    List<TbOrderShipping> selectByExample(TbOrderShippingCriteria example);

    int updateByExampleSelective(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingCriteria example);

    int updateByExample(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingCriteria example);
}