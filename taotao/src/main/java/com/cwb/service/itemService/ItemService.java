package com.cwb.service.itemService;

import com.cwb.bean.TbItem;

import java.util.List;

/**
 * Created by cwb on 18/8/7.
 */
public interface ItemService {
    // 查询所有的商品信息
    List<TbItem> findAllItem(String page, String rows);

    // 查询所有商品的数量
    Long totalOfItem();

    // 添加商品信息
    Boolean insertItem(TbItem tbItem, String desc);

}
