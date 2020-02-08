package com.volunteer.uapply.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.AliyunEnrollParam;
import com.volunteer.uapply.pojo.info.AliyunFisrtInterviewParam;
import com.volunteer.uapply.pojo.info.AliyunResponseInfo;
import com.volunteer.uapply.pojo.info.AliyunSecondInterviewParam;
import com.volunteer.uapply.service.MessageService;
import com.volunteer.uapply.utils.AliyunMessageUtil;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 16:20
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Resource
    AliyunMessageUtil aliyunMessageUtil;
    @Resource
    ApplyMsgMapper applyMsgMapper;

    @Override
    public UniversalResponseBody FirstInterviewMessage(AliyunFisrtInterviewParam aliyunFisrtInterviewParam) throws ClientException {
    return null;
    }

    /**
     * 发送二面短信
     * @param aliyunSecondInterviewParam
     * @return
     * @throws ClientException
     */
    @Override
    public UniversalResponseBody SecondInterviewMessage(AliyunSecondInterviewParam aliyunSecondInterviewParam) throws ClientException {

        return null;
    }

    @Override
    public UniversalResponseBody EnrollMessage(AliyunEnrollParam enrollParam) throws ClientException {
       return null;
    }
}
