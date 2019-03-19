package com.ovuwork.im.service;

import com.ovuwork.im.common.constant.AppRestCode;
import com.ovuwork.im.common.constant.FinalParam;
import com.ovuwork.im.common.dao.Dao;
import com.ovuwork.im.common.entity.rest.ResultVo;
import com.ovuwork.im.entity.ImGuest;
import com.ovuwork.im.repository.ImGuestRepository;
import com.ovuwork.im.utlis.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private ImGuestRepository imGuestRepository;

    /**
     * 用户注册
     * @param params
     * @return
     */
    public ResultVo register(Map params) {
        ResultVo resultVo = new ResultVo<>();
        String userId = params.get("user_id").toString();//用户登录唯一识别id
        String token = params.get("token").toString();//用户登录令牌
        String nickname = params.get("nickname").toString();//用户登录令牌
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(userId) || StringUtils.isEmpty(nickname)){
            resultVo.setFail(true);
            resultVo.setAppRestCode(AppRestCode.PARAM_IS_EMPTY);
            return resultVo;
        }
        //唯一性校验
        ImGuest imGuest = imGuestRepository.findOneByUserId(userId);
        if (imGuest != null) {
            resultVo.setFail(true);
            resultVo.setAppRestCode(AppRestCode.USER_ID_REPEAT);
            return resultVo;
        }
        imGuest = new ImGuest(null, userId, token, nickname, DateUtils.getNow(), FinalParam.IntYesNo.NO);
        Dao.saveOrUpdate(imGuest);
        resultVo.setAppRestCode(AppRestCode.SUCCESS);
        return resultVo;
    }
}
