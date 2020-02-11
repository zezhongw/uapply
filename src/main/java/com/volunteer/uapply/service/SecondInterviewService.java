package com.volunteer.uapply.service;

import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

import java.util.List;

/**
 * 二面相关服务层
 * @author 桂乙侨
 * @version 1.0
 * @date 2020/2/8 14:12
 */
public interface SecondInterviewService {
    /**
     * 将此人员的二面部门设置为此部门/二面签到
     * @param userTel
     * @param departmentId
     * @return
     */
    UniversalResponseBody SecondCheck(String userTel, Integer departmentId);

    UniversalResponseBody<List<ApplyPO>> listUserUnSecondInterview(Integer departmentId);

    UniversalResponseBody<List<ApplyPO>> listUserSecondedInterviewed(Integer departmentId);

    UniversalResponseBody EnrollMembers(Integer[] userId,Integer departmentId);

    UniversalResponseBody SecondEliminate(Integer userId,Integer departmentId);
}
