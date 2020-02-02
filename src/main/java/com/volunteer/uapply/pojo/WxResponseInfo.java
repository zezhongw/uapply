package com.volunteer.uapply.pojo;

import lombok.Data;

/**
 * 微信返回数据对象
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 13:16
 */
@Data
public class WxResponseInfo {

    /**
     * 用户唯一标识
     */
    private String openid;

    /**
     * 会话密钥
     */
    private String session_key;

    /**
     * 用户在开放平台的唯一标识符
     */
    private String unionid;

    private String errcode;

    private String errmsg;
}
