package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.mapper.InterviewMsgMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.FirstInterviewService;
import com.volunteer.uapply.utils.enums.InterviewStatusEnum;
import com.volunteer.uapply.utils.enums.PermissionIdEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 武泽中
 * @version 1.00
 * @date 2020/2/10/10:18
 */
@Slf4j
@Service
public class FirstInterviewServiceImpl implements FirstInterviewService {

    @Resource
    InterviewMsgMapper interviewMsgMapper;

    @Resource
    ApplyMsgMapper applyMsgMapper;

    /**
     * 插入面试评分,并更改面试状态
     *
     * @param interviewPO
     * @return
     */
    @Override
    public UniversalResponseBody scoreResume(InterviewPO interviewPO) {
        if (interviewMsgMapper.InsertInterview(interviewPO) > 0) {
            //并修改用户报名信息相应的状态
            ApplyPO applyPO = applyMsgMapper.findApplyMsgByUserId(interviewPO.getUserId());
            if (applyPO.getFirstIntentionId().equals(interviewPO.getDepartmentId())) {
                applyMsgMapper.ChangeFirstIntentionStatus(interviewPO.getUserId(), InterviewStatusEnum.FIRST_INTENTION_INTERVIEW.getInterviewStatusId());
            } else if (applyPO.getSecondIntentionId().equals(interviewPO.getDepartmentId())) {
                applyMsgMapper.ChangeSecondIntentionStatus(interviewPO.getUserId(), InterviewStatusEnum.SECOND_INTENTION_INTERVIEW.getInterviewStatusId());
            } else {
                return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(), ResponseResultEnum.FAILED.getMsg());
            }
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
        }else{
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }

    /**
     * 查询待一面人员
     * @param departmentId
     * @return
     */
    @Override
    public UniversalResponseBody<List<ApplyPO>> SelectUnfirstInterview(Integer departmentId) {
        List<ApplyPO> allunfirstInterview=interviewMsgMapper.SelectUnfirstInterviewByDepartmentId(departmentId);
        List<ApplyPO> unfirstInterview=new LinkedList<>();
        for(ApplyPO applypo :allunfirstInterview){
            List<User> temp=interviewMsgMapper.JudgeUnfirstInterview(applypo.getUserId());
            if(temp.size()==2) {
                continue;
            } else if(temp.size()==1){
                if(!departmentId.equals(temp.get(0).getDepartmentId())) {
                    unfirstInterview.add(applypo);
                }
            }
            else if(temp==null){
                unfirstInterview.add(applypo);
            }
        }
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),unfirstInterview);
    }

    /**
     * 查询已一面人员
     * @param departmentId
     * @return
     */
    @Override
    public UniversalResponseBody<List<ApplyPO>> SelectFirstInterviewed(Integer departmentId) {
        List<ApplyPO> applyPOs=interviewMsgMapper.SelectFirstInterviewed(departmentId);
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),applyPOs);
    }

    /**
     * 淘汰一面人员
     * @param userId
     * @param departmentId
     * @return
     */
    @Override
    public UniversalResponseBody EliminateFirst(Integer userId, Integer departmentId) {
        int result=interviewMsgMapper.EliminateFirst(userId,departmentId);
        if (result!=0){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
        }else{
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }

}
