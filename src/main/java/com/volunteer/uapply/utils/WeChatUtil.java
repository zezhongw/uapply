package com.volunteer.uapply.utils;

import com.alibaba.fastjson.JSON;
import com.volunteer.uapply.pojo.User;
import com.volunteer.uapply.pojo.WxResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 微信登录获取数据工具包
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 13:17
 */
@Slf4j
public class WeChatUtil {

    @Value("${wx.url}")
    private String WECHAT_OPENID_URL;

    private static RestTemplate restTemplate = new RestTemplate();

    public WxResponseInfo getWeChatResponseBody(String code) {

        String url = WECHAT_OPENID_URL + code;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() != 200) {
           log.error("Connect weChat failed");
        }

        WxResponseInfo wxResponseInfo = JSON.parseObject(responseEntity.getBody(), WxResponseInfo.class);
        return wxResponseInfo;
    }

    public String getOpenId(String code) throws Exception{
        return getWeChatResponseBody(code).getOpenid();
    }

    /**
     * 将微信返回数据转换为User对象
     * @param wxResponseInfo
     * @return
     */
    public User wxResponseToUser(WxResponseInfo wxResponseInfo){
        User user = new User();
        user.setOpenid(wxResponseInfo.getOpenid());
        return user;
    }
}
