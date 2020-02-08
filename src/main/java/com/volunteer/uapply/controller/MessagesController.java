package com.volunteer.uapply.controller;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.info.AliyunEnrollParamInfo;
import com.volunteer.uapply.pojo.info.AliyunInterviewParamInfo;
import com.volunteer.uapply.pojo.info.AliyunSecondMsgParamInfo;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 11:05
 */
@RestController
@RequestMapping("/messages")
public class MessagesController {
    /**
     * 发送一面面试短信
     * @param aliyunInterviewParamInfo
     * @return
     * @throws ClientException
     */
    @UserLoginToken
    @PostMapping("/interview/first")
    public UniversalResponseBody SendFirstInterviewMessage(@RequestBody AliyunInterviewParamInfo aliyunInterviewParamInfo) throws ClientException {
        //此处逻辑得改一下
        return null;
    }

    /**
     * 发送二面短信
     * @param aliyunSecondMsgParamInfo
     * @return
     */
    @UserLoginToken
    @PostMapping("/interview/second")
    public UniversalResponseBody SendSecondInterviewMessage(AliyunSecondMsgParamInfo aliyunSecondMsgParamInfo){
        return null;
    }

    /**
     * 发送录取短信
     * @param aliyunEnrollParamInfo
     * @return
     * @throws ClientException
     */
    @UserLoginToken
    @PostMapping("/enroll")
    public UniversalResponseBody SendFirstInterviewMessage(AliyunEnrollParamInfo aliyunEnrollParamInfo) throws ClientException {
        return null;
    }
}
