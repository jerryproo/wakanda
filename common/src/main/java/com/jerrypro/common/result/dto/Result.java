package com.jerrypro.common.result.dto;

import com.jerrypro.common.result.enums.ResultCodeEnum;

/**
 * @author 王正伟
 * 创建时间：2021/7/22
 */
public class Result<T> {
    /**
     * -1 失败
     * 1 成功
     */
    private Integer code;
    /**
     * 成功/失败提示语
     */
    private String msg;

    /**
     * 返回内容
     */
    private T data;

    public Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
    }

    public Result(ResultCodeEnum resultCodeEnum, String msg) {
        this.code = resultCodeEnum.getCode();
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.code.equals(ResultCodeEnum.SUCCESS.getCode());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
