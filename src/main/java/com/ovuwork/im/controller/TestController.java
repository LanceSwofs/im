package com.ovuwork.im.controller;

import com.ovuwork.im.common.constant.FinalParam;
import com.ovuwork.im.common.dao.Dao;
import com.ovuwork.im.common.entity.rest.RestInVo;
import com.ovuwork.im.common.entity.rest.RestOutVo;
import com.ovuwork.im.common.service.RedisService;
import com.ovuwork.im.entity.ImMessage;
import com.ovuwork.im.utlis.DateUtils;
import net.openmob.mobileimsdk.server.utils.LocalSendHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "sendData")
    public RestOutVo sendData(@Valid @RequestBody RestInVo<Map> restInVo, HttpServletRequest request) throws Exception {
        Map params = restInVo.getData();
        String userId = params.get("user_id").toString();
        String dataContent = params.get("data_content").toString();
        final boolean[] isSuccessArr = {true};
        final Object[] resultObjArr = new Object[1];
        LocalSendHelper.sendData(userId, dataContent, (isSuccess, resultObj) -> {
            if (!isSuccess){
                long sort = redisService.incr(FinalParam.RedisKeys.IM_MESSAGE_SORT, RedisService.NOT_EXPIRE);
                ImMessage imMessage = new ImMessage(null, UUID.randomUUID().toString(), "0", userId,
                        dataContent, sort, ImMessage.TYPES.S2C, ImMessage.STATUS.FAILURE, DateUtils.getNow(),
                        FinalParam.IntYesNo.NO);
                Dao.saveOrUpdate(imMessage);
            }
            isSuccessArr[0] = isSuccess;
            resultObjArr[0] = resultObj;
        });
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("is_success", isSuccessArr[0]);
        resultMap.put("result_obj", resultObjArr[0]);
        return RestOutVo.ok(resultMap);
    }

    @RequestMapping(value = "exception")
    public Object exception(HttpServletRequest request) {
        int i = 1/0;
        return i;
    }
}
