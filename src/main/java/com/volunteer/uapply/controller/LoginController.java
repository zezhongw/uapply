package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.PassToken;
import com.volunteer.uapply.annotation.ToLog;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.service.impl.UserServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录相关接口
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 13:35
 */
@RestController
public class LoginController {

    @Resource
    private UserServiceImpl userService;

    @PassToken
    @PostMapping("/login")
    public UniversalResponseBody<TokenPO> userLogin(@RequestBody String code){
        return userService.userWxLogin(code);
    }

}
