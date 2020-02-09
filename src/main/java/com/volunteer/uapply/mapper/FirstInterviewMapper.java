package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.User;

import java.util.List;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/9 13:21
 */
public interface FirstInterviewMapper {

    /**
     * 查询未一面，先在 applymessage查询全部，再根据interviewmessge筛选
     */
    List<User> SelectUnfirstInterviewByDepartmentId(Integer departmentId);

    /**
     *
     * @param userId
     * @return
     */
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
