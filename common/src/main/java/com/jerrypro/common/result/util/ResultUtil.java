package com.jerrypro.common.result.util;

/**
 * @author jerrypro
 * @date 2021/7/23
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jerrypro.common.result.dto.Result;
import com.jerrypro.common.result.enums.ResultCodeEnum;
import com.jerrypro.common.util.DateUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    /***************************************************成功*************begin
     * *************************************************/

    /**
     * 返回成功
     *
     * @return
     */
    public static Result success() {
        Result result = new Result(ResultCodeEnum.SUCCESS);
        return result;
    }

    /**
     * 返回成功
     *
     * @param msg 成功消息
     * @return
     */
    public static Result success(String msg) {
        Result result = new Result(ResultCodeEnum.SUCCESS, msg);
        return result;
    }

    /**
     * 返回成功
     *
     * @param object 需要的对象
     * @return
     */
    public static Result successData(Object object) {
        Result result = new Result(ResultCodeEnum.SUCCESS);
        result.setData(object);
        return result;
    }

    /**
     * 返回成功
     *
     * @param object 需要的对象
     * @return
     */
    public static Result successData(String fileNames, Object object) {
        Result result = new Result(ResultCodeEnum.SUCCESS);
        result.setData(getObjectMap(fileNames, object));
        return result;
    }

    /**
     * 返回处理后的map
     *
     * @param fileNames
     * @param object
     * @return
     */
    public static Map<String, Object> getObjectMap(String fileNames, Object object) {
        String[] fieldNameArr = fileNames.split(",");

        Map<String, Object> rtnMap = new HashMap<String, Object>();
        for (String fieldName : fieldNameArr) {
            Object value;
            try {
                String firstLetter = fieldName.substring(0, 1)
                        .toUpperCase();
                String getter = "get" + firstLetter + fieldName.substring(1);
                Method method = object.getClass()
                        .getMethod(getter, new Class[]{});
                String typeName = method.getReturnType()
                        .getName()
                        .toLowerCase();

                value = method.invoke(object, new Object[]{});
                if (value == null) {
                    value = getValueByTypeName(typeName);
                } else {
                    if (typeName.contains("localdatetime")) {
                        value = DateUtil.getDefLocalDateTimeStr((LocalDateTime) value);
                    } else if (typeName.contains("long")) {
                        //long类型暂时不转-》原因是分页total是long类型
                    }
                }
            } catch (NoSuchMethodException e) {
                value = null;
            } catch (SecurityException e) {
                value = null;
            } catch (IllegalAccessException e) {
                value = null;
            } catch (IllegalArgumentException e) {
                value = null;
            } catch (InvocationTargetException e) {
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

    /**
     * 返回成功
     *
     * @param tList 需要的对象
     * @return
     */
    public static <T> Result successDataList(String fileNames, List<T> tList) {
        Result resultDto = new Result(ResultCodeEnum.SUCCESS);
        resultDto.setData(getObjectListMap(fileNames, tList));
        return resultDto;
    }

    /**
     * 返回成功
     *
     * @param tList 需要的对象
     * @return
     */
    public static <T> Result successDataList(List<T> tList) {
        Result resultDto = new Result(ResultCodeEnum.SUCCESS);
        resultDto.setData(tList);
        return resultDto;
    }

    /**
     * 返回成功
     *
     * @param object 需要的对象
     * @return
     */
    public static Result successMap(String fileNames, Object object) {
        Result resultDto = new Result(ResultCodeEnum.SUCCESS);
        resultDto.setData(getMap(fileNames, object));
        return resultDto;
    }

    /**
     * 返回处理后的map
     *
     * @param obj 处理的对象
     * @return
     */
    public static Map<String, Object> getMap(String fieldName, Object obj) {
        String[] fieldNameArr = fieldName.split(",");
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<String, Object> map = (Map<String, Object>) obj;
        Class<? extends Object> valueClass = null;
        for (Map.Entry<String, Object> e : map.entrySet()) {
            if (!Arrays.asList(fieldNameArr)
                    .contains(e.getKey())) {
                continue;
            }
            Object value = e.getValue();
            valueClass = value.getClass();
            setMapValue(rtnMap, e.getKey(), value, valueClass);
        }

        return rtnMap;
    }

    /**
     * 对map塞值
     *
     * @param key        键
     * @param value      值
     * @param valueClass 对象
     */
    private static void setMapValue(
            Map<String, Object> rtnMap, Object key, Object value, Class<? extends Object> valueClass) {

        if (valueClass.equals(Integer.class)) {
            rtnMap.put((String) key, Integer.valueOf(String.valueOf(value)));
        } else if (valueClass.equals(Double.class)) {
            rtnMap.put((String) key, Double.valueOf(String.valueOf(value)));
        } else if (valueClass.equals(Long.class)) {
            rtnMap.put((String) key, Long.valueOf(String.valueOf(value)));
        } else if (valueClass.equals(Timestamp.class)) {
            Timestamp timestamp = (Timestamp) value;
            LocalDateTime localDateTime = timestamp.toLocalDateTime();

            try {
                rtnMap.put((String) key, DateUtil.getDefLocalDateTimeStr(localDateTime));
            } catch (Exception e) {
                rtnMap.put((String) key, String.valueOf(value));
            }

        } else {
            rtnMap.put((String) key, String.valueOf(value));
        }
    }

    /**
     * 对Map返回对象处理
     *
     * @param fileNames  返回的字段
     * @param objectList MapList
     * @return
     */
    public static Result successMapList(String fileNames, List<Object> objectList) {
        Result resultDto = new Result(ResultCodeEnum.SUCCESS);
        resultDto.setData(getMapList(fileNames, objectList));
        return resultDto;
    }

    /**
     * 返回处理后的maplist
     *
     * @param fileNames  需要返回的列
     * @param objectList 对象List
     * @return
     */
    private static List<Map<String, Object>> getMapList(String fileNames, List<Object> objectList) {
        List<Map<String, Object>> rtnMapList = new ArrayList<Map<String, Object>>();
        try {

            for (Object tempObject : objectList) {
                Map<String, Object> rtnMap = getMap(fileNames, tempObject);
                rtnMapList.add(rtnMap);
            }

            return rtnMapList;
        } catch (Exception e) {

            return null;
        }

    }

    public static Result successJsonArr(JSONArray array) {
        Result resultDto = new Result(ResultCodeEnum.SUCCESS);
        resultDto.setData(array);
        return resultDto;
    }

    public static Result successJson(JSONObject jsonObject) {
        Result resultDto = new Result(ResultCodeEnum.SUCCESS);
        resultDto.setData(jsonObject);
        return resultDto;
    }

    /**
     * 对对象处理需要返回的列整理为maplist
     *
     * @param fileNames 需要返回的列
     * @param tList     处理的列表
     * @return
     */
    public static <T> List<Map<String, Object>> getObjectListMap(String fileNames, List<T> tList) {
        return getObjectListMap(fileNames, null, tList);

    }

    /**
     * 对对象处理需要返回的列整理为maplist
     *
     * @param fileNames 需要返回的列
     * @param map       如果返回中存在列表，且列表也需要过滤字段。
     * @param tList     处理的列表
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, Object>> getObjectListMap(
            String fileNames, Map<String, String> map, List<T> tList) {
        if (tList == null) {
            return new ArrayList<>();
        }
        List<Map<String, Object>> rtnMapList = new ArrayList<Map<String, Object>>();
        try {

            for (Object tempObject : tList) {
                Map<String, Object> rtnMap = getObjectMap(fileNames, map, tempObject);
                rtnMapList.add(rtnMap);
            }

            return rtnMapList;
        } catch (Exception e) {

            return null;
        }

    }

    /**
     * 返回处理后的map
     *
     * @param fileNames
     * @param object
     * @return
     */
    public static Map<String, Object> getObjectMap(String fileNames, Map<String, String> map, Object object) {
        String[] fieldNameArr = fileNames.split(",");

        Map<String, Object> rtnMap = new HashMap<String, Object>();
        for (String fieldName : fieldNameArr) {
            Object value;
            try {
                String firstLetter = fieldName.substring(0, 1)
                        .toUpperCase();
                String getter = "get" + firstLetter + fieldName.substring(1);
                Method method = object.getClass()
                        .getMethod(getter, new Class[]{});
                String typeName = method.getReturnType()
                        .getName()
                        .toLowerCase();

                value = method.invoke(object, new Object[]{});
                if (value == null) {
                    value = getValueByTypeName(typeName);
                } else {
                    if (typeName.contains("localdatetime")) {
                        value = DateUtil.getDefLocalDateTimeStr((LocalDateTime) value);
                    } else if (typeName.contains("long")) {
                        //long类型暂时不转-》原因是分页total是long类型

                    } else if (typeName.contains("list") && map != null && map.containsKey(fieldName)) {
                        //包含列表，且列表需要过滤。
                        value = getObjectListMap(map.get(fieldName), (ArrayList) value);
                    }
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                value = null;
            }
            rtnMap.put(fieldName, value);
        }
        return rtnMap;
    }


    /***************************************************成功*************end
     * *************************************************/


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

