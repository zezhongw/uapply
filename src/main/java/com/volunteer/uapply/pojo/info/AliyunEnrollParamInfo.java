package com.volunteer.uapply.pojo.info;

/**
 * 录取短信
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/7 16:32
 */
public class AliyunEnrollParamInfo {

    /**
     * 接受短信的用户Id
     */
    private Integer[] userId;


    /**
     * 部门Id
     */
    private Integer departmentId;
    /**
     * QQ群号,阿里云审核不通过，只能这样命名了
     */
    private String secret;
}
