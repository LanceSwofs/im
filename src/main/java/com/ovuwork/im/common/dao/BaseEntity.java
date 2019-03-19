package com.ovuwork.im.common.dao;


import java.io.Serializable;

public class BaseEntity implements Serializable{

	protected String id;				// 主键id
	
	protected String remarks;			// 备注
	
	protected String create_by;			// 创建者
	
	protected String create_date;		// 创建日期
	
	protected String update_by;			// 更新者
	
	protected String update_date;		// 更新日期
	
	protected String del_flag = "0"; 	// 删除标记（0：正常；1：删除）
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
}
