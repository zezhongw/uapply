package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User相关mapper
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/4 9:28
 */
@Mapper
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

    /**
     * 批量插入数据
     * created by 桂乙侨
     * @param users
     * @return
     */
    int insertBatch(List<User> users);
}
