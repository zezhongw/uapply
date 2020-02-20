package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.mapper.InterviewMsgMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.pojo.SearchInterviewPojo;
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
 * @version 2.00
 * @date 2020/2/20/18:18
 */
@Slf4j
@Service
public class FirstInterviewServiceImpl implements FirstInterviewService {

    @Resource
    InterviewMsgMapper interviewMsgMapper;

    @Resource
    ApplyMsgMapper applyMsgMapper;

    @Resource
    UserMapper userMapper;

    /**
     * 插入面试评分,并更改面试状态
     *
     * @param interviewPO
     * @return
     */
    @Override
    public UniversalResponseBody scoreResume(InterviewPO interviewPO) {
        /*if (interviewMsgMapper.InsertInterview(interviewPO) > 0) {
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
        }*/
        return null;
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
    public UniversalResponseBody<List<SearchInterviewPojo>> SelectFirstInterviewed(Integer departmentId) {
        List<SearchInterviewPojo> searchInterviewPojos = new LinkedList<>();
        List<InterviewPO> myInterviews = interviewMsgMapper.FindInterviewMsgsByDepartmentId(departmentId);
        for (InterviewPO myInterview : myInterviews) {
            List<InterviewPO> elseInterviews = interviewMsgMapper.FindInterviewMsgsByUserId(myInterview.getUserId());
            InterviewPO elseInterview = null;
            if (elseInterviews.size() == 1)
                elseInterview = null;
            else if (elseInterviews.size() == 2) {
                if (myInterview.getDepartmentId().equals(elseInterviews.get(0).getDepartmentId()))
                    elseInterview = elseInterviews.get(1);
                else elseInterview = elseInterviews.get(0);
            }
            User user = userMapper.findUserByUserId(myInterview.getUserId());
            SearchInterviewPojo searchInterviewPojo = new SearchInterviewPojo(user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserTel(), myInterview, elseInterview);
            searchInterviewPojos.add(searchInterviewPojo);
        }
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(), searchInterviewPojos);
    }

    /**
     * 淘汰一面人员
     * @param userId
     * @param departmentId
     * @return
     */
    @Override
    public UniversalResponseBody EliminateFirst(Integer userId, Integer departmentId) {
        ApplyPO applyPO = applyMsgMapper.findApplyMsgByUserId(userId);
        int result;
        if (applyPO.getFirstIntentionId().equals(departmentId))
            result = interviewMsgMapper.EliminateFirstIntention(userId, departmentId);
        else
            result = interviewMsgMapper.EliminateSecondIntention(userId, departmentId);
        if (result != 0) {
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg());
        } else {
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(), ResponseResultEnum.FAILED.getMsg());
        }
    }

    /**
     * 通过一面人员
     *
     * @param userId
     * @param departmentId
     * @return
     */
    @Override
    public UniversalResponseBody PassFirst(Integer userId, Integer departmentId) {
        ApplyPO applyPO = applyMsgMapper.findApplyMsgByUserId(userId);
        int result;
        if (applyPO.getFirstIntentionId().equals(departmentId))
            result = interviewMsgMapper.PassFirstIntention(userId, departmentId);
        else
            result = interviewMsgMapper.PassSecondIntention(userId, departmentId);
        if (result!=0){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg());
        }else{
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }

}
