package com.cwb.dao;

import com.cwb.bean.TbContentCategory;
import com.cwb.bean.TbContentCategoryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbContentCategoryMapper {
    long countByExample(TbContentCategoryCriteria example);

    int deleteByExample(TbContentCategoryCriteria example);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    List<TbContentCategory> selectByExample(TbContentCategoryCriteria example);

    int updateByExampleSelective(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryCriteria example);

    int updateByExample(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryCriteria example);
}