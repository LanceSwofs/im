package com.ovuwork.im.common.entity;

import com.serverlite.dao.mapping.Table;

/**
 * 系统配置信息
 * @author Neo
 *
 */
@Table("sys_configs")
public class SysConfigs {

	private String id;
	
	private String key;
	
	private String val;
	
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
