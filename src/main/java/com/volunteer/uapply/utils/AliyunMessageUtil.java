package com.volunteer.uapply.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.volunteer.uapply.pojo.info.AliyunResponseInfo;
import com.volunteer.uapply.utils.enums.DepartmentEnum;
import com.volunteer.uapply.utils.enums.ResponseResultEnum;
import com.volunteer.uapply.utils.response.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 阿里云短信服务
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/7 21:23
 */
@Slf4j
@Component
public class AliyunMessageUtil {

    @Value("${aliyun.interviewTemplateCode}")
    private  String interviewTemplateCode;

    @Value("${aliyun.SignName}")
    private  String SignName;

    /**
     * 此处在方法里面写死，因为阿里云规范不让出现面试、群号
     */
    private String activity;

    @Value("${aliyun.accessKeyId}")
    private  String accessKeyId;

    @Value("${aliyun.accessKeySecret}")
    private  String  accessKeySecret ;

    public UniversalResponseBody SendMessage(String PhoneNumbers, String name, String timeSlot, Integer departmentId, String telNo, String place) throws ClientException {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        activity = "面试";
        //此处要重新写一下
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers",PhoneNumbers);
        request.putQueryParameter("SignName",SignName);
        request.putQueryParameter("TemplateCode",interviewTemplateCode);
        request.putQueryParameter("TemplateParam", "{\"name\":\""+name+"\","
                +"\"timeSlot\":\""+ timeSlot+"\","
                +"\"department\":\""+ DepartmentEnum.getDepartmentNameById(departmentId)+"\","
                +"\"telNo\":\""+telNo+"\","
                +"\"place\":\""+place+"\","
                +"\"activity\":\""+activity+"\","
                +"}");
        CommonResponse commonResponse = client.getCommonResponse(request);
        log.info(commonResponse.getData());
        AliyunResponseInfo aliyunResponseInfo = JSON.parseObject(commonResponse.getData(), AliyunResponseInfo.class);
        if ("OK".equals(aliyunResponseInfo.getCode())){
            return new UniversalResponseBody(ResponseResultEnum.SUCCESS.getCode(),"发送成功");
        }else{
            log.error(name+PhoneNumbers+"发送失败");
            return new UniversalResponseBody(ResponseResultEnum.FAILED.getCode(),"发送失败，请联系系统管理员");
        }
    }
}
