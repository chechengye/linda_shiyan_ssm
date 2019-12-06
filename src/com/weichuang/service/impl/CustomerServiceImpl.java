package com.weichuang.service.impl;

import com.weichuang.mapper.CustomerMapper;
import com.weichuang.service.CustomerService;
import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public Page getPageByQueryVo(QueryVo vo) {
        Page page = new Page();
        if(null != vo){
            vo.setMaxCount(10);
            if(vo.getPage() > 0){
                vo.setStartIndex((vo.getPage() - 1) * vo.getMaxCount());
            }
            page.setPage(vo.getPage());
            page.setSize(5);
            page.setTotal(customerMapper.getCustomerTotalByQueryVo(vo));
            page.setRows(customerMapper.getCustomerListByQueryVo(vo));
        }

        return page;
    }
}
