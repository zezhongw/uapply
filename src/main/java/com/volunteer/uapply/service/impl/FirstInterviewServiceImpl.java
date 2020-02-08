package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.mapper.InterviewMsgMapper;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.service.FirstInterviewService;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 9:26
 */
@Slf4j
@Service
public class FirstInterviewServiceImpl implements FirstInterviewService {

    @Resource
    InterviewMsgMapper interviewMsgMapper;

    /**
     * 插入面试评分
     * @param interviewPO
     * @return
     */
    @Override
    public UniversalResponseBody scoreResume(InterviewPO interviewPO) {
        if (interviewMsgMapper.InsertInterview(interviewPO)>0){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
        }else{
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }
}
