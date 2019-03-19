
package com.ovuwork.im.entity;

import com.serverlite.dao.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* Created by ovu on 2018-12-24 11:14:30
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "im_guest")
public class ImGuest {
    private String id;
    private String user_id; // 用户登录唯一识别id
    private String token; // 用户登录令牌
    private String nickname; // 昵称
    private String create_time;
    private int del_flag;
}