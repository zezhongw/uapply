package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.ApplyPO;
import com.volunteer.uapply.pojo.SearchInterviewPojo;
import com.volunteer.uapply.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 表applymessage相关的mapper
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 9:29
 */
@Mapper
public interface ApplyMsgMapper {

    int UpdateSecondDepartment(String userTel,Integer departmentId);


    int insertApplyMsg(ApplyPO applyPO);

    ApplyPO findApplyMsgByUserTel(String userTel);

    ApplyPO findApplyMsgByUserId(int userId);

    /**
     * 更改用户第一志愿的状态
     *
     * @param userId
     * @param status
     * @return
     */
    Integer ChangeFirstIntentionStatus(Integer userId, Integer status);


    /**
     * 更改用户第二志愿的状态
     *
     * @param userId
     * @param status
     * @return
     */
    Integer ChangeSecondIntentionStatus(Integer userId, Integer status);

    /**
     * 二面淘汰，根据用户 id 和部门 id ，查找相关人员，将二面部门id设置为-1，表示淘汰
     *
     * @param userId
     * @param departmentId
     * @return
     */
    Integer secondEliminate(Integer userId, Integer departmentId);
}
