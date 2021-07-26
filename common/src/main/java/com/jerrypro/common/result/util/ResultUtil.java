package com.jerrypro.common.result.util;

/**
 * @author jerrypro
 * @date 2021/7/23
 */

import com.jerrypro.common.result.dto.Result;
import com.jerrypro.common.result.enums.ResultCodeEnum;
import com.jerrypro.common.util.DateUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回值公共处理类
 * 2017-12-10 18:03
 *
 * @author TangLuLu
 */
public final class ResultUtil {

    private ResultUtil() {
    }

    /**
     * 返回成功
     *
     * @return res
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS);
    }

    /**
     * 返回成功
     *
     * @param msg 成功消息
     * @return result
     */
    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultCodeEnum.SUCCESS, msg);
    }

    /**
     * 返回成功
     *
     * @param t 需要的对象
     * @return result
     */
    public static <T> Result<T> successData(T t) {
        Result<T> result = new Result<>(ResultCodeEnum.SUCCESS);
        result.setData(t);
        return result;
    }

    /**
     * 返回成功
     *
     * @param object 需要的对象
     * @return result
     */
    public static Result<Map<String, Object>> successData(String fileNames, Object object) {
        Result<Map<String, Object>> result = new Result<>(ResultCodeEnum.SUCCESS);
        result.setData(getObjectMap(fileNames, object));
        return result;
    }

    /**
     * 返回处理后的map
     *
     * @param fileNames fileNames
     * @param object    object
     * @return map
     */
    public static Map<String, Object> getObjectMap(String fileNames, Object object) {
        String[] fieldNameArr = fileNames.split(",");

        Map<String, Object> rtnMap = new HashMap<>();
        for (String fieldName : fieldNameArr) {
            Object value;
            try {
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getter = "get" + firstLetter + fieldName.substring(1);
                Method method = object.getClass()
                        .getMethod(getter);
                String typeName = method.getReturnType()
                        .getName()
                        .toLowerCase();

                value = method.invoke(object);
                if (value == null) {
                    value = getValueByTypeName(typeName);
                } else {
                    if ("localdatetime".contains(typeName)) {
                        value = DateUtil.getDefLocalDateTimeStr((LocalDateTime) value);
                    } else if (typeName.contains("long")) {
                        //long类型暂时不转-》原因是分页total是long类型
                    }
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                value = null;
            }
            rtnMap.put(fieldName, value);
        }
        return rtnMap;
    }

    private static Object getValueByTypeName(String typeName) {
        Object value = null;
        if (typeName.contains("double")) {
            value = 0;
        } else if (typeName.contains("integer")) {
            value = 0;
        } else if (typeName.contains("string")) {
            value = "";
        } else if (typeName.contains("long")) {
            value = 0;
        }
        return value;
    }



    /***************************************************错误*************begin
     * *************************************************/

    /**
     * 失败
     *
     * @return
     */
    public static Result error() {
        Result resultDto = new Result(ResultCodeEnum.FAILURE);
        return resultDto;
    }

    /**
     * 失败
     *
     * @param msg 失败消息
     * @return
     */
    public static Result error(String msg) {
        Result resultDto = new Result(ResultCodeEnum.FAILURE, msg);
        return resultDto;
    }

    public static Result error2(String msg) {
        Result resultDto = new Result(ResultCodeEnum.TIME_LIMIT_OVER, msg);
        return resultDto;
    }

    /**
     * 失败
     *
     * @param object 返回的对象
     * @return
     */
    public static Result error(Object object) {
        Result resultDto = new Result(ResultCodeEnum.FAILURE);
        resultDto.setData(object);
        return resultDto;
    }

    public static Result error(String msg, Object object) {
        Result resultDto = new Result(ResultCodeEnum.FAILURE);
        resultDto.setData(object);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public static Result error(ResultCodeEnum resultCodeEnum, String msg) {
        Result resultDto = new Result(resultCodeEnum, msg);
        return resultDto;
    }


    /**************************************************错误****************end
     * **********************************************/


}

