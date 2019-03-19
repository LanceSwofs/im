package com.ovuwork.im.common.constant;

public enum AppRestCode {

	// 请求成功
	SUCCESS("0000","正确返回"),

	// 账户方面错误1xxx
	USERNAME_ERROR("1000","用户名错误"),
	PASSWORD_ERROR("1001","用户密码错误"),
	USERNAMEORPASSWORD_ERROR("1002","用户或密码错误"),
	USER_ID_REPEAT("1003","LOGIN_USER_ID已存在"),

	// 资源错误2xxx
	RESOURCE_EXPIRE("2000","资源已过期"),
	RESOURCE_ERROR("2001","资源不存在"),


	// 参数错误3xxx
	PARAM_IS_ERROR("3000","参数错误"),
	PARAM_IS_EMPTY("3000","参数为空"),

	// TOKEN错误4xxx

	// 业务错误5xxx
	RECEIPT_INFO_ERROR("5001","缴款单信息错误"),

	// 签名错误6xxx

	// 服务器错误9999
	RUN_ERROR("9999","服务器异常，请稍后重试！");



	public String code;
	public String message;

	private AppRestCode(String code, String message){
		this.code = code;
		this.message = message;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}

