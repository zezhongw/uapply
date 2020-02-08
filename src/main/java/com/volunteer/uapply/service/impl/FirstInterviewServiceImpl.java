package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.ApplyMsgMapper;
import com.volunteer.uapply.mapper.InterviewMsgMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.FirstInterviewService;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 9:26
 */

/**
 * @author 武泽中
 * @version 1.0
 * @date 2020/2/8/17:51
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

    /**
     * 查询待一面人员
     * @param departmentId
     * @return
     */
    @Override
    public UniversalResponseBody<List<User>> SelectUnfirstInterview(Integer departmentId) {
        List<User> allunfirstInterview=interviewMsgMapper.SelectUnfirstInterviewByDepartmentId(departmentId);
        List<User> unfirstInterview=new LinkedList<>();
        for(User user :allunfirstInterview){
            List<User> temp=interviewMsgMapper.JudgeUnfirstInterview(user.getUserId());
            if(temp.size()==2)
                continue;
            else if(temp.size()==1){
                if(departmentId!=temp.get(0).getDepartmentId())
                    unfirstInterview.add(user);
            }
            else if(temp==null){
                unfirstInterview.add(user);
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
    public UniversalResponseBody<List<User>> SelectFirstInterviewed(Integer departmentId) {
        List<User> users=interviewMsgMapper.SelectFirstInterviewed(departmentId);
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),users);
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
