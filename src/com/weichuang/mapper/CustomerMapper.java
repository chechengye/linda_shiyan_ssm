package com.weichuang.mapper;

import com.weichuang.pojo.Customer;
import com.weichuang.vo.QueryVo;

import java.util.List;


public interface CustomerMapper {


    int getCustomerTotalByQueryVo(QueryVo vo);

    List<Customer> getCustomerListByQueryVo(QueryVo vo);
}
