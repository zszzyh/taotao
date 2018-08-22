package com.cwb.dao;

import com.cwb.bean.TbItemParam;
import com.cwb.bean.TbItemParamCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemParamMapper {
    long countByExample(TbItemParamCriteria example);

    int deleteByExample(TbItemParamCriteria example);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    List<TbItemParam> selectByExampleWithBLOBs(TbItemParamCriteria example);

    List<TbItemParam> selectByExample(TbItemParamCriteria example);

    int updateByExampleSelective(@Param("record") TbItemParam record, @Param("example") TbItemParamCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbItemParam record, @Param("example") TbItemParamCriteria example);

    int updateByExample(@Param("record") TbItemParam record, @Param("example") TbItemParamCriteria example);
}