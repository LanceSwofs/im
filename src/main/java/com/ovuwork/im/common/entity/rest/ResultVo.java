package com.ovuwork.im.common.entity.rest;


import com.ovuwork.im.common.constant.AppRestCode;

public class ResultVo<T> {

	private boolean isFail = false;		//	是否错误	boolean
	
	private AppRestCode appRestCode;		//	错误信息	AppRestCode

	/** 业务参数 **/
	private T data;

	public boolean isFail() {
		return isFail;
	}

	public void setFail(boolean fail) {
		isFail = fail;
	}

	public AppRestCode getAppRestCode() {
		return appRestCode;
	}

	public void setAppRestCode(AppRestCode appRestCode) {
		this.appRestCode = appRestCode;
	}

	public T getData() {
		return data;
	}

	public ResultVo<T> setData(T data) {
		this.data = data;
		return this;
	}
}
