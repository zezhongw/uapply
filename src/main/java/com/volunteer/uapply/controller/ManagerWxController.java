package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员微信端相关接口
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/7 14:18
 */
@RestController
public class ManagerWxController {

    /**
     * 查看简历
     * @param departmentId
     * @param userTel
     * @return
     */
    @GetMapping("/wx/manager/resume")
    @UserLoginToken
    public UniversalResponseBody<ApplyPO> managerResume(@RequestParam("departmentId")  Integer departmentId,@RequestParam("userTel") String userTel){
        return null;
    }

    /**
     * 简历打分
     * @param interviewPO
     * @return
     */
    @PostMapping("/wx/manager/score")
    @UserLoginToken
    public UniversalResponseBody managerScore(InterviewPO interviewPO){
        return null;
    }


}
