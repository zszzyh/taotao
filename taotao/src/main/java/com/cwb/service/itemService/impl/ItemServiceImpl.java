package com.cwb.service.itemService.impl;

import com.cwb.bean.TbItem;
import com.cwb.bean.TbItemCriteria;
import com.cwb.bean.TbItemDesc;
import com.cwb.dao.TbItemDescMapper;
import com.cwb.dao.TbItemMapper;
import com.cwb.service.itemService.ItemService;
import com.cwb.util.DateUtil;
import com.cwb.util.IDUtils;
import com.cwb.util.StringToDate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * Created by cwb on 18/8/7.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private TbItemMapper tbItemMapper;
    @Resource
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public List<TbItem> findAllItem(String page, String rows) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        TbItemCriteria example = new TbItemCriteria();
        List<TbItem> tbItemList = tbItemMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(tbItemList);
        List<TbItem> resultList = pageInfo.getList();
        return resultList;
    }

    @Override
    public Long totalOfItem() {
        TbItemCriteria example = new TbItemCriteria();
        Long count = tbItemMapper.countByExample(example);
        return count;
    }

    @Override
    @Transactional
    public Boolean insertItem(TbItem tbItem, String desc) {
        tbItem.setId(IDUtils.genItemId());
        try {
            tbItem.setCreated(StringToDate.test(DateUtil.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tbItem.setUpdated(tbItem.getCreated());
        tbItem.setStatus((byte) 1);
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(tbItem.getId());
        tbItemDesc.setUpdated(tbItem.getUpdated());
        tbItemDesc.setCreated(tbItem.getCreated());

        tbItemMapper.insert(tbItem);
        tbItemDescMapper.insert(tbItemDesc);

        return true;
    }
}
