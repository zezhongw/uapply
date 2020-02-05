package com.volunteer.uapply.pojo;

/**
 * 用户报名信息对应的数据库对象
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/3 16:04
 */
public class ApplyPO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号
     */
    private String userTel;

    /**
     * 专业
     */
    private String profession;

    /**
     * 学院
     */
    private String college;

    /**
     * 意向部门一(部门Id）
     */
    private Integer intentionDepartmentId;

    /**
     * 自我介绍
     */
    private String selfIntroduction;
}
