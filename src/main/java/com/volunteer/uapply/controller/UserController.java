package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.PassToken;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.service.impl.UserServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 普通用户相关接口
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
     * 用户微信小程序登录
     * @param code
     * @return
     */
    @PassToken
    @PostMapping("/wx/login")
    public UniversalResponseBody<TokenPO> userWxLogin(@RequestBody String code){
        return userService.userWxLogin(code);
    }

    /**
     * 用户报名
     * @param applyPO
     * @return
     */
    @PostMapping("/wx/user/apply")
    @UserLoginToken
    public UniversalResponseBody applyMessage(ApplyPO applyPO){
        return null;
    }

    /**
     * 查询面试状态
     * @param userId
     * @return
     */
    @GetMapping("/wx/user/status")
    @UserLoginToken
    public UniversalResponseBody applyStatus(Integer userId){
        return null;
    }
}
