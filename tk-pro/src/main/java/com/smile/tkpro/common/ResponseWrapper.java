package com.smile.tkpro.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 功能描述：统一数据传输格式.
 *
 * @author liuguanghui
 * @since 2018-01-22
 */
@Getter
@Setter
@ToString
public class ResponseWrapper {

    /**
     * 状态类型
     */
    public enum StatusEnum {
        /* 成功 */
        SUCCESS,
        /* 异常 */
        ERROR
    }

    /**
     * infoCode 成功
     */
    private static final Integer INFO_CODE_SUCCESS = 0;
    /**
     * infoCode 异常
     */
    private static final Integer INFO_CODE_ERROR = 1;
    /**
     * 状态
     */
    private StatusEnum status;
    /**
     * 响应码
     */
    private Integer infoCode;
    /**
     * 响应信息
     */
    private String info;
    /**
     * 传输数据
     */
    private Object data;

    /**
     * 无参构造器
     */
    public ResponseWrapper() {
    }

    /**
     * 全参构造器
     *
     * @param status   状态
     * @param infoCode 响应码
     * @param info     响应信息
     * @param data     传输数据
     */
    public ResponseWrapper(StatusEnum status, Integer infoCode, String info, Object data) {
        this.status = status;
        this.infoCode = infoCode;
        this.info = info;
        this.data = data;
    }

    /**
     * 状态为成功的响应.
     *
     * @return 响应
     */
    public static ResponseWrapper success() {
        return new ResponseWrapper(StatusEnum.SUCCESS, INFO_CODE_SUCCESS, null, null);
    }

    /**
     * 状态为成功的响应.
     *
     * @param info 描述
     * @return 响应
     */
    public static ResponseWrapper success(String info) {
        return new ResponseWrapper(StatusEnum.SUCCESS, INFO_CODE_SUCCESS, info, null);
    }

    /**
     * 状态为成功的响应.
     *
     * @param data 返回数据
     * @return 响应
     */
    public static ResponseWrapper success(Object data) {
        return new ResponseWrapper(StatusEnum.SUCCESS, INFO_CODE_SUCCESS, null, data);
    }

    /**
     * 状态为成功的响应.
     *
     * @param info 描述
     * @param data 返回数据
     * @return 响应
     */
    public static ResponseWrapper success(String info, Object data) {
        return new ResponseWrapper(StatusEnum.SUCCESS, INFO_CODE_SUCCESS, info, data);
    }

    /**
     * 状态为异常的响应.
     *
     * @return 响应
     */
    public static ResponseWrapper error() {
        return new ResponseWrapper(StatusEnum.ERROR, INFO_CODE_ERROR, null, null);
    }

    /**
     * 状态为异常的响应.
     *
     * @param info 描述
     * @return 响应
     */
    public static ResponseWrapper error(String info) {
        return new ResponseWrapper(StatusEnum.ERROR, INFO_CODE_ERROR, info, null);
    }

    /**
     * 状态为异常的响应.
     *
     * @param data 返回数据
     * @return 响应
     */
    public static ResponseWrapper error(Object data) {
        return new ResponseWrapper(StatusEnum.ERROR, INFO_CODE_ERROR, null, data);
    }

    /**
     * 状态为异常的响应.
     *
     * @param info 描述
     * @param data 返回数据
     * @return 响应
     */
    public static ResponseWrapper error(String info, Object data) {
        return new ResponseWrapper(StatusEnum.ERROR, INFO_CODE_ERROR, info, data);
    }
}