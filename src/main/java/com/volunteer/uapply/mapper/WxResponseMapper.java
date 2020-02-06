package com.volunteer.uapply.mapper;

import com.volunteer.uapply.pojo.info.WxResponseInfo;

/**
 * 微信返回结果相关的数据库操作
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/3 19:22
 */
public interface WxResponseMapper {

    /**
     * 将微信返回数据结果插入数据库
     * @param wxResponseInfo
     * @return
     */
    int InsertWxResponse(WxResponseInfo wxResponseInfo);

    /**
     * 根据openid查找之前用户是否已经授权过，并查找userid
     * @param openid
     * @return
     */
    WxResponseInfo searchByOpenid(String openid);
}
