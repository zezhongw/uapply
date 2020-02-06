package com.volunteer.uapply.controller;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.annotation.PassToken;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.AliyunRequsetParamInfo;
import com.volunteer.uapply.service.AliyunMessageService;
import com.volunteer.uapply.service.impl.ManagerServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 18:40
 */
@Slf4j
@RestController
public class ManagerController {

    @Resource
    private ManagerServiceImpl managerService;
    @Resource
    private AliyunMessageService aliyunMessageService;

    /**
     * 管理员与部员PC端用户激活
     */
    @PassToken
    @PostMapping("/pc/activate")
    public UniversalResponseBody ManagerPcActivate( User user,String inviteCode){
        return managerService.userPcActivation(user,inviteCode);
    }

    /**
     * 管理员PC端登录接口
     * @param userTel
     * @param userPwd
     * @return
     */
    @PassToken
    @PostMapping("/pc/login")
    public UniversalResponseBody<TokenPO> ManagerPcLogin(@RequestParam("userTel")String userTel, @RequestParam("userPwd") String userPwd){
        return managerService.userPcLogin(userTel,userPwd);
    }

    /**
     * 管理员发送面试短信接口
     */
    @UserLoginToken
    @PostMapping("/pc/interview/message")
    public UniversalResponseBody SendInterviewMessage(@RequestBody AliyunRequsetParamInfo aliyunRequsetParamInfo) throws ClientException {
        return aliyunMessageService.SendMessage(aliyunRequsetParamInfo);
    }

}
