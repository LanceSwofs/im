package com.ovuwork.im.repository;

import com.ovuwork.im.common.dao.Dao;
import com.ovuwork.im.entity.ImGuest;
import org.springframework.stereotype.Repository;

@Repository
public class ImGuestRepository {

    /**
     * 查询未删除的用户
     * @param userId 用户唯一识别id
     * @return
     */
    public ImGuest findOneByUserId(String userId) {
        String sql = "select * from im_guest where del_flag=0 and user_id=? limit 1";
        return Dao.queryJavaOne(sql, ImGuest.class, userId);
    }
}
