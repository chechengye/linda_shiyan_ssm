package com.weichuang.controller;

import com.weichuang.pojo.BaseDict;
import com.weichuang.service.BaseDictService;
import com.weichuang.service.CustomerService;
import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    BaseDictService baseDictService;

    @Autowired
    CustomerService customerService;
    @RequestMapping("/customerList.do")
    public String getCustomerList(QueryVo vo , Model model){
        List<BaseDict> industryType = baseDictService.getBaseDictListByCode("001");
        List<BaseDict> fromType = baseDictService.getBaseDictListByCode("002");
        List<BaseDict> levelType = baseDictService.getBaseDictListByCode("006");
        model.addAttribute("fromType",fromType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("industryType",industryType);

        Page page = customerService.getPageByQueryVo(vo);
        model.addAttribute("page",page);
        model.addAttribute("vo",vo);
        return "customer";
    }

}
