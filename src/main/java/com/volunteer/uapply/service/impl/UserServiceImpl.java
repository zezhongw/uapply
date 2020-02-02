package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.pojo.TokenInfo;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.WxResponseInfo;
import com.volunteer.uapply.service.UserService;
import com.volunteer.uapply.utils.WeChatUtil;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.stereotype.Service;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 14:36
 */
@Service
public class UserServiceImpl implements UserService {

    private WeChatUtil weChatUtil;
    private WxResponseInfo wxResponseInfo;

    @Override
    public UniversalResponseBody<User> userWxLogin(String code){
        wxResponseInfo = weChatUtil.getWeChatResponseBody(code);
        /**
         * 将user插入数据库的代码
         */
       // return new UniversalResponseBody<User>(1,"success",new TokenInfo(token,data));
        return null;
    }

    @Override
    public User findUserByOpenId(String openid) {
        return null;
    }
}
