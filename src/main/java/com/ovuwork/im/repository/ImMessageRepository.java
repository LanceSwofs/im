package com.ovuwork.im.repository;

import com.ovuwork.im.common.dao.Dao;
import com.ovuwork.im.entity.ImMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImMessageRepository {

    public ImMessage findOneByFingerPrintForUpdate(String fingerPrint) {
        String sql = "select * from im_message where finger_print=? and del_flag=0 for update";
        return Dao.queryJavaOne(sql, ImMessage.class, fingerPrint);
    }

    public List<ImMessage> findFailureAllByUserId(String userId) {
        String sql = "select * from im_message where user_id=? and del_flag=0 and status=? order by sort asc";
        return Dao.queryJava(sql, ImMessage.class, userId, ImMessage.STATUS.FAILURE);
    }

    public void updateStatusById(String id, int status) {
        String sql = "update im_message set status=? where id=?";
        Dao.update(sql, status, id);
    }
}
