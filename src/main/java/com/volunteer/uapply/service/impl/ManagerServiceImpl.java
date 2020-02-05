package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.TokenMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.mapper.WxResponseMapper;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.service.ManagerService;
import com.volunteer.uapply.utils.Tokenutil;
import com.volunteer.uapply.utils.WeChatUtil;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 18:41
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private WeChatUtil weChatUtil;
    @Resource
    private Tokenutil tokenutil;
    @Resource
    private TokenMapper tokenMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public UniversalResponseBody<TokenPO> userPcLogin(String userTel, String userPwd) {
        User user = userMapper.findUserByUserTel(userTel);
        if(user == null){
            return new UniversalResponseBody(ResponseResultEnum.USER_LOGIN_ERROR.getCode(),ResponseResultEnum.USER_LOGIN_ERROR.getMsg());
        }
        Integer userId = user.getUserId();
        String truePwd = user.getUserPwd();
        //密码相同
        if (truePwd.equals(userPwd)){
            String trueToken = tokenMapper.findTokenByUserId(userId);
            //已经存在该用户的token
            if (trueToken!=null){
                return new UniversalResponseBody<TokenPO>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(),new TokenPO(userId,trueToken));
            }else{
                String token = tokenutil.TokenByUserId(userId);
                TokenPO tokenPO = new TokenPO(userId,token);
                tokenMapper.insertToken(tokenPO);
                //返回token和userId
                return new UniversalResponseBody<TokenPO>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(),tokenPO);
            }
        }else{
            return new UniversalResponseBody(ResponseResultEnum.USER_LOGIN_ERROR.getCode(), ResponseResultEnum.USER_LOGIN_ERROR.getMsg());
        }
    }
}
