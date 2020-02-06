package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.User;

/**
 * User相关mapper
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/4 9:28
 */
public interface UserMapper {

    /**
     * 根据UserId查找用户
     * @param userId
     * @return
     */
    User findUserByUserId(Integer userId);


    /**
     * 根据用户电话查找用户
     * @param userTel
     * @return
     */
    User findUserByUserTel(String userTel);

    /**
     * 插入用户
     */
    int InsertUser(User user);
}
