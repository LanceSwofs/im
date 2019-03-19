package com.ovuwork.im.mobileimsdk.server.constant;

public enum ErrorCode {

	SUCCESS(0,"正确返回"),
    LOGIN_USER_ID_NOT_EXIST(1025,"不存在的USER_ID"),
    TOKEN_ERROR(1026,"token错误"),
    PARAMS_EMPTY(1027,"参数为空"),


    RUN_ERROR(9999,"服务器异常"),
	;
	private int code;//大于1024的整数
	private String message;

	private ErrorCode(int code, String message){
		this.code = code;
		this.message = message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}

