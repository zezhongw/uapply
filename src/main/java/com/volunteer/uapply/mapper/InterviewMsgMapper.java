package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.pojo.User;

import java.util.List;

/**
 * InterviewMessageMapper相关mapper
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 10:17
 */
public interface InterviewMsgMapper {

    /**
     * 插入面试评价
     * @param interviewPO
     * @return
     */
    int InsertInterview(InterviewPO interviewPO);
    /**
     * 查询未一面，先在 applymessage查询全部，再根据interviewmessge筛选
    */
    List<User> SelectUnfirstInterviewByDepartmentId(Integer departmentId);
    List<User> JudgeUnfirstInterview(Integer userId);
    /**
     * 查询已一面
     */
    List<User> SelectFirstInterviewed(Integer departmentId);
    /**
     * 淘汰一面
     */
    int EliminateFirst(Integer userId,Integer departmentId);
}