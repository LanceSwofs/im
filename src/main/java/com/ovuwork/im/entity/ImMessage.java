
package com.ovuwork.im.entity;

import com.serverlite.dao.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Created by ovu on 2018-12-25 11:21:01
*/
@Table(value = "im_message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImMessage {
	private String id;	// 主键id,fingerPrint消息指纹
	private String finger_print; // 消息指纹
	private String from_user_id;	// 发送方的user_id
	private String user_id;	// 接收方的user_id
	private String data_content;	// 消息内容
	private long sort; // 消息排序号
	private int type;	// 消息类型(1.C2C 2.S2C)
	private int status;	// 消息状态(0.发送成功 1.发送失败)
	private String create_time;	// 创建时间
	private int del_flag;	// 删除标志(0.未删除 1.已删除)

	public interface TYPES{
		int C2C = 1;
		int S2C = 2;
	}

	public interface STATUS{
		int SUCCESS = 0;
		int FAILURE = 1;
	}
}