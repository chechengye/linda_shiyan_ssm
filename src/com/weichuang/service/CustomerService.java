package com.weichuang.service;

import com.weichuang.utils.Page;
import com.weichuang.vo.QueryVo;

public interface CustomerService {

    Page getPageByQueryVo(QueryVo vo);
}
