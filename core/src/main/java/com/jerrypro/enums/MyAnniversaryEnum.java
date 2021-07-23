package com.jerrypro.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
@Getter
@AllArgsConstructor
public enum MyAnniversaryEnum {
    /**
     * first day
     */
    FIRST_DAY("first_day", "FIRST DAY");
    /**
     * code
     */
    private final String code;

    /**
     * name
     */
    private final String name;
}
