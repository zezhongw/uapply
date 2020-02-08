package com.volunteer.uapply.controller;

import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 面试/报名数据
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 19:47
 */
@RestController
@RequestMapping("/data")
public class InterviewDataController {

    /**
     * 查询部门报名人数以及男女人数
     * @param departmentId
     * @return
     */
    @GetMapping("/count/{departmentId}")
    public UniversalResponseBody ApplyAndSexCount(@PathVariable Integer departmentId){
        return null;
    }


    /**
     * 查询整个青志各个部门的报名人数及各部们跨部人数
     * @return
     */
    @GetMapping("/counts")
    public UniversalResponseBody AllCounts(){
        return null;
    }

    /**
     * 查询所有部门一面以及没有一面的人数
     * @return
     */
    @GetMapping("/counts/detail")
    public UniversalResponseBody CountDetail(){
        return null;
    }
}
