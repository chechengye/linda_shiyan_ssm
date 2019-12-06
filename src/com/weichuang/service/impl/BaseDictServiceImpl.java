package com.weichuang.service.impl;

import com.weichuang.mapper.BaseDictMapper;
import com.weichuang.pojo.BaseDict;
import com.weichuang.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> getBaseDictListByCode(String code) {
        return baseDictMapper.getBaseDictListByCode(code);
    }
}
