package com.volunteer.uapply.service.impl;

import com.volunteer.uapply.mapper.TokenMapper;
import com.volunteer.uapply.mapper.WxResponseMapper;
import com.volunteer.uapply.pojo.TokenPO;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.WxResponseInfo;
import com.volunteer.uapply.service.UserService;
import com.volunteer.uapply.utils.Tokenutil;
import com.volunteer.uapply.utils.WeChatUtil;
import com.volunteer.uapply.utils.enums.ExceptionEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    /**
     * 微信服务器返回code无效的结果代码40029
     */
    private static int wxErrCode = 40029;

    @Override
    public UniversalResponseBody<TokenPO> userWxLogin(String code){
        WxResponseInfo wxResponseInfo = weChatUtil.getWeChatResponseBody(code);
        System.out.println(wxResponseInfo.toString());
        //Code无效
        if (wxResponseInfo.getErrcode().equals(wxErrCode)){
            //将微信返回错误代码及结果记录到日志中
            log.error(code+wxResponseInfo.getErrcode()+ wxResponseInfo.getErrmsg());
            return new UniversalResponseBody(ExceptionEnum.CODE_IS_INVALID.getCode(),ExceptionEnum.CODE_IS_INVALID.getMsg());
        }
        //将微信返回结果插入数据库并返回数据库递增id(userId)
        wxResponseMapper.InsertWxResponse(wxResponseInfo);
        Integer userId =  wxResponseInfo.getUserId();
        String token = tokenutil.TokenByOpenid(userId);
        TokenPO tokenPO = new TokenPO(userId,token);
        tokenMapper.insertToken(tokenPO);
       //返回token和userId
        return new UniversalResponseBody<TokenPO>(1,"success",tokenPO);
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return null;
    }

    @Override
    public String findTokenByUserId(Integer userId) {
        return null;
    }
}
