package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.TokenMapper;
import com.volunteer.uapply.mapper.UserMapper;
import com.volunteer.uapply.mapper.WxResponseMapper;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.info.WxResponseInfo;
import com.volunteer.uapply.service.UserService;
import com.volunteer.uapply.utils.Tokenutil;
import com.volunteer.uapply.utils.WeChatUtil;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 14:36
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private WeChatUtil weChatUtil;
    @Resource
    private Tokenutil tokenutil;
    @Resource
    private TokenMapper tokenMapper;
    @Resource
    private WxResponseMapper wxResponseMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 微信服务器返回code无效的结果代码40029
     */
    private static int wxErrCode = 40029;

    @Override
    public UniversalResponseBody<TokenPO> userWxLogin(String code){
        WxResponseInfo wxResponseInfo = weChatUtil.getWeChatResponseBody(code);
        //Code无效
        if (wxResponseInfo.getErrcode().equals(wxErrCode)){
            //将微信返回错误代码及结果记录到日志中
            log.error(code+wxResponseInfo.getErrcode()+ wxResponseInfo.getErrmsg());
            return new UniversalResponseBody(ResponseResultEnum.CODE_IS_INVALID.getCode(), ResponseResultEnum.CODE_IS_INVALID.getMsg());
        }
        //将微信返回结果插入数据库并返回数据库递增id(userId)
        wxResponseMapper.InsertWxResponse(wxResponseInfo);
        Integer userId =  wxResponseInfo.getUserId();
        String token = tokenutil.TokenByUserId(userId);
        TokenPO tokenPO = new TokenPO(userId,token);
        tokenMapper.insertToken(tokenPO);
       //返回token和userId
        return new UniversalResponseBody<TokenPO>(1,"success",tokenPO);
    }

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
