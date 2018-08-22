package com.cwb.service.itemService.impl;

import com.cwb.bean.EUTreeNode;
import com.cwb.bean.TbItem;
import com.cwb.bean.TbItemCat;
import com.cwb.bean.TbItemCatCriteria;
import com.cwb.dao.TbItemCatMapper;
import com.cwb.service.itemService.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cwb on 18/8/7.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EUTreeNode> getItemCatList(long parentId) {
        TbItemCatCriteria example = new TbItemCatCriteria();
        // 设置查询条件
        TbItemCatCriteria.Criteria criteria = example.createCriteria();
        // 设置parentId
        criteria.andParentIdEqualTo(parentId);

        // 执行查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        System.out.println(list);

        List<EUTreeNode> easyUITreeNodeList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EUTreeNode easyUITreeNode = new EUTreeNode();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setText(tbItemCat.getName());
            easyUITreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
            easyUITreeNodeList.add(easyUITreeNode);
        }
        return easyUITreeNodeList;

    }
}
