package com.ovuwork.im.controller;

import com.ovuwork.im.common.entity.rest.RestInVo;
import com.ovuwork.im.common.entity.rest.RestOutVo;
import com.ovuwork.im.common.entity.rest.ResultVo;
import com.ovuwork.im.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public RestOutVo register(@Valid @RequestBody RestInVo<Map> restInVo, HttpServletRequest request){
        Map params = restInVo.getData();
        ResultVo resultVo = userService.register(params);
        return RestOutVo.ok(resultVo);
    }
}