package com.volunteer.uapply.service;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.pojo.info.AliyunEnrollParam;
import com.volunteer.uapply.pojo.info.AliyunFisrtInterviewParam;
import com.volunteer.uapply.pojo.info.AliyunSecondInterviewParam;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

/**
 * 短信服务层
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 14:10
 */
public interface MessageService {

    /**
     * 一面短信
     * @param aliyunInterviewParamInfo
     * @return
     */
    UniversalResponseBody FirstInterviewMessage(AliyunFisrtInterviewParam aliyunInterviewParamInfo) throws ClientException;

    /**
     * 二面短信
     * @param aliyunSecondMsgParamInfo
     * @return
     */
    UniversalResponseBody SecondInterviewMessage(AliyunSecondInterviewParam aliyunSecondMsgParamInfo) throws ClientException;

    /**
     * 录取短信
     * @param enrollParam
     * @return
     */
    UniversalResponseBody EnrollMessage(AliyunEnrollParam enrollParam) throws ClientException;
}
