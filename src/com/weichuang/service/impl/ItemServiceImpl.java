package com.weichuang.service.impl;

import com.weichuang.mapper.ItemMapper;
import com.weichuang.pojo.Item;
import com.weichuang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;
    @Override
    public List<Item> getItemList() {
        return itemMapper.getItemList();
    }
}
