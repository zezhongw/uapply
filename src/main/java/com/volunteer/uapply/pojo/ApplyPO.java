package com.volunteer.uapply.pojo;

import lombok.Data;


/**
 * 用户报名信息对应的数据库对象
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/3 16:04
 */
@Data
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
     * 姓名
     */
    private String userName;

    /**
     * 学号
     */
    private String userStunum;

    /**
     * QQ
     */
    private String userQq;

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
    private Integer firstIntentionId;

    /**
     * 意向部门二(部门Id)
     */
    private Integer secondIntentionId;


    /**
     * 爱好特长
     */
    private String userHobby;

    /**
     * 自我介绍
     */
    private String userIntroduction;


    /**
     * 二面部门
     */
    private Integer secondDepartmentId;
}
