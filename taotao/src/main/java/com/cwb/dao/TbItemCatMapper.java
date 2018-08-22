package com.cwb.dao;

import com.cwb.bean.TbItemCat;
import com.cwb.bean.TbItemCatCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TbItemCatMapper {
    long countByExample(TbItemCatCriteria example);

    int deleteByExample(TbItemCatCriteria example);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    List<TbItemCat> selectByExample(TbItemCatCriteria example);

    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatCriteria example);

    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatCriteria example);
}