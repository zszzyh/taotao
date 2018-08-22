package com.cwb.service.itemService;

import com.cwb.bean.EUTreeNode;

import java.util.List;

/**
 * Created by cwb on 18/8/7.
 */
public interface ItemCatService {
    // 根据父节点id查询树形结构，最开始只显示一级目录，当点击下一级目录得时候再显示二级目录
    List<EUTreeNode> getItemCatList(long parentId);

}
