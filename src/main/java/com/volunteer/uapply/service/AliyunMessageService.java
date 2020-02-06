package com.volunteer.uapply.service;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.pojo.info.AliyunRequsetParamInfo;
import com.volunteer.uapply.utils.response.UniversalResponseBody;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 12:43
 */
public interface AliyunMessageService {
    /**
     * 发送短信
     * @param aliyunRequsetParamInfo
     * @return
     * @throws ClientException
     */
    UniversalResponseBody SendMessage(AliyunRequsetParamInfo aliyunRequsetParamInfo) throws ClientException;
}
