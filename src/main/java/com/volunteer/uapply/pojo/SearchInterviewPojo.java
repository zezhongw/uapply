package com.volunteer.uapply.pojo;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/18 14:23
 */
public class SearchInterviewPojo {


    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 性别
     */
    private String userSex;

    /**
     * 手机号
     */
    private String userTel;

    /**
     * 我评
     */
    private InterviewPO myInterview;


    /**
     * 他评(其余部门的评价)
     */
    private InterviewPO elseInterview;
}
