package com.volunteer.uapply.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.volunteer.uapply.pojo.info.AliyunRequsetParamInfo;
import com.volunteer.uapply.pojo.info.AliyunResponseInfo;
import com.volunteer.uapply.pojo.info.WxResponseInfo;
import com.volunteer.uapply.service.AliyunMessageService;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/5 12:43
 */
@Service
@Slf4j
public class AliyunMessageServiceImpl implements AliyunMessageService {

    @Value("${aliyun.templateCode}")
    private  String templateCode;

    @Value("${aliyun.SignName}")
    private  String SignName;

    /**
     * 活动(此处写死，因为阿里云规范不让出现面试)
     */
    private String activity = "面试";

    @Value("${aliyun.accessKeyId}")
    private  String accessKeyId;

    @Value("${aliyun.accessKeySecret}")
    private  String  accessKeySecret ;

    @Override
    public UniversalResponseBody SendMessage(AliyunRequsetParamInfo aliyunRequsetParamInfo) throws ClientException {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", aliyunRequsetParamInfo.getPhoneNumbers());
        request.putQueryParameter("SignName",SignName);
        request.putQueryParameter("TemplateCode",templateCode);
        request.putQueryParameter("TemplateParam", "{\"name\":\""+aliyunRequsetParamInfo.getName()+"\","
        +"\"timeSlot\":\""+aliyunRequsetParamInfo.getTimeSlot()+"\","
        +"\"department\":\""+DepartmentEnum.getDepartmentNameById(aliyunRequsetParamInfo.getDepartmentId())+"\","
        +"\"telNo\":\""+aliyunRequsetParamInfo.getTelNo()+"\","
        +"\"place\":\""+aliyunRequsetParamInfo.getPlace()+"\","
        +"\"activity\":\""+activity+"\","
        +"}");
        CommonResponse commonResponse = client.getCommonResponse(request);
        log.info(commonResponse.getData());
        AliyunResponseInfo aliyunResponseInfo = JSON.parseObject(commonResponse.getData(), AliyunResponseInfo.class);
        if (aliyunResponseInfo.getCode().equals("OK")){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),"发送成功");
        }else{
            log.error(aliyunRequsetParamInfo.toString());
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),"发送失败，请联系系统管理员");
        }
    }
}
