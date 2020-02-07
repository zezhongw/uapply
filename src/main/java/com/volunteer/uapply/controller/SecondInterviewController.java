package com.volunteer.uapply.controller;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.AliyunInterviewParamInfo;
import com.volunteer.uapply.service.AliyunMessageService;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/7 16:21
 */
@RequestMapping("/pc/second")
@RestController
public class SecondInterviewController {


    @Resource
    private AliyunMessageService aliyunMessageService;

    /**
     * 发送面试短信
     * @param aliyunInterviewParamInfo
     * @return
     * @throws ClientException
     */
    @UserLoginToken
    @PostMapping("/message")
    public UniversalResponseBody SendFirstInterviewMessage(@RequestBody AliyunInterviewParamInfo aliyunInterviewParamInfo){
        return null;
    }


    /**
     * 部门待二面
     * @param departmentId
     * @return
     */
    @UserLoginToken
    @GetMapping("/un")
    public UniversalResponseBody<List<User>> UnSecondInterview(Integer departmentId){
        return null;
    }

    /**
     * 部门已经二面
     * @param departmentId
     * @return
     */
    @UserLoginToken
    @GetMapping("/ed")
    public UniversalResponseBody<List<User>> SecondedInterviewed(Integer departmentId){
        return null;
    }

    /**
     * 录取为部员
     * @param departmentId
     * @return
     */
    @UserLoginToken
    @PostMapping("/enroll")
    public UniversalResponseBody EnrollMembers(Integer[] departmentId){
        return null;
    }

    /**
     * 二面淘汰
     * @return
     */
    @UserLoginToken
    @PostMapping("/eliminate")
    public UniversalResponseBody SecondEliminate(Integer userId,Integer departmentId){
        return null;
    }
}
