package com.jerrypro.service;

import com.jerrypro.entity.MyAnniversaryDTO;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
public interface MyAnniversaryService {
    /**
     * 按照code获取
     *
     * @param code code
     * @return anniversary
     */
    MyAnniversaryDTO getByCode(String code);
}
