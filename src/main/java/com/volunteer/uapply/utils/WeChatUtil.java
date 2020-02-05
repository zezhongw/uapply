package com.volunteer.uapply.utils;

import com.alibaba.fastjson.JSON;
import com.volunteer.uapply.pojo.info.WxResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 微信登录获取数据工具包
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 13:17
 */
@Component
@Slf4j
public class WeChatUtil {

    private String WECHAT_OPENID_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=${wx.appid}&secret=${wx.secret}&grant_type=authorization_code&js_code=";

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

}
