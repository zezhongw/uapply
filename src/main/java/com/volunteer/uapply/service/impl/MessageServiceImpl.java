package com.volunteer.uapply.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.AliyunEnrollParam;
import com.volunteer.uapply.pojo.info.AliyunFisrtInterviewParam;
import com.volunteer.uapply.pojo.info.AliyunResponseInfo;
import com.volunteer.uapply.pojo.info.AliyunSecondInterviewParam;
import com.volunteer.uapply.service.MessageService;
import com.volunteer.uapply.utils.AliyunMessageUtil;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
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
        ApplyPO applyPO;
        AliyunResponseInfo aliyunResponseInfo = null;
        for (Integer userId :
                aliyunFisrtInterviewParam.getUserId()) {
            applyPO = applyMsgMapper.findApplyMsgByUserId(userId);
            aliyunResponseInfo = aliyunMessageUtil.SendMessage(applyPO.getUserTel(), applyPO.getUserName(), aliyunFisrtInterviewParam.getTimeSlot(), aliyunFisrtInterviewParam.getDepartmentId(
            ), aliyunFisrtInterviewParam.getTelNo(), aliyunFisrtInterviewParam.getPlace());
            if ("OK".equals(aliyunResponseInfo.getCode())) {
                continue;
            } else {
                log.error("一面短信发送失败" + applyPO + aliyunFisrtInterviewParam.getDepartmentId());
            }
        }
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
    }

    /**
     * String PhoneNumbers, String name, String timeSlot, Integer departmentId, String telNo, String place
     * 发送二面短信
     *
     * @param aliyunSecondInterviewParam
     * @return
     * @throws ClientException
     */
    @Override
    public UniversalResponseBody SecondInterviewMessage(AliyunSecondInterviewParam aliyunSecondInterviewParam) throws ClientException {
        ApplyPO applyPO;
        AliyunResponseInfo aliyunResponseInfo = null;
        for (Integer userId :
                aliyunSecondInterviewParam.getUserId()) {
            applyPO = applyMsgMapper.findApplyMsgByUserId(userId);
            aliyunResponseInfo = aliyunMessageUtil.SendMessage(applyPO.getUserTel(), applyPO.getUserName(), aliyunSecondInterviewParam.getTimeSlot(), aliyunSecondInterviewParam.getDepartmentId(
            ), aliyunSecondInterviewParam.getTelNo(), aliyunSecondInterviewParam.getPlace());
            if ("OK".equals(aliyunResponseInfo.getCode())) {
                continue;
            } else {
                log.error("二面短信发送失败" + applyPO + aliyunSecondInterviewParam.getDepartmentId());
            }
        }
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
    }
    @Override
    public UniversalResponseBody EnrollMessage(AliyunEnrollParam enrollParam) throws ClientException {
        ApplyPO applyPO;
        AliyunResponseInfo aliyunResponseInfo = null;
        for (Integer userId :
                enrollParam.getUserId()) {
            applyPO = applyMsgMapper.findApplyMsgByUserId(userId);
            aliyunResponseInfo = aliyunMessageUtil.SendEnrollMessage(applyPO.getUserTel(), applyPO.getUserName(), enrollParam.getDepartmentId(), enrollParam.getSecret());
            if ("OK".equals(aliyunResponseInfo.getCode())) {
                continue;
            } else {
                log.error("录取短信发送失败" + applyPO + enrollParam.getDepartmentId());
            }
        }
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
    }
}
