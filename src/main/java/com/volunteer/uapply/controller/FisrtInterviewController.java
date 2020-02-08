package com.volunteer.uapply.controller;


import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.AliyunInterviewParamInfo;
import com.volunteer.uapply.service.FirstInterviewService;
import com.volunteer.uapply.service.impl.FirstInterviewServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 一面相关接口
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/7 16:17
 */
@RestController
@RequestMapping("/pc/first")
public class FisrtInterviewController {



    /**
     * 发送面试短信
     * @param aliyunInterviewParamInfo
     * @return
     * @throws ClientException
     */
    @UserLoginToken
    @PostMapping("/message")
    public UniversalResponseBody SendFirstInterviewMessage(@RequestBody AliyunInterviewParamInfo aliyunInterviewParamInfo) throws ClientException {
        //此处逻辑得改一下
        return null;
    }

    /**
     * 部门待一面
     * @param departmentId
     * @return
     */
    @UserLoginToken
    @GetMapping("/un")
    public UniversalResponseBody<List<User>> UnFirstInterview(Integer departmentId){
        return null;
    }

    /**
     * 部门已经一面
     * @param departmentId
     * @return
     */
    @UserLoginToken
    @GetMapping("/ed")
    public UniversalResponseBody<List<User>> FirstInterviewed(Integer departmentId){
        return null;
    }



    /**
     * 一面淘汰
     * @param userId
     * @param departmentId
     * @return
     */
    @UserLoginToken
    @PostMapping("/eliminate")
    public UniversalResponseBody FirstEliminate(Integer userId,Integer departmentId){
        return null;
    }

}
