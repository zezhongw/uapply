package com.volunteer.uapply.service;

import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

import java.util.List;

/**
 * 一面相关服务层
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 9:27
 */
public interface FirstInterviewService {


    /**
     * 一面简历打分功能
     * @param interviewPO
     * @return
     */
    UniversalResponseBody scoreResume(InterviewPO interviewPO);
    /**
     * 查询待一面
     */
    UniversalResponseBody<List<ApplyPO>> SelectUnfirstInterview(Integer departmentId);
    /**
     * 查询已一面
     */
    UniversalResponseBody<List<ApplyPO>> SelectFirstInterviewed(Integer departmentId);

    /**
     * 淘汰一面
     * @param userId
     * @param departmentId
     * @return
     */
    UniversalResponseBody EliminateFirst(Integer userId,Integer departmentId);
}
