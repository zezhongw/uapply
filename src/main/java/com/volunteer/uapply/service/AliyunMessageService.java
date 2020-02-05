package com.volunteer.uapply.service;

import com.aliyuncs.exceptions.ClientException;
import com.volunteer.uapply.pojo.info.AliyunRequsetParamInfo;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 12:43
 */
public interface AliyunMessageService {
    void SendMessage(AliyunRequsetParamInfo aliyunRequsetParamInfo) throws ClientException;
}
