package com.volunteer.uapply.controller;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.annotation.PassToken;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.AliyunEnrollParamInfo;
import com.volunteer.uapply.pojo.info.AliyunInterviewParamInfo;
import com.volunteer.uapply.service.impl.ManagerServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员PC端相关接口
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 18:40
 */
@Slf4j
@RestController
@RequestMapping("/pc")
public class ManagerPcController {

    @Resource
    private ManagerServiceImpl managerService;


    /**
     * 管理员PC端用户激活
     */
    @PassToken
    @PostMapping("/activate")
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
    @PostMapping("/login")
    public UniversalResponseBody<TokenPO> ManagerPcLogin(@RequestParam("userTel")String userTel, @RequestParam("userPwd") String userPwd){
        return managerService.userPcLogin(userTel,userPwd);
    }


    /**
     * 发送录取短信短信
     * @return
     * @throws ClientException
     */
    @UserLoginToken
    @PostMapping("/message")
    public UniversalResponseBody SendFirstInterviewMessage(AliyunEnrollParamInfo aliyunEnrollParamInfo) throws ClientException {
        return null;
    }


    @UserLoginToken
    @PostMapping("/members")
    public UniversalResponseBody FindMembers(@RequestParam("departmentId")Integer departmentId, @RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        return null;
    }


    /**
     ** 导出该部门所有部员详细信息
     * @param departmentId
     * @param response
     */
    @GetMapping("/export/{departmentId}")
    public void exportMessages(@PathVariable("departmentId")Integer departmentId, HttpServletResponse response){

    }
}
