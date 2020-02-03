package com.volunteer.uapply.service;

import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 14:35
 */
public interface UserService {

    /**
     * 用户微信登录服务层
     * @param code
     * @return
     * @throws Exception
     */
    UniversalResponseBody<TokenPO> userWxLogin(String code) throws Exception;

    /**
     * 通过openId来查找用户
     * @param userId
     * @return
     */
    User findUserByUserId(Integer userId);

    /**
     * 根据openid来查找对应的token
     * @param userId
     * @return
     */
    String findTokenByUserId(Integer userId);

    /**
     *
     */
}
