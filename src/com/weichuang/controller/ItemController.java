package com.weichuang.controller;

import com.weichuang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.weichuang.pojo.Item;

import java.util.List;


@Controller
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
        modelAndView.setViewName("WEB-INF/jsp/itemList.jsp");
        return modelAndView;
    }

}
