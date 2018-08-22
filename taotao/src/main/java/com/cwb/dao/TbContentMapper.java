package com.cwb.dao;

import com.cwb.bean.TbContent;
import com.cwb.bean.TbContentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbContentMapper {
    long countByExample(TbContentCriteria example);

    int deleteByExample(TbContentCriteria example);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    List<TbContent> selectByExampleWithBLOBs(TbContentCriteria example);

    List<TbContent> selectByExample(TbContentCriteria example);

    int updateByExampleSelective(@Param("record") TbContent record, @Param("example") TbContentCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbContent record, @Param("example") TbContentCriteria example);

    int updateByExample(@Param("record") TbContent record, @Param("example") TbContentCriteria example);
}