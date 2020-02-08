package com.volunteer.uapply.controller;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.annotation.PassToken;
import com.volunteer.uapply.annotation.UserLoginToken;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.AliyunEnrollParamInfo;
import com.volunteer.uapply.pojo.info.AliyunInterviewParamInfo;
import com.volunteer.uapply.service.impl.ManagerServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 部员
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 18:40
 */
@Slf4j
@RestController
@RequestMapping("/manager")
public class MembersController {

    @Resource
    private ManagerServiceImpl managerService;


    /**
     * 录取为部员
     * @param userId
     * @param departmentId
     * @return
     */
    @UserLoginToken
    @PostMapping("/enroll")
    public UniversalResponseBody EnrollMembers(Integer[] userId,Integer departmentId){
        return null;
    }


    /**
     * 分页查询部员数据
     * @param departmentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @UserLoginToken
    @PostMapping("/members")
    public UniversalResponseBody FindMembers(@RequestParam("departmentId")Integer departmentId, @RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize){
        return null;
    }


    /**
     ** 导出该部门所有部员详细信息
     * @param departmentId
     * @param response
     */
    @GetMapping("/export/{departmentId}")
    public void exportMessages(@PathVariable("departmentId")Integer departmentId, HttpServletResponse response){

    }
}
