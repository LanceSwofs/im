package com.ovuwork.im.common.entity.rest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 接口输入参数
 *
 * @author Neo
 */
public class RestInVo<T> {

    /**
     * 时间戳	    String	Y	14	   yyyyMMddHHmmss
     */
    @Pattern(regexp = "\\d+", message = "时间戳不正确")
    private String timestamp;

    /**
     * 业务参数
     */
    @SuppressWarnings("rawtypes")
    private T data;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
