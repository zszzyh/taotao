package com.cwb.dao;

import com.cwb.bean.TbItem;
import com.cwb.bean.TbItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbItemMapper {
    long countByExample(TbItemCriteria example);

    int deleteByExample(TbItemCriteria example);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemCriteria example);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemCriteria example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemCriteria example);
}