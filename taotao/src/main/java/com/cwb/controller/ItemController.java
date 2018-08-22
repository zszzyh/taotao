package com.cwb.controller;

import com.cwb.bean.EUTreeNode;
import com.cwb.bean.TbItem;
import com.cwb.bean.TbItemDesc;
import com.cwb.service.itemService.ItemCatService;
import com.cwb.service.itemService.ItemService;
import com.cwb.util.BaseEasyuiUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cwb on 18/8/7.
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    @Resource
    private ItemService itemServiceImpl;
    @Resource
    private ItemCatService itemCatServiceImpl;

    @RequestMapping("/doShowList.do")
    @ResponseBody
    public BaseEasyuiUtil doShow(String page, String rows){
        System.out.println(page + " ---page---" + rows);
        List<TbItem> list = itemServiceImpl.findAllItem(page,rows);
        BaseEasyuiUtil<TbItem> baseEasyuiUtil = new BaseEasyuiUtil<>();
        baseEasyuiUtil.setTotal(itemServiceImpl.totalOfItem().intValue());
        baseEasyuiUtil.setRows(list);
        return baseEasyuiUtil;
    }

    @RequestMapping("/cat/list.do")
    @ResponseBody
    public List<EUTreeNode> getItemCatList(@RequestParam(name="id",defaultValue = "0") Long parentId){
        List<EUTreeNode> itemCatList = itemCatServiceImpl.getItemCatList(parentId);
        return itemCatList;
    }

    @RequestMapping("/save.do")
    @ResponseBody
    public Map itemSave(TbItem tbItem, String desc){
        System.out.println(tbItem);
        System.out.println(desc);
        Map<String,Object> map = new HashMap<>();
        if (itemServiceImpl.insertItem(tbItem, desc)){
            map.put("status",200);
            return map;
        }else{
            map.put("status",500);
            return map;
        }
    }

}
