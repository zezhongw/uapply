package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.PassToken;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.impl.ManagerServiceImpl;
import com.volunteer.uapply.service.impl.UserServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录/激活
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 11:20
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private ManagerServiceImpl managerService;

    /**
     * 用户微信小程序登录
     * @param code
     * @return
     */
    @PassToken
    @PostMapping("/wx")
    public UniversalResponseBody<TokenPO> userWxLogin(@RequestBody String code){
        return userService.userWxLogin(code);
    }

    /**
     * 管理员PC端登录接口
     * @param userTel
     * @param userPwd
     * @return
     */
    @PassToken
    @PostMapping("/login")
    public UniversalResponseBody<TokenPO> ManagerPcLogin(@RequestParam("userTel")String userTel, @RequestParam("userPwd") String userPwd){
        return managerService.userPcLogin(userTel,userPwd);
    }

    /**
     * 管理员账户激活
     * @param user
     * @param inviteCode
     * @return
     */
    @PassToken
    @PostMapping("/activate")
    public UniversalResponseBody ManagerPcActivate(User user, String inviteCode){
        return managerService.userPcActivation(user,inviteCode);
    }
}
