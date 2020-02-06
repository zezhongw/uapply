package com.volunteer.uapply.pojo.info;

import lombok.Data;

/**
 * 邀请码和部门对应的类
 * 每个部门对应一个邀请码，
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/6 10:44
 */
@Data
public class InviteCodeInfo {

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 对应的部门id
     */
    private Integer departmentId;
}
