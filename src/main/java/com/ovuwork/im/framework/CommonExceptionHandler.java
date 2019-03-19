package com.ovuwork.im.framework;

import com.ovuwork.im.common.entity.rest.RestOutVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangruchao on 2018/3/17.
 */
@ComponentScan
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestOutVo jsonErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        String uri = request.getRequestURI();
        log.error(uri+" error :", e);
        return RestOutVo.error();
    }
}
