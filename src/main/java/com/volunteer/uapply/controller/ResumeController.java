package com.volunteer.uapply.controller;

import com.volunteer.uapply.annotation.UserLogin;
import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.InterviewPO;
import com.volunteer.uapply.service.ResumeService;
import com.volunteer.uapply.service.impl.FirstInterviewServiceImpl;
import com.volunteer.uapply.service.impl.ResumeServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 简历
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 11:29
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Resource
    FirstInterviewServiceImpl firstInterviewService;
    @Resource
    ResumeServiceImpl resumeService;
    /**
     * 用户报名
     * @param applyPO
     * @return
     */
    @PostMapping("/apply")
    @UserLogin
    public UniversalResponseBody applyMessage(ApplyPO applyPO){
        return resumeService.applyMessage(applyPO);
    }


    /**
     * 查看简历
     * @param departmentId
     * @param userTel
     * @return
     */
    @GetMapping("/view")
    @UserLogin
    public UniversalResponseBody<ApplyPO> managerResume(@RequestParam("departmentId")  Integer departmentId, @RequestParam("userTel") String userTel){
        return resumeService.viewApplyMessage(departmentId,userTel);
    }

    /**
     * 简历打分
     * @param interviewPO
     * @return
     */
    @PostMapping("/score")
    @UserLogin
    public UniversalResponseBody managerScore(InterviewPO interviewPO){
        return firstInterviewService.scoreResume(interviewPO);
    }
}
