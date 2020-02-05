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
     * 用户微信登录
     * @param code
     * @return
     * @throws Exception
     */
    UniversalResponseBody<TokenPO> userWxLogin(String code) throws Exception;

    /**
     * 用户Pc端登录
     * @param userTel
     * @param userPwd
     * @return
     */
    UniversalResponseBody<TokenPO> userPcLogin(String userTel,String userPwd);
}
