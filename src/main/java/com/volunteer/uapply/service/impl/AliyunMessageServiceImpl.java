package com.volunteer.uapply.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.volunteer.uapply.pojo.info.AliyunRequsetParamInfo;
import com.volunteer.uapply.service.AliyunMessageService;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
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

    private static String templateCode = "SMS_174022636";

    private static String SignName = "U报名";

    /**
     * 活动(此处写死，因为阿里云规范不让出现面试)
     */
    private String activity = "面试";


    private static String accessKeyId;

    private static String  accessKeySecret;

    @Override
    public void SendMessage(AliyunRequsetParamInfo aliyunRequsetParamInfo) throws ClientException {
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
    }
}
