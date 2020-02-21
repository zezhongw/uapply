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
        Integer userId = null;
        String token = null;
        TokenPO tokenPO = null;
        //该用户在数据库中的数据
        WxResponseInfo wxResponseInfoDB = wxResponseMapper.searchByOpenid(wxResponseInfo.getOpenid());
        //微信数据库中已经存在该用户
        if(wxResponseInfoDB!=null) {
            userId = wxResponseInfoDB.getUserId();
            token = tokenMapper.findTokenByUserId(wxResponseInfoDB.getUserId());
            //检查在用户数据库中是否已经存在该对象
            User user = userMapper.findUserByUserId(userId);
            //以防不存在的情况，此处对userId进行赋值
            user.setUserId(userId);
            tokenPO = new TokenPO(new User(userId), token);
        }else {
            //将微信返回结果插入数据库并返回数据库递增id(userId)
            wxResponseMapper.InsertWxResponse(wxResponseInfo);
            userId = wxResponseInfo.getUserId();
            token = tokenutil.TokenByUserId(userId);
            tokenPO = new TokenPO(new User(userId), token);
            tokenMapper.insertToken(userId, token);
        }
        return new UniversalResponseBody<TokenPO>(1,"success",tokenPO);
    }

    @Override
    public User findUserByUserTel(String userTel) {
        return userMapper.findUserByUserTel(userTel);
    }


}
