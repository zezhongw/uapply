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

    /**
     * 二面淘汰，根据用户id与部门id设置状态为2，表示淘汰
     *
     * @param userId
     * @param departmentId
     * @return
     */
    UniversalResponseBody secondEliminate(Integer userId, Integer departmentId);

    /**
     * 录取为部员，根据部门id与用户id，封装user后批量插入，pwd密码字段为空
     *
     * @param ids
     * @param departmentId
     * @return
     */
    UniversalResponseBody enrollMembers(Integer[] ids, Integer departmentId);
}
