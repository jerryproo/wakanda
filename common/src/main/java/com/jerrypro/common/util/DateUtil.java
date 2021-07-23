package com.jerrypro.common.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
@Slf4j
public final class DateUtil {

    /**
     * 默认格式yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime
     * @return
     */
    public static String getDefLocalDateTimeStr(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return getFormatLocalDateTimeStr(localDateTime, StringConstantUtil.DATE_TIME_FORMAT_STRING);

    }

    /**
     * 格式化的日期
     *
     * @param localDateTime 需要格式化的对象
     * @param formatStr     日期格式，例：yyyy-MM-dd HH:mm:ss
     * @return dateStr
     */
    public static String getFormatLocalDateTimeStr(LocalDateTime localDateTime, String formatStr) {
        if (localDateTime == null) {
            return "";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatStr);
        return dateTimeFormatter.format(localDateTime);
    }
}
