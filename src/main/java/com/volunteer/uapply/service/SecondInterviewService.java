package com.volunteer.uapply.service;

import com.volunteer.uapply.pojo.SearchInterviewPojo;
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

    /**
     * 根据部门查询所有二面还没面试的成员，封装到 SearchInterviewPojo
     *
     * @param departmentId
     * @return
     */
    UniversalResponseBody<List<SearchInterviewPojo>> listUnSecondInterviewInfo(Integer departmentId);

    /**
     * 根据部门查询所有二面已经面试的成员，封装到 SearchInterviewPojo
     *
     * @param departmentId
     * @return
     */
    UniversalResponseBody<List<SearchInterviewPojo>> listSecondedInterviewedInfo(Integer departmentId);

    UniversalResponseBody secondEliminate(Integer userId, Integer departmentId);

    UniversalResponseBody enrollMembers(Integer[] ids, Integer departmentId);
}
