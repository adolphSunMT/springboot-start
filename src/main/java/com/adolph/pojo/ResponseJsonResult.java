package com.adolph.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  200: 表示成功
 *  500: 表示错误，错误信息在msg字段中
 *  501: bean验证错误，不管多少个错误都以map形式返回
 *  502: 拦截器拦截到用户token出错
 *  555: 异常抛出信息
 *
 * @author MaJuntao
 */
public class ResponseJsonResult {
    //定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;
    //响应中的数据
    private Object data;

    private String ok; //

    public static ResponseJsonResult build(Integer status, String msg, Object data) {
        return new ResponseJsonResult(status, msg, data);
    }

    public static ResponseJsonResult ok(Object data) {
        return new ResponseJsonResult(data);
    }

    public static ResponseJsonResult ok() {
        return new ResponseJsonResult(null);
    }

    public static ResponseJsonResult errorMsg(String msg) {
        return new ResponseJsonResult(500, msg, null);
    }

    public static ResponseJsonResult errorMsg(Object data) {
        return new ResponseJsonResult(501, "error", data);
    }

    public static ResponseJsonResult errorTokenMsg(String msg) {
        return new ResponseJsonResult(502, msg, null);
    }
    public static ResponseJsonResult errorException(String msg) {
        return new ResponseJsonResult(505, msg, null);
    }

    public ResponseJsonResult() {
    }

    public ResponseJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
    public Boolean isOk() {
        return this.status == 200;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
