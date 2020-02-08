package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.service.SecondInterviewService;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 10:14
 */
@Service
public class SecondInterviewServiceImpl implements SecondInterviewService {

    @Resource
    ApplyMsgMapper applyMsgMapper;

    @Override
    public UniversalResponseBody SecondCheck(String userTel, Integer departmentId) {
        if (applyMsgMapper.UpdateSecondDepartment(userTel,departmentId)>0){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
        }else{
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }
}
