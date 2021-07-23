package com.jerrypro.mapper;

import com.jerrypro.entity.MyAnniversaryDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
public interface MyAnniversaryMapper {

    /**
     * 按照code获取
     *
     * @param code recordCode
     * @return dto
     */
    MyAnniversaryDTO getByCode(String code);
}
