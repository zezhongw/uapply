package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.PassToken;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.service.impl.UserServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录相关接口
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 13:35
 */
@Slf4j
@RestController
public class UserController {

    @Resource
    private UserServiceImpl userService;

    /**
     * 用户微信登录接口
     * @param code
     * @return
     */
    @PassToken
    @PostMapping("/wx/login")
    public UniversalResponseBody<TokenPO> userWxLogin(@RequestBody String code){
        return userService.userWxLogin(code);
    }



}
