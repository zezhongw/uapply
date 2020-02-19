package com.volunteer.uapply.utils.enums;

/**
 * 面试状态枚举类
 *
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/19 10:17
 */
public enum InterviewStatusEnum {

    FIRST_INTENTION_INTERVIEW(1, "第一志愿已经面试"),
    FIRST_INTENTION_PASS(2, "第一志愿通过"),
    FIRST_INTENTION_ELIMINATE(3, "第一志愿淘汰"),
    SECOND_INTENTION_INTERVIEW(6, "第二志愿已经面试"),
    SECOND_INTENTION_PASS(4, "第二志愿通过"),
    SECOND_INTENTION_ELIMINATE(5, "第二志愿淘汰"),
    SECOND_INTERVIEW(6, "二面已经签到"),
    SECOND_INTERVIEW_ELIMINATE(7, "二面淘汰");

    /**
     * 面试状态id
     */
    private Integer InterviewStatusId;

    /**
     * 面试状态
     */
    private String InterviewStatus;

    InterviewStatusEnum(Integer interviewStatusId, String interviewStatus) {
        InterviewStatusId = interviewStatusId;
        InterviewStatus = interviewStatus;
    }

    public Integer getInterviewStatusId() {
        return InterviewStatusId;
    }

    public void setInterviewStatusId(Integer interviewStatusId) {
        InterviewStatusId = interviewStatusId;
    }

    public String getInterviewStatus() {
        return InterviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        InterviewStatus = interviewStatus;
    }
}
