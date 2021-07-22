package com.jerrypro.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author jerrypro
 * @date 2021/7/22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MyAnniversaryDTO extends BaseEntity{

    /**
     * recordCode
     */
    private String recordCode;

    /**
     * recordName
     */
    private String recordName;

    /**
     * recordDate
     */
    private LocalDateTime recordDate;
}
