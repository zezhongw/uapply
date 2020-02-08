package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

/**
 * 简历
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 11:29
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    /**
     * 用户报名
     * @param applyPO
     * @return
     */
    @PostMapping("/apply")
    @UserLoginToken
    public UniversalResponseBody applyMessage(ApplyPO applyPO){
        return null;
    }


    /**
     * 查看简历
     * @param departmentId
     * @param userTel
     * @return
     */
    @GetMapping("/view")
    @UserLoginToken
    public UniversalResponseBody<ApplyPO> managerResume(@RequestParam("departmentId")  Integer departmentId, @RequestParam("userTel") String userTel){
        return null;
    }

    /**
     * 简历打分
     * @param interviewPO
     * @return
     */
    @PostMapping("/score")
    @UserLoginToken
    public UniversalResponseBody managerScore(InterviewPO interviewPO){
        return null;
    }
}
