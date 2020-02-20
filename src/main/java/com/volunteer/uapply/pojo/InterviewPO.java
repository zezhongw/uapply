package com.volunteer.uapply.pojo;

import lombok.Data;

/**
 * 面试相关信息
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/4 12:00
 */
@Data
public class InterviewPO {

    /**
     * 用户id
     */
    private Integer userId;


    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 性格
     */
    private String userCharacter;

    //产品说还没有定好，参数名称就先这么写吧,居然有6个参数
    /**
     * 参数1的分数
     */
    private Integer paramScore1;

    /**
     * 参数2的分数
     */
    private Integer paramScore2;

    /**
     * 参数3的分数
     */
    private Integer paramScore3;

    /**
     * 参数4的分数
     */
    private Integer paramScore4;

    /**
     * 参数5的分数
     */
    private Integer paramScore5;

    /**
     * 参数6的分数
     */
    private Integer paramScore6;



    /**
     * 备注
     */
    private String note;

    /**
     * 综合评价
     * @mock ABCD
     */
    private String overview;


    /**
     * 评价人
     */
    private String userName;
}
