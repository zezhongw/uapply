package com.volunteer.uapply.service;

import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 18:41
 */
public interface ManagerService {
    /**
     * 用户Pc端登录
     * @param userTel
     * @param userPwd
     * @return
     */
    UniversalResponseBody<TokenPO> userPcLogin(String userTel, String userPwd);


    /**
     * 管理员与部员PC端用户激活
     * @param user
     * @param inviteCode
     * @return
     */
    UniversalResponseBody userPcActivation(User user,String inviteCode);
}