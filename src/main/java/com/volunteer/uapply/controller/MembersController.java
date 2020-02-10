package com.volunteer.uapply.controller;


import com.volunteer.uapply.annotation.MinisterLogin;
import com.volunteer.uapply.annotation.UserLogin;
import com.volunteer.uapply.pojo.dto.EnrollMembersDTO;
import com.volunteer.uapply.service.SecondInterviewService;
import com.volunteer.uapply.service.impl.ManagerServiceImpl;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("secondInterviewServiceImpl")
    private SecondInterviewService secondInterviewService;

    /**
     * 录取部员
     * @param enrollMembersDTO
     * @return
     */
    @MinisterLogin
    @PostMapping("/enroll")
    public UniversalResponseBody EnrollMembers(@RequestBody EnrollMembersDTO enrollMembersDTO){
        return secondInterviewService.EnrollMembers(enrollMembersDTO.getUserId(),enrollMembersDTO.getDepartmentId());
    }


    /**
     * 分页查询部员数据
     * @param departmentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @UserLogin
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
