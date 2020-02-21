package com.volunteer.uapply.controller;


import com.github.pagehelper.PageInfo;
import com.volunteer.uapply.annotation.MinisterLogin;
import com.volunteer.uapply.annotation.UserLogin;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.dto.EnrollMembersDTO;
import com.volunteer.uapply.service.SecondInterviewService;
import com.volunteer.uapply.service.impl.ManagerServiceImpl;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

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
    public UniversalResponseBody EnrollMembers(@Valid @RequestBody EnrollMembersDTO enrollMembersDTO) {
        return secondInterviewService.enrollMembers(enrollMembersDTO.getUserId(), enrollMembersDTO.getDepartmentId());
    }


    /**
     * 分页查询部员数据
     *
     * @param departmentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @UserLogin
    @PostMapping("/members")
    public UniversalResponseBody<PageInfo<User>> FindMembers(@RequestParam("departmentId") Integer departmentId, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return managerService.allMembers(departmentId, pageNum, pageSize);
    }


    /**
     ** 导出该部门所有部员详细信息
     * @param departmentId
     * @param response
     */
    @GetMapping("/export/{departmentId}")
    public void exportMessages(@PathVariable("departmentId")Integer departmentId, HttpServletResponse response){
        managerService.exportMembersExcel(departmentId, response);
    }
}
