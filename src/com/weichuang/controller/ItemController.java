package com.weichuang.controller;

import com.weichuang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.weichuang.pojo.Item;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
//@RequestMapping("item")
public class ItemController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ItemService itemService;
    @RequestMapping("/itemList.do")
    public ModelAndView getItemList(){
        /*String sql = "select * from items";
        List<Item> itemList = jdbcTemplate.query(sql, new RowMapper<Item>() {

            @Override
            public Item mapRow(ResultSet rs, int i) throws SQLException {
                Item item = new Item();
                item.setName(rs.getString("name"));
                item.setPrice(rs.getString("price"));
                item.setDetail(rs.getString("detail"));
                item.setCreatetime(rs.getDate("createtime"));
                return item;
            }
        });*/
        List<Item> itemList = itemService.getItemList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList" , itemList);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    @RequestMapping("/itemEdit.do")
    public ModelAndView updateItemUI(@RequestParam(value = "id" ,required = false) int xxx , boolean status){
        Item item = itemService.getItemById(xxx);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item" , item);
        modelAndView.setViewName("editItem");
        return modelAndView;
    }

    @RequestMapping("/updateitem.do")
    public ModelAndView updateItem(Item item){
        itemService.updateItem(item);
        List<Item> itemList = itemService.getItemList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList" , itemList);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

}
