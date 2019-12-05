package com.weichuang.mapper;

import com.weichuang.pojo.Item;

import java.util.List;

public interface ItemMapper {
    List<Item> getItemList();

    Item getItemById(int id);

    void updateItem(Item item);
}
