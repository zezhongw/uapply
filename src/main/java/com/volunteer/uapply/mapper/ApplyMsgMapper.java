package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.User;

/**
 * 表applymessage相关的mapper
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/8 9:29
 */
public interface ApplyMsgMapper {

    int UpdateSecondDepartment(String userTel,Integer departmentId);


    User GetUserByUserId(Integer userId);

}
