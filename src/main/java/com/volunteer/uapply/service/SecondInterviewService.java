package com.volunteer.uapply.service;

import com.volunteer.uapply.utils.response.UniversalResponseBody;

/**
 * 二面相关服务层
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 10:14
 */
public interface SecondInterviewService {
    /**
     * 将此人员的二面部门设置为此部门/二面签到
     * @param userTel
     * @param departmentId
     * @return
     */
    public UniversalResponseBody SecondCheck(String userTel, Integer departmentId);
}
