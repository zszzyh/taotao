package com.cwb.dao;

import com.cwb.bean.TbItemParamItem;
import com.cwb.bean.TbItemParamItemCriteria;
import java.util.List;

public interface TbItemParamItemMapper {
    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    List<TbItemParamItem> selectByExampleWithBLOBs(TbItemParamItemCriteria example);

    List<TbItemParamItem> selectByExample(TbItemParamItemCriteria example);
}