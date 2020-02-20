package com.volunteer.uapply.controller;



import com.volunteer.uapply.annotation.UserLogin;

import com.volunteer.uapply.annotation.MinisterLogin;
import com.volunteer.uapply.annotation.UserLogin;
import com.volunteer.uapply.pojo.ApplyPO;

import com.volunteer.uapply.pojo.SearchInterviewPojo;
import com.volunteer.uapply.pojo.User;

import com.volunteer.uapply.service.FirstInterviewService;
import com.volunteer.uapply.service.ResumeService;
import com.volunteer.uapply.service.SecondInterviewService;
import com.volunteer.uapply.service.impl.ResumeServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 面试
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 11:34
 */
@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    @Qualifier("secondInterviewServiceImpl")
    private SecondInterviewService secondInterviewService;

    @Autowired
    @Qualifier("firstInterviewServiceImpl")
    private FirstInterviewService firstInterviewService;

    @Autowired
    @Qualifier("resumeServiceImpl")
    private ResumeService resumeService;

    /**
     * 查询面试状态
     *
     * @param userId
     * @return
     */
    @GetMapping("/status")
    @UserLogin
    public UniversalResponseBody applyStatus(Integer userId) {
        return resumeService.viewApplyStatus(userId);
    }

    /**
     * 待一面
     * @param departmentId
     * @return
     */
    @UserLogin
    @GetMapping("/first/un")
    public UniversalResponseBody<List<ApplyPO>> UnFirstInterview(Integer departmentId){
        return firstInterviewService.SelectUnfirstInterview(departmentId);
    }

    /**
     * 已经一面
     * @param departmentId
     * @return
     */
    @UserLogin
    @GetMapping("/first/finish")
    public UniversalResponseBody<List<SearchInterviewPojo>> FirstInterviewed(Integer departmentId) {
        return null;
    }

    /**
     * 淘汰一面人员
     * @param userId
     * @param departmentId
     * @return
     */
    @MinisterLogin
    @PostMapping("/first/eliminate")
    public UniversalResponseBody FirstEliminate(Integer userId, Integer departmentId) {
        return null;
    }

    /**
     * 通过一面人员
     *
     * @param userId
     * @param departmentId
     * @return
     */
    @MinisterLogin
    @PostMapping("/first/pass")
    public UniversalResponseBody FirstPass(Integer userId, Integer departmentId) {
        return null;
    }


    /**
     * 二面签到
     *
     * @param userTel
     * @param departmentId
     * @return
     */
    @UserLogin
    @PostMapping("/second/check")
    public UniversalResponseBody SecondCheck(String userTel,Integer departmentId){
        return secondInterviewService.SecondCheck(userTel,departmentId);
    }

    /**
     * 待二面
     *
     * @param departmentId
     * @return
     */
    @UserLogin
    @GetMapping("/second/un")
    public UniversalResponseBody<List<SearchInterviewPojo>> UnSecondInterview(Integer departmentId) {
        return null;
    }

    /**
     * 已经二面
     *
     * @param departmentId
     * @return
     */
    @UserLogin
    @GetMapping("/second/finish")
    public UniversalResponseBody<List<SearchInterviewPojo>> SecondedInterviewed(Integer departmentId) {
        return null;
    }


    /**
     * 淘汰二面人员
     * @param userId
     * @param departmentId
     * @return
     */
    @MinisterLogin
    @PostMapping("/second/eliminate")
    public UniversalResponseBody SecondEliminate(Integer userId,Integer departmentId) {
        return null;
    }
}
