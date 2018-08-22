package com.cwb.dao;

import com.cwb.bean.TbItemDesc;
import com.cwb.bean.TbItemDescCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbItemDescMapper {
    long countByExample(TbItemDescCriteria example);

    int deleteByExample(TbItemDescCriteria example);

    int insert(TbItemDesc record);

    int insertSelective(TbItemDesc record);

    List<TbItemDesc> selectByExampleWithBLOBs(TbItemDescCriteria example);

    List<TbItemDesc> selectByExample(TbItemDescCriteria example);

    int updateByExampleSelective(@Param("record") TbItemDesc record, @Param("example") TbItemDescCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TbItemDesc record, @Param("example") TbItemDescCriteria example);

    int updateByExample(@Param("record") TbItemDesc record, @Param("example") TbItemDescCriteria example);
}