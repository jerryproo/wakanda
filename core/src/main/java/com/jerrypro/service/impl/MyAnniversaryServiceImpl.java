package com.jerrypro.service.impl;

import com.jerrypro.entity.MyAnniversaryDTO;
import com.jerrypro.mapper.MyAnniversaryMapper;
import com.jerrypro.service.MyAnniversaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
@Service
@Slf4j
public class MyAnniversaryServiceImpl implements MyAnniversaryService {
    @Resource
    MyAnniversaryMapper myAnniversaryMapper;

    @Override
    public MyAnniversaryDTO getByCode(String code) {
        return myAnniversaryMapper.getByCode(code);
    }
}
