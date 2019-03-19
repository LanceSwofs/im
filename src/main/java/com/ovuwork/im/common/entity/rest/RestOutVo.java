package com.ovuwork.im.common.entity.rest;

import com.ovuwork.im.common.constant.AppRestCode;
import com.ovuwork.im.utlis.DateUtils;

/**
 * 接口输出参数
 *
 * @author Neo
 */
public class RestOutVo<T> {

    /**
     * 时间戳	String	Y	14	yyyyMMddHHmmss
     */
    private String timestamp;

    /**
     * 错误码	String	N	4
     */
    private String code;

    /**
     * 错误信息	String	N	32
     */
    private String msg;

    /**
     * 业务数据
     */
    private T data;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public RestOutVo setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestOutVo setData(T data) {
        this.data = data;
        return this;
    }

    public RestOutVo(AppRestCode restCode) {
        this.setCode(restCode.code);
        this.setMsg(restCode.message);
    }

    public RestOutVo() {
    }

    public RestOutVo setResult(AppRestCode result) {
        this.setTimestamp(DateUtils.getDateTimeSequence());
        this.setCode(result.code);
        this.setMsg(result.message);
        return this;
    }

    public static RestOutVo ok(AppRestCode appRestCode) {
        return new RestOutVo().setResult(appRestCode);
    }

    public static RestOutVo ok(AppRestCode appRestCode, Object data) {
        return new RestOutVo().setResult(appRestCode).setData(data);
    }

    public static RestOutVo ok(ResultVo resultVo) {
        return new RestOutVo().setResult(resultVo.getAppRestCode()).setData(resultVo.getData());
    }

    public static RestOutVo ok(Object data) {
        return new RestOutVo().setResult(AppRestCode.SUCCESS).setData(data);
    }

    public static RestOutVo ok() {
        return new RestOutVo().setResult(AppRestCode.SUCCESS);
    }

    public static RestOutVo error() {
        return new RestOutVo().setResult(AppRestCode.RUN_ERROR);
    }
}
