package com.jerrypro.service.impl;

import com.jerrypro.entity.MyAnniversaryDTO;
import com.jerrypro.mapper.MyAnniversaryMapper;
import com.jerrypro.service.MyAnniversaryService;

import javax.annotation.Resource;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
public class MyAnniversaryServiceImpl implements MyAnniversaryService {
    @Resource
    MyAnniversaryMapper myAnniversaryMapper;

    @Override
    public MyAnniversaryDTO getByCode(String code) {
        return myAnniversaryMapper.getByCode(code);
    }
}
