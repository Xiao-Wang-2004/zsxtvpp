package com.wang.zsxt.tool;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一响应格式类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    
    /**
     * 响应状态码
     */
    private Integer code;
    
    /**
     * 响应消息
     */
    private String msg;
    
    /**
     * 响应数据
     */
    private T data;

    public Response() {}

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功响应
     */
    public static <T> Response<T> success() {
        return new Response<>(200, "操作成功", null);
    }

    public static <T> Response<T> success(String msg) {
        return new Response<>(200, msg, null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(200, "操作成功", data);
    }

    public static <T> Response<T> success(String msg, T data) {
        return new Response<>(200, msg, data);
    }

    /**
     * 失败响应
     */
    public static <T> Response<T> error() {
        return new Response<>(500, "操作失败", null);
    }

    public static <T> Response<T> error(String msg) {
        return new Response<>(500, msg, null);
    }

    public static <T> Response<T> error(Integer code, String msg) {
        return new Response<>(code, msg, null);
    }

    public static <T> Response<T> error(Integer code, String msg, T data) {
        return new Response<>(code, msg, data);
    }

    // Getter和Setter方法
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