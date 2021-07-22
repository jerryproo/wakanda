package com.jerrypro.common.result.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 王正伟
 * 创建时间：2021/7/22
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    /**
     * success
     */
    SUCCESS(200, "success"),

    /**
     * failed
     */
    FAILURE(1000, "failure"),
    ;

    /**
     * code
     */
    private final Integer code;

    /**
     * msg
     */
    private final String msg;
}
